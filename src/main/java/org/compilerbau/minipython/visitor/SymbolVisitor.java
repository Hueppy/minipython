package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Class;
import org.compilerbau.minipython.ast.Number;
import org.compilerbau.minipython.symbol.*;

import java.util.Iterator;

public class SymbolVisitor extends TraverseBase {
    Scope scope;

    @Override
    public Object visit(Assignment node) {

        Symbol type = (Symbol) visit(node.getExpression());

        if(type != null) {
            scope.bind(new SymbolVariable(node.getIdentifier().getIdentifier(), type, scope));
        } else {
            scope.bind(new SymbolVariable(node.getIdentifier().getIdentifier(), null, scope));
        }

        return null;
    }

    @Override
    public Object visit(Calculation node) {
        Iterator<Expression> it = node.getOperands().iterator();

        while(it.hasNext()) {
           visit(it.next());
        }

        return null;
    }

    @Override
    public Object visit(Call node) {
        String name = node.getIdentifier().getIdentifier();
        Symbol func = scope.resolve(name);

        if(func == null) {
            throw new RuntimeException("Function " + name + "() doesn't exist");
        } else if(func instanceof SymbolVariable) {
            throw new RuntimeException("Can't call " + name + " because it's a variable");
        }

        Iterator<Expression> it = node.getParameter().iterator();

        scope = new Scope(scope);

        while(it.hasNext()) {
            visit(it.next());
        }

        scope = scope.getEnclosingScope();

        return func;
    }

    @Override
    public Object visit(Comparison node) {
        Iterator<Expression> it = node.getOperands().iterator();

        while(it.hasNext()) {
            visit(it.next());
        }

        return null;
    }

    @Override
    public Object visit(Class node) {
        String name = node.getName();
        String baseName = node.getBase();
        SymbolClass parentClass = null;

        if(baseName != null) {
            SymbolClass symbolClass = (SymbolClass) scope.resolve(baseName);

            if(symbolClass == null) {
                throw new RuntimeException("Class " + baseName + " doesn't exist");
            }

            parentClass = symbolClass;
        }

        Symbol symbolClass = new SymbolClass(name, scope, null, parentClass);
        scope.bind(symbolClass);

        scope = (Scope) symbolClass;

        for(Function function : node.getFunctions()) {
            visit(function);
        }

        scope = scope.getEnclosingScope();

        return symbolClass;
    }

    @Override
    public Object visit(Conditional node) {
        visit(node.getCondition());

        for(Statement statement : node.getIfBody()) {
            visit(statement);
        }

        for(Statement statement : node.getElseBody()) {
            visit(statement);
        }

        return null;
    }

    @Override
    public Object visit(Connective node) {
        for(Expression operand : node.getOperands()) {
            visit(operand);
        }

        return null;
    }

    @Override
    public Object visit(Function node) {
        String name = node.getName();
        SymbolFunction func = new SymbolFunction(name, null, scope);

        Symbol symbol = scope.resolve(name);

        if(symbol != null) {
            throw new RuntimeException("Name " + name + " is already taken or declared");
        }

        scope.bind(func);

        Iterator<String> it = node.getParameter().iterator();

        scope = func;

        while(it.hasNext()) {
            String parameter = it.next();
            SymbolVariable var = new SymbolVariable(parameter, null, scope);
            scope.bind(var);
        }

        for(Statement statement : node.getBody()) {
            visit(statement);
        }

        scope = scope.getEnclosingScope();

        return null;
    }

    @Override
    public Object visit(Loop node) {
        visit(node.getCondition());

        scope = new Scope(scope);

        for(Statement statement : node.getBody()) {
            visit(statement);
        }

        scope = scope.getEnclosingScope();

        return null;
    }

    @Override
    public Object visit(Program node) {
        Scope globals = new Scope(null);
        globals.bind(new BuiltIn("print"));
        scope = globals;

        for(Statement statement : node.getStatements()) {
            visit(statement);
        }

        return scope;
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
