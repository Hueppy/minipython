package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Class;
import org.compilerbau.minipython.ast.Number;

public abstract class TraverseBase<T> {
    public abstract T visit(Assignment node);
    public abstract T visit(Calculation node);
    public abstract T visit(Call node);
    public abstract T visit(Comparison node);
    public abstract T visit(Class node);
    public abstract T visit(Conditional node);
    public abstract T visit(Connective node);
    //public abstract T visit(Expression node);
    public abstract T visit(Function node);
    public abstract T visit(Loop node);
    public abstract T visit(Number node);
    public abstract T visit(Program node);
    //public abstract T visit(Statement node);
    public abstract T visit(Text node);
    public abstract T visit(Truth node);
    public abstract T visit(Identifier node);
    public abstract T visit(Return node);

    public T visit(Statement node) {
        if(node instanceof Assignment) {
            return visit((Assignment) node);
        } else if(node instanceof Comparison) {
            return visit((Comparison) node);
        } else if(node instanceof Call) {
            return visit((Call) node);
        } else if(node instanceof Class) {
            return visit((Class) node);
        } else if(node instanceof Conditional) {
            return visit((Conditional) node);
        } else if(node instanceof Function) {
            return visit((Function) node);
        } else if(node instanceof Loop) {
            return visit((Loop) node);
        } else if(node instanceof Identifier) {
            return visit((Identifier) node);
        } else if(node instanceof Return) {
            return visit((Return) node);
        } else {
            throw new RuntimeException("Unknown instance " + node.getClass().toString() + " in Statement");
        }
    }

    public T visit(Expression node) {
        if(node instanceof Text) {
            return visit((Text) node);
        } else if (node instanceof Identifier) {
            return visit((Identifier) node);
        } else if (node instanceof Number) {
            return visit((Number) node);
        } else if (node instanceof Call) {
            return visit((Call) node);
        } else if (node instanceof Calculation) {
            return visit((Calculation) node);
        } else if (node instanceof Comparison) {
            return visit((Comparison) node);
        } else {
            throw new RuntimeException("Unknown instance " + node.getClass().toString() + " in Expression");
        }
    }

    public T visit(Node node) {
        if(node instanceof Assignment) {
            return visit((Assignment) node);
        } else if(node instanceof Calculation) {
            return visit((Calculation) node);
        } else if(node instanceof Call) {
            return visit((Call) node);
        } else if(node instanceof Comparison) {
            return visit((Comparison) node);
        } else if(node instanceof Class) {
            return visit((Class) node);
        } else if(node instanceof Conditional) {
            return visit((Conditional) node);
        } else if(node instanceof Connective) {
            return visit((Connective) node);
        } else if(node instanceof Expression) {
            return visit((Expression) node);
        } else if(node instanceof Function) {
            return visit((Function) node);
        } else if(node instanceof Loop) {
            return visit((Loop) node);
        } else if(node instanceof Number) {
            return visit((Number) node);
        } else if(node instanceof Program) {
            return visit((Program) node);
        } else if(node instanceof Statement) {
            return visit((Statement) node);
        } else if(node instanceof Text) {
            return visit((Text) node);
        } else if(node instanceof Truth) {
            return visit((Truth) node);
        } else if(node instanceof Identifier) {
            return visit((Identifier) node);
        } else {
            throw new RuntimeException("Unknown instance " + node.getClass().toString() + " in Node");
        }
    }
}
