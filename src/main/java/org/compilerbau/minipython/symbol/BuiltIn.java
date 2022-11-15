package org.compilerbau.minipython.symbol;

public class BuiltIn extends SymbolBase implements SymbolType {

    public BuiltIn(String name) {
        super(name, null, null);
    }
}
