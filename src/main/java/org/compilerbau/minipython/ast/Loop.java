package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.symbol.Scope;
import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.List;

public class Loop extends Statement {
    private Expression condition;
    private final List<Statement> body;
    private Scope scope;

    public Loop() {
        body = new ArrayList<>();
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public int getChildCount() {
        return 1 + body.size();
    }

    @Override
    public Tree getChild(int i) {
        if (i-- == 0) {
            return condition;
        }
        return body.get(i);
    }

    @Override
    public String toStringTree() {
        return "Loop";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
