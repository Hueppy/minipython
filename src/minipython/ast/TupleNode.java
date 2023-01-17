package minipython.ast;

public class TupleNode implements INode{
	
	private INode[] items = null;
	private boolean isEmpty = true;
	
	public TupleNode() {
		this.isEmpty = true;
	}
	
	public TupleNode(INode[] items) {
		if(items != null && items.length > 0) {
			this.items = items;
			this.isEmpty = false;
		}
		else {
			this.isEmpty = true;
		}
	}

	@Override
	public String toString() {
		if(this.isEmpty) {
			return "empty tuple";
		}
		else {
			StringBuilder builder = new StringBuilder("tuple( ");
			int index = 0;
			while(index < this.items.length - 1) {
				builder.append(this.items[index].toString()).append(" , ");
				index = index + 1;
			}
			if(index < this.items.length) {
				builder.append(this.items[index].toString());
			}
			return builder.append(" )").toString();
		}
	}

	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
