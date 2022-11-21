package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

public class Negation extends Expression {
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Tree getChild(int i) {
        return expression;
    }

    @Override
    public int getChildCount() {
        return 1;
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
