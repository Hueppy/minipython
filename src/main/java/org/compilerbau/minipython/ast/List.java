package org.compilerbau.minipython.ast;

import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;

public class List extends Expression {
    private final java.util.List<Expression> values;

    public List() {
        values = new ArrayList<>();
    }

    public java.util.List<Expression> getValues() {
        return values;
    }

    @Override
    public String toStringTree() {
        return String.format("List \"%d\"", values.stream().map(x -> x.toStringTree()).reduce((x, y) -> String.format("%s, %s", x, y)));
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
