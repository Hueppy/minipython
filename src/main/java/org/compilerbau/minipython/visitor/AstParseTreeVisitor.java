package org.compilerbau.minipython.visitor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.compilerbau.minipython.MiniPythonBaseVisitor;
import org.compilerbau.minipython.MiniPythonLexer;
import org.compilerbau.minipython.MiniPythonParser;
import org.compilerbau.minipython.ast.*;
import org.compilerbau.minipython.ast.Class;
import org.compilerbau.minipython.ast.Number;

import java.io.IOException;
import java.util.List;

public class AstParseTreeVisitor extends MiniPythonBaseVisitor<Node> {
    private int programHashCode;
    private void visitExpressions(List<MiniPythonParser.ExpressionContext> source, List<Expression> target) {
        for (MiniPythonParser.ExpressionContext expression: source) {
            target.add((Expression) expression.accept(this));
        }
    }
    @Override
    // TODO Prevent import loops
    public Node visitImport_statement(MiniPythonParser.Import_statementContext ctx) {
        Import imp = new Import();

        imp.setTreeHashCode(this.programHashCode);
        this.programHashCode = ctx.hashCode();

        // Remove first and last character
        imp.setPath(ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1));
        CharStream charStream = null;

        try {
            charStream = CharStreams.fromFileName(imp.getPath());
        } catch (IOException e) {
            throw new RuntimeException("Error at importing " + imp.getPath());
        }

        MiniPythonLexer lexer = new MiniPythonLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniPythonParser parser = new MiniPythonParser(tokens);

        ParseTree tree = parser.start();
        imp.setProgram((Program) tree.accept(this));

        for (TerminalNode identifier : ctx.imports().IDENTIFIER()) {
            imp.getImports().add(identifier.getText());
        }

        System.out.println(this.programHashCode);

        this.programHashCode = imp.getTreeHashCode();

