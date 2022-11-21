package org.compilerbau.minipython.symbol;
import java.util.*;

public final class Scope {
    private Scope parent;
    private final Map<String, Symbol> symbols;
    public Scope() {
        symbols = new LinkedHashMap<>();
    }

    public void bind(String name, Symbol symbol) {
        symbols.put(name, symbol);
    }

    public Symbol resolve(String name) {
        if (symbols.containsKey(name)) {
            return symbols.get(name);
        } else if (parent != null) {
            return parent.resolve(name);
        }

        return null;
    }

    public Scope getParent() {
        return parent;
    }

    public void setParent(Scope parent) {
        this.parent = parent;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }
}
