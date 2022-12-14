package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.symbol.*;
import org.compilerbau.minipython.symbol.Class;
import org.compilerbau.minipython.symbol.Function;

import java.util.function.Supplier;

public class SymbolVisitor extends AstVisitorBase<Object> {
    protected Scope scope;

    public static class SymbolException extends RuntimeException {
        public SymbolException(String message) {
            super(message);
        }
    }

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
    public Object visit(Assignment node) {
        Identifier identifier = node.getIdentifier();
        if (scope.resolve(identifier) == null) {
            scope.bind(identifier, new Variable());
        }

        return null;
    }

    @Override
    public Object visit(org.compilerbau.minipython.ast.Class node) {
        if(scope.resolve(node.getName()) != null) {
            throw new SymbolException("Class " + node.getName() + " is already defined");
        }

        scope.bind(node.getName(), nest(() -> {
            String baseName = node.getBase();
            if(baseName != null) {
                Class parent = (Class) scope.resolve(baseName);
                if(parent == null) {
                    throw new SymbolException("Class " + baseName + " doesn't exist");
                }

                scope.setParent(parent.getScope());
            }

            for(org.compilerbau.minipython.ast.Function function : node.getFunctions()) {
                function.accept(this);
            }

            node.setScope(scope);

            return new Class(scope);
        }));

        return null;
    }

    @Override
    public Object visit(Conditional node) {
        node.getIfBody().accept(this);
        if (node.getElseBody() != null) {
            node.getElseBody().accept(this);
        }

        return null;
    }

    @Override
    public Object visit(org.compilerbau.minipython.ast.Function node) {
        if(scope.resolve(node.getName()) != null) {
            throw new SymbolException("Function " + node.getName() + "() is already defined");
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
    public Object visit(Loop node) {
        node.getBody().accept(this);

        return null;
    }

    @Override
    public Object visit(Program node) {
        nest(() -> {
            scope.bind("print", BuiltInFunction.PRINT);
            scope.bind("input", BuiltInFunction.INPUT);

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
