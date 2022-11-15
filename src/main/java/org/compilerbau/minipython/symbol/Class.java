package org.compilerbau.minipython.symbol;


public class Class extends Symbol {
    private final Scope scope;

    public Class(Scope scope) {
        this.scope = scope;
    }

    public Scope getScope() {
        return scope;
    }
}
