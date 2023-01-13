package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Class;
import org.compilerbau.minipython.ast.Module;
import org.compilerbau.minipython.ast.Number;
import org.compilerbau.minipython.symbol.BuiltInFunction;
import org.compilerbau.minipython.symbol.Scope;
import org.compilerbau.minipython.symbol.Symbol;
import org.compilerbau.minipython.symbol.Variable;

import java.nio.file.Path;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuilderVisitor extends AstVisitorBase<Object> {
    private Scope scope;

    private String buildIdentifier(Module module, String name) {
        if(scope.resolve(name) instanceof BuiltInFunction) {
            return name;
        } else if(module != null) {
            return name + "_" + module.getId();
        } else {
            return name + "_0";
        }
    }
    private final AstVisitorBase<CBuilder.Expression> expressionBuilder = new AstVisitorBase<>() {
        @Override
        public CBuilder.Expression visit(Text node) {
            return new CBuilder.literals.StringLiteral(node.getValue());
        }

        @Override
        public CBuilder.Expression visit(Truth node) {
            return new CBuilder.literals.BoolLiteral(node.getValue());
        }

        @Override
        public CBuilder.Expression visit(Number node) {
            return new CBuilder.literals.IntLiteral(node.getValue());
        }

        private String buildSymbol(Symbol symbol, Node node, String name) {
            if(symbol instanceof org.compilerbau.minipython.symbol.Class) {
                return buildIdentifier(((org.compilerbau.minipython.symbol.Class) symbol).getClazz().getModule(), name);
            } else if(symbol instanceof org.compilerbau.minipython.symbol.Function) {
                return buildIdentifier(((org.compilerbau.minipython.symbol.Function) symbol).getFunction().getModule(), name);
            } else {
                return buildIdentifier(node.getModule(), name);
            }
        }

        @Override
        public CBuilder.Expression visit(Identifier node) {
            Symbol symbol = scope.resolve(node.getIdentifier());
            String name = buildSymbol(symbol, node, node.getIdentifier());

            CBuilder.Expression reference = new CBuilder.Reference(name);

            while (node.hasNext()) {
                node = node.getNext();
                String subName = buildSymbol((symbol instanceof Variable) ? (Symbol) ((Variable) symbol).getValue() : null, node, node.getIdentifier());

                reference = new CBuilder.objects.AttributeReference(subName, reference);
            }

            return reference;
        }

        @Override
        public CBuilder.Expression visit(Call node) {
            return new CBuilder.objects.Call(
                    node.getIdentifier().accept(this),
                    node.getParameter().stream()
                            .map(x -> x.accept(this))
                            .collect(Collectors.toList()));
        }

        @Override
        public CBuilder.Expression visit(Connective node) {
            return node.getOperands().stream()
                    .map(x -> x.accept(this))
                    .reduce((x, y) -> {
                        if (node.getOperator() == Connective.Operator.And) {
                            return new CBuilder.keywords.bool.AndKeyword(x, y);
                        }
                        return new CBuilder.keywords.bool.OrKeyword(x, y);
                    })
                    .get();
        }

        @Override
        public CBuilder.Expression visit(Comparison node) {
            final Supplier<String> func = () -> {
                switch (node.getOperator()) {
                    case Equality: return "__eq__";
                    case Inequality: return "__ne__";
                    case GreaterEqual: return "__ge__";
                    case GreaterThan: return "__gt__";
                    case LessEqual: return "__le__";
                    case LessThan: return "__lt__";
                }
                return "";
            };

            return node.getOperands().stream()
                    .map(x -> x.accept(this))
                    .reduce((x, y) -> new CBuilder.objects.Call(
                        new CBuilder.objects.AttributeReference(func.get(), x),
                        Collections.singletonList(y)))
                    .get();
        }

        @Override
        public CBuilder.Expression visit(Tuple node) {
            return new CBuilder.literals.TupleLiteral(node.getExpressions().stream()
                    .map(x -> x.accept(this))
                    .collect(Collectors.toList()));
        }

        @Override
        public CBuilder.Expression visit(Calculation node) {
            final Supplier<String> func = () -> {
                switch (node.getOperator()) {
                    case Addition: return "__add__";
                    case Subtraction: return "__sub__";
                    case Multiplication: return "__mul__";
                    case Division: return "__div__";
                }
                return "";
            };

            return node.getOperands().stream()
                    .map(x -> x.accept(this))
                    .reduce((x, y) -> new CBuilder.objects.Call(new CBuilder.objects.AttributeReference(func.get(), x), Collections.singletonList(y)))
                    .get();
        }

        @Override
        public CBuilder.Expression visit(Negation node) {
            return new CBuilder.keywords.bool.NotKeyword(node.getExpression().accept(this));
        }

        @Override
        public CBuilder.Expression visit(ElementAccess node) {
            return new CBuilder.tuple.TupleReference(node.getTuple().accept(this), node.getIndex());
        }
    };

    private final AstVisitorBase<CBuilder.Statement> statementVisitor = new AstVisitorBase<>() {
        @Override
        public CBuilder.Statement visit(Call node) {
            return node.accept(expressionBuilder);
        }

        @Override
        public CBuilder.Statement visit(Block node) {
            Scope prevScope = scope;
            scope = node.getScope();
            for (String name : scope.getSymbols().keySet()) {
                Symbol symbol = node.getScope().resolve(name);
                if (symbol instanceof Variable) {
                    variables.add(new CBuilder.variables.VariableDeclaration(buildIdentifier(node.getModule(), name)));
                }
            }

            // hack :^)
            CBuilder.conditions.IfThenElseStatement cond = new CBuilder.conditions.IfThenElseStatement(
                    new CBuilder.conditions.conditionalStatement.IfStatement(
                        new CBuilder.literals.BoolLiteral(true),
                        node.getStatements().stream()
                                .map(x -> x.accept(this))
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList())),
                    Optional.empty(),
                    Optional.empty());

            scope = prevScope;

            return cond;
        }

        @Override
        public CBuilder.Statement visit(Assignment node) {
            CBuilder.Expression reference = node.getIdentifier().accept(expressionBuilder);
            CBuilder.Expression expression = node.getExpression().accept(expressionBuilder);
            if (reference instanceof CBuilder.Reference) {
                // Regular assignment
                return new CBuilder.variables.Assignment((CBuilder.Reference) reference, expression);
            }

            // Attribute assignment
            return new CBuilder.objects.AttributeAssignment((CBuilder.objects.AttributeReference) reference, expression);
        }

        @Override
        public CBuilder.Statement visit(Conditional node) {
            return new CBuilder.conditions.IfThenElseStatement(
                    new CBuilder.conditions.conditionalStatement.IfStatement(
                            node.getCondition().accept(expressionBuilder),
                            Collections.singletonList(node.getIfBody().accept(this))),
                    Optional.empty(),
                    node.getElseBody() == null ? Optional.empty() : Optional.of(
                            new CBuilder.conditions.conditionalStatement.ElseStatement(
                                    Collections.singletonList(node.getElseBody().accept(this))))
            );
        }

        @Override
        public CBuilder.Statement visit(Loop node) {
            return new CBuilder.conditions.conditionalStatement.WhileStatement(
                    node.getCondition().accept(expressionBuilder),
                    Collections.singletonList(node.getBody().accept(this)));
        }

        @Override
        public CBuilder.Statement visit(Function node) {
            BuilderVisitor.this.visit(node);
            return super.visit(node);
        }

        @Override
        public CBuilder.Statement visit(Return node) {
            return new CBuilder.objects.functions.ReturnStatement(node.getExpression().accept(expressionBuilder));
        }

        @Override
        public CBuilder.Statement visit(Class node) {
            BuilderVisitor.this.visit(node);
            return super.visit(node);
        }

        @Override
        public CBuilder.Statement visit(Import node) {
            BuilderVisitor.this.visit(node);
            return super.visit(node);
        }
    };

    private final Path output;
    private List<CBuilder.variables.VariableDeclaration> variables = new ArrayList<>();
    private List<CBuilder.objects.functions.Function> functions = new ArrayList<>();
    private List<CBuilder.objects.MPyClass> classes = new ArrayList<>();

    public BuilderVisitor(Path output) {
        this.output = output;
    }

    @Override
    public Object visit(Function node) {
        List<CBuilder.variables.VariableDeclaration> enclosing = variables;
        variables = new ArrayList<>();

        functions.add(new CBuilder.objects.functions.Function(
                buildIdentifier(node.getModule(), node.getName()),
                Collections.singletonList(node.getBody().accept(statementVisitor)),
                IntStream.range(0, node.getParameter().size())
                        .mapToObj(x -> new CBuilder.objects.functions.Argument(buildIdentifier(node.getModule(), node.getParameter().get(x)), x))
                        .collect(Collectors.toList()),
                variables));

        variables = enclosing;

        return super.visit(node);
    }

    @Override
    public Object visit(Class node) {
        String base = node.getBase();

        List<CBuilder.objects.functions.Function> enclosing = functions;
        functions = new ArrayList<>();

        if (node.getFunctions().stream().noneMatch(f -> f.getName().equals("__init__"))) {
            functions.add(new CBuilder.objects.functions.Function(
                    "__init__",
                    List.of(new CBuilder.objects.SuperCall(List.of())),
                    List.of(new CBuilder.objects.functions.Argument("self", 0)),
                    List.of()
            ));
        }

        for (Function function: node.getFunctions()) {
            function.accept(this);
        }

        classes.add(new CBuilder.objects.MPyClass(
                buildIdentifier(node.getModule(), node.getName()),
                base != null ? new CBuilder.Reference(buildIdentifier(node.getModule(), base)) : new CBuilder.Reference("__MPyType_Object"),
                functions,
                Map.of()));

        functions = enclosing;

        return super.visit(node);
    }

    @Override
    public Object visit(Import node) {
        node.getProgram().accept(this);
        return super.visit(node);
    }
    @Override
    public Object visit(Program node) {
        CBuilder.Statement statement = node.getBlock().accept(statementVisitor);
        CBuilder.ProgramBuilder programBuilder = new CBuilder.ProgramBuilder();
        for (CBuilder.variables.VariableDeclaration variable: variables) {
            programBuilder.addVariable(variable);
        }
        for (CBuilder.objects.functions.Function function: functions) {
            programBuilder.addFunction(function);
        }
        for (CBuilder.objects.MPyClass _class: classes) {
            programBuilder.addClass(_class);
        }
        programBuilder.addStatement(statement);
        programBuilder.writeProgram(output);

        return super.visit(node);
    }
}
