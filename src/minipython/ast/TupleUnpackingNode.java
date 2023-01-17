package minipython.ast;

public class TupleUnpackingNode implements INode{

	private TupleNode tupel = null;
	private String id = null;
	
	public TupleUnpackingNode(INode[] parameter, String id) {
		this.tupel = new TupleNode(parameter);
		this.id = id;
	}
	
	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.tupel.toString()).append(" = ").append(this.id);
		return builder.toString();
	}
}
