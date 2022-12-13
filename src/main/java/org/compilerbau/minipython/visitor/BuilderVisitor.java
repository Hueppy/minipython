package org.compilerbau.minipython.visitor;

import CBuilder.Statement;
import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Class;
import org.compilerbau.minipython.ast.Number;
import org.compilerbau.minipython.symbol.Symbol;
import org.compilerbau.minipython.symbol.Variable;

import java.nio.file.Path;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuilderVisitor extends AstVisitorBase<Object> {
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

        @Override
        public CBuilder.Expression visit(Identifier node) {
            CBuilder.Expression reference = new CBuilder.Reference(node.getIdentifier());
            while (node.hasNext()) {
                reference = new CBuilder.objects.AttributeReference(node.getIdentifier(), reference);
                node = node.getNext();
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
                    .reduce((x, y) -> new CBuilder.objects.Call(new CBuilder.objects.AttributeReference(func.get(), x), Collections.singletonList(y)))
                    .get();
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
    };

    private final AstVisitorBase<CBuilder.Statement> statementVisitor = new AstVisitorBase<>() {
        @Override
        public CBuilder.Statement visit(Call node) {
            return node.accept(expressionBuilder);
        }

        @Override
        public CBuilder.Statement visit(Block node) {
            for (String name: node.getScope().getSymbols().keySet()) {
                Symbol symbol = node.getScope().resolve(name);
                if (symbol instanceof Variable) {
                    variables.add(new CBuilder.variables.VariableDeclaration(name));
                }
            }

            // hack :^)
            return new CBuilder.conditions.IfThenElseStatement(
                    new CBuilder.conditions.conditionalStatement.IfStatement(
                        new CBuilder.literals.BoolLiteral(true),
                        node.getStatements().stream()
                                .map(x -> x.accept(this))
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList())),
                    Optional.empty(),
                    Optional.empty());
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
        public Statement visit(Class node) {
            BuilderVisitor.this.visit(node);
            return super.visit(node);
        }
    };

    private final Path output;
    private List<CBuilder.variables.VariableDeclaration> variables = new ArrayList<>();
    private List<CBuilder.objects.functions.Function> functions = new ArrayList<>();

    public BuilderVisitor(Path output) {
        this.output = output;
    }

    @Override
    public Object visit(Function node) {
        List<CBuilder.variables.VariableDeclaration> enclosing = variables;
        variables = new ArrayList<>();

        functions.add(new CBuilder.objects.functions.Function(
                node.getName(),
                Collections.singletonList(node.getBody().accept(statementVisitor)),
                IntStream.range(0, node.getParameter().size())
                        .mapToObj(x -> new CBuilder.objects.functions.Argument(node.getParameter().get(x), x))
                        .collect(Collectors.toList()),
                variables));

        variables = enclosing;

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
        programBuilder.addStatement(statement);
        programBuilder.writeProgram(output);

        return super.visit(node);
    }
}
