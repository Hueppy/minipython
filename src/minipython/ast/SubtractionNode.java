package minipython.ast;

public class SubtractionNode implements SumNode{
	private INode subtrahend = null;
	private INode minuend = null;

	@Override
	public void setLeft(INode n) {
		this.subtrahend = n;
	}

	@Override
	public void setRight(INode n) {
		this.minuend = n; 
	}

	@Override
	public INode getLeft() {
		return this.subtrahend;
	}

	@Override
	public INode getRight() {
		return this.minuend;
	}
	
	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.subtrahend.toString()).append(" - ").append(this.minuend.toString());
		return builder.toString();
	}
}
