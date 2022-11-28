package org.compilerbau.minipython.symbol;

public class Function extends Symbol implements Scoped {
    private final Scope scope;

    private org.compilerbau.minipython.ast.Function function;

    public Function(Scope scope) {
        this.scope = scope;
    }

    public Scope getScope() {
        return scope;
    }

    public org.compilerbau.minipython.ast.Function getFunction() {
        return function;
    }

    public void setFunction(org.compilerbau.minipython.ast.Function function) {
        this.function = function;
    }
}
