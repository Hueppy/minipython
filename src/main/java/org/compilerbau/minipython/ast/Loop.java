package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

public class Loop extends Statement {
    private Expression condition;
    private Block body;

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    @Override
    public int getChildCount() {
        return body != null ? 2 : 1;
    }

    @Override
    public Tree getChild(int i) {
        switch (i) {
            case 0:
                return condition;
            case 1:
                return body;
            default:
                return super.getChild(i);
        }
    }

    @Override
    public String toStringTree() {
        return "Loop";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Block getBody() {
        return body;
    }

    public void setBody(Block body) {
        this.body = body;
    }
}
