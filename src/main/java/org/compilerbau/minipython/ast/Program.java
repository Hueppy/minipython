package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.symbol.Scope;
import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends Node {
    private final List<Statement> statements;
    private Scope scope;

    public Program() {
        statements = new ArrayList<>();
    }

    public List<Statement> getStatements() {
        return statements;
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
        return "Program";
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
