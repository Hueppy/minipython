package org.compilerbau.minipython.symbol;


public class SymbolClass extends Scope implements Symbol, SymbolType {
    String name;
    Scope scope;
    SymbolClass parentClass;
    Symbol type;

    public SymbolClass(String name, Scope enclosingScope, Symbol type, SymbolClass parentClass) {
        super(enclosingScope);
        this.type = type;
        this.name = name;
        this.parentClass = parentClass;
    }

    public Symbol resolve(String name) {
        if (getSymbols().containsKey(name)) {
            return getSymbols().get(name);
        }

        if (parentClass != null) {
            return parentClass.resolve(name);
        }

        try {
            return getEnclosingScope().resolve(name);
        } catch (Exception e) {
            return null;
        }
    }

    public Symbol resolveMember(String name) {
        if (getSymbols().containsKey(name)) {
            return getSymbols().get(name);
        }

        try {
            return parentClass.resolveMember(name);
        } catch (Exception e) {
            return null;
        }
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
        return this.getScope();
    }

    @Override
    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
