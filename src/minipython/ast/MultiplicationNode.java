package minipython.ast;

public class MultiplicationNode implements ProductNode{
	private INode multiplicand = null;
	private INode multiplier = null;

	@Override
	public void setLeft(INode n) {
		this.multiplicand = n;
	}

	@Override
	public void setRight(INode n) {
		this.multiplier = n;
	}

	@Override
	public INode getLeft() {
		return this.multiplicand;
	}

	@Override
	public INode getRight() {
		return this.multiplier;
	}
	
	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.multiplicand.toString()).append(" * ").append(this.multiplier.toString());
		return builder.toString();
	}
}
