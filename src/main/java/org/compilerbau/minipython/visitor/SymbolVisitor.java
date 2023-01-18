package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Import;
import org.compilerbau.minipython.exception.SymbolException;
import org.compilerbau.minipython.symbol.*;
import org.compilerbau.minipython.symbol.Class;
import org.compilerbau.minipython.symbol.Function;

import java.util.Map;
import java.util.function.Supplier;

public class SymbolVisitor extends AstVisitorBase<Object> {
    protected Scope scope;

    private Symbol nest(Supplier<Symbol> action) {
        Scope parent = scope;
        scope = new Scope();
        if (parent != null) {
            scope.setParent(parent);
        }

        Symbol symbol = action.get();

        scope = parent;
        return symbol;
    }

    @Override
    public Object visit(Call node) {
        Identifier identifier = node.getIdentifier();

        if(identifier.hasNext()) {
            identifier.accept(this);

            while (identifier.hasNext()) {
                identifier = identifier.getNext();
                identifier.accept(this);
            }
        } else {
            return identifier.accept(this);
        }

        return null;
    }

    @Override
    public Object visit(Assignment node) {
        Identifier identifier = node.getIdentifier();
        Symbol var = scope.resolve(identifier);

        if (var == null) {
            Variable newVar = new Variable();
            newVar.setValue(node.getExpression().accept(this));
            scope.bind(identifier, newVar);
        } else if (var instanceof Variable) {
            ((Variable) var).setValue(node.getExpression().accept(this));
        }

        return null;
    }
    @Override
    public Object visit(Import node) {
        node.getProgram().accept(this);

        if(node.getImports().size() == 0) {
            for(Map.Entry<String, Symbol> entry : node.getProgram().getBlock().getScope().getSymbols().entrySet()) {
                // Bind only functions and classes
                if(entry.getValue() instanceof Function || entry.getValue() instanceof Class) {
                    scope.getParent().bind(entry.getKey(), entry.getValue());
                }
            }
        } else {
            for(String importIdentifier : node.getImports()) {
                // Check if imports are valid
                Symbol symbol = node.getProgram().getBlock().getScope().resolve(importIdentifier);

                if(symbol == null) {
                    throw new SymbolException("Can't import '" + importIdentifier + "' because doesn't exist in " + node.getPath(), node);
                } else if(scope.getParent().resolve(importIdentifier) != null) {
                    throw new SymbolException("Can't import '" + importIdentifier + "' because it's already imported or defined", node);
                } else if(symbol instanceof Function == false && symbol instanceof Class == false) {
                    throw new SymbolException("Can't import '" + importIdentifier + "' because it's neither a class or function", node);
                }

                scope.getParent().bind(importIdentifier, symbol);
            }
        }

        return null;
    }

    @Override
    public Object visit(Identifier node) {
        Symbol symbol = null;

        if(node.hasPrevious()) {
            Symbol prev = scope.resolve(node.getPrevious().getIdentifier());

            if (prev instanceof Variable) {
                Object value = ((Variable) prev).getValue();

                if (value instanceof org.compilerbau.minipython.symbol.Class) {
                    symbol = ((org.compilerbau.minipython.symbol.Class) value).getScope().resolveLocally(node.getIdentifier());
                }
            }
        } else {
            symbol = scope.resolve(node.getIdentifier());
        }

        if(symbol == null) {
            throw new SymbolException("Identifier '" + node.getIdentifier() + "' is not defined", node);
        }

        return symbol;
    }

    @Override
    public Object visit(org.compilerbau.minipython.ast.Class node) {
        if(scope.resolve(node.getName()) != null) {
            throw new SymbolException("Class '" + node.getName() + "' is already defined or imported", node);
        }

        scope.bind(node.getName(), nest(() -> {
            String baseName = node.getBase();
            if(baseName != null) {
                Class parent = (Class) scope.resolve(baseName);
                if(parent == null) {
                    throw new SymbolException("Class '" + baseName + "' doesn't exist", node);
                }

                scope.setParent(parent.getScope());
            }

            for(org.compilerbau.minipython.ast.Function function : node.getFunctions()) {
                function.accept(this);
            }

            node.setScope(scope);
            Class newClass = new Class(scope);
            newClass.setClass(node);

            return newClass;
        }));

        return scope.resolve(node.getName());
    }

    @Override
    public Object visit(Calculation node) {
        for(Expression expr : node.getOperands()) {
            expr.accept(this);
        }

        return null;
    }

    @Override
    public Object visit(Comparison node) {
        for(Expression expr : node.getOperands()) {
            expr.accept(this);
        }

        return null;
    }

    @Override
    public Object visit(Connective node) {
        for(Expression expr : node.getOperands()) {
            expr.accept(this);
        }

        return null;
    }

    @Override
    public Object visit(Negation node) {
        node.getExpression().accept(this);
        return null;
    }

    @Override
    public Object visit(Conditional node) {
        node.getCondition().accept(this);
        node.getIfBody().accept(this);
        if (node.getElseBody() != null) {
            node.getElseBody().accept(this);
        }

        return null;
    }

    @Override
    public Object visit(org.compilerbau.minipython.ast.Function node) {
        if(scope.resolve(node.getName()) != null) {
            throw new SymbolException("Function '" + node.getName() + "' is already defined or imported", node);
        }

        scope.bind(node.getName(), nest(() -> {
            for (String parameter: node.getParameter()) {
                scope.bind(parameter, new Parameter());
            }

            node.getBody().accept(this);
            node.setScope(scope);
            Function function = new Function(scope);
            function.setFunction(node);
            return function;
        }));

        return null;
    }

    @Override
    public Object visit(Return node) {
        node.getExpression().accept(this);
        return null;
    }

    @Override
    public Object visit(Loop node) {
        node.getCondition().accept(this);
        node.getBody().accept(this);

        return null;
    }

    @Override
    public Object visit(Program node) {
        nest(() -> {
            scope.bind("print", BuiltInFunction.PRINT);
            scope.bind("input", BuiltInFunction.INPUT);
            scope.bind("range", BuiltInFunction.RANGE);

            node.getBlock().accept(this);

            return null;
        });

        return null;
    }

    @Override
    public Object visit(Block node) {
        nest(() -> {
            for(Statement statement : node.getStatements()) {
                statement.accept(this);
            }

            node.setScope(scope);

            return null;
        });

        return null;
    }
}
