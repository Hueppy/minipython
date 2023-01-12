package org.compilerbau.minipython.ast;

import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.List;

public class Tuple extends Expression {
    private final List<Expression> expressions;

    public Tuple() {
        expressions = new ArrayList<>();
    }

    public List<Expression> getExpressions() {
        return expressions;
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
