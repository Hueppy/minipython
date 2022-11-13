package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Conditional extends Statement {
    private Expression condition;
    private final List<Statement> ifBody;
    private final List<Statement> elseBody;

    public Conditional() {
        ifBody = new ArrayList<>();
        elseBody = new ArrayList<>();
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    @Override
    public int getChildCount() {
        return 1 + ifBody.size() + elseBody.size();
    }

    @Override
    public Tree getChild(int i) {
        if (i-- == 0) {
            return condition;
        }
        if (i < ifBody.size()) {
            return ifBody.get(i);
        }
        return elseBody.get(i - ifBody.size());
    }

    @Override
    public String toStringTree() {
        return String.format("Conditional");
    }
}
