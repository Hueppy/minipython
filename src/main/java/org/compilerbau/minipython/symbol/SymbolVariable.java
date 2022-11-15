package org.compilerbau.minipython.symbol;

public class SymbolVariable extends SymbolBase {
    public SymbolVariable(String name, Symbol type, Scope scope) {
        super(name, type, scope);
    }
}
