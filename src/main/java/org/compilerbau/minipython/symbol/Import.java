package org.compilerbau.minipython.symbol;

public class Import extends Symbol implements Scoped {
    private final Scope scope;

    public Import(Scope scope) {
        this.scope = scope;
    }

    @Override
    public Scope getScope() {
        return scope;
    }
}
