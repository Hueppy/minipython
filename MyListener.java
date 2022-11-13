import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyListener extends MiniPythonBaseListener {
    // Loescht den Knoten und heangt die Kinder an den obrigen Eltern Knoten an
    private void deleteNode(ParserRuleContext ctx) {
        int ctxParentIndex = ctx.getParent().children.indexOf(ctx);

        if(ctxParentIndex != -1) {
            ctx.getParent().children.remove(ctxParentIndex);

            for (int i = ctx.children.size() - 1; i >= 0; i--) {
                ctx.getParent().children.add(ctxParentIndex, ctx.children.get(i));
            }
        }
    }

    @Override
    public void exitIdentifier(MiniPythonParser.IdentifierContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("."));

        deleteNode(ctx);
    }


    @Override
    public void exitExpression(MiniPythonParser.ExpressionContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("(")
          || child.getText().equals(")"));

        if(ctx.getChildCount() == 1) {
            deleteNode(ctx);
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
    public void exitFunction(MiniPythonParser.FunctionContext ctx) {
        // #End entfernen
        ctx.removeLastChild();

        // Restliche Zeichen entfernen
        ctx.children.removeIf(child -> child.getText().equals("def")
            || child.getText().equals(":")
            || child.getText().equals("(")
            || child.getText().equals(")"));
    }

    @Override
    public void exitClass_function(MiniPythonParser.Class_functionContext ctx) {
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
    public void exitClass(MiniPythonParser.ClassContext ctx) {
        // #End entfernen
        ctx.removeLastChild();

        // Restliche Zeichen entfernen
        ctx.children.removeIf(child -> child.getText().equals("class")
            || child.getText().equals(":")
            || child.getText().equals("(")
            || child.getText().equals(")"));
    }

    @Override
    public void exitReturn(MiniPythonParser.ReturnContext ctx) {
        for (ParseTree child : ctx.children) {
            if (child.getText().equals("return")) {
                ctx.children.remove(child);
            }
        }
    }

    @Override
    public void exitFunction_parameter(MiniPythonParser.Function_parameterContext ctx) {
        // Bei mehreren Parametern die , entfernen
        if(ctx.getChildCount() > 0) {
            ctx.children.removeIf(child -> child.getText().equals(","));
        }
    }

    @Override
    public void exitCall_parameter(MiniPythonParser.Call_parameterContext ctx) {
        // Bei mehreren Parametern die , entfernen
        if(ctx.getChildCount() > 0) {
            ctx.children.removeIf(child -> child.getText().equals(","));
        }
    }

    @Override
    public void exitCall(MiniPythonParser.CallContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("(")
            || child.getText().equals(")"));

        // Leere parameter liste entfernen
        if(ctx.children.get(1).getChildCount() == 0) {
            ctx.children.remove(1);
        }
    }

    @Override
    public void exitConditional(MiniPythonParser.ConditionalContext ctx) {
        // #End entfernen
        ctx.removeLastChild();
    }

    @Override
    public void exitLoop(MiniPythonParser.LoopContext ctx) {
        // #End entfernen
        ctx.removeLastChild();

        ctx.children.removeIf(child -> child.getText().equals("while"));
    }

    @Override
    public void exitElse_statement(MiniPythonParser.Else_statementContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("else")
          || child.getText().equals(":"));
    }

    @Override
    public void exitElif_statement(MiniPythonParser.Elif_statementContext ctx) {
        ctx.children.removeIf(child -> child.getText().equals("elif")
            || child.getText().equals(":"));
    }

    @Override
    public void exitIf_statement(MiniPythonParser.If_statementContext ctx) {
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

    @Override
    public void exitStatements(MiniPythonParser.StatementsContext ctx) {
        deleteNode(ctx);
    }
}
