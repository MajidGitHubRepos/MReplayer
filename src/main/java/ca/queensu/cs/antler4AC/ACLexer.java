package ca.queensu.cs.antler4AC; // Generated from AC.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ACLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, INTVAR=3, DOUBLEVAR=4, STRINGVAR=5, OR=6, AND=7, EQ=8, 
		NEQ=9, GT=10, LT=11, GTEQ=12, LTEQ=13, PLUS=14, PLUSPLUS=15, MINUS=16, 
		MINUSMINUS=17, MULT=18, DIV=19, MOD=20, POW=21, NOT=22, COMMA=23, COLON=24, 
		SCOL=25, ASSIGN=26, OPAR=27, CPAR=28, OBRACE=29, CBRACE=30, LBRACKET=31, 
		RBRACKET=32, TRUE=33, FALSE=34, NIL=35, IF=36, ELSE=37, WHILE=38, LOG=39, 
		FOR=40, DO=41, SEND=42, SENDAT=43, BACKMSG=44, SHOWHEAP=45, SHOWLISTSEND=46, 
		ID=47, INT=48, FLOAT=49, STRING=50, COMMENT=51, BLOCKCOMMENT=52, SPACE=53, 
		NEWLINE=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "INTVAR", "DOUBLEVAR", "STRINGVAR", "OR", "AND", "EQ", 
			"NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "PLUSPLUS", "MINUS", "MINUSMINUS", 
			"MULT", "DIV", "MOD", "POW", "NOT", "COMMA", "COLON", "SCOL", "ASSIGN", 
			"OPAR", "CPAR", "OBRACE", "CBRACE", "LBRACKET", "RBRACKET", "TRUE", "FALSE", 
			"NIL", "IF", "ELSE", "WHILE", "LOG", "FOR", "DO", "SEND", "SENDAT", "BACKMSG", 
			"SHOWHEAP", "SHOWLISTSEND", "ID", "INT", "FLOAT", "STRING", "COMMENT", 
			"BLOCKCOMMENT", "SPACE", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'()'", "'int'", "'double'", "'String'", "'||'", "'&&'", 
			"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'++'", "'-'", "'--'", 
			"'*'", "'/'", "'%'", "'^'", "'!'", "','", "':'", "';'", "'='", "'('", 
			"')'", "'{'", "'}'", "'['", "']'", "'true'", "'false'", "'nil'", "'if'", 
			"'else'", "'while'", "'log'", "'for'", "'do'", "'send'", "'sendAt'", 
			"'msg->sapIndex0_'", "'showHeap'", "'showListSendMsg'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "INTVAR", "DOUBLEVAR", "STRINGVAR", "OR", "AND", "EQ", 
			"NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "PLUSPLUS", "MINUS", "MINUSMINUS", 
			"MULT", "DIV", "MOD", "POW", "NOT", "COMMA", "COLON", "SCOL", "ASSIGN", 
			"OPAR", "CPAR", "OBRACE", "CBRACE", "LBRACKET", "RBRACKET", "TRUE", "FALSE", 
			"NIL", "IF", "ELSE", "WHILE", "LOG", "FOR", "DO", "SEND", "SENDAT", "BACKMSG", 
			"SHOWHEAP", "SHOWLISTSEND", "ID", "INT", "FLOAT", "STRING", "COMMENT", 
			"BLOCKCOMMENT", "SPACE", "NEWLINE"
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


	public ACLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AC.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u0172\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+\3"+
		",\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3\60\3\60\7\60\u0124\n\60\f\60\16\60\u0127\13\60\3\61\6\61\u012a"+
		"\n\61\r\61\16\61\u012b\3\62\6\62\u012f\n\62\r\62\16\62\u0130\3\62\3\62"+
		"\7\62\u0135\n\62\f\62\16\62\u0138\13\62\3\62\3\62\6\62\u013c\n\62\r\62"+
		"\16\62\u013d\5\62\u0140\n\62\3\63\3\63\3\63\3\63\7\63\u0146\n\63\f\63"+
		"\16\63\u0149\13\63\3\63\3\63\3\64\3\64\3\64\3\64\7\64\u0151\n\64\f\64"+
		"\16\64\u0154\13\64\3\64\3\64\3\65\3\65\3\65\3\65\7\65\u015c\n\65\f\65"+
		"\16\65\u015f\13\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\67\3"+
		"\67\5\67\u016c\n\67\3\67\5\67\u016f\n\67\3\67\3\67\3\u015d\28\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8\3\2\b\5\2"+
		"C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2\f\f\17\17$$\4\2\f\f\17\17\5\2\13\f"+
		"\17\17\"\"\2\u017d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\3o\3\2\2\2\5q\3\2\2\2\7t\3\2\2\2\tx\3\2\2\2\13\177"+
		"\3\2\2\2\r\u0086\3\2\2\2\17\u0089\3\2\2\2\21\u008c\3\2\2\2\23\u008f\3"+
		"\2\2\2\25\u0092\3\2\2\2\27\u0094\3\2\2\2\31\u0096\3\2\2\2\33\u0099\3\2"+
		"\2\2\35\u009c\3\2\2\2\37\u009e\3\2\2\2!\u00a1\3\2\2\2#\u00a3\3\2\2\2%"+
		"\u00a6\3\2\2\2\'\u00a8\3\2\2\2)\u00aa\3\2\2\2+\u00ac\3\2\2\2-\u00ae\3"+
		"\2\2\2/\u00b0\3\2\2\2\61\u00b2\3\2\2\2\63\u00b4\3\2\2\2\65\u00b6\3\2\2"+
		"\2\67\u00b8\3\2\2\29\u00ba\3\2\2\2;\u00bc\3\2\2\2=\u00be\3\2\2\2?\u00c0"+
		"\3\2\2\2A\u00c2\3\2\2\2C\u00c4\3\2\2\2E\u00c9\3\2\2\2G\u00cf\3\2\2\2I"+
		"\u00d3\3\2\2\2K\u00d6\3\2\2\2M\u00db\3\2\2\2O\u00e1\3\2\2\2Q\u00e5\3\2"+
		"\2\2S\u00e9\3\2\2\2U\u00ec\3\2\2\2W\u00f1\3\2\2\2Y\u00f8\3\2\2\2[\u0108"+
		"\3\2\2\2]\u0111\3\2\2\2_\u0121\3\2\2\2a\u0129\3\2\2\2c\u013f\3\2\2\2e"+
		"\u0141\3\2\2\2g\u014c\3\2\2\2i\u0157\3\2\2\2k\u0165\3\2\2\2m\u016e\3\2"+
		"\2\2op\7\60\2\2p\4\3\2\2\2qr\7*\2\2rs\7+\2\2s\6\3\2\2\2tu\7k\2\2uv\7p"+
		"\2\2vw\7v\2\2w\b\3\2\2\2xy\7f\2\2yz\7q\2\2z{\7w\2\2{|\7d\2\2|}\7n\2\2"+
		"}~\7g\2\2~\n\3\2\2\2\177\u0080\7U\2\2\u0080\u0081\7v\2\2\u0081\u0082\7"+
		"t\2\2\u0082\u0083\7k\2\2\u0083\u0084\7p\2\2\u0084\u0085\7i\2\2\u0085\f"+
		"\3\2\2\2\u0086\u0087\7~\2\2\u0087\u0088\7~\2\2\u0088\16\3\2\2\2\u0089"+
		"\u008a\7(\2\2\u008a\u008b\7(\2\2\u008b\20\3\2\2\2\u008c\u008d\7?\2\2\u008d"+
		"\u008e\7?\2\2\u008e\22\3\2\2\2\u008f\u0090\7#\2\2\u0090\u0091\7?\2\2\u0091"+
		"\24\3\2\2\2\u0092\u0093\7@\2\2\u0093\26\3\2\2\2\u0094\u0095\7>\2\2\u0095"+
		"\30\3\2\2\2\u0096\u0097\7@\2\2\u0097\u0098\7?\2\2\u0098\32\3\2\2\2\u0099"+
		"\u009a\7>\2\2\u009a\u009b\7?\2\2\u009b\34\3\2\2\2\u009c\u009d\7-\2\2\u009d"+
		"\36\3\2\2\2\u009e\u009f\7-\2\2\u009f\u00a0\7-\2\2\u00a0 \3\2\2\2\u00a1"+
		"\u00a2\7/\2\2\u00a2\"\3\2\2\2\u00a3\u00a4\7/\2\2\u00a4\u00a5\7/\2\2\u00a5"+
		"$\3\2\2\2\u00a6\u00a7\7,\2\2\u00a7&\3\2\2\2\u00a8\u00a9\7\61\2\2\u00a9"+
		"(\3\2\2\2\u00aa\u00ab\7\'\2\2\u00ab*\3\2\2\2\u00ac\u00ad\7`\2\2\u00ad"+
		",\3\2\2\2\u00ae\u00af\7#\2\2\u00af.\3\2\2\2\u00b0\u00b1\7.\2\2\u00b1\60"+
		"\3\2\2\2\u00b2\u00b3\7<\2\2\u00b3\62\3\2\2\2\u00b4\u00b5\7=\2\2\u00b5"+
		"\64\3\2\2\2\u00b6\u00b7\7?\2\2\u00b7\66\3\2\2\2\u00b8\u00b9\7*\2\2\u00b9"+
		"8\3\2\2\2\u00ba\u00bb\7+\2\2\u00bb:\3\2\2\2\u00bc\u00bd\7}\2\2\u00bd<"+
		"\3\2\2\2\u00be\u00bf\7\177\2\2\u00bf>\3\2\2\2\u00c0\u00c1\7]\2\2\u00c1"+
		"@\3\2\2\2\u00c2\u00c3\7_\2\2\u00c3B\3\2\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6"+
		"\7t\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8\7g\2\2\u00c8D\3\2\2\2\u00c9\u00ca"+
		"\7h\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7u\2\2\u00cd"+
		"\u00ce\7g\2\2\u00ceF\3\2\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7k\2\2\u00d1"+
		"\u00d2\7n\2\2\u00d2H\3\2\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7h\2\2\u00d5"+
		"J\3\2\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7u\2\2\u00d9"+
		"\u00da\7g\2\2\u00daL\3\2\2\2\u00db\u00dc\7y\2\2\u00dc\u00dd\7j\2\2\u00dd"+
		"\u00de\7k\2\2\u00de\u00df\7n\2\2\u00df\u00e0\7g\2\2\u00e0N\3\2\2\2\u00e1"+
		"\u00e2\7n\2\2\u00e2\u00e3\7q\2\2\u00e3\u00e4\7i\2\2\u00e4P\3\2\2\2\u00e5"+
		"\u00e6\7h\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7t\2\2\u00e8R\3\2\2\2\u00e9"+
		"\u00ea\7f\2\2\u00ea\u00eb\7q\2\2\u00ebT\3\2\2\2\u00ec\u00ed\7u\2\2\u00ed"+
		"\u00ee\7g\2\2\u00ee\u00ef\7p\2\2\u00ef\u00f0\7f\2\2\u00f0V\3\2\2\2\u00f1"+
		"\u00f2\7u\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7f\2\2"+
		"\u00f5\u00f6\7C\2\2\u00f6\u00f7\7v\2\2\u00f7X\3\2\2\2\u00f8\u00f9\7o\2"+
		"\2\u00f9\u00fa\7u\2\2\u00fa\u00fb\7i\2\2\u00fb\u00fc\7/\2\2\u00fc\u00fd"+
		"\7@\2\2\u00fd\u00fe\7u\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100\7r\2\2\u0100"+
		"\u0101\7K\2\2\u0101\u0102\7p\2\2\u0102\u0103\7f\2\2\u0103\u0104\7g\2\2"+
		"\u0104\u0105\7z\2\2\u0105\u0106\7\62\2\2\u0106\u0107\7a\2\2\u0107Z\3\2"+
		"\2\2\u0108\u0109\7u\2\2\u0109\u010a\7j\2\2\u010a\u010b\7q\2\2\u010b\u010c"+
		"\7y\2\2\u010c\u010d\7J\2\2\u010d\u010e\7g\2\2\u010e\u010f\7c\2\2\u010f"+
		"\u0110\7r\2\2\u0110\\\3\2\2\2\u0111\u0112\7u\2\2\u0112\u0113\7j\2\2\u0113"+
		"\u0114\7q\2\2\u0114\u0115\7y\2\2\u0115\u0116\7N\2\2\u0116\u0117\7k\2\2"+
		"\u0117\u0118\7u\2\2\u0118\u0119\7v\2\2\u0119\u011a\7U\2\2\u011a\u011b"+
		"\7g\2\2\u011b\u011c\7p\2\2\u011c\u011d\7f\2\2\u011d\u011e\7O\2\2\u011e"+
		"\u011f\7u\2\2\u011f\u0120\7i\2\2\u0120^\3\2\2\2\u0121\u0125\t\2\2\2\u0122"+
		"\u0124\t\3\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126`\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u012a"+
		"\t\4\2\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012cb\3\2\2\2\u012d\u012f\t\4\2\2\u012e\u012d\3\2\2\2"+
		"\u012f\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132"+
		"\3\2\2\2\u0132\u0136\7\60\2\2\u0133\u0135\t\4\2\2\u0134\u0133\3\2\2\2"+
		"\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0140"+
		"\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013b\7\60\2\2\u013a\u013c\t\4\2\2"+
		"\u013b\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e"+
		"\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u012e\3\2\2\2\u013f\u0139\3\2\2\2\u0140"+
		"d\3\2\2\2\u0141\u0147\7$\2\2\u0142\u0146\n\5\2\2\u0143\u0144\7$\2\2\u0144"+
		"\u0146\7$\2\2\u0145\u0142\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0149\3\2"+
		"\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149"+
		"\u0147\3\2\2\2\u014a\u014b\7$\2\2\u014bf\3\2\2\2\u014c\u014d\7\61\2\2"+
		"\u014d\u014e\7\61\2\2\u014e\u0152\3\2\2\2\u014f\u0151\n\6\2\2\u0150\u014f"+
		"\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\b\64\2\2\u0156h\3\2\2\2"+
		"\u0157\u0158\7\61\2\2\u0158\u0159\7,\2\2\u0159\u015d\3\2\2\2\u015a\u015c"+
		"\13\2\2\2\u015b\u015a\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015e\3\2\2\2"+
		"\u015d\u015b\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0161"+
		"\7,\2\2\u0161\u0162\7\61\2\2\u0162\u0163\3\2\2\2\u0163\u0164\b\65\2\2"+
		"\u0164j\3\2\2\2\u0165\u0166\t\7\2\2\u0166\u0167\3\2\2\2\u0167\u0168\b"+
		"\66\2\2\u0168l\3\2\2\2\u0169\u016b\7\17\2\2\u016a\u016c\7\f\2\2\u016b"+
		"\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016f\7\f"+
		"\2\2\u016e\u0169\3\2\2\2\u016e\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u0171\b\67\2\2\u0171n\3\2\2\2\17\2\u0125\u012b\u0130\u0136\u013d\u013f"+
		"\u0145\u0147\u0152\u015d\u016b\u016e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}