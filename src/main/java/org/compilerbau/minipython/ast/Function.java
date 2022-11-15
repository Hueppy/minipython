package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Function extends Statement {
    private String name;

    private final List<String> parameter;

    private Block body;

    public Function() {
        parameter = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParameter() {
        return parameter;
    }

    @Override
    public int getChildCount() {
        return 1;
    }

    @Override
    public Tree getChild(int i) {
        return body;
    }

    @Override
    public String toStringTree() {
        return String.format("Function \"%s\" %s", name, parameter);
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
