// Generated from java-escape by ANTLR 4.11.1
package minipython.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniPythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FAULT_INTEGER=1, INTEGER=2, ID=3, OPENING=4, CLOSING=5, LBRACKET=6, RBRACKET=7, 
		PLUS=8, MINUS=9, MULTIPLY=10, DIVIDE=11, PERCENT=12, ASSIGMENT=13, PARAMETERLIST=14, 
		METHODOPERATOR=15, LOWER_THEN=16, LOWER_EQUALS=17, GREATER_THEN=18, GREATER_EQUALS=19, 
		NOT_EQUALS=20, EQUALS=21, BOOLEAN=22, ENDOFLINE=23;
	public static final int
		RULE_parenthesized = 0, RULE_variable = 1, RULE_number = 2, RULE_boolean = 3, 
		RULE_atom = 4, RULE_tupleListItem = 5, RULE_tupleList_ = 6, RULE_tupleList = 7, 
		RULE_tupleCall = 8, RULE_listListItem = 9, RULE_listList_ = 10, RULE_listList = 11, 
		RULE_listCall = 12, RULE_reference = 13, RULE_negativeFactor = 14, RULE_factor = 15, 
		RULE_multiplication = 16, RULE_division = 17, RULE_remainder = 18, RULE_product_ = 19, 
		RULE_product = 20, RULE_addition = 21, RULE_substaction = 22, RULE_sum_ = 23, 
		RULE_sum = 24, RULE_lowerThen = 25, RULE_lowerEquals = 26, RULE_greaterThen = 27, 
		RULE_greaterEquals = 28, RULE_notEquls = 29, RULE_equals = 30, RULE_comparison_ = 31, 
		RULE_comparison = 32, RULE_operation = 33, RULE_tupleUnpackingListParameter = 34, 
		RULE_tupleUnpackingList_ = 35, RULE_tupleUnpackingList = 36, RULE_tupleUnpacking = 37, 
		RULE_variableAssigment_ = 38, RULE_variableAssigment = 39, RULE_assigment = 40, 
		RULE_statement = 41, RULE_statements_ = 42, RULE_statements = 43, RULE_start = 44;
	private static String[] makeRuleNames() {
		return new String[] {
			"parenthesized", "variable", "number", "boolean", "atom", "tupleListItem", 
			"tupleList_", "tupleList", "tupleCall", "listListItem", "listList_", 
			"listList", "listCall", "reference", "negativeFactor", "factor", "multiplication", 
			"division", "remainder", "product_", "product", "addition", "substaction", 
			"sum_", "sum", "lowerThen", "lowerEquals", "greaterThen", "greaterEquals", 
			"notEquls", "equals", "comparison_", "comparison", "operation", "tupleUnpackingListParameter", 
			"tupleUnpackingList_", "tupleUnpackingList", "tupleUnpacking", "variableAssigment_", 
			"variableAssigment", "assigment", "statement", "statements_", "statements", 
			"start"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'('", "')'", "'['", "']'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'='", "','", "'.'", "'<'", "'<='", "'>'", "'>='", "'!='", 
			"'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FAULT_INTEGER", "INTEGER", "ID", "OPENING", "CLOSING", "LBRACKET", 
			"RBRACKET", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "PERCENT", "ASSIGMENT", 
			"PARAMETERLIST", "METHODOPERATOR", "LOWER_THEN", "LOWER_EQUALS", "GREATER_THEN", 
			"GREATER_EQUALS", "NOT_EQUALS", "EQUALS", "BOOLEAN", "ENDOFLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniPythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedContext extends ParserRuleContext {
		public TerminalNode OPENING() { return getToken(MiniPythonParser.OPENING, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode CLOSING() { return getToken(MiniPythonParser.CLOSING, 0); }
		public ParenthesizedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesized; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitParenthesized(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedContext parenthesized() throws RecognitionException {
		ParenthesizedContext _localctx = new ParenthesizedContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parenthesized);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(OPENING);
			setState(91);
			operation();
			setState(92);
			match(CLOSING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MiniPythonParser.INTEGER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(MiniPythonParser.BOOLEAN, 0); }
		public BooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanContext boolean_() throws RecognitionException {
		BooleanContext _localctx = new BooleanContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_boolean);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(BOOLEAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public ParenthesizedContext parenthesized() {
			return getRuleContext(ParenthesizedContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atom);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENING:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				parenthesized();
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				number();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				boolean_();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleListItemContext extends ParserRuleContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TupleListItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleListItem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitTupleListItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleListItemContext tupleListItem() throws RecognitionException {
		TupleListItemContext _localctx = new TupleListItemContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tupleListItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			operation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleList_Context extends ParserRuleContext {
		public TerminalNode PARAMETERLIST() { return getToken(MiniPythonParser.PARAMETERLIST, 0); }
		public TupleListItemContext tupleListItem() {
			return getRuleContext(TupleListItemContext.class,0);
		}
		public TupleList_Context tupleList_() {
			return getRuleContext(TupleList_Context.class,0);
		}
		public TupleList_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleList_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitTupleList_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleList_Context tupleList_() throws RecognitionException {
		TupleList_Context _localctx = new TupleList_Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_tupleList_);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARAMETERLIST:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(108);
				match(PARAMETERLIST);
				setState(109);
				tupleListItem();
				setState(110);
				tupleList_();
				}
				}
				break;
			case CLOSING:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleListContext extends ParserRuleContext {
		public TupleListItemContext tupleListItem() {
			return getRuleContext(TupleListItemContext.class,0);
		}
		public TupleList_Context tupleList_() {
			return getRuleContext(TupleList_Context.class,0);
		}
		public TerminalNode PARAMETERLIST() { return getToken(MiniPythonParser.PARAMETERLIST, 0); }
		public TupleListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitTupleList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleListContext tupleList() throws RecognitionException {
		TupleListContext _localctx = new TupleListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tupleList);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(115);
				tupleListItem();
				setState(116);
				tupleList_();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(118);
				tupleListItem();
				setState(119);
				match(PARAMETERLIST);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleCallContext extends ParserRuleContext {
		public TerminalNode OPENING() { return getToken(MiniPythonParser.OPENING, 0); }
		public TupleListContext tupleList() {
			return getRuleContext(TupleListContext.class,0);
		}
		public TerminalNode CLOSING() { return getToken(MiniPythonParser.CLOSING, 0); }
		public TupleCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitTupleCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleCallContext tupleCall() throws RecognitionException {
		TupleCallContext _localctx = new TupleCallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tupleCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(OPENING);
			setState(125);
			tupleList();
			setState(126);
			match(CLOSING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListListItemContext extends ParserRuleContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public ListListItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listListItem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitListListItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListListItemContext listListItem() throws RecognitionException {
		ListListItemContext _localctx = new ListListItemContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_listListItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			operation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListList_Context extends ParserRuleContext {
		public TerminalNode PARAMETERLIST() { return getToken(MiniPythonParser.PARAMETERLIST, 0); }
		public ListListItemContext listListItem() {
			return getRuleContext(ListListItemContext.class,0);
		}
		public ListList_Context listList_() {
			return getRuleContext(ListList_Context.class,0);
		}
		public ListList_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listList_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitListList_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListList_Context listList_() throws RecognitionException {
		ListList_Context _localctx = new ListList_Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_listList_);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARAMETERLIST:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(130);
				match(PARAMETERLIST);
				setState(131);
				listListItem();
				setState(132);
				listList_();
				}
				}
				break;
			case RBRACKET:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListListContext extends ParserRuleContext {
		public ListListItemContext listListItem() {
			return getRuleContext(ListListItemContext.class,0);
		}
		public ListList_Context listList_() {
			return getRuleContext(ListList_Context.class,0);
		}
		public ListListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitListList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListListContext listList() throws RecognitionException {
		ListListContext _localctx = new ListListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listList);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case ID:
			case OPENING:
			case MINUS:
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(137);
				listListItem();
				setState(138);
				listList_();
				}
				}
				break;
			case RBRACKET:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListCallContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(MiniPythonParser.LBRACKET, 0); }
		public ListListContext listList() {
			return getRuleContext(ListListContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(MiniPythonParser.RBRACKET, 0); }
		public ListCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitListCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListCallContext listCall() throws RecognitionException {
		ListCallContext _localctx = new ListCallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_listCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(LBRACKET);
			setState(144);
			listList();
			setState(145);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReferenceContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			atom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NegativeFactorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(MiniPythonParser.MINUS, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public NegativeFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negativeFactor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitNegativeFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegativeFactorContext negativeFactor() throws RecognitionException {
		NegativeFactorContext _localctx = new NegativeFactorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_negativeFactor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(MINUS);
			setState(150);
			reference();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public NegativeFactorContext negativeFactor() {
			return getRuleContext(NegativeFactorContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_factor);
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case ID:
			case OPENING:
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				reference();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				negativeFactor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationContext extends ParserRuleContext {
		public TerminalNode MULTIPLY() { return getToken(MiniPythonParser.MULTIPLY, 0); }
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public MultiplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicationContext multiplication() throws RecognitionException {
		MultiplicationContext _localctx = new MultiplicationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_multiplication);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(MULTIPLY);
			setState(157);
			product();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DivisionContext extends ParserRuleContext {
		public TerminalNode DIVIDE() { return getToken(MiniPythonParser.DIVIDE, 0); }
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public DivisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_division; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivisionContext division() throws RecognitionException {
		DivisionContext _localctx = new DivisionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_division);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(DIVIDE);
			setState(160);
			product();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RemainderContext extends ParserRuleContext {
		public TerminalNode PERCENT() { return getToken(MiniPythonParser.PERCENT, 0); }
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public RemainderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_remainder; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitRemainder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RemainderContext remainder() throws RecognitionException {
		RemainderContext _localctx = new RemainderContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_remainder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(PERCENT);
			setState(163);
			product();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Product_Context extends ParserRuleContext {
		public MultiplicationContext multiplication() {
			return getRuleContext(MultiplicationContext.class,0);
		}
		public DivisionContext division() {
			return getRuleContext(DivisionContext.class,0);
		}
		public RemainderContext remainder() {
			return getRuleContext(RemainderContext.class,0);
		}
		public Product_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitProduct_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Product_Context product_() throws RecognitionException {
		Product_Context _localctx = new Product_Context(_ctx, getState());
		enterRule(_localctx, 38, RULE_product_);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MULTIPLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				multiplication();
				}
				break;
			case DIVIDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				division();
				}
				break;
			case PERCENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				remainder();
				}
				break;
			case CLOSING:
			case RBRACKET:
			case PLUS:
			case MINUS:
			case PARAMETERLIST:
			case LOWER_THEN:
			case LOWER_EQUALS:
			case GREATER_THEN:
			case GREATER_EQUALS:
			case NOT_EQUALS:
			case EQUALS:
			case ENDOFLINE:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProductContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Product_Context product_() {
			return getRuleContext(Product_Context.class,0);
		}
		public ProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitProduct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProductContext product() throws RecognitionException {
		ProductContext _localctx = new ProductContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_product);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			factor();
			setState(172);
			product_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditionContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(MiniPythonParser.PLUS, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public AdditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionContext addition() throws RecognitionException {
		AdditionContext _localctx = new AdditionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_addition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(PLUS);
			setState(175);
			sum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubstactionContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(MiniPythonParser.MINUS, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public SubstactionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_substaction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitSubstaction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubstactionContext substaction() throws RecognitionException {
		SubstactionContext _localctx = new SubstactionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_substaction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(MINUS);
			setState(178);
			sum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Sum_Context extends ParserRuleContext {
		public AdditionContext addition() {
			return getRuleContext(AdditionContext.class,0);
		}
		public SubstactionContext substaction() {
			return getRuleContext(SubstactionContext.class,0);
		}
		public Sum_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitSum_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sum_Context sum_() throws RecognitionException {
		Sum_Context _localctx = new Sum_Context(_ctx, getState());
		enterRule(_localctx, 46, RULE_sum_);
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				addition();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				substaction();
				}
				break;
			case CLOSING:
			case RBRACKET:
			case PARAMETERLIST:
			case LOWER_THEN:
			case LOWER_EQUALS:
			case GREATER_THEN:
			case GREATER_EQUALS:
			case NOT_EQUALS:
			case EQUALS:
			case ENDOFLINE:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SumContext extends ParserRuleContext {
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public Sum_Context sum_() {
			return getRuleContext(Sum_Context.class,0);
		}
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_sum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			product();
			setState(186);
			sum_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LowerThenContext extends ParserRuleContext {
		public TerminalNode LOWER_THEN() { return getToken(MiniPythonParser.LOWER_THEN, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public LowerThenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowerThen; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitLowerThen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerThenContext lowerThen() throws RecognitionException {
		LowerThenContext _localctx = new LowerThenContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_lowerThen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(LOWER_THEN);
			setState(189);
			sum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LowerEqualsContext extends ParserRuleContext {
		public TerminalNode LOWER_EQUALS() { return getToken(MiniPythonParser.LOWER_EQUALS, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public LowerEqualsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowerEquals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitLowerEquals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LowerEqualsContext lowerEquals() throws RecognitionException {
		LowerEqualsContext _localctx = new LowerEqualsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_lowerEquals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(LOWER_EQUALS);
			setState(192);
			sum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GreaterThenContext extends ParserRuleContext {
		public TerminalNode GREATER_THEN() { return getToken(MiniPythonParser.GREATER_THEN, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public GreaterThenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterThen; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitGreaterThen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreaterThenContext greaterThen() throws RecognitionException {
		GreaterThenContext _localctx = new GreaterThenContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_greaterThen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(GREATER_THEN);
			setState(195);
			sum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GreaterEqualsContext extends ParserRuleContext {
		public TerminalNode GREATER_EQUALS() { return getToken(MiniPythonParser.GREATER_EQUALS, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public GreaterEqualsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterEquals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitGreaterEquals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreaterEqualsContext greaterEquals() throws RecognitionException {
		GreaterEqualsContext _localctx = new GreaterEqualsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_greaterEquals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(GREATER_EQUALS);
			setState(198);
			sum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NotEqulsContext extends ParserRuleContext {
		public TerminalNode NOT_EQUALS() { return getToken(MiniPythonParser.NOT_EQUALS, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public NotEqulsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notEquls; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitNotEquls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotEqulsContext notEquls() throws RecognitionException {
		NotEqulsContext _localctx = new NotEqulsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_notEquls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(NOT_EQUALS);
			setState(201);
			sum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualsContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(MiniPythonParser.EQUALS, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public EqualsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitEquals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualsContext equals() throws RecognitionException {
		EqualsContext _localctx = new EqualsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_equals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(EQUALS);
			setState(204);
			sum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comparison_Context extends ParserRuleContext {
		public LowerThenContext lowerThen() {
			return getRuleContext(LowerThenContext.class,0);
		}
		public LowerEqualsContext lowerEquals() {
			return getRuleContext(LowerEqualsContext.class,0);
		}
		public GreaterThenContext greaterThen() {
			return getRuleContext(GreaterThenContext.class,0);
		}
		public GreaterEqualsContext greaterEquals() {
			return getRuleContext(GreaterEqualsContext.class,0);
		}
		public NotEqulsContext notEquls() {
			return getRuleContext(NotEqulsContext.class,0);
		}
		public EqualsContext equals() {
			return getRuleContext(EqualsContext.class,0);
		}
		public Comparison_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitComparison_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparison_Context comparison_() throws RecognitionException {
		Comparison_Context _localctx = new Comparison_Context(_ctx, getState());
		enterRule(_localctx, 62, RULE_comparison_);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOWER_THEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				lowerThen();
				}
				break;
			case LOWER_EQUALS:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				lowerEquals();
				}
				break;
			case GREATER_THEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(208);
				greaterThen();
				}
				break;
			case GREATER_EQUALS:
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
				greaterEquals();
				}
				break;
			case NOT_EQUALS:
				enterOuterAlt(_localctx, 5);
				{
				setState(210);
				notEquls();
				}
				break;
			case EQUALS:
				enterOuterAlt(_localctx, 6);
				{
				setState(211);
				equals();
				}
				break;
			case CLOSING:
			case RBRACKET:
			case PARAMETERLIST:
			case ENDOFLINE:
				enterOuterAlt(_localctx, 7);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ParserRuleContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public Comparison_Context comparison_() {
			return getRuleContext(Comparison_Context.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			sum();
			setState(216);
			comparison_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperationContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			comparison();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleUnpackingListParameterContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TupleUnpackingListParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleUnpackingListParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitTupleUnpackingListParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleUnpackingListParameterContext tupleUnpackingListParameter() throws RecognitionException {
		TupleUnpackingListParameterContext _localctx = new TupleUnpackingListParameterContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_tupleUnpackingListParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleUnpackingList_Context extends ParserRuleContext {
		public TerminalNode PARAMETERLIST() { return getToken(MiniPythonParser.PARAMETERLIST, 0); }
		public TupleUnpackingListParameterContext tupleUnpackingListParameter() {
			return getRuleContext(TupleUnpackingListParameterContext.class,0);
		}
		public TupleUnpackingList_Context tupleUnpackingList_() {
			return getRuleContext(TupleUnpackingList_Context.class,0);
		}
		public TupleUnpackingList_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleUnpackingList_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitTupleUnpackingList_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleUnpackingList_Context tupleUnpackingList_() throws RecognitionException {
		TupleUnpackingList_Context _localctx = new TupleUnpackingList_Context(_ctx, getState());
		enterRule(_localctx, 70, RULE_tupleUnpackingList_);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARAMETERLIST:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(222);
				match(PARAMETERLIST);
				setState(223);
				tupleUnpackingListParameter();
				setState(224);
				tupleUnpackingList_();
				}
				}
				break;
			case CLOSING:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleUnpackingListContext extends ParserRuleContext {
		public TupleUnpackingListParameterContext tupleUnpackingListParameter() {
			return getRuleContext(TupleUnpackingListParameterContext.class,0);
		}
		public TupleUnpackingList_Context tupleUnpackingList_() {
			return getRuleContext(TupleUnpackingList_Context.class,0);
		}
		public TerminalNode PARAMETERLIST() { return getToken(MiniPythonParser.PARAMETERLIST, 0); }
		public TupleUnpackingListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleUnpackingList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitTupleUnpackingList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleUnpackingListContext tupleUnpackingList() throws RecognitionException {
		TupleUnpackingListContext _localctx = new TupleUnpackingListContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_tupleUnpackingList);
		try {
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(229);
				tupleUnpackingListParameter();
				setState(230);
				tupleUnpackingList_();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(232);
				tupleUnpackingListParameter();
				setState(233);
				match(PARAMETERLIST);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleUnpackingContext extends ParserRuleContext {
		public TerminalNode OPENING() { return getToken(MiniPythonParser.OPENING, 0); }
		public TupleUnpackingListContext tupleUnpackingList() {
			return getRuleContext(TupleUnpackingListContext.class,0);
		}
		public TerminalNode CLOSING() { return getToken(MiniPythonParser.CLOSING, 0); }
		public TerminalNode ASSIGMENT() { return getToken(MiniPythonParser.ASSIGMENT, 0); }
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public TupleUnpackingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleUnpacking; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitTupleUnpacking(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleUnpackingContext tupleUnpacking() throws RecognitionException {
		TupleUnpackingContext _localctx = new TupleUnpackingContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_tupleUnpacking);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(OPENING);
			setState(238);
			tupleUnpackingList();
			setState(239);
			match(CLOSING);
			setState(240);
			match(ASSIGMENT);
			setState(241);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableAssigment_Context extends ParserRuleContext {
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TupleCallContext tupleCall() {
			return getRuleContext(TupleCallContext.class,0);
		}
		public ListCallContext listCall() {
			return getRuleContext(ListCallContext.class,0);
		}
		public VariableAssigment_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssigment_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitVariableAssigment_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssigment_Context variableAssigment_() throws RecognitionException {
		VariableAssigment_Context _localctx = new VariableAssigment_Context(_ctx, getState());
		enterRule(_localctx, 76, RULE_variableAssigment_);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				operation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				tupleCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				listCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableAssigmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPythonParser.ID, 0); }
		public TerminalNode ASSIGMENT() { return getToken(MiniPythonParser.ASSIGMENT, 0); }
		public VariableAssigment_Context variableAssigment_() {
			return getRuleContext(VariableAssigment_Context.class,0);
		}
		public VariableAssigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssigment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitVariableAssigment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssigmentContext variableAssigment() throws RecognitionException {
		VariableAssigmentContext _localctx = new VariableAssigmentContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_variableAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(ID);
			setState(249);
			match(ASSIGMENT);
			setState(250);
			variableAssigment_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssigmentContext extends ParserRuleContext {
		public TupleUnpackingContext tupleUnpacking() {
			return getRuleContext(TupleUnpackingContext.class,0);
		}
		public VariableAssigmentContext variableAssigment() {
			return getRuleContext(VariableAssigmentContext.class,0);
		}
		public AssigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assigment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitAssigment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssigmentContext assigment() throws RecognitionException {
		AssigmentContext _localctx = new AssigmentContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_assigment);
		try {
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENING:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				tupleUnpacking();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				variableAssigment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssigmentContext assigment() {
			return getRuleContext(AssigmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			assigment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Statements_Context extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Statements_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitStatements_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statements_Context statements_() throws RecognitionException {
		Statements_Context _localctx = new Statements_Context(_ctx, getState());
		enterRule(_localctx, 84, RULE_statements_);
		try {
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case OPENING:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				statements();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode ENDOFLINE() { return getToken(MiniPythonParser.ENDOFLINE, 0); }
		public Statements_Context statements_() {
			return getRuleContext(Statements_Context.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_statements);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			statement();
			setState(263);
			match(ENDOFLINE);
			setState(264);
			statements_();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MiniPythonParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPythonVisitor ) return ((MiniPythonVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			statements();
			setState(267);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017\u010e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004i\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"r\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007{\b\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u0088\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u008e\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u009b\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00aa\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00b8\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u00d6\b\u001f\u0001 "+
		"\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0003#\u00e4\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003"+
		"$\u00ec\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001"+
		"&\u0003&\u00f7\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0003"+
		"(\u00ff\b(\u0001)\u0001)\u0001*\u0001*\u0003*\u0105\b*\u0001+\u0001+\u0001"+
		"+\u0001+\u0001,\u0001,\u0001,\u0001,\u0000\u0000-\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLNPRTVX\u0000\u0000\u00fa\u0000Z\u0001\u0000\u0000\u0000"+
		"\u0002^\u0001\u0000\u0000\u0000\u0004`\u0001\u0000\u0000\u0000\u0006b"+
		"\u0001\u0000\u0000\u0000\bh\u0001\u0000\u0000\u0000\nj\u0001\u0000\u0000"+
		"\u0000\fq\u0001\u0000\u0000\u0000\u000ez\u0001\u0000\u0000\u0000\u0010"+
		"|\u0001\u0000\u0000\u0000\u0012\u0080\u0001\u0000\u0000\u0000\u0014\u0087"+
		"\u0001\u0000\u0000\u0000\u0016\u008d\u0001\u0000\u0000\u0000\u0018\u008f"+
		"\u0001\u0000\u0000\u0000\u001a\u0093\u0001\u0000\u0000\u0000\u001c\u0095"+
		"\u0001\u0000\u0000\u0000\u001e\u009a\u0001\u0000\u0000\u0000 \u009c\u0001"+
		"\u0000\u0000\u0000\"\u009f\u0001\u0000\u0000\u0000$\u00a2\u0001\u0000"+
		"\u0000\u0000&\u00a9\u0001\u0000\u0000\u0000(\u00ab\u0001\u0000\u0000\u0000"+
		"*\u00ae\u0001\u0000\u0000\u0000,\u00b1\u0001\u0000\u0000\u0000.\u00b7"+
		"\u0001\u0000\u0000\u00000\u00b9\u0001\u0000\u0000\u00002\u00bc\u0001\u0000"+
		"\u0000\u00004\u00bf\u0001\u0000\u0000\u00006\u00c2\u0001\u0000\u0000\u0000"+
		"8\u00c5\u0001\u0000\u0000\u0000:\u00c8\u0001\u0000\u0000\u0000<\u00cb"+
		"\u0001\u0000\u0000\u0000>\u00d5\u0001\u0000\u0000\u0000@\u00d7\u0001\u0000"+
		"\u0000\u0000B\u00da\u0001\u0000\u0000\u0000D\u00dc\u0001\u0000\u0000\u0000"+
		"F\u00e3\u0001\u0000\u0000\u0000H\u00eb\u0001\u0000\u0000\u0000J\u00ed"+
		"\u0001\u0000\u0000\u0000L\u00f6\u0001\u0000\u0000\u0000N\u00f8\u0001\u0000"+
		"\u0000\u0000P\u00fe\u0001\u0000\u0000\u0000R\u0100\u0001\u0000\u0000\u0000"+
		"T\u0104\u0001\u0000\u0000\u0000V\u0106\u0001\u0000\u0000\u0000X\u010a"+
		"\u0001\u0000\u0000\u0000Z[\u0005\u0004\u0000\u0000[\\\u0003B!\u0000\\"+
		"]\u0005\u0005\u0000\u0000]\u0001\u0001\u0000\u0000\u0000^_\u0005\u0003"+
		"\u0000\u0000_\u0003\u0001\u0000\u0000\u0000`a\u0005\u0002\u0000\u0000"+
		"a\u0005\u0001\u0000\u0000\u0000bc\u0005\u0016\u0000\u0000c\u0007\u0001"+
		"\u0000\u0000\u0000di\u0003\u0000\u0000\u0000ei\u0003\u0004\u0002\u0000"+
		"fi\u0003\u0006\u0003\u0000gi\u0003\u0002\u0001\u0000hd\u0001\u0000\u0000"+
		"\u0000he\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hg\u0001\u0000"+
		"\u0000\u0000i\t\u0001\u0000\u0000\u0000jk\u0003B!\u0000k\u000b\u0001\u0000"+
		"\u0000\u0000lm\u0005\u000e\u0000\u0000mn\u0003\n\u0005\u0000no\u0003\f"+
		"\u0006\u0000or\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000ql\u0001"+
		"\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000r\r\u0001\u0000\u0000\u0000"+
		"st\u0003\n\u0005\u0000tu\u0003\f\u0006\u0000u{\u0001\u0000\u0000\u0000"+
		"vw\u0003\n\u0005\u0000wx\u0005\u000e\u0000\u0000x{\u0001\u0000\u0000\u0000"+
		"y{\u0001\u0000\u0000\u0000zs\u0001\u0000\u0000\u0000zv\u0001\u0000\u0000"+
		"\u0000zy\u0001\u0000\u0000\u0000{\u000f\u0001\u0000\u0000\u0000|}\u0005"+
		"\u0004\u0000\u0000}~\u0003\u000e\u0007\u0000~\u007f\u0005\u0005\u0000"+
		"\u0000\u007f\u0011\u0001\u0000\u0000\u0000\u0080\u0081\u0003B!\u0000\u0081"+
		"\u0013\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u000e\u0000\u0000\u0083"+
		"\u0084\u0003\u0012\t\u0000\u0084\u0085\u0003\u0014\n\u0000\u0085\u0088"+
		"\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0082"+
		"\u0001\u0000\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u0015"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0003\u0012\t\u0000\u008a\u008b\u0003"+
		"\u0014\n\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008e\u0001\u0000"+
		"\u0000\u0000\u008d\u0089\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000"+
		"\u0000\u0000\u008e\u0017\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0006"+
		"\u0000\u0000\u0090\u0091\u0003\u0016\u000b\u0000\u0091\u0092\u0005\u0007"+
		"\u0000\u0000\u0092\u0019\u0001\u0000\u0000\u0000\u0093\u0094\u0003\b\u0004"+
		"\u0000\u0094\u001b\u0001\u0000\u0000\u0000\u0095\u0096\u0005\t\u0000\u0000"+
		"\u0096\u0097\u0003\u001a\r\u0000\u0097\u001d\u0001\u0000\u0000\u0000\u0098"+
		"\u009b\u0003\u001a\r\u0000\u0099\u009b\u0003\u001c\u000e\u0000\u009a\u0098"+
		"\u0001\u0000\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u001f"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0005\n\u0000\u0000\u009d\u009e\u0003"+
		"(\u0014\u0000\u009e!\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u000b\u0000"+
		"\u0000\u00a0\u00a1\u0003(\u0014\u0000\u00a1#\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0005\f\u0000\u0000\u00a3\u00a4\u0003(\u0014\u0000\u00a4%\u0001"+
		"\u0000\u0000\u0000\u00a5\u00aa\u0003 \u0010\u0000\u00a6\u00aa\u0003\""+
		"\u0011\u0000\u00a7\u00aa\u0003$\u0012\u0000\u00a8\u00aa\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a5\u0001\u0000\u0000\u0000\u00a9\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\'\u0001\u0000\u0000\u0000\u00ab\u00ac\u0003\u001e\u000f\u0000"+
		"\u00ac\u00ad\u0003&\u0013\u0000\u00ad)\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0005\b\u0000\u0000\u00af\u00b0\u00030\u0018\u0000\u00b0+\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0005\t\u0000\u0000\u00b2\u00b3\u00030\u0018"+
		"\u0000\u00b3-\u0001\u0000\u0000\u0000\u00b4\u00b8\u0003*\u0015\u0000\u00b5"+
		"\u00b8\u0003,\u0016\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b8/\u0001\u0000\u0000\u0000\u00b9\u00ba\u0003"+
		"(\u0014\u0000\u00ba\u00bb\u0003.\u0017\u0000\u00bb1\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0005\u0010\u0000\u0000\u00bd\u00be\u00030\u0018\u0000"+
		"\u00be3\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u0011\u0000\u0000\u00c0"+
		"\u00c1\u00030\u0018\u0000\u00c15\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"+
		"\u0012\u0000\u0000\u00c3\u00c4\u00030\u0018\u0000\u00c47\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0005\u0013\u0000\u0000\u00c6\u00c7\u00030\u0018\u0000"+
		"\u00c79\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u0014\u0000\u0000\u00c9"+
		"\u00ca\u00030\u0018\u0000\u00ca;\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005"+
		"\u0015\u0000\u0000\u00cc\u00cd\u00030\u0018\u0000\u00cd=\u0001\u0000\u0000"+
		"\u0000\u00ce\u00d6\u00032\u0019\u0000\u00cf\u00d6\u00034\u001a\u0000\u00d0"+
		"\u00d6\u00036\u001b\u0000\u00d1\u00d6\u00038\u001c\u0000\u00d2\u00d6\u0003"+
		":\u001d\u0000\u00d3\u00d6\u0003<\u001e\u0000\u00d4\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d5\u00ce\u0001\u0000\u0000\u0000\u00d5\u00cf\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d0\u0001\u0000\u0000\u0000\u00d5\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6?\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d8\u00030\u0018\u0000\u00d8\u00d9\u0003>\u001f\u0000\u00d9A"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\u0003@ \u0000\u00dbC\u0001\u0000"+
		"\u0000\u0000\u00dc\u00dd\u0003\u0002\u0001\u0000\u00ddE\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0005\u000e\u0000\u0000\u00df\u00e0\u0003D\"\u0000"+
		"\u00e0\u00e1\u0003F#\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e3\u00de\u0001\u0000\u0000\u0000\u00e3\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e4G\u0001\u0000\u0000\u0000\u00e5\u00e6\u0003"+
		"D\"\u0000\u00e6\u00e7\u0003F#\u0000\u00e7\u00ec\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0003D\"\u0000\u00e9\u00ea\u0005\u000e\u0000\u0000\u00ea"+
		"\u00ec\u0001\u0000\u0000\u0000\u00eb\u00e5\u0001\u0000\u0000\u0000\u00eb"+
		"\u00e8\u0001\u0000\u0000\u0000\u00ecI\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0005\u0004\u0000\u0000\u00ee\u00ef\u0003H$\u0000\u00ef\u00f0\u0005\u0005"+
		"\u0000\u0000\u00f0\u00f1\u0005\r\u0000\u0000\u00f1\u00f2\u0005\u0003\u0000"+
		"\u0000\u00f2K\u0001\u0000\u0000\u0000\u00f3\u00f7\u0003B!\u0000\u00f4"+
		"\u00f7\u0003\u0010\b\u0000\u00f5\u00f7\u0003\u0018\f\u0000\u00f6\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f7M\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005"+
		"\u0003\u0000\u0000\u00f9\u00fa\u0005\r\u0000\u0000\u00fa\u00fb\u0003L"+
		"&\u0000\u00fbO\u0001\u0000\u0000\u0000\u00fc\u00ff\u0003J%\u0000\u00fd"+
		"\u00ff\u0003N\'\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00fd"+
		"\u0001\u0000\u0000\u0000\u00ffQ\u0001\u0000\u0000\u0000\u0100\u0101\u0003"+
		"P(\u0000\u0101S\u0001\u0000\u0000\u0000\u0102\u0105\u0003V+\u0000\u0103"+
		"\u0105\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104"+
		"\u0103\u0001\u0000\u0000\u0000\u0105U\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\u0003R)\u0000\u0107\u0108\u0005\u0017\u0000\u0000\u0108\u0109\u0003T"+
		"*\u0000\u0109W\u0001\u0000\u0000\u0000\u010a\u010b\u0003V+\u0000\u010b"+
		"\u010c\u0005\u0000\u0000\u0001\u010cY\u0001\u0000\u0000\u0000\u000ehq"+
		"z\u0087\u008d\u009a\u00a9\u00b7\u00d5\u00e3\u00eb\u00f6\u00fe\u0104";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}