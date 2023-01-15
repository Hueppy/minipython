package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.List;

public class Import extends Statement {
    private String path;
    private final List<String> imports;

    private Program program;

    public Import() {
        imports = new ArrayList<>();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int getChildCount() {
        return 1;
    }

    public List<String> getImports() {
        return imports;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public Tree getChild(int i) {
        return program;
    }

    @Override
    public String toStringTree() {
        return "Import " + path + " " + (imports.size() > 0 ? imports.toString() : "");
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
