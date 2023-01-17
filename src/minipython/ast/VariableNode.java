package minipython.ast;

public class VariableNode implements INode{
	private String id;
	
	public VariableNode(String id) {
		this.id = id;
	}

	public String getID() {
		return this.id;
	}

	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return this.id;
	}
	
}
