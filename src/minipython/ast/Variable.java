package minipython.ast;

public class Variable implements Symbol{
	private String name = null;
	private Scope scope = null;
	private String type = null;

	public Variable(String name, Scope s, String type) {
		this.name = name;
		this.scope = s;
		this.type = type;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Scope getScope() {
		return this.scope;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public boolean equalType(Symbol s) {
		if(s != null && s.getType().equals(this.type)) {
			return true;
		}
		else {
			return false;
		}
	}
}
