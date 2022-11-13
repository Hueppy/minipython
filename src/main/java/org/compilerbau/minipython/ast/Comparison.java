package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Comparison extends Expression {
    public static enum Operator {
        Equality,
        Inequality,
        GreaterEqual,
        LessEqual,
        GreaterThan,
        LessThan;

        String getSymbol() {
            switch (this) {
                case Equality:
                    return "==";
                case Inequality:
                    return "!=";
                case GreaterEqual:
                    return ">=";
                case LessEqual:
                    return "<=";
                case GreaterThan:
                    return ">";
                case LessThan:
                    return "<";
                default:
                    return "";
            }
        }
    }

    ;

    private Operator operator;
    private final List<Expression> operands;

    public Comparison() {
        operands = new ArrayList<>();
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public List<Expression> getOperands() {
        return operands;
    }

    @Override
    public int getChildCount() {
        return operands.size();
    }

    @Override
    public Tree getChild(int i) {
        return operands.get(i);
    }

    @Override
    public String toStringTree() {
        return String.format("Comparison \"%s\"", operator.getSymbol());
    }
}
