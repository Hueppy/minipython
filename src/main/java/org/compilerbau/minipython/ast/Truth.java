package org.compilerbau.minipython.ast;

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
}
