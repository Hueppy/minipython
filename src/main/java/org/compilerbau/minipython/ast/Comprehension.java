package org.compilerbau.minipython.ast;

import org.compilerbau.minipython.visitor.AstVisitor;

public class Comprehension extends Expression {
    private Expression expression;
    private Identifier identifier;
    private Expression list;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Expression getList() {
        return list;
    }

    public void setList(Expression list) {
        this.list = list;
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
