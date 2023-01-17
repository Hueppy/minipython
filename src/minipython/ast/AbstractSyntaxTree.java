package minipython.ast;

public class AbstractSyntaxTree {
	private INode[] statements = null;

	public AbstractSyntaxTree(INode[] statements) {
		this.statements = statements;
	}

	@Override
	public String toString() {
		int index = 0;
		StringBuilder builder = new StringBuilder();
		while(index < this.statements.length) {
			builder.append(this.statements[index].toString()).append('\n');
			index = index + 1;
		}
		return builder.toString();
	}
}