package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Class;
import org.compilerbau.minipython.ast.Number;

public abstract class AstVisitorBase<T> implements AstVisitor<T> {
    public T visit(Assignment node) { return null; }
    public T visit(Calculation node) { return null; }
    public T visit(Call node) { return null; }
    public T visit(Comparison node) { return null; }
    public T visit(Class node) { return null; }
    public T visit(Conditional node) { return null; }
    public T visit(Connective node) { return null; }
    public T visit(Function node) { return null; }
    public T visit(Loop node) { return null; }
    public T visit(Number node) { return null; }
    public T visit(Program node) { return null; }
    public T visit(Text node) { return null; }
    public T visit(Truth node) { return null; }
    public T visit(Identifier node) { return null; }
    public T visit(Return node) { return null; }

    public T visit(Block node) {
        return null;
    }
}
