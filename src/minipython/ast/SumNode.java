package minipython.ast;

public interface SumNode extends INode{
	public void setLeft(INode n);
	public INode getLeft();
	public void setRight(INode n);
	public INode getRight();
}
