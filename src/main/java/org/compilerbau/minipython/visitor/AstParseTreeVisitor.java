package org.compilerbau.minipython.visitor;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.compilerbau.minipython.MiniPythonBaseVisitor;
import org.compilerbau.minipython.MiniPythonParser;
import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Class;
import org.compilerbau.minipython.ast.Number;

import java.util.List;

public class AstParseTreeVisitor extends MiniPythonBaseVisitor<Node> {
    private void visitExpressions(List<MiniPythonParser.ExpressionContext> source, List<Expression> target) {
        for (MiniPythonParser.ExpressionContext expression: source) {
            target.add((Expression) expression.accept(this));
        }
    }

    private void visitStatements(List<MiniPythonParser.StatementContext> source, List<Statement> target) {
        for (MiniPythonParser.StatementContext statement: source) {
            target.add((Statement) statement.accept(this));
        }
    }

    @Override
    public Node visitIdentifier(MiniPythonParser.IdentifierContext ctx) {
        Identifier identifier = new Identifier();
        identifier.setIdentifier(ctx.getText());
        return identifier;
    }

    @Override
    public Node visitCallExpression(MiniPythonParser.CallExpressionContext ctx) {
        Call call = new Call();
        call.setIdentifier((Identifier) ctx.call().identifier().accept(this));
        visitExpressions(ctx.call().call_parameter().expression(), call.getParameter());
        return call;
    }

    @Override
    public Node visitFunction(MiniPythonParser.FunctionContext ctx) {
        Function function = new Function();
        function.setName(ctx.IDENTIFIER().getText());
        if (ctx.function_parameter() != null) {
            for (TerminalNode parameter: ctx.function_parameter().IDENTIFIER()) {
                function.getParameter().add(parameter.getText());
            }
        }
        visitStatements(ctx.statements().statement(), function.getBody());
        return function;
    }

    @Override
    public Node visitAssignment(MiniPythonParser.AssignmentContext ctx) {
        Assignment assignment = new Assignment();
        assignment.setIdentifier((Identifier) ctx.identifier().accept(this));
        assignment.setExpression((Expression) ctx.expression().accept(this));
        return assignment;
    }

    @Override
    public Node visitNumberExpression(MiniPythonParser.NumberExpressionContext ctx) {
        Number number = new Number();
        number.setValue(Integer.parseInt(ctx.INT().getText()));
        return number;
    }

    @Override
    public Node visitTextExpression(MiniPythonParser.TextExpressionContext ctx) {
        Text text = new Text();
        text.setValue(ctx.STRING().getText());
        return text;
    }

    @Override
    public Node visitTruthExpression(MiniPythonParser.TruthExpressionContext ctx) {
        Truth truth = new Truth();
        truth.setValue(Boolean.parseBoolean(ctx.BOOLEAN().getText()));
        return truth;
    }

    @Override
    public Node visitMultiplicationExpression(MiniPythonParser.MultiplicationExpressionContext ctx) {
        Calculation calculation = new Calculation();
        calculation.setOperator(Calculation.Operator.Multiplication);
        visitExpressions(ctx.expression(), calculation.getOperands());
        return calculation;
    }

    @Override
    public Node visitDivisionExpression(MiniPythonParser.DivisionExpressionContext ctx) {
        Calculation calculation = new Calculation();
        calculation.setOperator(Calculation.Operator.Division);
        visitExpressions(ctx.expression(), calculation.getOperands());
        return calculation;
    }

    @Override
    public Node visitAdditionExpression(MiniPythonParser.AdditionExpressionContext ctx) {
        Calculation calculation = new Calculation();
        calculation.setOperator(Calculation.Operator.Addition);
        visitExpressions(ctx.expression(), calculation.getOperands());
        return calculation;
    }

    @Override
    public Node visitSubtractionExpression(MiniPythonParser.SubtractionExpressionContext ctx) {
        Calculation calculation = new Calculation();
        calculation.setOperator(Calculation.Operator.Subtraction);
        visitExpressions(ctx.expression(), calculation.getOperands());
        return calculation;
    }

