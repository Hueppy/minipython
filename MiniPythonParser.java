// Generated from java-escape by ANTLR 4.11.1
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
		T__0=1, T__1=2, T__2=3, LBRACKET=4, RBRACKET=5, ASSIGN=6, COLON=7, DOT=8, 
		MULTIPLY=9, DIVIDE=10, ADD=11, SUBTRACT=12, EQUALS=13, NOT_EQUALS=14, 
		GREATER_EQUALS=15, LOWER_EQUALS=16, LOWER_THAN=17, GREATER_THAN=18, SELF=19, 
		RETURN=20, WHILE=21, IF=22, ELIF=23, ELSE=24, CLASS=25, DEF=26, NOT=27, 
		AND=28, OR=29, INT=30, STRING=31, BOOLEAN=32, END=33, IDENTIFIER=34, COMMENT=35, 
		WHITESPACE=36;
	public static final int
		RULE_start = 0, RULE_identifier = 1, RULE_call_parameter = 2, RULE_call = 3, 
		RULE_expression = 4, RULE_assignment = 5, RULE_return = 6, RULE_condition = 7, 
		RULE_loop = 8, RULE_if_statement = 9, RULE_elif_statement = 10, RULE_else_statement = 11, 
		RULE_conditional = 12, RULE_function_parameter = 13, RULE_function = 14, 
		RULE_class_function = 15, RULE_class = 16, RULE_statement = 17, RULE_statements = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "identifier", "call_parameter", "call", "expression", "assignment", 
			"return", "condition", "loop", "if_statement", "elif_statement", "else_statement", 
			"conditional", "function_parameter", "function", "class_function", "class", 
			"statement", "statements"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'):'", "'pass'", "'('", "')'", "'='", "':'", "'.'", "'*'", 
			"'/'", "'+'", "'-'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", "'self'", 
			"'return'", "'while'", "'if'", "'elif'", "'else:'", "'class'", "'def'", 
			"'not'", "'and'", "'or'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "LBRACKET", "RBRACKET", "ASSIGN", "COLON", "DOT", 
			"MULTIPLY", "DIVIDE", "ADD", "SUBTRACT", "EQUALS", "NOT_EQUALS", "GREATER_EQUALS", 
			"LOWER_EQUALS", "LOWER_THAN", "GREATER_THAN", "SELF", "RETURN", "WHILE", 
			"IF", "ELIF", "ELSE", "CLASS", "DEF", "NOT", "AND", "OR", "INT", "STRING", 
			"BOOLEAN", "END", "IDENTIFIER", "COMMENT", "WHITESPACE"
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
	public static class StartContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			statements();
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniPythonParser.IDENTIFIER, 0); }
		public TerminalNode SELF() { return getToken(MiniPythonParser.SELF, 0); }
		public TerminalNode DOT() { return getToken(MiniPythonParser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		return identifier(0);
	}

	private IdentifierContext identifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdentifierContext _localctx = new IdentifierContext(_ctx, _parentState);
		IdentifierContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_identifier, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(41);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(42);
				match(SELF);
				}
				break;
			case 3:
				{
				setState(43);
				match(SELF);
				setState(44);
				match(DOT);
				setState(45);
				match(IDENTIFIER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IdentifierContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_identifier);
					setState(48);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(49);
					match(DOT);
					setState(50);
					match(IDENTIFIER);
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Call_parameterContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Call_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterCall_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitCall_parameter(this);
		}
	}

	public final Call_parameterContext call_parameter() throws RecognitionException {
		Call_parameterContext _localctx = new Call_parameterContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_call_parameter);
		int _la;
		try {
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACKET:
			case SELF:
			case NOT:
			case INT:
			case STRING:
			case BOOLEAN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				expression(0);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(57);
					match(T__0);
					setState(58);
					expression(0);
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
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
	public static class CallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(MiniPythonParser.LBRACKET, 0); }
		public Call_parameterContext call_parameter() {
			return getRuleContext(Call_parameterContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(MiniPythonParser.RBRACKET, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitCall(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			identifier(0);
			setState(68);
			match(LBRACKET);
			setState(69);
			call_parameter();
			setState(70);
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
	public static class ExpressionContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INT() { return getToken(MiniPythonParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MiniPythonParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(MiniPythonParser.BOOLEAN, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniPythonParser.LBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(MiniPythonParser.RBRACKET, 0); }
		public TerminalNode NOT() { return getToken(MiniPythonParser.NOT, 0); }
		public TerminalNode MULTIPLY() { return getToken(MiniPythonParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(MiniPythonParser.DIVIDE, 0); }
		public TerminalNode ADD() { return getToken(MiniPythonParser.ADD, 0); }
		public TerminalNode SUBTRACT() { return getToken(MiniPythonParser.SUBTRACT, 0); }
		public TerminalNode EQUALS() { return getToken(MiniPythonParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(MiniPythonParser.NOT_EQUALS, 0); }
		public TerminalNode GREATER_EQUALS() { return getToken(MiniPythonParser.GREATER_EQUALS, 0); }
		public TerminalNode LOWER_EQUALS() { return getToken(MiniPythonParser.LOWER_EQUALS, 0); }
		public TerminalNode GREATER_THAN() { return getToken(MiniPythonParser.GREATER_THAN, 0); }
		public TerminalNode LOWER_THAN() { return getToken(MiniPythonParser.LOWER_THAN, 0); }
		public TerminalNode AND() { return getToken(MiniPythonParser.AND, 0); }
		public TerminalNode OR() { return getToken(MiniPythonParser.OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(73);
				call();
				}
				break;
			case 2:
				{
				setState(74);
				identifier(0);
				}
				break;
			case 3:
				{
				setState(75);
				match(INT);
				}
				break;
			case 4:
				{
				setState(76);
				match(STRING);
				}
				break;
			case 5:
				{
				setState(77);
				match(BOOLEAN);
				}
				break;
			case 6:
				{
				setState(78);
				match(LBRACKET);
				setState(79);
				expression(0);
				setState(80);
				match(RBRACKET);
				}
				break;
			case 7:
				{
				setState(82);
				match(NOT);
				setState(83);
				expression(3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(122);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(86);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(87);
						match(MULTIPLY);
						setState(88);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(89);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(90);
						match(DIVIDE);
						setState(91);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(93);
						match(ADD);
						setState(94);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(95);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(96);
						match(SUBTRACT);
						setState(97);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(98);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(99);
						match(EQUALS);
						setState(100);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(102);
						match(NOT_EQUALS);
						setState(103);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(105);
						match(GREATER_EQUALS);
						setState(106);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(108);
						match(LOWER_EQUALS);
						setState(109);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(111);
						match(GREATER_THAN);
						setState(112);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(114);
						match(LOWER_THAN);
						setState(115);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(117);
						match(AND);
						setState(118);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(120);
						match(OR);
						setState(121);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MiniPythonParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			identifier(0);
			setState(128);
			match(ASSIGN);
			setState(129);
			expression(0);
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
	public static class ReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniPythonParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitReturn(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(RETURN);
			setState(132);
			expression(0);
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
	public static class ConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MiniPythonParser.COLON, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniPythonParser.LBRACKET, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_condition);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				expression(0);
				setState(135);
				match(COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(LBRACKET);
				setState(138);
				expression(0);
				setState(139);
				match(T__1);
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
	public static class LoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniPythonParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitLoop(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(WHILE);
			setState(144);
			condition();
			setState(145);
			statements();
			setState(146);
			match(END);
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
	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniPythonParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitIf_statement(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(IF);
			setState(149);
			condition();
			setState(150);
			statements();
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
	public static class Elif_statementContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(MiniPythonParser.ELIF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Elif_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterElif_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitElif_statement(this);
		}
	}

	public final Elif_statementContext elif_statement() throws RecognitionException {
		Elif_statementContext _localctx = new Elif_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elif_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(ELIF);
			setState(153);
			condition();
			setState(154);
			statements();
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
	public static class Else_statementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MiniPythonParser.ELSE, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitElse_statement(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(ELSE);
			setState(157);
			statements();
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
	public static class ConditionalContext extends ParserRuleContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public List<Elif_statementContext> elif_statement() {
			return getRuleContexts(Elif_statementContext.class);
		}
		public Elif_statementContext elif_statement(int i) {
			return getRuleContext(Elif_statementContext.class,i);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitConditional(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			if_statement();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(160);
				elif_statement();
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(166);
				else_statement();
				}
			}

			setState(169);
			match(END);
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
	public static class Function_parameterContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(MiniPythonParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MiniPythonParser.IDENTIFIER, i);
		}
		public Function_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterFunction_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitFunction_parameter(this);
		}
	}

	public final Function_parameterContext function_parameter() throws RecognitionException {
		Function_parameterContext _localctx = new Function_parameterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function_parameter);
		int _la;
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(IDENTIFIER);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(172);
					match(T__0);
					setState(173);
					match(IDENTIFIER);
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__1:
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
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(MiniPythonParser.DEF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniPythonParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniPythonParser.LBRACKET, 0); }
		public Function_parameterContext function_parameter() {
			return getRuleContext(Function_parameterContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(DEF);
			setState(183);
			match(IDENTIFIER);
			setState(184);
			match(LBRACKET);
			setState(185);
			function_parameter();
			setState(186);
			match(T__1);
			setState(187);
			statements();
			setState(188);
			match(END);
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
	public static class Class_functionContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(MiniPythonParser.DEF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniPythonParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniPythonParser.LBRACKET, 0); }
		public TerminalNode SELF() { return getToken(MiniPythonParser.SELF, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public Function_parameterContext function_parameter() {
			return getRuleContext(Function_parameterContext.class,0);
		}
		public Class_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterClass_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitClass_function(this);
		}
	}

	public final Class_functionContext class_function() throws RecognitionException {
		Class_functionContext _localctx = new Class_functionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_class_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(DEF);
			setState(191);
			match(IDENTIFIER);
			setState(192);
			match(LBRACKET);
			setState(193);
			match(SELF);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(194);
				match(T__0);
				setState(195);
				function_parameter();
				}
			}

			setState(198);
			match(T__1);
			setState(199);
			statements();
			setState(200);
			match(END);
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
	public static class ClassContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(MiniPythonParser.CLASS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(MiniPythonParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MiniPythonParser.IDENTIFIER, i);
		}
		public TerminalNode END() { return getToken(MiniPythonParser.END, 0); }
		public TerminalNode COLON() { return getToken(MiniPythonParser.COLON, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniPythonParser.LBRACKET, 0); }
		public List<Class_functionContext> class_function() {
			return getRuleContexts(Class_functionContext.class);
		}
		public Class_functionContext class_function(int i) {
			return getRuleContext(Class_functionContext.class,i);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitClass(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(CLASS);
			setState(203);
			match(IDENTIFIER);
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLON:
				{
				setState(204);
				match(COLON);
				}
				break;
			case LBRACKET:
				{
				setState(205);
				match(LBRACKET);
				setState(206);
				match(IDENTIFIER);
				setState(207);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEF) {
				{
				{
				setState(210);
				class_function();
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
			match(END);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public ClassContext class_() {
			return getRuleContext(ClassContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		try {
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				loop();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				conditional();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(222);
				function();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(223);
				return_();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(224);
				class_();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(225);
				match(T__2);
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
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPythonListener ) ((MiniPythonListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(228);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(231); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return identifier_sempred((IdentifierContext)_localctx, predIndex);
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean identifier_sempred(IdentifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001$\u00ea\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001/\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u00014\b\u0001\n\u0001\f\u00017\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002<\b\u0002\n\u0002\f\u0002?\t\u0002"+
		"\u0001\u0002\u0003\u0002B\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004U\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004{\b\u0004"+
		"\n\u0004\f\u0004~\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u008e\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0005\f\u00a2\b\f\n\f\f\f\u00a5\t\f\u0001\f\u0003\f\u00a8"+
		"\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r\u00af\b\r\n\r\f\r"+
		"\u00b2\t\r\u0001\r\u0003\r\u00b5\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00c5\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00d1\b\u0010\u0001\u0010\u0005\u0010\u00d4\b\u0010\n\u0010\f\u0010\u00d7"+
		"\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00e3"+
		"\b\u0011\u0001\u0012\u0004\u0012\u00e6\b\u0012\u000b\u0012\f\u0012\u00e7"+
		"\u0001\u0012\u0001\u00e7\u0002\u0002\b\u0013\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0000"+
		"\u00fd\u0000&\u0001\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u0004"+
		"A\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\bT\u0001\u0000"+
		"\u0000\u0000\n\u007f\u0001\u0000\u0000\u0000\f\u0083\u0001\u0000\u0000"+
		"\u0000\u000e\u008d\u0001\u0000\u0000\u0000\u0010\u008f\u0001\u0000\u0000"+
		"\u0000\u0012\u0094\u0001\u0000\u0000\u0000\u0014\u0098\u0001\u0000\u0000"+
		"\u0000\u0016\u009c\u0001\u0000\u0000\u0000\u0018\u009f\u0001\u0000\u0000"+
		"\u0000\u001a\u00b4\u0001\u0000\u0000\u0000\u001c\u00b6\u0001\u0000\u0000"+
		"\u0000\u001e\u00be\u0001\u0000\u0000\u0000 \u00ca\u0001\u0000\u0000\u0000"+
		"\"\u00e2\u0001\u0000\u0000\u0000$\u00e5\u0001\u0000\u0000\u0000&\'\u0003"+
		"$\u0012\u0000\'\u0001\u0001\u0000\u0000\u0000()\u0006\u0001\uffff\uffff"+
		"\u0000)/\u0005\"\u0000\u0000*/\u0005\u0013\u0000\u0000+,\u0005\u0013\u0000"+
		"\u0000,-\u0005\b\u0000\u0000-/\u0005\"\u0000\u0000.(\u0001\u0000\u0000"+
		"\u0000.*\u0001\u0000\u0000\u0000.+\u0001\u0000\u0000\u0000/5\u0001\u0000"+
		"\u0000\u000001\n\u0002\u0000\u000012\u0005\b\u0000\u000024\u0005\"\u0000"+
		"\u000030\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000"+
		"\u0000\u000056\u0001\u0000\u0000\u00006\u0003\u0001\u0000\u0000\u0000"+
		"75\u0001\u0000\u0000\u00008=\u0003\b\u0004\u00009:\u0005\u0001\u0000\u0000"+
		":<\u0003\b\u0004\u0000;9\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>B\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000@B\u0001\u0000\u0000\u0000A8\u0001\u0000"+
		"\u0000\u0000A@\u0001\u0000\u0000\u0000B\u0005\u0001\u0000\u0000\u0000"+
		"CD\u0003\u0002\u0001\u0000DE\u0005\u0004\u0000\u0000EF\u0003\u0004\u0002"+
		"\u0000FG\u0005\u0005\u0000\u0000G\u0007\u0001\u0000\u0000\u0000HI\u0006"+
		"\u0004\uffff\uffff\u0000IU\u0003\u0006\u0003\u0000JU\u0003\u0002\u0001"+
		"\u0000KU\u0005\u001e\u0000\u0000LU\u0005\u001f\u0000\u0000MU\u0005 \u0000"+
		"\u0000NO\u0005\u0004\u0000\u0000OP\u0003\b\u0004\u0000PQ\u0005\u0005\u0000"+
		"\u0000QU\u0001\u0000\u0000\u0000RS\u0005\u001b\u0000\u0000SU\u0003\b\u0004"+
		"\u0003TH\u0001\u0000\u0000\u0000TJ\u0001\u0000\u0000\u0000TK\u0001\u0000"+
		"\u0000\u0000TL\u0001\u0000\u0000\u0000TM\u0001\u0000\u0000\u0000TN\u0001"+
		"\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000U|\u0001\u0000\u0000\u0000"+
		"VW\n\r\u0000\u0000WX\u0005\t\u0000\u0000X{\u0003\b\u0004\u000eYZ\n\f\u0000"+
		"\u0000Z[\u0005\n\u0000\u0000[{\u0003\b\u0004\r\\]\n\u000b\u0000\u0000"+
		"]^\u0005\u000b\u0000\u0000^{\u0003\b\u0004\f_`\n\n\u0000\u0000`a\u0005"+
		"\f\u0000\u0000a{\u0003\b\u0004\u000bbc\n\t\u0000\u0000cd\u0005\r\u0000"+
		"\u0000d{\u0003\b\u0004\nef\n\b\u0000\u0000fg\u0005\u000e\u0000\u0000g"+
		"{\u0003\b\u0004\thi\n\u0007\u0000\u0000ij\u0005\u000f\u0000\u0000j{\u0003"+
		"\b\u0004\bkl\n\u0006\u0000\u0000lm\u0005\u0010\u0000\u0000m{\u0003\b\u0004"+
		"\u0007no\n\u0005\u0000\u0000op\u0005\u0012\u0000\u0000p{\u0003\b\u0004"+
		"\u0006qr\n\u0004\u0000\u0000rs\u0005\u0011\u0000\u0000s{\u0003\b\u0004"+
		"\u0005tu\n\u0002\u0000\u0000uv\u0005\u001c\u0000\u0000v{\u0003\b\u0004"+
		"\u0003wx\n\u0001\u0000\u0000xy\u0005\u001d\u0000\u0000y{\u0003\b\u0004"+
		"\u0002zV\u0001\u0000\u0000\u0000zY\u0001\u0000\u0000\u0000z\\\u0001\u0000"+
		"\u0000\u0000z_\u0001\u0000\u0000\u0000zb\u0001\u0000\u0000\u0000ze\u0001"+
		"\u0000\u0000\u0000zh\u0001\u0000\u0000\u0000zk\u0001\u0000\u0000\u0000"+
		"zn\u0001\u0000\u0000\u0000zq\u0001\u0000\u0000\u0000zt\u0001\u0000\u0000"+
		"\u0000zw\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}\t\u0001\u0000\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0003\u0002\u0001\u0000\u0080\u0081\u0005"+
		"\u0006\u0000\u0000\u0081\u0082\u0003\b\u0004\u0000\u0082\u000b\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0005\u0014\u0000\u0000\u0084\u0085\u0003\b\u0004"+
		"\u0000\u0085\r\u0001\u0000\u0000\u0000\u0086\u0087\u0003\b\u0004\u0000"+
		"\u0087\u0088\u0005\u0007\u0000\u0000\u0088\u008e\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0005\u0004\u0000\u0000\u008a\u008b\u0003\b\u0004\u0000\u008b"+
		"\u008c\u0005\u0002\u0000\u0000\u008c\u008e\u0001\u0000\u0000\u0000\u008d"+
		"\u0086\u0001\u0000\u0000\u0000\u008d\u0089\u0001\u0000\u0000\u0000\u008e"+
		"\u000f\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0015\u0000\u0000\u0090"+
		"\u0091\u0003\u000e\u0007\u0000\u0091\u0092\u0003$\u0012\u0000\u0092\u0093"+
		"\u0005!\u0000\u0000\u0093\u0011\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"\u0016\u0000\u0000\u0095\u0096\u0003\u000e\u0007\u0000\u0096\u0097\u0003"+
		"$\u0012\u0000\u0097\u0013\u0001\u0000\u0000\u0000\u0098\u0099\u0005\u0017"+
		"\u0000\u0000\u0099\u009a\u0003\u000e\u0007\u0000\u009a\u009b\u0003$\u0012"+
		"\u0000\u009b\u0015\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0018\u0000"+
		"\u0000\u009d\u009e\u0003$\u0012\u0000\u009e\u0017\u0001\u0000\u0000\u0000"+
		"\u009f\u00a3\u0003\u0012\t\u0000\u00a0\u00a2\u0003\u0014\n\u0000\u00a1"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a8\u0003\u0016\u000b\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0005!\u0000\u0000\u00aa\u0019\u0001\u0000\u0000\u0000\u00ab\u00b0"+
		"\u0005\"\u0000\u0000\u00ac\u00ad\u0005\u0001\u0000\u0000\u00ad\u00af\u0005"+
		"\"\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b5\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b5\u0001\u0000\u0000\u0000\u00b4\u00ab\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u001b\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0005\u001a\u0000\u0000\u00b7\u00b8\u0005\"\u0000"+
		"\u0000\u00b8\u00b9\u0005\u0004\u0000\u0000\u00b9\u00ba\u0003\u001a\r\u0000"+
		"\u00ba\u00bb\u0005\u0002\u0000\u0000\u00bb\u00bc\u0003$\u0012\u0000\u00bc"+
		"\u00bd\u0005!\u0000\u0000\u00bd\u001d\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0005\u001a\u0000\u0000\u00bf\u00c0\u0005\"\u0000\u0000\u00c0\u00c1\u0005"+
		"\u0004\u0000\u0000\u00c1\u00c4\u0005\u0013\u0000\u0000\u00c2\u00c3\u0005"+
		"\u0001\u0000\u0000\u00c3\u00c5\u0003\u001a\r\u0000\u00c4\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0005\u0002\u0000\u0000\u00c7\u00c8\u0003$\u0012"+
		"\u0000\u00c8\u00c9\u0005!\u0000\u0000\u00c9\u001f\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u0005\u0019\u0000\u0000\u00cb\u00d0\u0005\"\u0000\u0000\u00cc"+
		"\u00d1\u0005\u0007\u0000\u0000\u00cd\u00ce\u0005\u0004\u0000\u0000\u00ce"+
		"\u00cf\u0005\"\u0000\u0000\u00cf\u00d1\u0005\u0002\u0000\u0000\u00d0\u00cc"+
		"\u0001\u0000\u0000\u0000\u00d0\u00cd\u0001\u0000\u0000\u0000\u00d1\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d4\u0003\u001e\u000f\u0000\u00d3\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d8\u00d9"+
		"\u0005!\u0000\u0000\u00d9!\u0001\u0000\u0000\u0000\u00da\u00e3\u0003\b"+
		"\u0004\u0000\u00db\u00e3\u0003\n\u0005\u0000\u00dc\u00e3\u0003\u0010\b"+
		"\u0000\u00dd\u00e3\u0003\u0018\f\u0000\u00de\u00e3\u0003\u001c\u000e\u0000"+
		"\u00df\u00e3\u0003\f\u0006\u0000\u00e0\u00e3\u0003 \u0010\u0000\u00e1"+
		"\u00e3\u0005\u0003\u0000\u0000\u00e2\u00da\u0001\u0000\u0000\u0000\u00e2"+
		"\u00db\u0001\u0000\u0000\u0000\u00e2\u00dc\u0001\u0000\u0000\u0000\u00e2"+
		"\u00dd\u0001\u0000\u0000\u0000\u00e2\u00de\u0001\u0000\u0000\u0000\u00e2"+
		"\u00df\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e3#\u0001\u0000\u0000\u0000\u00e4\u00e6"+
		"\u0003\"\u0011\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e8%\u0001\u0000\u0000\u0000\u0011.5=ATz|\u008d\u00a3"+
		"\u00a7\u00b0\u00b4\u00c4\u00d0\u00d5\u00e2\u00e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}