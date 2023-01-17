package minipython.ast;

public class BuiltIN implements Symbol{

	private String name = null;
	private Scope scope = null;
	
	public BuiltIN(String name, Scope s) {
		this.name = name;
		this.scope = s;
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
		return this.name;
	}

	@Override
	public boolean equalType(Symbol s) {
		if(s != null && s.getType().equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
