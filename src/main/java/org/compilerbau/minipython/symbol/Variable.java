package org.compilerbau.minipython.symbol;

public class Variable extends Symbol {
    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
