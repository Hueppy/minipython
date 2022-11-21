package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.symbol.Scope;
import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.List;

public class Class extends Statement {
    private String name;
    private String base;
    private final List<Function> functions;

    private Scope scope;

    public Class() {
        functions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    @Override
    public int getChildCount() {
        return functions.size();
    }

    @Override
    public Tree getChild(int i) {
        return functions.get(i);
    }

    @Override
    public String toStringTree() {
        return String.format("Class \"%s\" (%s)", name, base);
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
