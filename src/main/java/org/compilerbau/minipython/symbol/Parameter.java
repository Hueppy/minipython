package org.compilerbau.minipython.symbol;

import java.util.Stack;

public class Parameter extends Variable {
    private final Stack<Object> previousValues;

    public Parameter() {
        previousValues = new Stack<>();
    }

    public void push(Object value) {
        previousValues.push(getValue());
        setValue(value);
    }

    public void pop() {
        setValue(previousValues.pop());
    }
}
