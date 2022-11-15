package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.symbol.Scope;
import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.List;

public class Conditional extends Statement {
    private Expression condition;
    private Block ifBody;
    private Block elseBody;

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    @Override
    public int getChildCount() {
        return 1 + (ifBody != null ? 1 : 0) + (elseBody != null ? 1 : 0);
    }

    @Override
    public Tree getChild(int i) {
        switch (i) {
            case 0:
                return condition;
            case 1:
                return ifBody;
            case 2:
                return elseBody;
            default:
                return super.getChild(i);
        }
    }

    @Override
    public String toStringTree() {
        return "Conditional";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Block getIfBody() {
        return ifBody;
    }

    public void setIfBody(Block ifBody) {
        this.ifBody = ifBody;
    }

    public Block getElseBody() {
        return elseBody;
    }

    public void setElseBody(Block elseBody) {
        this.elseBody = elseBody;
    }
}
