import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyListener extends MiniPythonBaseListener {
    // Loescht den Knoten und heangt die Kinder an den obrigen Eltern Knoten an
    private void deleteNode(ParserRuleContext ctx) {
        int ctxParentIndex = ctx.getParent().children.indexOf(ctx);

        for(ParseTree child : ctx.children) {
            ctx.getParent().children.add(ctxParentIndex, child);
        }

        ctx.getParent().children.remove(ctx);
    }

    @Override
    public void exitIdentifier(MiniPythonParser.IdentifierContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("."));
        deleteNode(ctx);
    }

    @Override
    public void enterExpression(MiniPythonParser.ExpressionContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("(")
          || child.getText().equals(")"));
    }

    @Override
    public void exitExpression(MiniPythonParser.ExpressionContext ctx) {
        // Expression mit genau ein Kind Knoten entfernen
        if(ctx.getChildCount() == 1) {
            int ctxParentIndex = ctx.getParent().children.indexOf(ctx);

            ctx.getParent().children.add(ctxParentIndex, ctx.getChild(0));
            ctx.getParent().children.remove(ctx);
        }
    }

    @Override
    public void exitStatement(MiniPythonParser.StatementContext ctx) {
        // Statement entfernen
        deleteNode(ctx);
    }

    @Override
    public void exitAssignment(MiniPythonParser.AssignmentContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("."));
    }

    @Override
    public void enterFunction(MiniPythonParser.FunctionContext ctx) {
        // #End entfernen
        ctx.removeLastChild();

        // Restliche Zeichen entfernen
        ctx.children.removeIf(child -> child.getText().equals("def")
            || child.getText().equals(":")
            || child.getText().equals("(")
            || child.getText().equals(")"));
    }

    @Override
    public void enterClass_function(MiniPythonParser.Class_functionContext ctx) {
        // #End entfernen
        ctx.removeLastChild();

        // Restliche Zeichen entfernen
        ctx.children.removeIf(child -> child.getText().equals("def")
            || child.getText().equals(",")
            || child.getText().equals(":")
            || child.getText().equals("(")
            || child.getText().equals(")"));
    }

    @Override
    public void enterClass(MiniPythonParser.ClassContext ctx) {
        // #End entfernen
        ctx.removeLastChild();

        // Restliche Zeichen entfernen
        ctx.children.removeIf(child -> child.getText().equals("class")
            || child.getText().equals(":")
            || child.getText().equals("(")
            || child.getText().equals(")"));
    }

    @Override
    public void enterReturn(MiniPythonParser.ReturnContext ctx) {
        // Return node entfernen
        ctx.children.remove(0);

        // Kind hoch ziehen
        for(int i = 0; i<ctx.children.get(0).getChildCount(); i++) {
            ctx.children.add(ctx.children.get(0).getChild(i));
        }

        ctx.children.remove(0);
    }

    @Override
    public void exitFunction_parameter(MiniPythonParser.Function_parameterContext ctx) {
        // Bei mehreren Parametern die , entfernen
        if(ctx.getChildCount() > 0) {
            ctx.children.removeIf(child -> child.getText().equals(","));
        }
    }

    @Override
    public void enterCall_parameter(MiniPythonParser.Call_parameterContext ctx) {
        // Bei mehreren Parametern die , entfernen
        if(ctx.getChildCount() > 0) {
            ctx.children.removeIf(child -> child.getText().equals(","));
        }
    }

    @Override
    public void enterCall(MiniPythonParser.CallContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("(")
            || child.getText().equals(")"));

        // Leere parameter liste entfernen
        if(ctx.children.get(1).getChildCount() == 0) {
            ctx.children.remove(1);
        }
    }

    @Override
    public void enterConditional(MiniPythonParser.ConditionalContext ctx) {
        // #End entfernen
        ctx.removeLastChild();
    }

    @Override
    public void enterLoop(MiniPythonParser.LoopContext ctx) {
        // #End entfernen
        ctx.removeLastChild();

        ctx.children.removeIf(child -> child.getText().equals("while"));
    }

    @Override
    public void enterElse_statement(MiniPythonParser.Else_statementContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("else")
          || child.getText().equals(":"));
    }

    @Override
    public void enterElif_statement(MiniPythonParser.Elif_statementContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("elif")
            || child.getText().equals(":"));
    }

    @Override
    public void enterIf_statement(MiniPythonParser.If_statementContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("if")
            || child.getText().equals(":"));
    }

    @Override
    public void exitCondition(MiniPythonParser.ConditionContext ctx) {
        // : entfernen
        ctx.removeLastChild();

        // Kind hoch ziehen
        for(int i = 0; i < ctx.children.get(0).getChildCount(); i++) {
            ctx.children.add(ctx.children.get(0).getChild(i));
        }

        ctx.children.remove(0);
    }
}
