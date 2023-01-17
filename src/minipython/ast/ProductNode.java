package minipython.ast;

public interface ProductNode extends INode{
	public void setLeft(INode n);
	public INode getLeft();
	public void setRight(INode n);
	public INode getRight();
}
