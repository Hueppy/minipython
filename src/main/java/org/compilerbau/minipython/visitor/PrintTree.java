package org.compilerbau.minipython.visitor;

import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Class;
import org.compilerbau.minipython.ast.Number;

import java.util.Iterator;

public class PrintTree extends TraverseBase<String> {

    @Override
    public String visit(Assignment node) {
        return node.getIdentifier() + "=" + visit(node.getExpression());
    }

    @Override
    public String visit(Calculation node) {
        String calc = "";
        Iterator<Expression> it = node.getOperands().iterator();

        while(it.hasNext()) {
            calc += visit(it.next());

            if(it.hasNext()) {
                calc += node;
            }
        }

        return calc;
    }

    @Override
    public String visit(Call node) {
        String parameters = "";
        Iterator<Expression> it = node.getParameter().iterator();

        while(it.hasNext()) {
            parameters += visit(it.next());

            if(it.hasNext()) {
                parameters += ",";
            }
        }

        return node.getIdentifier().getIdentifier() + " " + parameters;
    }

    @Override
    public String visit(Comparison node) {
        String compare = "";

        Iterator<Expression> it = node.getOperands().iterator();

        while(it.hasNext()) {
            compare += visit(it.next());

            if(it.hasNext()) {
                compare += node;
            }
        }

        return compare;
    }

    @Override
    public String visit(Class node) {
        String functions = "";

        for(Function function : node.getFunctions()) {
            functions += visit(function);
        }

        return node.getName() + ":" + node.getBase() + "\n" + functions;
    }

    @Override
    public String visit(Conditional node) {
        String ifBody = "";
        String elseBody = "";

        for(Statement statement : node.getIfBody()) {
            ifBody += visit(statement) + "\n";
        }

        for(Statement statement : node.getElseBody()) {
            elseBody += visit(statement) + "\n";
        }

        String print = "";
        print = "if " + visit(node.getCondition()) + "\n" + ifBody;

        if(!elseBody.isEmpty()) print += "else\n" + elseBody;

        return print;
    }

    @Override
    public String visit(Connective node) {
        for(Expression operand : node.getOperands()) {
            visit(operand);
        }

        return node.getOperator().toString();
    }

    @Override
    public String visit(Function node) {
        String parameters = "";
        String statements = "";
        Iterator<String> it = node.getParameter().iterator();

        while(it.hasNext()) {
            parameters += it.next();

            if(it.hasNext()) {
                parameters += ",";
            }
        }


        for(Statement statement : node.getBody()) {
            statements += visit(statement) + "\n";
        }

        return "def " + node.getName() + " " + parameters + "\n" + statements;
    }

    @Override
    public String visit(Loop node) {
        String statements = "";

        for(Statement statement : node.getBody()) {
            statements += visit(statement) + "\n";
        }

        return "while " + visit(node.getCondition()) + "\n" + statements;
    }

    @Override
    public String visit(Program node) {
        String program = "";

        for(Statement statement : node.getStatements()) {
            program += visit(statement) + "\n";
        }

        return program;
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
        return "return " + visit(node.getExpression());
    }
}
