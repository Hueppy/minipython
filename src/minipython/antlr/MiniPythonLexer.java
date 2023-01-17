// Generated from java-escape by ANTLR 4.11.1
package minipython.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniPythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FAULT_INTEGER=1, INTEGER=2, ID=3, OPENING=4, CLOSING=5, LBRACKET=6, RBRACKET=7, 
		PLUS=8, MINUS=9, MULTIPLY=10, DIVIDE=11, PERCENT=12, ASSIGMENT=13, PARAMETERLIST=14, 
		METHODOPERATOR=15, LOWER_THEN=16, LOWER_EQUALS=17, GREATER_THEN=18, GREATER_EQUALS=19, 
		NOT_EQUALS=20, EQUALS=21, BOOLEAN=22, ENDOFLINE=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FAULT_INTEGER", "INTEGER", "ZERO_DIGIT", "NON_ZERO_DIGIT", "DIGIT", 
			"ID", "CHARACTER", "OPENING", "CLOSING", "LBRACKET", "RBRACKET", "PLUS", 
			"MINUS", "MULTIPLY", "DIVIDE", "PERCENT", "ASSIGMENT", "PARAMETERLIST", 
			"METHODOPERATOR", "LOWER_THEN", "LOWER_EQUALS", "GREATER_THEN", "GREATER_EQUALS", 
			"NOT_EQUALS", "EQUALS", "BOOLEAN", "ENDOFLINE"
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


	public MiniPythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniPython.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0017\u009b\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0001\u0000\u0004\u00009\b\u0000\u000b\u0000\f\u0000:\u0001\u0000\u0005"+
		"\u0000>\b\u0000\n\u0000\f\u0000A\t\u0000\u0001\u0001\u0001\u0001\u0005"+
		"\u0001E\b\u0001\n\u0001\f\u0001H\t\u0001\u0001\u0001\u0004\u0001K\b\u0001"+
		"\u000b\u0001\f\u0001L\u0003\u0001O\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005X\b"+
		"\u0005\u000b\u0005\f\u0005Y\u0001\u0005\u0005\u0005]\b\u0005\n\u0005\f"+
		"\u0005`\t\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0095\b\u0019\u0001\u001a\u0003\u001a\u0098\b"+
		"\u001a\u0001\u001a\u0001\u001a\u0000\u0000\u001b\u0001\u0001\u0003\u0002"+
		"\u0005\u0000\u0007\u0000\t\u0000\u000b\u0003\r\u0000\u000f\u0004\u0011"+
		"\u0005\u0013\u0006\u0015\u0007\u0017\b\u0019\t\u001b\n\u001d\u000b\u001f"+
		"\f!\r#\u000e%\u000f\'\u0010)\u0011+\u0012-\u0013/\u00141\u00153\u0016"+
		"5\u0017\u0001\u0000\u0003\u0001\u000019\u0001\u000009\u0003\u0000AZ__"+
		"az\u009f\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00018\u0001"+
		"\u0000\u0000\u0000\u0003N\u0001\u0000\u0000\u0000\u0005P\u0001\u0000\u0000"+
		"\u0000\u0007R\u0001\u0000\u0000\u0000\tT\u0001\u0000\u0000\u0000\u000b"+
		"W\u0001\u0000\u0000\u0000\ra\u0001\u0000\u0000\u0000\u000fc\u0001\u0000"+
		"\u0000\u0000\u0011e\u0001\u0000\u0000\u0000\u0013g\u0001\u0000\u0000\u0000"+
		"\u0015i\u0001\u0000\u0000\u0000\u0017k\u0001\u0000\u0000\u0000\u0019m"+
		"\u0001\u0000\u0000\u0000\u001bo\u0001\u0000\u0000\u0000\u001dq\u0001\u0000"+
		"\u0000\u0000\u001fs\u0001\u0000\u0000\u0000!u\u0001\u0000\u0000\u0000"+
		"#w\u0001\u0000\u0000\u0000%y\u0001\u0000\u0000\u0000\'{\u0001\u0000\u0000"+
		"\u0000)}\u0001\u0000\u0000\u0000+\u0080\u0001\u0000\u0000\u0000-\u0082"+
		"\u0001\u0000\u0000\u0000/\u0085\u0001\u0000\u0000\u00001\u0088\u0001\u0000"+
		"\u0000\u00003\u0094\u0001\u0000\u0000\u00005\u0097\u0001\u0000\u0000\u0000"+
		"79\u0003\u0005\u0002\u000087\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;?\u0001\u0000"+
		"\u0000\u0000<>\u0003\t\u0004\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@\u0002"+
		"\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BF\u0003\u0007\u0003"+
		"\u0000CE\u0003\t\u0004\u0000DC\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GO\u0001\u0000"+
		"\u0000\u0000HF\u0001\u0000\u0000\u0000IK\u0003\u0005\u0002\u0000JI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MO\u0001\u0000\u0000\u0000NB\u0001\u0000\u0000"+
		"\u0000NJ\u0001\u0000\u0000\u0000O\u0004\u0001\u0000\u0000\u0000PQ\u0005"+
		"0\u0000\u0000Q\u0006\u0001\u0000\u0000\u0000RS\u0007\u0000\u0000\u0000"+
		"S\b\u0001\u0000\u0000\u0000TU\u0007\u0001\u0000\u0000U\n\u0001\u0000\u0000"+
		"\u0000VX\u0003\r\u0006\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000"+
		"\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z^\u0001\u0000"+
		"\u0000\u0000[]\u0003\t\u0004\u0000\\[\u0001\u0000\u0000\u0000]`\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_\f\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0007\u0002\u0000"+
		"\u0000b\u000e\u0001\u0000\u0000\u0000cd\u0005(\u0000\u0000d\u0010\u0001"+
		"\u0000\u0000\u0000ef\u0005)\u0000\u0000f\u0012\u0001\u0000\u0000\u0000"+
		"gh\u0005[\u0000\u0000h\u0014\u0001\u0000\u0000\u0000ij\u0005]\u0000\u0000"+
		"j\u0016\u0001\u0000\u0000\u0000kl\u0005+\u0000\u0000l\u0018\u0001\u0000"+
		"\u0000\u0000mn\u0005-\u0000\u0000n\u001a\u0001\u0000\u0000\u0000op\u0005"+
		"*\u0000\u0000p\u001c\u0001\u0000\u0000\u0000qr\u0005/\u0000\u0000r\u001e"+
		"\u0001\u0000\u0000\u0000st\u0005%\u0000\u0000t \u0001\u0000\u0000\u0000"+
		"uv\u0005=\u0000\u0000v\"\u0001\u0000\u0000\u0000wx\u0005,\u0000\u0000"+
		"x$\u0001\u0000\u0000\u0000yz\u0005.\u0000\u0000z&\u0001\u0000\u0000\u0000"+
		"{|\u0005<\u0000\u0000|(\u0001\u0000\u0000\u0000}~\u0005<\u0000\u0000~"+
		"\u007f\u0005=\u0000\u0000\u007f*\u0001\u0000\u0000\u0000\u0080\u0081\u0005"+
		">\u0000\u0000\u0081,\u0001\u0000\u0000\u0000\u0082\u0083\u0005>\u0000"+
		"\u0000\u0083\u0084\u0005=\u0000\u0000\u0084.\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005!\u0000\u0000\u0086\u0087\u0005=\u0000\u0000\u00870\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0005=\u0000\u0000\u0089\u008a\u0005=\u0000"+
		"\u0000\u008a2\u0001\u0000\u0000\u0000\u008b\u008c\u0005t\u0000\u0000\u008c"+
		"\u008d\u0005r\u0000\u0000\u008d\u008e\u0005u\u0000\u0000\u008e\u0095\u0005"+
		"e\u0000\u0000\u008f\u0090\u0005f\u0000\u0000\u0090\u0091\u0005a\u0000"+
		"\u0000\u0091\u0092\u0005l\u0000\u0000\u0092\u0093\u0005s\u0000\u0000\u0093"+
		"\u0095\u0005e\u0000\u0000\u0094\u008b\u0001\u0000\u0000\u0000\u0094\u008f"+
		"\u0001\u0000\u0000\u0000\u00954\u0001\u0000\u0000\u0000\u0096\u0098\u0005"+
		"\r\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0005\n\u0000"+
		"\u0000\u009a6\u0001\u0000\u0000\u0000\n\u0000:?FLNY^\u0094\u0097\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}