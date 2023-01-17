package org.compilerbau.minipython.ast;

import org.compilerbau.minipython.visitor.AstVisitor;

public class ElementAccess extends Expression {
    private Expression tuple;
    private int index;

    public Expression getTuple() {
        return tuple;
    }

    public void setTuple(Expression tuple) {
        this.tuple = tuple;
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