    @Override
    public Node visitEqualityExpression(MiniPythonParser.EqualityExpressionContext ctx) {
        Comparison comparison = new Comparison();
        comparison.setOperator(Comparison.Operator.Equality);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitInequalityExpression(MiniPythonParser.InequalityExpressionContext ctx)  {
        Comparison comparison = new Comparison();
        comparison.setOperator(Comparison.Operator.Inequality);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitGreaterEqualExpression(MiniPythonParser.GreaterEqualExpressionContext ctx)  {
        Comparison comparison = new Comparison();
        comparison.setOperator(Comparison.Operator.GreaterEqual);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitLessEqualExpression(MiniPythonParser.LessEqualExpressionContext ctx)  {
        Comparison comparison = new Comparison();
        comparison.setOperator(Comparison.Operator.LessEqual);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitGreaterThanExpression(MiniPythonParser.GreaterThanExpressionContext ctx)  {
        Comparison comparison = new Comparison();
        comparison.setOperator(Comparison.Operator.GreaterThan);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitLessThanExpression(MiniPythonParser.LessThanExpressionContext ctx)  {
        Comparison comparison = new Comparison();
        comparison.setOperator(Comparison.Operator.LessThan);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitConjunctionExpression(MiniPythonParser.ConjunctionExpressionContext ctx) {
        Connective connective = new Connective();
        connective.setOperator(Connective.Operator.And);
        visitExpressions(ctx.expression(), connective.getOperands());
        return connective;
    }

    @Override
    public Node visitDisjunctionExpression(MiniPythonParser.DisjunctionExpressionContext ctx) {
        Connective connective = new Connective();
        connective.setOperator(Connective.Operator.Or);
        visitExpressions(ctx.expression(), connective.getOperands());
        return connective;
    }

    @Override
    public Node visitSubexpressionExpression(MiniPythonParser.SubexpressionExpressionContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public Node visitConditional(MiniPythonParser.ConditionalContext ctx) {
        Conditional conditional = new Conditional();
        conditional.setCondition((Expression) ctx.if_statement().condition().expression().accept(this));
        visitStatements(ctx.if_statement().statements().statement(), conditional.getIfBody());
        Conditional fold = conditional;
        for (MiniPythonParser.Elif_statementContext elseIf: ctx.elif_statement()) {
            Conditional sub = new Conditional();
            sub.setCondition((Expression) elseIf.condition().expression().accept(this));
            visitStatements(elseIf.statements().statement(), sub.getIfBody());
            fold.getElseBody().add(sub);
            fold = sub;
        }
        if (ctx.else_statement() != null) {
            visitStatements(ctx.else_statement().statements().statement(), fold.getElseBody());
        }

        return conditional;
    }

    @Override
    public Node visitLoop(MiniPythonParser.LoopContext ctx) {
        Loop loop = new Loop();
        loop.setCondition((Expression) ctx.condition().expression().accept(this));
        visitStatements(ctx.statements().statement(), loop.getBody());
        return loop;
    }

    @Override
    public Node visitClass(MiniPythonParser.ClassContext ctx) {
        Class c = new Class();
        c.setName(ctx.IDENTIFIER(0).getText());
        if (ctx.IDENTIFIER(1) != null) {
            c.setBase(ctx.IDENTIFIER(1).getText());
        }
        for (MiniPythonParser.Class_functionContext function: ctx.class_function()) {
            c.getFunctions().add((Function) function.accept(this));
        }
        return c;
    }

    @Override
    public Node visitClass_function(MiniPythonParser.Class_functionContext ctx) {
        Function function = new Function();
        function.setName(ctx.IDENTIFIER().getText());
        function.getParameter().add("self");
        if (ctx.function_parameter() != null) {
            for (TerminalNode parameter: ctx.function_parameter().IDENTIFIER()) {
                function.getParameter().add(parameter.getText());
            }
        }
        visitStatements(ctx.statements().statement(), function.getBody());
        return function;
    }

    @Override
    public Node visitReturn(MiniPythonParser.ReturnContext ctx) {
        Return r = new Return();
        r.setExpression((Expression) ctx.expression().accept(this));
        return r;
    }

    @Override
    public Node visitStart(MiniPythonParser.StartContext ctx) {
        Program program = new Program();
        visitStatements(ctx.statements().statement(), program.getStatements());
        return program;
    }
}
