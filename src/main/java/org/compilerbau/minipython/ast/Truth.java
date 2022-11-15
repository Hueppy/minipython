package org.compilerbau.minipython.ast;

import org.compilerbau.minipython.visitor.AstVisitor;

public class Truth extends Expression {
    private boolean value;

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toStringTree() {
        return String.format("Truth \"%b\"", value);
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
