package minipython.ast;

public class VariableAssigmentNode implements INode{

	private String id = null;
	private INode operation = null;

	public VariableAssigmentNode(String id, INode operation) {
		this.id = id;
		this.operation = operation;
	}

	public String getID() {
		return this.id;
	}

	public INode getOperation() {
		return this.operation;
	}
	
	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.id).append(" = ").append(this.operation.toString());
		return builder.toString();
	}
}
