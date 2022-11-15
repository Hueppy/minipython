package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.symbol.*;
import org.compilerbau.minipython.symbol.Class;
import org.compilerbau.minipython.symbol.Function;

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
        node.getIfBody().accept(this);
        if (node.getElseBody() != null) {
            node.getElseBody().accept(this);
        }

        return null;
    }

    @Override
    public Object visit(org.compilerbau.minipython.ast.Function node) {
        node.getBody().accept(this);
        scope.bind(node.getName(), new Function(node.getBody().getScope()));

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
            scope.bind("print", new BuiltIn());

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
