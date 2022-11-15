package org.compilerbau.minipython.symbol;

public class SymbolBase implements Symbol {
    String name;
    Scope scope;
    Symbol type;
    public SymbolBase(String name, Symbol type, Scope scope) {
        this.type = type;
        this.name = name;
        this.scope = scope;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Symbol getType() {
        return this.type;
    }

    @Override
    public void setType(Symbol type) {
        this.type = type;
    }

    @Override
    public Scope getScope() {
        return this.scope;
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
