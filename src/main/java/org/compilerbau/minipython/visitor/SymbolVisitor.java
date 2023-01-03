package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Import;
import org.compilerbau.minipython.symbol.*;
import org.compilerbau.minipython.symbol.Class;
import org.compilerbau.minipython.symbol.Function;

import java.util.Map;
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
    public Object visit(Call node) {
        Identifier identifier = node.getIdentifier();
        identifier.accept(this);

        while (identifier.hasNext()) {
            identifier = identifier.getNext();
            identifier.accept(this);
        }

        return null;
    }

    @Override
    public Object visit(Assignment node) {
        Identifier identifier = node.getIdentifier();
        node.getExpression().accept(this);
        if (scope.resolve(identifier) == null) {
            scope.bind(identifier, new Variable());
        }

        return null;
    }
    @Override
    // TODO * imports
    public Object visit(Import node) {
        node.getProgram().accept(this);
        org.compilerbau.minipython.symbol.Import imported = new org.compilerbau.minipython.symbol.Import(node.getProgram().getBlock().getScope());

        if(node.getImports().size() == 0) {
            for(String importIdentifier : node.getProgram().getBlock().getScope().getSymbols().keySet()) {
                scope.getParent().bind(importIdentifier, imported);
            }
        } else {
            for(String importIdentifier : node.getImports()) {
                // Check if imports are valid
                Symbol symbol = node.getProgram().getBlock().getScope().resolve(importIdentifier);

                if(symbol == null) {
                    throw new SymbolException(importIdentifier + " doesn't exist in " + node.getPath());
                } else if (scope.getParent().resolve(importIdentifier) != null) {
                    throw new SymbolException(importIdentifier + " is already imported or defined");
                }

                scope.getParent().bind(importIdentifier, imported);
            }
        }

        return null;
    }

    @Override
    public Object visit(Identifier node) {
        Symbol symbol = scope.resolve(node.getIdentifier());

        /*
        if(symbol == null) {
            throw new SymbolException(node.getIdentifier() + " is not defined");
        }
        */

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
            Class newClass = new Class(scope);
            newClass.setClass(node);

            return newClass;
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
