package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Program extends Node {
    private final List<Statement> statements;

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
}
