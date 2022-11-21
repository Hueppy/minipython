package org.compilerbau.minipython.symbol;

public class Function extends Symbol implements Scoped {
    private final Scope scope;

    public Function(Scope scope) {
        this.scope = scope;
    }

    public Scope getScope() {
        return scope;
    }
}
