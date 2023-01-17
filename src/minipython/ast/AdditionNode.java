package minipython.ast;

public class AdditionNode implements SumNode{
	private INode addendLeft = null;
	private INode addendRight = null;

	@Override
	public void setLeft(INode n) {
		this.addendLeft = n;
	}

	@Override
	public void setRight(INode n) {
		this.addendRight = n;
	}

	@Override
	public INode getLeft() {
		return this.addendLeft;
	}

	@Override
	public INode getRight() {
		return this.addendRight;
	}
	
	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.addendLeft.toString()).append(" + ").append(this.addendRight.toString());
		return builder.toString();
	}
}
