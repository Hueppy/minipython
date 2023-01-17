package minipython.ast;

public class LowerThenNode implements ComparisonNode{
	private INode comparisonLeft = null;
	private INode comparisonRight = null;

	@Override
	public void setLeft(INode n) {
		this.comparisonLeft = n;
	}

	@Override
	public void setRight(INode n) {
		this.comparisonRight = n;
	}

	@Override
	public INode getLeft() {
		return this.comparisonLeft;
	}

	@Override
	public INode getRight() {
		return this.comparisonRight;
	}

	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.comparisonLeft.toString()).append(" < ").append(this.comparisonRight.toString());
		return builder.toString();
	}
}
