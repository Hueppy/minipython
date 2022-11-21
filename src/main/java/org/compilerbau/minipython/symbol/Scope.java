package org.compilerbau.minipython.symbol;
import org.compilerbau.minipython.ast.Identifier;

import java.util.*;

public final class Scope {
    public static final Scope EMPTY = new Scope();
    private Scope parent;
    private final Map<String, Symbol> symbols;
    public Scope() {
        symbols = new LinkedHashMap<>();
    }

    public void bind(String name, Symbol symbol) {
        symbols.put(name, symbol);
    }

    public void bind(Identifier identifier, Symbol symbol) {
        Scope scope = this;

        if (identifier.hasNext()) {
            Symbol scoped = resolve(identifier.getIdentifier());
            if (scoped instanceof Scoped) {
                scope = ((Scoped) scoped).getScope();
            }
        }

        scope.bind(identifier.getIdentifier(), symbol);
    }

    public Symbol resolve(String name) {
        if (symbols.containsKey(name)) {
            return symbols.get(name);
        } else if (parent != null) {
            return parent.resolve(name);
        }

        return null;
    }

    public Symbol resolve(Identifier identifier) {
        Symbol result = resolve(identifier.getIdentifier());

        if (identifier.hasNext() && result instanceof Scoped) {
            result = ((Scoped) result).getScope().resolve(identifier.getNext());
        }

        return result;
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
