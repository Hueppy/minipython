package minipython.ast;

public class ListNode implements INode{

	private INode[] items = null;
	private boolean isEmpty = true;

	public ListNode() {
		this.isEmpty = true;
	}

	public ListNode(INode[] items) {
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
			return "empty list";
		}
		else {
			StringBuilder builder = new StringBuilder("list[ ");
			int index = 0;
			while(index < this.items.length - 1) {
				builder.append(this.items[index].toString()).append(" , ");
				index = index + 1;
			}
			if(index < this.items.length) {
				builder.append(this.items[index].toString());
			}
			return builder.append(" ]").toString();
		}
	}
	
	@Override
	public <T> T accept(IASTVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