        return imp;
    }

    @Override
    public Node visitStatements(MiniPythonParser.StatementsContext ctx) {
        Block block = new Block();
        block.setTreeHashCode(this.programHashCode);
        for (MiniPythonParser.StatementContext statement: ctx.statement()) {
            block.getStatements().add((Statement) statement.accept(this));
        }

        return block;
    }

    @Override
    public Node visitBasicIdentifier(MiniPythonParser.BasicIdentifierContext ctx) {
        Identifier identifier = new Identifier();
        identifier.setTreeHashCode(this.programHashCode);
        identifier.setIdentifier(ctx.IDENTIFIER().getText());
        return identifier;
    }

    @Override
    public Node visitSelfIdentifier(MiniPythonParser.SelfIdentifierContext ctx) {
        Identifier identifier = new Identifier();
        identifier.setTreeHashCode(this.programHashCode);
        identifier.setIdentifier("self");
        return identifier;
    }

    @Override
    public Node visitRecursiveIdentifier(MiniPythonParser.RecursiveIdentifierContext ctx) {
        Identifier next = new Identifier();
        next.setTreeHashCode(this.programHashCode);
        next.setIdentifier(ctx.IDENTIFIER().getText());

        Identifier identifier = (Identifier) ctx.identifier().accept(this);
        identifier.setNext(next);
        return identifier;
    }

    @Override
    public Node visitCallExpression(MiniPythonParser.CallExpressionContext ctx) {
        Call call = new Call();
        call.setTreeHashCode(this.programHashCode);
        call.setIdentifier((Identifier) ctx.call().identifier().accept(this));
        visitExpressions(ctx.call().call_parameter().expression(), call.getParameter());
        return call;
    }

    @Override
    public Node visitFunction(MiniPythonParser.FunctionContext ctx) {
        Function function = new Function();
        function.setTreeHashCode(this.programHashCode);
        function.setName(ctx.IDENTIFIER().getText());
        if (ctx.function_parameter() != null) {
            for (TerminalNode parameter: ctx.function_parameter().IDENTIFIER()) {
                function.getParameter().add(parameter.getText());
            }
        }
        function.setBody((Block) ctx.statements().accept(this));
        return function;
    }

    @Override
    public Node visitAssignment(MiniPythonParser.AssignmentContext ctx) {
        Assignment assignment = new Assignment();
        assignment.setTreeHashCode(this.programHashCode);
        assignment.setIdentifier((Identifier) ctx.identifier().accept(this));
        assignment.setExpression((Expression) ctx.expression().accept(this));
        return assignment;
    }

    @Override
    public Node visitNumberExpression(MiniPythonParser.NumberExpressionContext ctx) {
        Number number = new Number();
        number.setTreeHashCode(this.programHashCode);
        number.setValue(Integer.parseInt(ctx.INT().getText()));
        return number;
    }

    @Override
    public Node visitTextExpression(MiniPythonParser.TextExpressionContext ctx) {
        Text text = new Text();
        text.setTreeHashCode(this.programHashCode);
        text.setValue(ctx.STRING().getText().replaceAll("^\"|^'|\"$|'$", ""));
        return text;
    }

    @Override
    public Node visitTruthExpression(MiniPythonParser.TruthExpressionContext ctx) {
        Truth truth = new Truth();
        truth.setTreeHashCode(this.programHashCode);
        truth.setValue(Boolean.parseBoolean(ctx.BOOLEAN().getText()));
        return truth;
    }

    @Override
    public Node visitNegationExpression(MiniPythonParser.NegationExpressionContext ctx) {
        Negation negation = new Negation();
        negation.setTreeHashCode(this.programHashCode);
        negation.setExpression((Expression) ctx.expression().accept(this));
        return negation;
    }

    @Override
    public Node visitMultiplicationExpression(MiniPythonParser.MultiplicationExpressionContext ctx) {
        Calculation calculation = new Calculation();
        calculation.setTreeHashCode(this.programHashCode);
        calculation.setOperator(Calculation.Operator.Multiplication);
        visitExpressions(ctx.expression(), calculation.getOperands());
        return calculation;
    }

    @Override
    public Node visitDivisionExpression(MiniPythonParser.DivisionExpressionContext ctx) {
        Calculation calculation = new Calculation();
        calculation.setTreeHashCode(this.programHashCode);
        calculation.setOperator(Calculation.Operator.Division);
        visitExpressions(ctx.expression(), calculation.getOperands());
        return calculation;
    }

    @Override
    public Node visitAdditionExpression(MiniPythonParser.AdditionExpressionContext ctx) {
        Calculation calculation = new Calculation();
        calculation.setTreeHashCode(this.programHashCode);
        calculation.setOperator(Calculation.Operator.Addition);
        visitExpressions(ctx.expression(), calculation.getOperands());
        return calculation;
    }

    @Override
    public Node visitSubtractionExpression(MiniPythonParser.SubtractionExpressionContext ctx) {
        Calculation calculation = new Calculation();
        calculation.setTreeHashCode(this.programHashCode);
        calculation.setOperator(Calculation.Operator.Subtraction);
        visitExpressions(ctx.expression(), calculation.getOperands());
        return calculation;
    }

    @Override
    public Node visitEqualityExpression(MiniPythonParser.EqualityExpressionContext ctx) {
        Comparison comparison = new Comparison();
        comparison.setTreeHashCode(this.programHashCode);
        comparison.setOperator(Comparison.Operator.Equality);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitInequalityExpression(MiniPythonParser.InequalityExpressionContext ctx)  {
        Comparison comparison = new Comparison();
        comparison.setTreeHashCode(this.programHashCode);
        comparison.setOperator(Comparison.Operator.Inequality);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitGreaterEqualExpression(MiniPythonParser.GreaterEqualExpressionContext ctx)  {
        Comparison comparison = new Comparison();
        comparison.setTreeHashCode(this.programHashCode);
        comparison.setOperator(Comparison.Operator.GreaterEqual);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitLessEqualExpression(MiniPythonParser.LessEqualExpressionContext ctx)  {
        Comparison comparison = new Comparison();
        comparison.setTreeHashCode(this.programHashCode);
        comparison.setOperator(Comparison.Operator.LessEqual);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitGreaterThanExpression(MiniPythonParser.GreaterThanExpressionContext ctx)  {
        Comparison comparison = new Comparison();
        comparison.setTreeHashCode(this.programHashCode);
        comparison.setOperator(Comparison.Operator.GreaterThan);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitLessThanExpression(MiniPythonParser.LessThanExpressionContext ctx)  {
        Comparison comparison = new Comparison();
        comparison.setTreeHashCode(this.programHashCode);
        comparison.setOperator(Comparison.Operator.LessThan);
        visitExpressions(ctx.expression(), comparison.getOperands());
        return comparison;
    }

    @Override
    public Node visitConjunctionExpression(MiniPythonParser.ConjunctionExpressionContext ctx) {
        Connective connective = new Connective();
        connective.setTreeHashCode(this.programHashCode);
        connective.setOperator(Connective.Operator.And);
        visitExpressions(ctx.expression(), connective.getOperands());
        return connective;
    }

    @Override
    public Node visitDisjunctionExpression(MiniPythonParser.DisjunctionExpressionContext ctx) {
        Connective connective = new Connective();
        connective.setTreeHashCode(this.programHashCode);
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
        conditional.setTreeHashCode(this.programHashCode);
        conditional.setCondition((Expression) ctx.if_statement().condition().expression().accept(this));
        conditional.setIfBody((Block) ctx.if_statement().statements().accept(this));
        Conditional fold = conditional;
        for (MiniPythonParser.Elif_statementContext elseIf: ctx.elif_statement()) {
            Conditional sub = new Conditional();
            sub.setCondition((Expression) elseIf.condition().expression().accept(this));
            sub.setIfBody((Block) elseIf.statements().accept(this));
            fold.setElseBody(new Block());
            fold.getElseBody().getStatements().add(sub);
            fold = sub;
        }
        if (ctx.else_statement() != null) {
            fold.setElseBody((Block) ctx.else_statement().statements().accept(this));
        }

        return conditional;
    }

    @Override
    public Node visitLoop(MiniPythonParser.LoopContext ctx) {
        Loop loop = new Loop();
        loop.setTreeHashCode(this.programHashCode);
        loop.setCondition((Expression) ctx.condition().expression().accept(this));
        loop.setBody((Block) ctx.statements().accept(this));
        return loop;
    }

    @Override
    public Node visitClass(MiniPythonParser.ClassContext ctx) {
        Class c = new Class();
        c.setTreeHashCode(this.programHashCode);
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
        function.setTreeHashCode(this.programHashCode);
        function.getParameter().add("self");
        if (ctx.function_parameter() != null) {
            for (TerminalNode parameter: ctx.function_parameter().IDENTIFIER()) {
                function.getParameter().add(parameter.getText());
            }
        }
        function.setBody((Block) ctx.statements().accept(this));
        return function;
    }

    @Override
    public Node visitReturn(MiniPythonParser.ReturnContext ctx) {
        Return r = new Return();
        r.setTreeHashCode(this.hashCode());
        r.setExpression((Expression) ctx.expression().accept(this));
        return r;
    }

    @Override
    public Node visitStart(MiniPythonParser.StartContext ctx) {
        Program program = new Program();
        this.programHashCode = ctx.hashCode();
        program.setBlock((Block) ctx.statements().accept(this));
        return program;
    }
}
