package org.compilerbau.minipython.ast;

public class Identifier extends Expression {
    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toStringTree() {
        return String.format("Identifier \"%s\"", identifier);
    }
}
