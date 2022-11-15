package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.List;

public class Call extends Expression {
    private Identifier identifier;
    private final List<Expression> parameter;


    public Call() {
        parameter = new ArrayList<>();
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public List<Expression> getParameter() {
        return parameter;
    }

    @Override
    public int getChildCount() {
        return 1 + parameter.size();
    }

    @Override
    public Tree getChild(int i) {
        if (i-- == 0) {
            return identifier;
        }
        return parameter.get(i);
    }

    @Override
    public String toStringTree() {
        return "Call";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
