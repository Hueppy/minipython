package org.compilerbau.minipython.ast;

import org.compilerbau.minipython.visitor.AstVisitor;

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

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
