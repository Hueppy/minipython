package org.compilerbau.minipython.ast;

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
}
