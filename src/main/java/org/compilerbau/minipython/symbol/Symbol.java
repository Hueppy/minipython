package org.compilerbau.minipython.symbol;

public interface Symbol {
    String getName();
    void setName(String name);
    Symbol getType();
    void setType(Symbol type);
    Scope getScope();
    void setScope(Scope scope);
}
