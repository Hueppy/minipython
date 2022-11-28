package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.Function;
import org.compilerbau.minipython.ast.Number;
import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.symbol.*;
import org.compilerbau.minipython.symbol.Class;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterpretingVisitor extends AstVisitorBase<Object> {
    public static class InterpreterException extends RuntimeException {
        public InterpreterException(String message) {
            super(message);
        }
    }

    private Scope scope;

    private Object enter(Scope scope, Supplier<Object> action) {
        Scope old = this.scope;
        this.scope = scope;

        Object result = action.get();

        this.scope = old;
        return result;
    }

    private void pushParameter(List<String> names, List<Object> values) {
        for (int i = 0; i < names.size(); i++) {
            Symbol param = scope.resolve(names.get(i));
            if (param instanceof Parameter) {
                ((Parameter) param).push(values.get(i));
            }
        }
    }

    private void popParameter(List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            Symbol param = scope.resolve(names.get(i));
            if (param instanceof Parameter) {
                ((Parameter) param).pop();
            }
        }
    }

    @Override
    public Object visit(Assignment node) {
        super.visit(node);

        Symbol symbol;
        if(node.getIdentifier().getIdentifier().equals("self")) {
            if(node.getIdentifier().getNext() == null) {
                throw new InterpreterException("Can't assign values directly to self");
            }

            symbol = scope.resolve(node.getIdentifier().getIdentifier());
            String var = node.getIdentifier().getNext().getIdentifier();
            Class.Instance instance = (Class.Instance) ((Variable) symbol).getValue();

            if(instance.getScope().resolveLocally(var) == null) {
                instance.getScope().bind(var, new Variable());
            }

            Symbol selfSymbol = instance.getScope().resolveLocally(var);

            if(selfSymbol instanceof Variable) {
                ((Variable) selfSymbol).setValue(node.getExpression().accept(this));
            }
        } else {
            symbol = scope.resolve(node.getIdentifier());
            if (symbol instanceof Variable) {
                ((Variable) symbol).setValue(node.getExpression().accept(this));
            }
        }

        return null;
    }

    @Override
    public Object visit(Identifier node) {
        Symbol symbol = scope.resolve(node);

        if (symbol instanceof Variable) {
            return ((Variable) symbol).getValue();
        } else if (symbol == null && node.getIdentifier().equals("self")) {
            // Bind class attribute if not found
            symbol = scope.resolve(node.getIdentifier());
            Class.Instance instance = (Class.Instance) ((Variable) symbol).getValue();
            instance.getScope().bind(node.getNext().getIdentifier(), new Variable());

            return null;
        } else if (symbol == null) {
            throw new InterpreterException(node.getIdentifier() + " doesn't exist");
        } else {
            throw new InterpreterException(node.getIdentifier() + " is not a variable");
        }
    }

    @Override
    public Object visit(Number node) {
        return node.getValue();
    }

    @Override
    public Object visit(Text node) {
        return node.getValue();
    }

    @Override
    public Object visit(Truth node) {
        return node.getValue();
    }

    @Override
    public Object visit(Calculation node) {
        List<Object> operands = node.getOperands().stream()
                .map(x -> x.accept(this))
                .collect(Collectors.toList());

        if (operands.stream().allMatch(x -> x instanceof Integer)) {
            switch (node.getOperator()) {
                case Multiplication:
                    return operands.stream().reduce((x, y) -> (int)x * (int)y).orElse(1);
                case Division:
                    return operands.stream().reduce((x, y) -> (int)x / (int)y).orElse(1);
                case Addition:
                    return operands.stream().reduce((x, y) -> (int)x + (int)y).orElse(0);
                case Subtraction:
                    return operands.stream().reduce((x, y) -> (int)x - (int)y).orElse(0);
            }
        } else if (operands.stream().anyMatch(x -> x instanceof String) && node.getOperator() == Calculation.Operator.Addition) {
            return operands.stream().reduce((x, y) -> x + y.toString()).orElse("");
        } else {
            throw new InterpreterException("Calculation error");
        }

        return null;
    }

    @Override
    public Object visit(Comparison node) {
        List<Object> operands = node.getOperands().stream()
                .map(x -> x.accept(this))
                .collect(Collectors.toList());

        if (operands.stream().allMatch(x -> x instanceof Integer)) {
            switch (node.getOperator()) {
                case Equality:
                    return operands.stream().reduce((x, y) -> (int)x == (int) y).orElse(true);
                case Inequality:
                    return operands.stream().reduce((x, y) -> (int)x != (int) y).orElse(true);
                case GreaterEqual:
                    return operands.stream().reduce((x, y) -> (int)x >= (int) y).orElse(true);
                case LessEqual:
                    return operands.stream().reduce((x, y) -> (int)x <= (int) y).orElse(true);
                case GreaterThan:
                    return operands.stream().reduce((x, y) -> (int)x > (int) y).orElse(true);
                case LessThan:
                    return operands.stream().reduce((x, y) -> (int)x < (int) y).orElse(true);
            }
        } else if (operands.stream().allMatch(x -> x instanceof String)) {
            switch (node.getOperator()) {
                case Equality:
                    return operands.stream().reduce((x, y) -> ((String)x).compareTo((String)y) == 0).orElse(true);
                case Inequality:
                    return operands.stream().reduce((x, y) -> ((String)x).compareTo((String)y) != 0).orElse(true);
                case GreaterEqual:
                    return operands.stream().reduce((x, y) -> ((String)x).compareTo((String)y) >= 0).orElse(true);
                case LessEqual:
                    return operands.stream().reduce((x, y) -> ((String)x).compareTo((String)y) <= 0).orElse(true);
                case GreaterThan:
                    return operands.stream().reduce((x, y) -> ((String)x).compareTo((String)y) > 0).orElse(true);
                case LessThan:
                    return operands.stream().reduce((x, y) -> ((String)x).compareTo((String)y) < 0).orElse(true);
            }
        } else if (operands.stream().allMatch(x -> x instanceof Boolean)
                && (node.getOperator() == Comparison.Operator.Equality || node.getOperator() == Comparison.Operator.Inequality)) {
            switch (node.getOperator()) {
                case Equality:
                    return operands.stream().reduce((x, y) -> (boolean) x == (boolean) y).orElse(true);
                case Inequality:
                    return operands.stream().reduce((x, y) -> (boolean) x != (boolean) y).orElse(true);
            }
        } else {
            throw new InterpreterException("Comparison error");
        }

        return null;
    }

    @Override
    public Object visit(Connective node) {
        List<Object> operands = node.getOperands().stream()
                .map(x -> x.accept(this))
                .collect(Collectors.toList());

        if (operands.stream().allMatch(x -> x instanceof Boolean)) {
            switch (node.getOperator()) {
                case And:
                    return operands.stream().reduce((x, y) -> (boolean)x && (boolean) y).orElse(true);
                case Or:
                    return operands.stream().reduce((x, y) -> (boolean)x || (boolean) y).orElse(true);
            }
        } else {
            throw new InterpreterException("Connective error");
        }

        return null;
    }

    @Override
    public Object visit(Negation node) {
        Object expression = node.getExpression().accept(this);

        if (expression instanceof Boolean) {
            return !(boolean)expression;
        } else {
            throw new InterpreterException(node.getExpression() + " is not a boolean");
        }
    }

    @Override
    public Object visit(Return node) {
        return node.getExpression().accept(this);
    }

    @Override
    public Object visit(Call node) {
        List<Object> parameter = node.getParameter().stream().map(x -> x.accept(this)).collect(Collectors.toList());

        Symbol symbol = scope.resolve(node.getIdentifier());
        if (symbol instanceof org.compilerbau.minipython.symbol.Function) {
            Function function = ((org.compilerbau.minipython.symbol.Function) symbol).getFunction();
            if (function.getParameter().stream().anyMatch(s -> s.equals("self"))) {
                parameter.add(0, ((Variable) scope.resolve(node.getIdentifier().removeLast())).getValue());
            }

            return enter(function.getScope(), () -> {
                pushParameter(function.getParameter(), parameter);
                Object result = function.getBody().accept(this);
                popParameter(function.getParameter());
                return result;
            });
        } else if (symbol instanceof org.compilerbau.minipython.symbol.Class) {
            return ((Class) symbol).instantiate();
        } else if (symbol instanceof BuiltInFunction) {
            BuiltInFunction function = (BuiltInFunction) symbol;
            return function.run(parameter);
        } else {
            throw new InterpreterException("Call error on " + node.getIdentifier());
        }
    }

    @Override
    public Object visit(Conditional node) {
        if ((boolean) node.getCondition().accept(this)) {
            return node.getIfBody().accept(this);
        } else if (node.hasElseBody()) {
            return node.getElseBody().accept(this);
        }

        return null;
    }

    @Override
    public Object visit(Loop node) {
        Object result = null;

        while ((boolean) node.getCondition().accept(this)) {
            result = node.getBody().accept(this);
        }

        return result;
    }

    @Override
    public Object visit(Program node) {
        return node.getBlock().accept(this);
    }

    @Override
    public Object visit(Block node) {
        return enter(node.getScope(), () -> {
            Object result = null;
            for (Statement statement: node.getStatements()) {
                result = statement.accept(this);
            }
            return result;
        });
    }
}
