package org.compilerbau.minipython.symbol;
import java.util.*;

public final class Scope {
    private final List<Scope> parents;
    private final Map<String, Symbol> symbols;
    public Scope() {
        parents = new ArrayList<>();
        symbols = new LinkedHashMap<>();
    }

    public void bind(String name, Symbol symbol) {
        symbols.put(name, symbol);
    }

    public Symbol resolve(String name) {
        if (symbols.containsKey(name)) {
            return symbols.get(name);
        } else {
            for (Scope parent: parents) {
                Symbol symbol = parent.resolve(name);
                if (symbol != null) {
                    return symbol;
                }
            }
        }

        return null;
    }

    public List<Scope> getParents() {
        return parents;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }
}
