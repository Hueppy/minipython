package minipython.ast;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import minipython.antlr.*;

public class AbstractSyntaxTreeVisitor extends MiniPythonBaseVisitor<INode>{
	private List<INode> statements = null;
	private List<INode> tupleListItems = null;
	private List<INode> tupleUnpakingList = null;
	private List<INode> listListItems = null;
	private AbstractSyntaxTree ast = null;
	private INode comparisonLeft = null;
	private INode sumLeft = null;
	private INode productLeft = null;

	public AbstractSyntaxTree getAST(String input) throws IOException {
		MiniPythonLexer lexer = new MiniPythonLexer(CharStreams.fromFileName(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniPythonParser parser = new MiniPythonParser(tokens);
		parser.start().accept(this);
		return this.ast;
	}

	@Override
	public INode visitStart(MiniPythonParser.StartContext ctx) {
		this.statements = new ArrayList<INode>();
		ctx.statements().accept(this);
		INode[] tmp = new INode[this.statements.size()];
		this.ast = new AbstractSyntaxTree(this.statements.toArray(tmp));
		return null;
	}

	@Override
	public INode visitStatements(MiniPythonParser.StatementsContext ctx) {
		this.statements.add(ctx.statement().accept(this));
		return ctx.statements_().accept(this);
	}

	@Override
	public INode visitVariableAssigment(MiniPythonParser.VariableAssigmentContext ctx) {
		String id = ctx.ID().getText();
		INode value = ctx.variableAssigment_().accept(this);
		return new VariableAssigmentNode(id, value);
	}

	@Override
	public INode visitTupleUnpacking(MiniPythonParser.TupleUnpackingContext ctx) {
		this.tupleUnpakingList = new ArrayList<INode>();
		ctx.tupleUnpackingList().accept(this);
		INode[] tmp = new INode[this.tupleUnpakingList.size()];
		return new TupleUnpackingNode(this.tupleUnpakingList.toArray(tmp), ctx.ID().getText());
	}

	@Override
	public INode visitTupleUnpackingListParameter(MiniPythonParser.TupleUnpackingListParameterContext ctx) {
		this.tupleUnpakingList.add(ctx.variable().accept(this));
		return null;
	}

	@Override
	public INode visitOperation(MiniPythonParser.OperationContext ctx) {
		return ctx.comparison().accept(this);
	}

	@Override
	public INode visitComparison(MiniPythonParser.ComparisonContext ctx) {
		this.comparisonLeft = ctx.sum().accept(this);
		INode comparisonRight = ctx.comparison_().accept(this);
		if(comparisonRight != null) {
			return comparisonRight;
		}
		else {
			return this.comparisonLeft;
		}
	}

	@Override
	public INode visitLowerThen(MiniPythonParser.LowerThenContext ctx) {
		ComparisonNode lowerThen = new LowerThenNode();
		lowerThen.setLeft(this.comparisonLeft);
		lowerThen.setRight(ctx.sum().accept(this));
		return lowerThen;
	}

	@Override
	public INode visitLowerEquals(MiniPythonParser.LowerEqualsContext ctx) {
		ComparisonNode lowerEquals = new LowerEqualsNode();
		lowerEquals.setLeft(this.comparisonLeft);
		lowerEquals.setRight(ctx.sum().accept(this));
		return lowerEquals;
	}

	@Override
	public INode visitSum(MiniPythonParser.SumContext ctx) {
		this.sumLeft = ctx.product().accept(this);
		INode sumRight = ctx.sum_().accept(this);
		if(sumRight != null) {
			return sumRight;
		}
		else {
			return this.sumLeft;
		}
	}

	@Override
	public INode visitAddition(MiniPythonParser.AdditionContext ctx) {
		SumNode addition = new AdditionNode();
		addition.setLeft(this.sumLeft);
		addition.setRight(ctx.sum().accept(this));
		return addition;
	}

	@Override
	public INode visitSubstaction(MiniPythonParser.SubstactionContext ctx) {
		SumNode substraction  = new SubtractionNode();
		substraction.setLeft(this.sumLeft);
		substraction.setRight(ctx.sum().accept(this));
		return substraction;
	}

	@Override
	public INode visitProduct(MiniPythonParser.ProductContext ctx) {
		this.productLeft = ctx.factor().accept(this);
		INode productRight = ctx.product_().accept(this);
		if (productRight != null) {
			return productRight;
		}
		else {
			return this.productLeft;
		}
	}

	@Override
	public INode visitMultiplication(MiniPythonParser.MultiplicationContext ctx) {
		ProductNode multiplication = new MultiplicationNode();
		multiplication.setLeft(this.productLeft);
		multiplication.setRight(ctx.product().accept(this));
		return multiplication;
	}

	@Override
	public INode visitDivision(MiniPythonParser.DivisionContext ctx) {
		ProductNode division = new DivisionNode();
		division.setLeft(this.productLeft);
		division.setRight(ctx.product().accept(this));
		return division;
	}

	@Override
	public INode visitRemainder(MiniPythonParser.RemainderContext ctx) {
		ProductNode remainder = new RemainderNode();
		remainder.setLeft(this.productLeft);
		remainder.setRight(ctx.product().accept(this));
		return remainder;
	}

	@Override
	public INode visitTupleCall(MiniPythonParser.TupleCallContext ctx) {
		this.tupleListItems = new ArrayList<INode>();
		ctx.tupleList().accept(this);
		if(this.tupleListItems.isEmpty()) {
			return new TupleNode();
		}
		else {
			INode[] tmp = new INode[this.tupleListItems.size()];
			return new TupleNode(this.tupleListItems.toArray(tmp));
		}
	}

	@Override
	public INode visitTupleListItem(MiniPythonParser.TupleListItemContext ctx) {
		this.tupleListItems.add(ctx.operation().accept(this));
		return null;
	}

	@Override
	public INode visitListCall(MiniPythonParser.ListCallContext ctx) {
		this.listListItems = new ArrayList<INode>();
		ctx.listList().accept(this);
		if(this.listListItems.isEmpty()) {
			return new ListNode();
		}
		else {
			INode[] tmp = new INode[this.listListItems.size()];
			return new ListNode(this.listListItems.toArray(tmp));
		}
	}

	@Override
	public INode visitListListItem(MiniPythonParser.ListListItemContext ctx) {
		this.listListItems.add(ctx.operation().accept(this));
		return null;
	}

	@Override
	public INode visitVariable(MiniPythonParser.VariableContext ctx) {
		return new VariableNode(ctx.getText());
	}

	@Override
	public INode visitNumber(MiniPythonParser.NumberContext ctx) {
		return new NumberNode(ctx.getText());
	}
}
