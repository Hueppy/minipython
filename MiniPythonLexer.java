// Generated from java-escape by ANTLR 4.11.1
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
		T__0=1, T__1=2, T__2=3, LBRACKET=4, RBRACKET=5, ASSIGN=6, COLON=7, DOT=8, 
		MULTIPLY=9, DIVIDE=10, ADD=11, SUBTRACT=12, EQUALS=13, NOT_EQUALS=14, 
		GREATER_EQUALS=15, LOWER_EQUALS=16, LOWER_THAN=17, GREATER_THAN=18, SELF=19, 
		RETURN=20, WHILE=21, IF=22, ELIF=23, ELSE=24, CLASS=25, DEF=26, NOT=27, 
		AND=28, OR=29, INT=30, STRING=31, BOOLEAN=32, END=33, IDENTIFIER=34, COMMENT=35, 
		WHITESPACE=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "LBRACKET", "RBRACKET", "ASSIGN", "COLON", "DOT", 
			"MULTIPLY", "DIVIDE", "ADD", "SUBTRACT", "EQUALS", "NOT_EQUALS", "GREATER_EQUALS", 
			"LOWER_EQUALS", "LOWER_THAN", "GREATER_THAN", "SELF", "RETURN", "WHILE", 
			"IF", "ELIF", "ELSE", "CLASS", "DEF", "NOT", "AND", "OR", "INT", "STRING", 
			"BOOLEAN", "END", "IDENTIFIER", "COMMENT", "WHITESPACE"
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
		"\u0004\u0000$\u00f2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0004\u001d\u00ac\b\u001d\u000b\u001d\f\u001d\u00ad\u0001"+
		"\u001e\u0001\u001e\u0005\u001e\u00b2\b\u001e\n\u001e\f\u001e\u00b5\t\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u00ba\b\u001e\n\u001e"+
		"\f\u001e\u00bd\t\u001e\u0001\u001e\u0003\u001e\u00c0\b\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0003\u001f\u00cb\b\u001f\u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u00d5\b \u0001!\u0001!\u0005"+
		"!\u00d9\b!\n!\f!\u00dc\t!\u0001\"\u0001\"\u0005\"\u00e0\b\"\n\"\f\"\u00e3"+
		"\t\"\u0001\"\u0001\"\u0001\"\u0003\"\u00e8\b\"\u0001\"\u0001\"\u0001#"+
		"\u0004#\u00ed\b#\u000b#\f#\u00ee\u0001#\u0001#\u0003\u00b3\u00bb\u00e1"+
		"\u0000$\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\""+
		"E#G$\u0001\u0000\u0004\u0001\u000009\u0003\u0000AZ__az\u0004\u000009A"+
		"Z__az\u0003\u0000\t\n\r\r  \u00fc\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000"+
		";\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001"+
		"\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000"+
		"\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0001"+
		"I\u0001\u0000\u0000\u0000\u0003K\u0001\u0000\u0000\u0000\u0005N\u0001"+
		"\u0000\u0000\u0000\u0007S\u0001\u0000\u0000\u0000\tU\u0001\u0000\u0000"+
		"\u0000\u000bW\u0001\u0000\u0000\u0000\rY\u0001\u0000\u0000\u0000\u000f"+
		"[\u0001\u0000\u0000\u0000\u0011]\u0001\u0000\u0000\u0000\u0013_\u0001"+
		"\u0000\u0000\u0000\u0015a\u0001\u0000\u0000\u0000\u0017c\u0001\u0000\u0000"+
		"\u0000\u0019e\u0001\u0000\u0000\u0000\u001bh\u0001\u0000\u0000\u0000\u001d"+
		"k\u0001\u0000\u0000\u0000\u001fn\u0001\u0000\u0000\u0000!q\u0001\u0000"+
		"\u0000\u0000#s\u0001\u0000\u0000\u0000%u\u0001\u0000\u0000\u0000\'z\u0001"+
		"\u0000\u0000\u0000)\u0081\u0001\u0000\u0000\u0000+\u0087\u0001\u0000\u0000"+
		"\u0000-\u008a\u0001\u0000\u0000\u0000/\u008f\u0001\u0000\u0000\u00001"+
		"\u0095\u0001\u0000\u0000\u00003\u009b\u0001\u0000\u0000\u00005\u009f\u0001"+
		"\u0000\u0000\u00007\u00a3\u0001\u0000\u0000\u00009\u00a7\u0001\u0000\u0000"+
		"\u0000;\u00ab\u0001\u0000\u0000\u0000=\u00bf\u0001\u0000\u0000\u0000?"+
		"\u00ca\u0001\u0000\u0000\u0000A\u00cc\u0001\u0000\u0000\u0000C\u00d6\u0001"+
		"\u0000\u0000\u0000E\u00dd\u0001\u0000\u0000\u0000G\u00ec\u0001\u0000\u0000"+
		"\u0000IJ\u0005,\u0000\u0000J\u0002\u0001\u0000\u0000\u0000KL\u0005)\u0000"+
		"\u0000LM\u0005:\u0000\u0000M\u0004\u0001\u0000\u0000\u0000NO\u0005p\u0000"+
		"\u0000OP\u0005a\u0000\u0000PQ\u0005s\u0000\u0000QR\u0005s\u0000\u0000"+
		"R\u0006\u0001\u0000\u0000\u0000ST\u0005(\u0000\u0000T\b\u0001\u0000\u0000"+
		"\u0000UV\u0005)\u0000\u0000V\n\u0001\u0000\u0000\u0000WX\u0005=\u0000"+
		"\u0000X\f\u0001\u0000\u0000\u0000YZ\u0005:\u0000\u0000Z\u000e\u0001\u0000"+
		"\u0000\u0000[\\\u0005.\u0000\u0000\\\u0010\u0001\u0000\u0000\u0000]^\u0005"+
		"*\u0000\u0000^\u0012\u0001\u0000\u0000\u0000_`\u0005/\u0000\u0000`\u0014"+
		"\u0001\u0000\u0000\u0000ab\u0005+\u0000\u0000b\u0016\u0001\u0000\u0000"+
		"\u0000cd\u0005-\u0000\u0000d\u0018\u0001\u0000\u0000\u0000ef\u0005=\u0000"+
		"\u0000fg\u0005=\u0000\u0000g\u001a\u0001\u0000\u0000\u0000hi\u0005!\u0000"+
		"\u0000ij\u0005=\u0000\u0000j\u001c\u0001\u0000\u0000\u0000kl\u0005<\u0000"+
		"\u0000lm\u0005=\u0000\u0000m\u001e\u0001\u0000\u0000\u0000no\u0005>\u0000"+
		"\u0000op\u0005=\u0000\u0000p \u0001\u0000\u0000\u0000qr\u0005<\u0000\u0000"+
		"r\"\u0001\u0000\u0000\u0000st\u0005>\u0000\u0000t$\u0001\u0000\u0000\u0000"+
		"uv\u0005s\u0000\u0000vw\u0005e\u0000\u0000wx\u0005l\u0000\u0000xy\u0005"+
		"f\u0000\u0000y&\u0001\u0000\u0000\u0000z{\u0005r\u0000\u0000{|\u0005e"+
		"\u0000\u0000|}\u0005t\u0000\u0000}~\u0005u\u0000\u0000~\u007f\u0005r\u0000"+
		"\u0000\u007f\u0080\u0005n\u0000\u0000\u0080(\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0005w\u0000\u0000\u0082\u0083\u0005h\u0000\u0000\u0083\u0084\u0005"+
		"i\u0000\u0000\u0084\u0085\u0005l\u0000\u0000\u0085\u0086\u0005e\u0000"+
		"\u0000\u0086*\u0001\u0000\u0000\u0000\u0087\u0088\u0005i\u0000\u0000\u0088"+
		"\u0089\u0005f\u0000\u0000\u0089,\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"e\u0000\u0000\u008b\u008c\u0005l\u0000\u0000\u008c\u008d\u0005i\u0000"+
		"\u0000\u008d\u008e\u0005f\u0000\u0000\u008e.\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0005e\u0000\u0000\u0090\u0091\u0005l\u0000\u0000\u0091\u0092\u0005"+
		"s\u0000\u0000\u0092\u0093\u0005e\u0000\u0000\u0093\u0094\u0005:\u0000"+
		"\u0000\u00940\u0001\u0000\u0000\u0000\u0095\u0096\u0005c\u0000\u0000\u0096"+
		"\u0097\u0005l\u0000\u0000\u0097\u0098\u0005a\u0000\u0000\u0098\u0099\u0005"+
		"s\u0000\u0000\u0099\u009a\u0005s\u0000\u0000\u009a2\u0001\u0000\u0000"+
		"\u0000\u009b\u009c\u0005d\u0000\u0000\u009c\u009d\u0005e\u0000\u0000\u009d"+
		"\u009e\u0005f\u0000\u0000\u009e4\u0001\u0000\u0000\u0000\u009f\u00a0\u0005"+
		"n\u0000\u0000\u00a0\u00a1\u0005o\u0000\u0000\u00a1\u00a2\u0005t\u0000"+
		"\u0000\u00a26\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005a\u0000\u0000\u00a4"+
		"\u00a5\u0005n\u0000\u0000\u00a5\u00a6\u0005d\u0000\u0000\u00a68\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0005o\u0000\u0000\u00a8\u00a9\u0005r\u0000"+
		"\u0000\u00a9:\u0001\u0000\u0000\u0000\u00aa\u00ac\u0007\u0000\u0000\u0000"+
		"\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ae<\u0001\u0000\u0000\u0000\u00af\u00b3\u0005\"\u0000\u0000\u00b0"+
		"\u00b2\t\u0000\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b3\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b6\u00c0\u0005\"\u0000\u0000\u00b7\u00bb\u0005"+
		"\'\u0000\u0000\u00b8\u00ba\t\u0000\u0000\u0000\u00b9\u00b8\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00be\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c0\u0005\'\u0000"+
		"\u0000\u00bf\u00af\u0001\u0000\u0000\u0000\u00bf\u00b7\u0001\u0000\u0000"+
		"\u0000\u00c0>\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005T\u0000\u0000\u00c2"+
		"\u00c3\u0005r\u0000\u0000\u00c3\u00c4\u0005u\u0000\u0000\u00c4\u00cb\u0005"+
		"e\u0000\u0000\u00c5\u00c6\u0005F\u0000\u0000\u00c6\u00c7\u0005a\u0000"+
		"\u0000\u00c7\u00c8\u0005l\u0000\u0000\u00c8\u00c9\u0005s\u0000\u0000\u00c9"+
		"\u00cb\u0005e\u0000\u0000\u00ca\u00c1\u0001\u0000\u0000\u0000\u00ca\u00c5"+
		"\u0001\u0000\u0000\u0000\u00cb@\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"#\u0000\u0000\u00cd\u00ce\u0005e\u0000\u0000\u00ce\u00cf\u0005n\u0000"+
		"\u0000\u00cf\u00d0\u0005d\u0000\u0000\u00d0\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d5\u0005\n\u0000\u0000\u00d2\u00d3\u0005\r\u0000\u0000\u00d3"+
		"\u00d5\u0005\n\u0000\u0000\u00d4\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5B\u0001"+
		"\u0000\u0000\u0000\u00d6\u00da\u0007\u0001\u0000\u0000\u00d7\u00d9\u0007"+
		"\u0002\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001"+
		"\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001"+
		"\u0000\u0000\u0000\u00dbD\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000"+
		"\u0000\u0000\u00dd\u00e1\u0005#\u0000\u0000\u00de\u00e0\t\u0000\u0000"+
		"\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e7\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e8\u0005\n\u0000\u0000\u00e5\u00e6\u0005\r\u0000\u0000"+
		"\u00e6\u00e8\u0005\n\u0000\u0000\u00e7\u00e4\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0006\"\u0000\u0000\u00eaF\u0001\u0000\u0000\u0000\u00eb\u00ed"+
		"\u0007\u0003\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f1"+
		"\u0006#\u0000\u0000\u00f1H\u0001\u0000\u0000\u0000\u000b\u0000\u00ad\u00b3"+
		"\u00bb\u00bf\u00ca\u00d4\u00da\u00e1\u00e7\u00ee\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}