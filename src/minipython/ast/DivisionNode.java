package minipython.ast;

public class DivisionNode implements ProductNode {
	private INode dividend = null;
	private INode divisor = null;

	@Override
	public void setLeft(INode n) {
		this.dividend = n;
	}

	@Override
	public void setRight(INode n) {
		this.divisor = n;
	}

	@Override
	public INode getLeft() {
		return this.dividend;
	}

	@Override
	public INode getRight() {
		return this.divisor;
	}
	
	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.dividend.toString()).append(" / ").append(this.divisor.toString());
		return builder.toString();
	}
	
}
