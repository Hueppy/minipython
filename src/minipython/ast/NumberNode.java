package minipython.ast;

public class NumberNode implements INode{
	private String number = null;
	
	public NumberNode(String ctxText) {
		this.number = ctxText;
	}

	public String getNumber() {
		return this.number;
	}
	
	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.number;
	}
}
