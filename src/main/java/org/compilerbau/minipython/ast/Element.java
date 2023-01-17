package org.compilerbau.minipython.ast;

import org.compilerbau.minipython.visitor.AstVisitor;

public class Element extends Expression {
    private Identifier identifier;
    private int index;

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toStringTree() {
        return null;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
