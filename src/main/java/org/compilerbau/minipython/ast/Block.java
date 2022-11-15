package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.symbol.Scope;
import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.List;

public class Block extends Node {
    private final List<Statement> statements;
    private Scope scope;

    public Block() {
        statements = new ArrayList<>();
    }

    @Override
    public Tree getChild(int i) {
        return statements.get(i);
    }

    @Override
    public int getChildCount() {
        return statements.size();
    }

    @Override
    public String toStringTree() {
        return "Block";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
