// Generated from java-escape by ANTLR 4.11.1
package minipython.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniPythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniPythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#parenthesized}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesized(MiniPythonParser.ParenthesizedContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MiniPythonParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(MiniPythonParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(MiniPythonParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(MiniPythonParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#tupleListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleListItem(MiniPythonParser.TupleListItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#tupleList_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleList_(MiniPythonParser.TupleList_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#tupleList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleList(MiniPythonParser.TupleListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#tupleCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleCall(MiniPythonParser.TupleCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#listListItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListListItem(MiniPythonParser.ListListItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#listList_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListList_(MiniPythonParser.ListList_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#listList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListList(MiniPythonParser.ListListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#listCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListCall(MiniPythonParser.ListCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(MiniPythonParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#negativeFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeFactor(MiniPythonParser.NegativeFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(MiniPythonParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(MiniPythonParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#division}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(MiniPythonParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#remainder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemainder(MiniPythonParser.RemainderContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#product_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct_(MiniPythonParser.Product_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#product}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct(MiniPythonParser.ProductContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#addition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(MiniPythonParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#substaction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstaction(MiniPythonParser.SubstactionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#sum_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum_(MiniPythonParser.Sum_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(MiniPythonParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#lowerThen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowerThen(MiniPythonParser.LowerThenContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#lowerEquals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowerEquals(MiniPythonParser.LowerEqualsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#greaterThen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThen(MiniPythonParser.GreaterThenContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#greaterEquals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterEquals(MiniPythonParser.GreaterEqualsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#notEquls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEquls(MiniPythonParser.NotEqulsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#equals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(MiniPythonParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#comparison_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_(MiniPythonParser.Comparison_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(MiniPythonParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(MiniPythonParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#tupleUnpackingListParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleUnpackingListParameter(MiniPythonParser.TupleUnpackingListParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#tupleUnpackingList_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleUnpackingList_(MiniPythonParser.TupleUnpackingList_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#tupleUnpackingList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleUnpackingList(MiniPythonParser.TupleUnpackingListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#tupleUnpacking}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleUnpacking(MiniPythonParser.TupleUnpackingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#variableAssigment_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssigment_(MiniPythonParser.VariableAssigment_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#variableAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssigment(MiniPythonParser.VariableAssigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#assigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigment(MiniPythonParser.AssigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniPythonParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#statements_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements_(MiniPythonParser.Statements_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(MiniPythonParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPythonParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MiniPythonParser.StartContext ctx);
}