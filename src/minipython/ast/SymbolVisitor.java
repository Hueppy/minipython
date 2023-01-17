package minipython.ast;

public class SymbolVisitor implements IASTVisitor<Symbol>{

	Scope scope = null;
	Symbol booleanSymbol = null;
	Symbol numberSymbol = null;
	Symbol tupleSymbol = null;

	public SymbolVisitor() {
		this.scope = new Scope(null);
		this.booleanSymbol = new BuiltIN("Boolean", this.scope);
		this.scope.bind(this.booleanSymbol);
		this.numberSymbol = new BuiltIN("Number", this.scope);
		this.scope.bind(this.numberSymbol);
		this.tupleSymbol = new BuiltIN("Tuple", this.scope);
		this.scope.bind(this.tupleSymbol);
	}
	
	@Override
	public Symbol visit(VariableAssigmentNode node) {
		String id = node.getID();
		Symbol operation = node.getOperation().accept(this);
		if(operation != null) {
			Variable variable = new Variable(id, this.scope, operation.getType());
			this.scope.bind(variable);
		}
		return null;
	}

	@Override
	public Symbol visit(TupleUnpackingNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visit(TupleNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visit(ListNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visit(ComparisonNode node) {
		Symbol left = node.getLeft().accept(this);
		Symbol right = node.getRight().accept(this);
		//TODO
		return this.tupleSymbol;
	}

	@Override
	public Symbol visit(SumNode node) {
		Symbol left = node.getLeft().accept(this);
		Symbol right = node.getRight().accept(this);
		if(this.numberSymbol.equalType(left) && this.numberSymbol.equalType(right)) {
			return this.numberSymbol;
		}
		else {
			return null;
		}
	}

	@Override
	public Symbol visit(ProductNode node) {
		Symbol left = node.getLeft().accept(this);
		Symbol right = node.getRight().accept(this);
		if(this.numberSymbol.equalType(left) && this.numberSymbol.equalType(right)) {
			return this.numberSymbol;
		}
		else {
			return null;
		}
	}

	@Override
	public Symbol visit(BooleanNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symbol visit(NumberNode node) {
		try {
			Integer.parseInt(node.getNumber());
			return this.numberSymbol;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Symbol visit(VariableNode node) {
		Symbol varSymbol = this.scope.resolve(node.getID());
		if(varSymbol != null) {
			return varSymbol;
		}
		else {
			return null;
		}
	}
}
