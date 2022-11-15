package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Function extends Statement {
    private String name;

    private final List<String> parameter;
    private final List<Statement> body;

    public Function() {
        parameter = new ArrayList<>();
        body = new ArrayList<>();
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

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public int getChildCount() {
        return body.size();
    }

    @Override
    public Tree getChild(int i) {
        return body.get(i);
    }

    @Override
    public String toStringTree() {
        return String.format("Function \"%s\" %s", name, parameter);
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
