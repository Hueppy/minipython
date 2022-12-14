package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.List;

public class Calculation extends Expression {
    public enum Operator {
        Multiplication,
        Division,
        Addition,
        Subtraction;

        public String getSymbol() {
            switch (this) {
                case Multiplication:
                    return "*";
                case Division:
                    return "/";
                case Addition:
                    return "+";
                case Subtraction:
                    return "-";
                default:
                    return "";
            }
        }
    }

    private Operator operator;
    private final List<Expression> operands;

    public Calculation() {
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
        return String.format("Calculation \"%s\"", operator.getSymbol());
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
