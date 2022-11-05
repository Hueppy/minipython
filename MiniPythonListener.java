// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniPythonParser}.
 */
public interface MiniPythonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(MiniPythonParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(MiniPythonParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MiniPythonParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MiniPythonParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#call_parameter}.
	 * @param ctx the parse tree
	 */
	void enterCall_parameter(MiniPythonParser.Call_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#call_parameter}.
	 * @param ctx the parse tree
	 */
	void exitCall_parameter(MiniPythonParser.Call_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(MiniPythonParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(MiniPythonParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniPythonParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniPythonParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniPythonParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniPythonParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(MiniPythonParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(MiniPythonParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MiniPythonParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MiniPythonParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(MiniPythonParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(MiniPythonParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(MiniPythonParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(MiniPythonParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#elif_statement}.
	 * @param ctx the parse tree
	 */
	void enterElif_statement(MiniPythonParser.Elif_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#elif_statement}.
	 * @param ctx the parse tree
	 */
	void exitElif_statement(MiniPythonParser.Elif_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(MiniPythonParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(MiniPythonParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(MiniPythonParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(MiniPythonParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#function_parameter}.
	 * @param ctx the parse tree
	 */
	void enterFunction_parameter(MiniPythonParser.Function_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#function_parameter}.
	 * @param ctx the parse tree
	 */
	void exitFunction_parameter(MiniPythonParser.Function_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MiniPythonParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MiniPythonParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#class_function}.
	 * @param ctx the parse tree
	 */
	void enterClass_function(MiniPythonParser.Class_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#class_function}.
	 * @param ctx the parse tree
	 */
	void exitClass_function(MiniPythonParser.Class_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(MiniPythonParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(MiniPythonParser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniPythonParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniPythonParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPythonParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(MiniPythonParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPythonParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(MiniPythonParser.StatementsContext ctx);
}