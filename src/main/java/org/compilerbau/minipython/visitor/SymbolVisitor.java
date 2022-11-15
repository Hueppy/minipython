package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Number;
import org.compilerbau.minipython.symbol.*;
import org.compilerbau.minipython.symbol.Class;
import org.compilerbau.minipython.symbol.Function;

import java.util.Iterator;
import java.util.function.Supplier;

public class SymbolVisitor extends AstVisitorBase<Object> {
    Scope scope;

    private Symbol nest(Supplier<Symbol> action) {
        Scope parent = scope;
        scope = new Scope();
        if (parent != null) {
            scope.getParents().add(parent);
        }

        Symbol symbol = action.get();

        scope = parent;
        return symbol;
    }

    @Override
    public Object visit(Assignment node) {
        scope.bind(node.getIdentifier().getIdentifier(), new Variable());

        return null;
    }

    @Override
    public Object visit(org.compilerbau.minipython.ast.Class node) {
        scope.bind(node.getName(), nest(() -> {
            String baseName = node.getBase();
            if(baseName != null) {
                Class parent = (Class) scope.resolve(baseName);
                if(parent == null) {
                    throw new RuntimeException("Class " + baseName + " doesn't exist");
                }

                scope.getParents().add(parent.getScope());
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
        nest(() -> {
            for(Statement statement : node.getIfBody()) {
                statement.accept(this);
            }

            node.setIfBodyScope(scope);

            return null;
        });
        nest(() -> {
            for(Statement statement : node.getElseBody()) {
                statement.accept(this);
            }

            node.setElseBodyScope(scope);

            return null;
        });

        return null;
    }

    @Override
    public Object visit(org.compilerbau.minipython.ast.Function node) {
        scope.bind(node.getName(), nest(() -> {
            for (Statement statement: node.getBody()) {
                statement.accept(this);
            }

            node.setScope(scope);

            return new Function(scope);
        }));

        return null;
    }

    @Override
    public Object visit(Loop node) {
        nest(() -> {
            for(Statement statement : node.getBody()) {
                statement.accept(this);
            }

            node.setScope(scope);

            return null;
        });

        return null;
    }

    @Override
    public Object visit(Program node) {
        nest(() -> {
            scope.bind("print", new BuiltIn());

            for(Statement statement : node.getStatements()) {
                statement.accept(this);
            }

            node.setScope(scope);

            return null;
        });

        return null;
    }

    @Override
    public Object visit(Number node) {
        return null;
    }

    @Override
    public Object visit(Text node) {
        return null;
    }

    @Override
    public Object visit(Truth node) {
        return null;
    }

    @Override
    public Object visit(Identifier node) {
        String name = node.getIdentifier();
        Symbol var = scope.resolve(name);

        if(var == null) {
            throw new RuntimeException("Variable " + name + " doesn't exist");
        }

        return null;
    }

    @Override
    public Object visit(Return node) {
        return null;
    }
}
