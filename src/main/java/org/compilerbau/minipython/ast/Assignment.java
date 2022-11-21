package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

public class Assignment extends Statement {
    private Identifier identifier;
    private Expression expression;

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Tree getChild(int i) {
        switch (i) {
            case 0:
                return identifier;
            case 1:
                return expression;
            default:
                return super.getChild(i);
        }
    }

    @Override
    public int getChildCount() {
        return 2;
    }

    @Override
    public String toStringTree() {
        return "Assignment";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
