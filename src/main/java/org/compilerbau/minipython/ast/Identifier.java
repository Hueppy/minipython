package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

public class Identifier extends Expression {
    private String identifier;
    private Identifier next;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Identifier getNext() {
        return next;
    }

    public void setNext(Identifier next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public int getChildCount() {
        return next == null ? 0 : 1;
    }

    @Override
    public Tree getChild(int i) {
        return next;
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
