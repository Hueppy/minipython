package minipython.ast;

public interface INode {
	public <T> T accept(IASTVisitor<T> visitor);
}
