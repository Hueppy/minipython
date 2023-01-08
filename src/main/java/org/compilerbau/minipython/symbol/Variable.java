package org.compilerbau.minipython.symbol;

import java.util.List;
import java.util.Map;

public class Variable extends Symbol implements Scoped {
    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public Scope getScope() {
        if (value instanceof Scoped) {
            return ((Scoped) value).getScope();
        }
        return Scope.EMPTY;
    }
}
