package minipython.ast;

public interface Symbol {
	public String getName();
	public Scope getScope();
	public String getType();
	public boolean equalType(Symbol s);
}
