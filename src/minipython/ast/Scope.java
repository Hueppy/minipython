package minipython.ast;

import java.util.HashMap;
import java.util.Map;

public class Scope {
	private Scope enclosingScope = null;
	private Map<String, Symbol> symbols = null;

	public Scope(Scope enclosing) {
		this.enclosingScope = enclosing;
		this.symbols = new HashMap<String, Symbol>();
	}

	public Symbol resolve(String id) {
		Symbol s = this.symbols.get(id);
		if(s == null && this.enclosingScope != null) {
			return this.enclosingScope.resolve(id);
		}
		else {
			return s;
		}
	}

	public void bind(Symbol variable) {
		this.symbols.put(variable.getName(), variable);
	}
}
