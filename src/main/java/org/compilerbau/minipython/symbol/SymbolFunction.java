package org.compilerbau.minipython.symbol;

public class SymbolFunction extends Scope implements Symbol {
    String name;
    Scope scope;
    Symbol type;

    public SymbolFunction(String name, Symbol type, Scope enclosingScope) {
        super(enclosingScope);
        this.type = type;
        this.name = name;
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
