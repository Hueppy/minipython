package org.compilerbau.minipython.ast;

public class Text extends Expression {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toStringTree() {
        return String.format("Text \"%s\"", value);
    }
}
