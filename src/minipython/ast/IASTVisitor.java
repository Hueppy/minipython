package minipython.ast;

public interface IASTVisitor<T> {
	public T visit(VariableAssigmentNode node);
	public T visit(TupleUnpackingNode node);
	public T visit(TupleNode node);
	public T visit(ListNode node);
	public T visit(ComparisonNode node);
	public T visit(SumNode node);
	public T visit(ProductNode node);
	public T visit(BooleanNode node);
	public T visit(NumberNode node);
	public T visit(VariableNode node);
}
