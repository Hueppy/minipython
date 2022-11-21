package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

public abstract class Node implements Tree {
    @Override
    public Tree getParent() {
        return null;
    }

    @Override
    public Object getPayload() {
        return this;
    }

    public Tree getChild(int i) {
        return null;
    }

    public int getChildCount() {
        return 0;
    }

    @Override
    public abstract String toStringTree();

    @Override
    public String toString() {
        return toStringTree();
    }

    public abstract <T> T accept(AstVisitor<T> visitor);
}
