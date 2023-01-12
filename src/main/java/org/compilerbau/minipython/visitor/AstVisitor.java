package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Number;

public interface AstVisitor<T> {
    T visit(Assignment node);
    T visit(Tuple node);
    T visit(Calculation node);
    T visit(Call node);
    T visit(Comparison node);
    T visit(org.compilerbau.minipython.ast.Class node);
    T visit(Conditional node);
    T visit(Connective node);
    T visit(Negation node);
    T visit(Function node);
    T visit(Loop node);
    T visit(Number node);
    T visit(Program node);
    T visit(Text node);
    T visit(Truth node);
    T visit(Identifier node);
    T visit(Return node);
    T visit(Import node);
    T visit(Block node);
}
