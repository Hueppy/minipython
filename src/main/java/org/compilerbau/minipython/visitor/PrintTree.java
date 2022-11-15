package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Class;
import org.compilerbau.minipython.ast.Number;

import java.util.Arrays;
import java.util.Iterator;

public class PrintTree extends AstVisitorBase<String> {

    @Override
    public String visit(Assignment node) {
        return String.format("%s = %s",
                node.getIdentifier().accept(this),
                node.getExpression().accept(this)
        );
    }

    @Override
    public String visit(Calculation node) {
        return node.getOperands().stream()
                .map(x -> x.accept(this))
                .reduce((x, y) -> String.format("%s %s %s", x, node.getOperator().getSymbol(), y))
                .orElse("");
    }

    @Override
    public String visit(Call node) {
        return String.format("%s(%s)",
                node.getIdentifier().accept(this),
                node.getParameter().stream()
                        .map(x -> x.accept(this))
                        .reduce((x, y) -> String.format("%s, %s", x, y))
                        .orElse("")
        );
    }

    @Override
    public String visit(Comparison node) {
        return node.getOperands().stream()
                .map(x -> x.accept(this))
                .reduce((x, y) -> String.format("%s %s %s", x, node.getOperator().getSymbol(), y))
                .orElse("");
    }

    @Override
    public String visit(Class node) {
        return String.format("class %s(%s) {\n%s\n}",
                node.getName(),
                node.getBase(),
                node.getFunctions().stream()
                        .map(x -> x.accept(this))
                        .reduce((x, y) -> String.format("%s\n%s", x, y))
                        .orElse("")
        );
    }

    @Override
    public String visit(Conditional node) {
        return String.format("if %s {\n%s\n} else {\n%s\n}",
                node.getCondition().accept(this),
                node.getIfBody().stream()
                        .map(x -> x.accept(this))
                        .reduce((x, y) -> String.format("x\ny", x, y))
                        .orElse(""),
                node.getElseBody().stream()
                        .map(x -> x.accept(this))
                        .reduce((x, y) -> String.format("x\ny", x, y))
                        .orElse("")
        );
    }

    @Override
    public String visit(Connective node) {
        return node.getOperands().stream()
                .map(x -> x.accept(this))
                .reduce((x, y) -> String.format("%s %s %s", x, node.getOperator().getSymbol(), y))
                .orElse("");
    }

    @Override
    public String visit(Function node) {
        return String.format("def %s(%s) {\n%s\n}",
                node.getName(),
                String.join(", ", node.getParameter()),
                node.getBody().stream()
                        .map(x -> x.accept(this))
                        .reduce((x, y) -> String.format("%s\n%s", x, y))
                        .orElse("")
        );
    }

    @Override
    public String visit(Loop node) {
        return String.format("while %s {\n%s\n}",
                node.getCondition().accept(this),
                node.getBody().stream()
                        .map(x -> x.accept(this))
                        .reduce((x, y) -> String.format("%s\n%s", x, y))
                        .orElse("")
        );
    }

    @Override
    public String visit(Program node) {
        return node.getStatements().stream()
                .map(x -> x.accept(this))
                .reduce((x, y) -> String.format("%s\n%s", x, y))
                .orElse("");
    }

    @Override
    public String visit(Number node) {
        return String.valueOf(node.getValue());
    }

    @Override
    public String visit(Text node) {
        return node.getValue();
    }

    @Override
    public String visit(Truth node) {
        return String.valueOf(node.getValue());
    }

    @Override
    public String visit(Identifier node) {
        return node.getIdentifier();
    }

    @Override
    public String visit(Return node) {
        return String.format("return %s", node.getExpression().accept(this));
    }
}
