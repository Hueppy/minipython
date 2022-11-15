package org.compilerbau.minipython.ast;

import org.antlr.v4.runtime.tree.Tree;
import org.compilerbau.minipython.visitor.AstVisitor;

public class Program extends Node {
    private Block block;

    public Program() {
        block = new Block();
    }
    @Override
    public Tree getChild(int i) {
        return block;
    }

    @Override
    public int getChildCount() {
        return 1;
    }

    @Override
    public String toStringTree() {
        return "Program";
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
