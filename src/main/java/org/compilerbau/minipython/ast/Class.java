package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Class extends Statement {
    private String name;
    private String base;
    private final List<Function> functions;

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
}