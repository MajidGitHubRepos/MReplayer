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
		NEWLINE=54, IGNORE=55;
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
			"BLOCKCOMMENT", "SPACE", "NEWLINE", "IGNORE"
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
			"BLOCKCOMMENT", "SPACE", "NEWLINE", "IGNORE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\29\u018f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3"+
		"\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&"+
		"\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+"+
		"\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3\60\3\60\7\60\u0126\n\60\f\60\16\60\u0129\13\60\3\61\6\61"+
		"\u012c\n\61\r\61\16\61\u012d\3\62\6\62\u0131\n\62\r\62\16\62\u0132\3\62"+
		"\3\62\7\62\u0137\n\62\f\62\16\62\u013a\13\62\3\62\3\62\6\62\u013e\n\62"+
		"\r\62\16\62\u013f\5\62\u0142\n\62\3\63\3\63\3\63\3\63\7\63\u0148\n\63"+
		"\f\63\16\63\u014b\13\63\3\63\3\63\3\64\3\64\3\64\3\64\7\64\u0153\n\64"+
		"\f\64\16\64\u0156\13\64\3\64\3\64\3\65\3\65\3\65\3\65\7\65\u015e\n\65"+
		"\f\65\16\65\u0161\13\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3"+
		"\67\3\67\5\67\u016e\n\67\3\67\5\67\u0171\n\67\3\67\3\67\38\38\38\38\3"+
		"8\38\38\38\38\38\38\38\38\38\38\38\38\38\78\u0187\n8\f8\168\u018a\138"+
		"\38\38\38\38\4\u015f\u0188\29\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"a\62c\63e\64g\65i\66k\67m8o9\3\2\b\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\5"+
		"\2\f\f\17\17$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u019b\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\3"+
		"q\3\2\2\2\5s\3\2\2\2\7v\3\2\2\2\tz\3\2\2\2\13\u0081\3\2\2\2\r\u0088\3"+
		"\2\2\2\17\u008b\3\2\2\2\21\u008e\3\2\2\2\23\u0091\3\2\2\2\25\u0094\3\2"+
		"\2\2\27\u0096\3\2\2\2\31\u0098\3\2\2\2\33\u009b\3\2\2\2\35\u009e\3\2\2"+
		"\2\37\u00a0\3\2\2\2!\u00a3\3\2\2\2#\u00a5\3\2\2\2%\u00a8\3\2\2\2\'\u00aa"+
		"\3\2\2\2)\u00ac\3\2\2\2+\u00ae\3\2\2\2-\u00b0\3\2\2\2/\u00b2\3\2\2\2\61"+
		"\u00b4\3\2\2\2\63\u00b6\3\2\2\2\65\u00b8\3\2\2\2\67\u00ba\3\2\2\29\u00bc"+
		"\3\2\2\2;\u00be\3\2\2\2=\u00c0\3\2\2\2?\u00c2\3\2\2\2A\u00c4\3\2\2\2C"+
		"\u00c6\3\2\2\2E\u00cb\3\2\2\2G\u00d1\3\2\2\2I\u00d5\3\2\2\2K\u00d8\3\2"+
		"\2\2M\u00dd\3\2\2\2O\u00e3\3\2\2\2Q\u00e7\3\2\2\2S\u00eb\3\2\2\2U\u00ee"+
		"\3\2\2\2W\u00f3\3\2\2\2Y\u00fa\3\2\2\2[\u010a\3\2\2\2]\u0113\3\2\2\2_"+
		"\u0123\3\2\2\2a\u012b\3\2\2\2c\u0141\3\2\2\2e\u0143\3\2\2\2g\u014e\3\2"+
		"\2\2i\u0159\3\2\2\2k\u0167\3\2\2\2m\u0170\3\2\2\2o\u0174\3\2\2\2qr\7\60"+
		"\2\2r\4\3\2\2\2st\7*\2\2tu\7+\2\2u\6\3\2\2\2vw\7k\2\2wx\7p\2\2xy\7v\2"+
		"\2y\b\3\2\2\2z{\7f\2\2{|\7q\2\2|}\7w\2\2}~\7d\2\2~\177\7n\2\2\177\u0080"+
		"\7g\2\2\u0080\n\3\2\2\2\u0081\u0082\7U\2\2\u0082\u0083\7v\2\2\u0083\u0084"+
		"\7t\2\2\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087\7i\2\2\u0087"+
		"\f\3\2\2\2\u0088\u0089\7~\2\2\u0089\u008a\7~\2\2\u008a\16\3\2\2\2\u008b"+
		"\u008c\7(\2\2\u008c\u008d\7(\2\2\u008d\20\3\2\2\2\u008e\u008f\7?\2\2\u008f"+
		"\u0090\7?\2\2\u0090\22\3\2\2\2\u0091\u0092\7#\2\2\u0092\u0093\7?\2\2\u0093"+
		"\24\3\2\2\2\u0094\u0095\7@\2\2\u0095\26\3\2\2\2\u0096\u0097\7>\2\2\u0097"+
		"\30\3\2\2\2\u0098\u0099\7@\2\2\u0099\u009a\7?\2\2\u009a\32\3\2\2\2\u009b"+
		"\u009c\7>\2\2\u009c\u009d\7?\2\2\u009d\34\3\2\2\2\u009e\u009f\7-\2\2\u009f"+
		"\36\3\2\2\2\u00a0\u00a1\7-\2\2\u00a1\u00a2\7-\2\2\u00a2 \3\2\2\2\u00a3"+
		"\u00a4\7/\2\2\u00a4\"\3\2\2\2\u00a5\u00a6\7/\2\2\u00a6\u00a7\7/\2\2\u00a7"+
		"$\3\2\2\2\u00a8\u00a9\7,\2\2\u00a9&\3\2\2\2\u00aa\u00ab\7\61\2\2\u00ab"+
		"(\3\2\2\2\u00ac\u00ad\7\'\2\2\u00ad*\3\2\2\2\u00ae\u00af\7`\2\2\u00af"+
		",\3\2\2\2\u00b0\u00b1\7#\2\2\u00b1.\3\2\2\2\u00b2\u00b3\7.\2\2\u00b3\60"+
		"\3\2\2\2\u00b4\u00b5\7<\2\2\u00b5\62\3\2\2\2\u00b6\u00b7\7=\2\2\u00b7"+
		"\64\3\2\2\2\u00b8\u00b9\7?\2\2\u00b9\66\3\2\2\2\u00ba\u00bb\7*\2\2\u00bb"+
		"8\3\2\2\2\u00bc\u00bd\7+\2\2\u00bd:\3\2\2\2\u00be\u00bf\7}\2\2\u00bf<"+
		"\3\2\2\2\u00c0\u00c1\7\177\2\2\u00c1>\3\2\2\2\u00c2\u00c3\7]\2\2\u00c3"+
		"@\3\2\2\2\u00c4\u00c5\7_\2\2\u00c5B\3\2\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8"+
		"\7t\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7g\2\2\u00caD\3\2\2\2\u00cb\u00cc"+
		"\7h\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7n\2\2\u00ce\u00cf\7u\2\2\u00cf"+
		"\u00d0\7g\2\2\u00d0F\3\2\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7k\2\2\u00d3"+
		"\u00d4\7n\2\2\u00d4H\3\2\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7h\2\2\u00d7"+
		"J\3\2\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7n\2\2\u00da\u00db\7u\2\2\u00db"+
		"\u00dc\7g\2\2\u00dcL\3\2\2\2\u00dd\u00de\7y\2\2\u00de\u00df\7j\2\2\u00df"+
		"\u00e0\7k\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2\7g\2\2\u00e2N\3\2\2\2\u00e3"+
		"\u00e4\7n\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7i\2\2\u00e6P\3\2\2\2\u00e7"+
		"\u00e8\7h\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7t\2\2\u00eaR\3\2\2\2\u00eb"+
		"\u00ec\7f\2\2\u00ec\u00ed\7q\2\2\u00edT\3\2\2\2\u00ee\u00ef\7u\2\2\u00ef"+
		"\u00f0\7g\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7f\2\2\u00f2V\3\2\2\2\u00f3"+
		"\u00f4\7u\2\2\u00f4\u00f5\7g\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7\7f\2\2"+
		"\u00f7\u00f8\7C\2\2\u00f8\u00f9\7v\2\2\u00f9X\3\2\2\2\u00fa\u00fb\7o\2"+
		"\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7i\2\2\u00fd\u00fe\7/\2\2\u00fe\u00ff"+
		"\7@\2\2\u00ff\u0100\7u\2\2\u0100\u0101\7c\2\2\u0101\u0102\7r\2\2\u0102"+
		"\u0103\7K\2\2\u0103\u0104\7p\2\2\u0104\u0105\7f\2\2\u0105\u0106\7g\2\2"+
		"\u0106\u0107\7z\2\2\u0107\u0108\7\62\2\2\u0108\u0109\7a\2\2\u0109Z\3\2"+
		"\2\2\u010a\u010b\7u\2\2\u010b\u010c\7j\2\2\u010c\u010d\7q\2\2\u010d\u010e"+
		"\7y\2\2\u010e\u010f\7J\2\2\u010f\u0110\7g\2\2\u0110\u0111\7c\2\2\u0111"+
		"\u0112\7r\2\2\u0112\\\3\2\2\2\u0113\u0114\7u\2\2\u0114\u0115\7j\2\2\u0115"+
		"\u0116\7q\2\2\u0116\u0117\7y\2\2\u0117\u0118\7N\2\2\u0118\u0119\7k\2\2"+
		"\u0119\u011a\7u\2\2\u011a\u011b\7v\2\2\u011b\u011c\7U\2\2\u011c\u011d"+
		"\7g\2\2\u011d\u011e\7p\2\2\u011e\u011f\7f\2\2\u011f\u0120\7O\2\2\u0120"+
		"\u0121\7u\2\2\u0121\u0122\7i\2\2\u0122^\3\2\2\2\u0123\u0127\t\2\2\2\u0124"+
		"\u0126\t\3\2\2\u0125\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2"+
		"\2\2\u0127\u0128\3\2\2\2\u0128`\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012c"+
		"\t\4\2\2\u012b\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012b\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012eb\3\2\2\2\u012f\u0131\t\4\2\2\u0130\u012f\3\2\2\2"+
		"\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0138\7\60\2\2\u0135\u0137\t\4\2\2\u0136\u0135\3\2\2\2"+
		"\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0142"+
		"\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013d\7\60\2\2\u013c\u013e\t\4\2\2"+
		"\u013d\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140"+
		"\3\2\2\2\u0140\u0142\3\2\2\2\u0141\u0130\3\2\2\2\u0141\u013b\3\2\2\2\u0142"+
		"d\3\2\2\2\u0143\u0149\7$\2\2\u0144\u0148\n\5\2\2\u0145\u0146\7$\2\2\u0146"+
		"\u0148\7$\2\2\u0147\u0144\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014b\3\2"+
		"\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014c\u014d\7$\2\2\u014df\3\2\2\2\u014e\u014f\7\61\2\2"+
		"\u014f\u0150\7\61\2\2\u0150\u0154\3\2\2\2\u0151\u0153\n\6\2\2\u0152\u0151"+
		"\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u0157\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0158\b\64\2\2\u0158h\3\2\2\2"+
		"\u0159\u015a\7\61\2\2\u015a\u015b\7,\2\2\u015b\u015f\3\2\2\2\u015c\u015e"+
		"\13\2\2\2\u015d\u015c\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u0160\3\2\2\2"+
		"\u015f\u015d\3\2\2\2\u0160\u0162\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163"+
		"\7,\2\2\u0163\u0164\7\61\2\2\u0164\u0165\3\2\2\2\u0165\u0166\b\65\2\2"+
		"\u0166j\3\2\2\2\u0167\u0168\t\7\2\2\u0168\u0169\3\2\2\2\u0169\u016a\b"+
		"\66\2\2\u016al\3\2\2\2\u016b\u016d\7\17\2\2\u016c\u016e\7\f\2\2\u016d"+
		"\u016c\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u0171\7\f"+
		"\2\2\u0170\u016b\3\2\2\2\u0170\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u0173\b\67\2\2\u0173n\3\2\2\2\u0174\u0175\7v\2\2\u0175\u0176\7j\2\2\u0176"+
		"\u0177\7k\2\2\u0177\u0178\7u\2\2\u0178\u0179\7/\2\2\u0179\u017a\7@\2\2"+
		"\u017a\u017b\7j\2\2\u017b\u017c\7q\2\2\u017c\u017d\7u\2\2\u017d\u017e"+
		"\7v\2\2\u017e\u017f\7E\2\2\u017f\u0180\7q\2\2\u0180\u0181\7p\2\2\u0181"+
		"\u0182\7h\2\2\u0182\u0183\7k\2\2\u0183\u0184\7i\2\2\u0184\u0188\3\2\2"+
		"\2\u0185\u0187\13\2\2\2\u0186\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u018b\3\2\2\2\u018a\u0188\3\2"+
		"\2\2\u018b\u018c\7=\2\2\u018c\u018d\3\2\2\2\u018d\u018e\b8\2\2\u018ep"+
		"\3\2\2\2\20\2\u0127\u012d\u0132\u0138\u013f\u0141\u0147\u0149\u0154\u015f"+
		"\u016d\u0170\u0188\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}