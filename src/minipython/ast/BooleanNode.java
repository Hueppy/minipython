package minipython.ast;

public class BooleanNode implements INode{
	
	public BooleanNode(String ctxText) {
		//TODO
	}
	
	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
