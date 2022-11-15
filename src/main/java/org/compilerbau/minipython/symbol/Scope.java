package org.compilerbau.minipython.symbol;
import java.util.*;

public class Scope {
    private Scope enclosingScope;
    private LinkedHashMap<String, Symbol> symbols;
    public Scope(Scope enclosingScope) {
        this.enclosingScope = enclosingScope;
        this.symbols = new LinkedHashMap<>();
    }

    public void bind(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
        symbol.setScope(this);
    }

    public Symbol resolve(String name) {
        if (symbols.containsKey(name)) return symbols.get(name);

        try {
            return enclosingScope.resolve(name);
        } catch (Exception e) {
            return null;
        }
    }

    public void setEnclosingScope(Scope enclosingScope) {
        this.enclosingScope = enclosingScope;
    }

    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }
}
