package org.compilerbau.minipython.ast;

import org.compilerbau.minipython.visitor.AstVisitor;

public class Number extends Expression {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toStringTree() {
        return String.format("Number \"%d\"", value);
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
