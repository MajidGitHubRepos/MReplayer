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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, DOT=9, 
		INSTREAM=10, OUTSTREAM=11, OR=12, AND=13, EQ=14, NEQ=15, GT=16, LT=17, 
		GTEQ=18, LTEQ=19, PLUS=20, PLUSPLUS=21, MINUS=22, MINUSMINUS=23, MULT=24, 
		DIV=25, MOD=26, POW=27, NOT=28, COMMA=29, COLON=30, SCOL=31, ASSIGN=32, 
		OPAR=33, CPAR=34, OBRACE=35, CBRACE=36, LBRACKET=37, RBRACKET=38, TRUE=39, 
		FALSE=40, NIL=41, IF=42, ELSE=43, WHILE=44, LOG=45, FOR=46, DO=47, SEND=48, 
		SENDAT=49, BACKMSG=50, GETNAME=51, RANDFUNC=52, SHOWHEAP=53, SHOWLISTSEND=54, 
		BOOLVAR=55, INTVAR=56, DOUBLEVAR=57, CHARVAR=58, STRINGVAR=59, ID=60, 
		INT=61, FLOAT=62, STRING=63, COMMENT=64, BLOCKCOMMENT=65, SPACE=66, NEWLINE=67, 
		Space=68, IGNORELINE=69, IGNOREWORD=70, IGNOREEXPR=71;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "DOT", 
			"INSTREAM", "OUTSTREAM", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", 
			"LTEQ", "PLUS", "PLUSPLUS", "MINUS", "MINUSMINUS", "MULT", "DIV", "MOD", 
			"POW", "NOT", "COMMA", "COLON", "SCOL", "ASSIGN", "OPAR", "CPAR", "OBRACE", 
			"CBRACE", "LBRACKET", "RBRACKET", "TRUE", "FALSE", "NIL", "IF", "ELSE", 
			"WHILE", "LOG", "FOR", "DO", "SEND", "SENDAT", "BACKMSG", "GETNAME", 
			"RANDFUNC", "SHOWHEAP", "SHOWLISTSEND", "BOOLVAR", "INTVAR", "DOUBLEVAR", 
			"CHARVAR", "STRINGVAR", "ID", "INT", "FLOAT", "STRING", "COMMENT", "BLOCKCOMMENT", 
			"SPACE", "NEWLINE", "Space", "IGNORELINE", "IGNOREWORD", "IGNOREEXPR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'()'", "'informIn'", "'cancelTimer'", "'informEvery'", "'find'", 
			"'substr'", "'length()'", "'strcmp'", "'.'", "'<<'", "'>>'", "'||'", 
			"'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'++'", 
			"'-'", "'--'", "'*'", "'/'", "'%'", "'^'", "'!'", "','", "':'", "';'", 
			"'='", "'('", "')'", "'{'", "'}'", "'['", "']'", "'true'", "'false'", 
			"'nil'", "'if'", "'else'", "'while'", "'log'", "'for'", "'do'", "'send'", 
			"'sendAt'", "'msg->sapIndex0_'", null, "'rand()'", "'showHeap'", "'showListSendMsg'", 
			"'bool'", "'int'", "'double'", "'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "DOT", "INSTREAM", 
			"OUTSTREAM", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", 
			"PLUSPLUS", "MINUS", "MINUSMINUS", "MULT", "DIV", "MOD", "POW", "NOT", 
			"COMMA", "COLON", "SCOL", "ASSIGN", "OPAR", "CPAR", "OBRACE", "CBRACE", 
			"LBRACKET", "RBRACKET", "TRUE", "FALSE", "NIL", "IF", "ELSE", "WHILE", 
			"LOG", "FOR", "DO", "SEND", "SENDAT", "BACKMSG", "GETNAME", "RANDFUNC", 
			"SHOWHEAP", "SHOWLISTSEND", "BOOLVAR", "INTVAR", "DOUBLEVAR", "CHARVAR", 
			"STRINGVAR", "ID", "INT", "FLOAT", "STRING", "COMMENT", "BLOCKCOMMENT", 
			"SPACE", "NEWLINE", "Space", "IGNORELINE", "IGNOREWORD", "IGNOREEXPR"
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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 67:
			Space_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void Space_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2I\u02fc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&"+
		"\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3,\3,\3"+
		",\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\61"+
		"\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64"+
		"\5\64\u015d\n\64\3\64\5\64\u0160\n\64\3\64\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3"+
		"\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"8\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\3"+
		"<\3<\3<\3<\3<\5<\u01ae\n<\3<\5<\u01b1\n<\3<\3<\5<\u01b5\n<\3<\3<\5<\u01b9"+
		"\n<\3<\5<\u01bc\n<\5<\u01be\n<\3=\3=\7=\u01c2\n=\f=\16=\u01c5\13=\3>\6"+
		">\u01c8\n>\r>\16>\u01c9\3?\6?\u01cd\n?\r?\16?\u01ce\3?\3?\7?\u01d3\n?"+
		"\f?\16?\u01d6\13?\3?\3?\6?\u01da\n?\r?\16?\u01db\5?\u01de\n?\3@\3@\3@"+
		"\3@\7@\u01e4\n@\f@\16@\u01e7\13@\3@\3@\3A\3A\3A\3A\7A\u01ef\nA\fA\16A"+
		"\u01f2\13A\3A\3A\3B\3B\3B\3B\7B\u01fa\nB\fB\16B\u01fd\13B\3B\3B\3B\3B"+
		"\3B\3C\6C\u0205\nC\rC\16C\u0206\3C\3C\3D\3D\5D\u020d\nD\3D\5D\u0210\n"+
		"D\3D\3D\3E\6E\u0215\nE\rE\16E\u0216\3E\3E\3F\3F\3F\3F\3F\5F\u0220\nF\3"+
		"F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3"+
		"F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3"+
		"F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\5F\u025f\nF\3F\7F\u0262\n"+
		"F\fF\16F\u0265\13F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G"+
		"\3G\3G\3G\3G\5G\u027c\nG\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\5H\u02eb\nH\3H\3H\7H\u02ef\nH\fH\16H\u02f2\13H\3H\3H\7H\u02f6\n"+
		"H\fH\16H\u02f9\13H\3H\3H\6\u01fb\u0263\u02f0\u02f7\2I\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177"+
		"A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\3\2\b\5\2C\\"+
		"aac|\6\2\62;C\\aac|\3\2\62;\5\2\f\f\17\17$$\4\2\f\f\17\17\4\2\13\f\"\""+
		"\2\u0322\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y"+
		"\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3"+
		"\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2"+
		"\2\u008d\3\2\2\2\2\u008f\3\2\2\2\3\u0091\3\2\2\2\5\u0094\3\2\2\2\7\u009d"+
		"\3\2\2\2\t\u00a9\3\2\2\2\13\u00b5\3\2\2\2\r\u00ba\3\2\2\2\17\u00c1\3\2"+
		"\2\2\21\u00ca\3\2\2\2\23\u00d1\3\2\2\2\25\u00d3\3\2\2\2\27\u00d6\3\2\2"+
		"\2\31\u00d9\3\2\2\2\33\u00dc\3\2\2\2\35\u00df\3\2\2\2\37\u00e2\3\2\2\2"+
		"!\u00e5\3\2\2\2#\u00e7\3\2\2\2%\u00e9\3\2\2\2\'\u00ec\3\2\2\2)\u00ef\3"+
		"\2\2\2+\u00f1\3\2\2\2-\u00f4\3\2\2\2/\u00f6\3\2\2\2\61\u00f9\3\2\2\2\63"+
		"\u00fb\3\2\2\2\65\u00fd\3\2\2\2\67\u00ff\3\2\2\29\u0101\3\2\2\2;\u0103"+
		"\3\2\2\2=\u0105\3\2\2\2?\u0107\3\2\2\2A\u0109\3\2\2\2C\u010b\3\2\2\2E"+
		"\u010d\3\2\2\2G\u010f\3\2\2\2I\u0111\3\2\2\2K\u0113\3\2\2\2M\u0115\3\2"+
		"\2\2O\u0117\3\2\2\2Q\u011c\3\2\2\2S\u0122\3\2\2\2U\u0126\3\2\2\2W\u0129"+
		"\3\2\2\2Y\u012e\3\2\2\2[\u0134\3\2\2\2]\u0138\3\2\2\2_\u013c\3\2\2\2a"+
		"\u013f\3\2\2\2c\u0144\3\2\2\2e\u014b\3\2\2\2g\u015c\3\2\2\2i\u0171\3\2"+
		"\2\2k\u0178\3\2\2\2m\u0181\3\2\2\2o\u0191\3\2\2\2q\u0196\3\2\2\2s\u019a"+
		"\3\2\2\2u\u01a1\3\2\2\2w\u01bd\3\2\2\2y\u01bf\3\2\2\2{\u01c7\3\2\2\2}"+
		"\u01dd\3\2\2\2\177\u01df\3\2\2\2\u0081\u01ea\3\2\2\2\u0083\u01f5\3\2\2"+
		"\2\u0085\u0204\3\2\2\2\u0087\u020f\3\2\2\2\u0089\u0214\3\2\2\2\u008b\u021f"+
		"\3\2\2\2\u008d\u027b\3\2\2\2\u008f\u02ea\3\2\2\2\u0091\u0092\7*\2\2\u0092"+
		"\u0093\7+\2\2\u0093\4\3\2\2\2\u0094\u0095\7k\2\2\u0095\u0096\7p\2\2\u0096"+
		"\u0097\7h\2\2\u0097\u0098\7q\2\2\u0098\u0099\7t\2\2\u0099\u009a\7o\2\2"+
		"\u009a\u009b\7K\2\2\u009b\u009c\7p\2\2\u009c\6\3\2\2\2\u009d\u009e\7e"+
		"\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7e\2\2\u00a1\u00a2"+
		"\7g\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7V\2\2\u00a4\u00a5\7k\2\2\u00a5"+
		"\u00a6\7o\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7t\2\2\u00a8\b\3\2\2\2\u00a9"+
		"\u00aa\7k\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7h\2\2\u00ac\u00ad\7q\2\2"+
		"\u00ad\u00ae\7t\2\2\u00ae\u00af\7o\2\2\u00af\u00b0\7G\2\2\u00b0\u00b1"+
		"\7x\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7{\2\2\u00b4"+
		"\n\3\2\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7p\2\2\u00b8"+
		"\u00b9\7f\2\2\u00b9\f\3\2\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\7w\2\2\u00bc"+
		"\u00bd\7d\2\2\u00bd\u00be\7u\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7t\2\2"+
		"\u00c0\16\3\2\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7"+
		"p\2\2\u00c4\u00c5\7i\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7\7j\2\2\u00c7\u00c8"+
		"\7*\2\2\u00c8\u00c9\7+\2\2\u00c9\20\3\2\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc"+
		"\7v\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf\7o\2\2\u00cf"+
		"\u00d0\7r\2\2\u00d0\22\3\2\2\2\u00d1\u00d2\7\60\2\2\u00d2\24\3\2\2\2\u00d3"+
		"\u00d4\7>\2\2\u00d4\u00d5\7>\2\2\u00d5\26\3\2\2\2\u00d6\u00d7\7@\2\2\u00d7"+
		"\u00d8\7@\2\2\u00d8\30\3\2\2\2\u00d9\u00da\7~\2\2\u00da\u00db\7~\2\2\u00db"+
		"\32\3\2\2\2\u00dc\u00dd\7(\2\2\u00dd\u00de\7(\2\2\u00de\34\3\2\2\2\u00df"+
		"\u00e0\7?\2\2\u00e0\u00e1\7?\2\2\u00e1\36\3\2\2\2\u00e2\u00e3\7#\2\2\u00e3"+
		"\u00e4\7?\2\2\u00e4 \3\2\2\2\u00e5\u00e6\7@\2\2\u00e6\"\3\2\2\2\u00e7"+
		"\u00e8\7>\2\2\u00e8$\3\2\2\2\u00e9\u00ea\7@\2\2\u00ea\u00eb\7?\2\2\u00eb"+
		"&\3\2\2\2\u00ec\u00ed\7>\2\2\u00ed\u00ee\7?\2\2\u00ee(\3\2\2\2\u00ef\u00f0"+
		"\7-\2\2\u00f0*\3\2\2\2\u00f1\u00f2\7-\2\2\u00f2\u00f3\7-\2\2\u00f3,\3"+
		"\2\2\2\u00f4\u00f5\7/\2\2\u00f5.\3\2\2\2\u00f6\u00f7\7/\2\2\u00f7\u00f8"+
		"\7/\2\2\u00f8\60\3\2\2\2\u00f9\u00fa\7,\2\2\u00fa\62\3\2\2\2\u00fb\u00fc"+
		"\7\61\2\2\u00fc\64\3\2\2\2\u00fd\u00fe\7\'\2\2\u00fe\66\3\2\2\2\u00ff"+
		"\u0100\7`\2\2\u01008\3\2\2\2\u0101\u0102\7#\2\2\u0102:\3\2\2\2\u0103\u0104"+
		"\7.\2\2\u0104<\3\2\2\2\u0105\u0106\7<\2\2\u0106>\3\2\2\2\u0107\u0108\7"+
		"=\2\2\u0108@\3\2\2\2\u0109\u010a\7?\2\2\u010aB\3\2\2\2\u010b\u010c\7*"+
		"\2\2\u010cD\3\2\2\2\u010d\u010e\7+\2\2\u010eF\3\2\2\2\u010f\u0110\7}\2"+
		"\2\u0110H\3\2\2\2\u0111\u0112\7\177\2\2\u0112J\3\2\2\2\u0113\u0114\7]"+
		"\2\2\u0114L\3\2\2\2\u0115\u0116\7_\2\2\u0116N\3\2\2\2\u0117\u0118\7v\2"+
		"\2\u0118\u0119\7t\2\2\u0119\u011a\7w\2\2\u011a\u011b\7g\2\2\u011bP\3\2"+
		"\2\2\u011c\u011d\7h\2\2\u011d\u011e\7c\2\2\u011e\u011f\7n\2\2\u011f\u0120"+
		"\7u\2\2\u0120\u0121\7g\2\2\u0121R\3\2\2\2\u0122\u0123\7p\2\2\u0123\u0124"+
		"\7k\2\2\u0124\u0125\7n\2\2\u0125T\3\2\2\2\u0126\u0127\7k\2\2\u0127\u0128"+
		"\7h\2\2\u0128V\3\2\2\2\u0129\u012a\7g\2\2\u012a\u012b\7n\2\2\u012b\u012c"+
		"\7u\2\2\u012c\u012d\7g\2\2\u012dX\3\2\2\2\u012e\u012f\7y\2\2\u012f\u0130"+
		"\7j\2\2\u0130\u0131\7k\2\2\u0131\u0132\7n\2\2\u0132\u0133\7g\2\2\u0133"+
		"Z\3\2\2\2\u0134\u0135\7n\2\2\u0135\u0136\7q\2\2\u0136\u0137\7i\2\2\u0137"+
		"\\\3\2\2\2\u0138\u0139\7h\2\2\u0139\u013a\7q\2\2\u013a\u013b\7t\2\2\u013b"+
		"^\3\2\2\2\u013c\u013d\7f\2\2\u013d\u013e\7q\2\2\u013e`\3\2\2\2\u013f\u0140"+
		"\7u\2\2\u0140\u0141\7g\2\2\u0141\u0142\7p\2\2\u0142\u0143\7f\2\2\u0143"+
		"b\3\2\2\2\u0144\u0145\7u\2\2\u0145\u0146\7g\2\2\u0146\u0147\7p\2\2\u0147"+
		"\u0148\7f\2\2\u0148\u0149\7C\2\2\u0149\u014a\7v\2\2\u014ad\3\2\2\2\u014b"+
		"\u014c\7o\2\2\u014c\u014d\7u\2\2\u014d\u014e\7i\2\2\u014e\u014f\7/\2\2"+
		"\u014f\u0150\7@\2\2\u0150\u0151\7u\2\2\u0151\u0152\7c\2\2\u0152\u0153"+
		"\7r\2\2\u0153\u0154\7K\2\2\u0154\u0155\7p\2\2\u0155\u0156\7f\2\2\u0156"+
		"\u0157\7g\2\2\u0157\u0158\7z\2\2\u0158\u0159\7\62\2\2\u0159\u015a\7a\2"+
		"\2\u015af\3\2\2\2\u015b\u015d\5w<\2\u015c\u015b\3\2\2\2\u015c\u015d\3"+
		"\2\2\2\u015d\u015f\3\2\2\2\u015e\u0160\5\u0085C\2\u015f\u015e\3\2\2\2"+
		"\u015f\u0160\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\7v\2\2\u0162\u0163"+
		"\7j\2\2\u0163\u0164\7k\2\2\u0164\u0165\7u\2\2\u0165\u0166\7/\2\2\u0166"+
		"\u0167\7@\2\2\u0167\u0168\7i\2\2\u0168\u0169\7g\2\2\u0169\u016a\7v\2\2"+
		"\u016a\u016b\7P\2\2\u016b\u016c\7c\2\2\u016c\u016d\7o\2\2\u016d\u016e"+
		"\7g\2\2\u016e\u016f\7*\2\2\u016f\u0170\7+\2\2\u0170h\3\2\2\2\u0171\u0172"+
		"\7t\2\2\u0172\u0173\7c\2\2\u0173\u0174\7p\2\2\u0174\u0175\7f\2\2\u0175"+
		"\u0176\7*\2\2\u0176\u0177\7+\2\2\u0177j\3\2\2\2\u0178\u0179\7u\2\2\u0179"+
		"\u017a\7j\2\2\u017a\u017b\7q\2\2\u017b\u017c\7y\2\2\u017c\u017d\7J\2\2"+
		"\u017d\u017e\7g\2\2\u017e\u017f\7c\2\2\u017f\u0180\7r\2\2\u0180l\3\2\2"+
		"\2\u0181\u0182\7u\2\2\u0182\u0183\7j\2\2\u0183\u0184\7q\2\2\u0184\u0185"+
		"\7y\2\2\u0185\u0186\7N\2\2\u0186\u0187\7k\2\2\u0187\u0188\7u\2\2\u0188"+
		"\u0189\7v\2\2\u0189\u018a\7U\2\2\u018a\u018b\7g\2\2\u018b\u018c\7p\2\2"+
		"\u018c\u018d\7f\2\2\u018d\u018e\7O\2\2\u018e\u018f\7u\2\2\u018f\u0190"+
		"\7i\2\2\u0190n\3\2\2\2\u0191\u0192\7d\2\2\u0192\u0193\7q\2\2\u0193\u0194"+
		"\7q\2\2\u0194\u0195\7n\2\2\u0195p\3\2\2\2\u0196\u0197\7k\2\2\u0197\u0198"+
		"\7p\2\2\u0198\u0199\7v\2\2\u0199r\3\2\2\2\u019a\u019b\7f\2\2\u019b\u019c"+
		"\7q\2\2\u019c\u019d\7w\2\2\u019d\u019e\7d\2\2\u019e\u019f\7n\2\2\u019f"+
		"\u01a0\7g\2\2\u01a0t\3\2\2\2\u01a1\u01a2\7e\2\2\u01a2\u01a3\7j\2\2\u01a3"+
		"\u01a4\7c\2\2\u01a4\u01a5\7t\2\2\u01a5v\3\2\2\2\u01a6\u01a7\7u\2\2\u01a7"+
		"\u01a8\7v\2\2\u01a8\u01a9\7t\2\2\u01a9\u01aa\7k\2\2\u01aa\u01ab\7p\2\2"+
		"\u01ab\u01be\7i\2\2\u01ac\u01ae\7*\2\2\u01ad\u01ac\3\2\2\2\u01ad\u01ae"+
		"\3\2\2\2\u01ae\u01b0\3\2\2\2\u01af\u01b1\5\u0085C\2\u01b0\u01af\3\2\2"+
		"\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b4\5u;\2\u01b3\u01b5"+
		"\5\u0085C\2\u01b4\u01b3\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\3\2\2"+
		"\2\u01b6\u01b8\5\61\31\2\u01b7\u01b9\5\u0085C\2\u01b8\u01b7\3\2\2\2\u01b8"+
		"\u01b9\3\2\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01bc\7+\2\2\u01bb\u01ba\3\2"+
		"\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd\u01a6\3\2\2\2\u01bd"+
		"\u01ad\3\2\2\2\u01bex\3\2\2\2\u01bf\u01c3\t\2\2\2\u01c0\u01c2\t\3\2\2"+
		"\u01c1\u01c0\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4"+
		"\3\2\2\2\u01c4z\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6\u01c8\t\4\2\2\u01c7"+
		"\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2"+
		"\2\2\u01ca|\3\2\2\2\u01cb\u01cd\t\4\2\2\u01cc\u01cb\3\2\2\2\u01cd\u01ce"+
		"\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"\u01d4\7\60\2\2\u01d1\u01d3\t\4\2\2\u01d2\u01d1\3\2\2\2\u01d3\u01d6\3"+
		"\2\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01de\3\2\2\2\u01d6"+
		"\u01d4\3\2\2\2\u01d7\u01d9\7\60\2\2\u01d8\u01da\t\4\2\2\u01d9\u01d8\3"+
		"\2\2\2\u01da\u01db\3\2\2\2\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc"+
		"\u01de\3\2\2\2\u01dd\u01cc\3\2\2\2\u01dd\u01d7\3\2\2\2\u01de~\3\2\2\2"+
		"\u01df\u01e5\7$\2\2\u01e0\u01e4\n\5\2\2\u01e1\u01e2\7$\2\2\u01e2\u01e4"+
		"\7$\2\2\u01e3\u01e0\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5"+
		"\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e8\3\2\2\2\u01e7\u01e5\3\2"+
		"\2\2\u01e8\u01e9\7$\2\2\u01e9\u0080\3\2\2\2\u01ea\u01eb\7\61\2\2\u01eb"+
		"\u01ec\7\61\2\2\u01ec\u01f0\3\2\2\2\u01ed\u01ef\n\6\2\2\u01ee\u01ed\3"+
		"\2\2\2\u01ef\u01f2\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1"+
		"\u01f3\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f3\u01f4\bA\2\2\u01f4\u0082\3\2"+
		"\2\2\u01f5\u01f6\7\61\2\2\u01f6\u01f7\7,\2\2\u01f7\u01fb\3\2\2\2\u01f8"+
		"\u01fa\13\2\2\2\u01f9\u01f8\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01fc\3"+
		"\2\2\2\u01fb\u01f9\3\2\2\2\u01fc\u01fe\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe"+
		"\u01ff\7,\2\2\u01ff\u0200\7\61\2\2\u0200\u0201\3\2\2\2\u0201\u0202\bB"+
		"\2\2\u0202\u0084\3\2\2\2\u0203\u0205\t\7\2\2\u0204\u0203\3\2\2\2\u0205"+
		"\u0206\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0208\3\2"+
		"\2\2\u0208\u0209\bC\2\2\u0209\u0086\3\2\2\2\u020a\u020c\7\17\2\2\u020b"+
		"\u020d\7\f\2\2\u020c\u020b\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u0210\3\2"+
		"\2\2\u020e\u0210\7\f\2\2\u020f\u020a\3\2\2\2\u020f\u020e\3\2\2\2\u0210"+
		"\u0211\3\2\2\2\u0211\u0212\bD\2\2\u0212\u0088\3\2\2\2\u0213\u0215\t\7"+
		"\2\2\u0214\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0214\3\2\2\2\u0216"+
		"\u0217\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\bE\3\2\u0219\u008a\3\2"+
		"\2\2\u021a\u021b\7u\2\2\u021b\u021c\7v\2\2\u021c\u021d\7f\2\2\u021d\u021e"+
		"\7<\2\2\u021e\u0220\7<\2\2\u021f\u021a\3\2\2\2\u021f\u0220\3\2\2\2\u0220"+
		"\u025e\3\2\2\2\u0221\u0222\7n\2\2\u0222\u0223\7q\2\2\u0223\u0224\7i\2"+
		"\2\u0224\u0225\7h\2\2\u0225\u0226\7k\2\2\u0226\u0227\7n\2\2\u0227\u0228"+
		"\7g\2\2\u0228\u0229\7\60\2\2\u0229\u022a\7h\2\2\u022a\u022b\7n\2\2\u022b"+
		"\u022c\7w\2\2\u022c\u022d\7u\2\2\u022d\u022e\7j\2\2\u022e\u022f\7*\2\2"+
		"\u022f\u025f\7+\2\2\u0230\u0231\7n\2\2\u0231\u0232\7q\2\2\u0232\u0233"+
		"\7i\2\2\u0233\u0234\7h\2\2\u0234\u0235\7k\2\2\u0235\u0236\7n\2\2\u0236"+
		"\u0237\7g\2\2\u0237\u0238\7>\2\2\u0238\u025f\7>\2\2\u0239\u023a\7n\2\2"+
		"\u023a\u023b\7q\2\2\u023b\u023c\7i\2\2\u023c\u023d\7h\2\2\u023d\u023e"+
		"\7k\2\2\u023e\u023f\7n\2\2\u023f\u0240\7g\2\2\u0240\u0241\7@\2\2\u0241"+
		"\u025f\7@\2\2\u0242\u0243\7e\2\2\u0243\u0244\7q\2\2\u0244\u0245\7w\2\2"+
		"\u0245\u0246\7v\2\2\u0246\u0247\7>\2\2\u0247\u025f\7>\2\2\u0248\u0249"+
		"\7v\2\2\u0249\u024a\7j\2\2\u024a\u024b\7k\2\2\u024b\u024c\7u\2\2\u024c"+
		"\u024d\7a\2\2\u024d\u024e\7v\2\2\u024e\u024f\7j\2\2\u024f\u0250\7t\2\2"+
		"\u0250\u0251\7g\2\2\u0251\u0252\7c\2\2\u0252\u025f\7f\2\2\u0253\u0254"+
		"\7v\2\2\u0254\u0255\7u\2\2\u0255\u0256\7\60\2\2\u0256\u0257\7i\2\2\u0257"+
		"\u0258\7g\2\2\u0258\u0259\7v\2\2\u0259\u025a\7e\2\2\u025a\u025b\7n\2\2"+
		"\u025b\u025c\7q\2\2\u025c\u025d\7e\2\2\u025d\u025f\7m\2\2\u025e\u0221"+
		"\3\2\2\2\u025e\u0230\3\2\2\2\u025e\u0239\3\2\2\2\u025e\u0242\3\2\2\2\u025e"+
		"\u0248\3\2\2\2\u025e\u0253\3\2\2\2\u025f\u0263\3\2\2\2\u0260\u0262\13"+
		"\2\2\2\u0261\u0260\3\2\2\2\u0262\u0265\3\2\2\2\u0263\u0264\3\2\2\2\u0263"+
		"\u0261\3\2\2\2\u0264\u0266\3\2\2\2\u0265\u0263\3\2\2\2\u0266\u0267\7="+
		"\2\2\u0267\u008c\3\2\2\2\u0268\u0269\7v\2\2\u0269\u026a\7j\2\2\u026a\u026b"+
		"\7k\2\2\u026b\u026c\7u\2\2\u026c\u026d\7/\2\2\u026d\u027c\7@\2\2\u026e"+
		"\u026f\7u\2\2\u026f\u0270\7v\2\2\u0270\u0271\7f\2\2\u0271\u0272\7<\2\2"+
		"\u0272\u027c\7<\2\2\u0273\u0274\7\60\2\2\u0274\u0275\7e\2\2\u0275\u0276"+
		"\7a\2\2\u0276\u0277\7u\2\2\u0277\u0278\7v\2\2\u0278\u0279\7t\2\2\u0279"+
		"\u027a\7*\2\2\u027a\u027c\7+\2\2\u027b\u0268\3\2\2\2\u027b\u026e\3\2\2"+
		"\2\u027b\u0273\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u027e\bG\2\2\u027e\u008e"+
		"\3\2\2\2\u027f\u0280\7n\2\2\u0280\u0281\7q\2\2\u0281\u0282\7i\2\2\u0282"+
		"\u0283\7h\2\2\u0283\u0284\7k\2\2\u0284\u0285\7n\2\2\u0285\u02eb\7g\2\2"+
		"\u0286\u0287\7M\2\2\u0287\u0288\7g\2\2\u0288\u0289\7g\2\2\u0289\u028a"+
		"\7r\2\2\u028a\u028b\7C\2\2\u028b\u028c\7n\2\2\u028c\u028d\7k\2\2\u028d"+
		"\u028e\7x\2\2\u028e\u028f\7g\2\2\u028f\u0290\7V\2\2\u0290\u0291\7k\2\2"+
		"\u0291\u0292\7o\2\2\u0292\u0293\7g\2\2\u0293\u0294\7t\2\2\u0294\u0295"+
		"\7K\2\2\u0295\u02eb\7f\2\2\u0296\u0297\7M\2\2\u0297\u0298\7g\2\2\u0298"+
		"\u0299\7g\2\2\u0299\u029a\7r\2\2\u029a\u029b\7C\2\2\u029b\u029c\7n\2\2"+
		"\u029c\u029d\7k\2\2\u029d\u029e\7x\2\2\u029e\u029f\7g\2\2\u029f\u02a0"+
		"\7V\2\2\u02a0\u02a1\7k\2\2\u02a1\u02a2\7o\2\2\u02a2\u02a3\7g\2\2\u02a3"+
		"\u02a4\7t\2\2\u02a4\u02a5\7K\2\2\u02a5\u02eb\7f\2\2\u02a6\u02a7\7C\2\2"+
		"\u02a7\u02a8\7p\2\2\u02a8\u02a9\7p\2\2\u02a9\u02aa\7q\2\2\u02aa\u02ab"+
		"\7w\2\2\u02ab\u02ac\7p\2\2\u02ac\u02ad\7e\2\2\u02ad\u02ae\7g\2\2\u02ae"+
		"\u02af\7o\2\2\u02af\u02b0\7g\2\2\u02b0\u02b1\7p\2\2\u02b1\u02b2\7v\2\2"+
		"\u02b2\u02b3\7V\2\2\u02b3\u02b4\7k\2\2\u02b4\u02b5\7o\2\2\u02b5\u02b6"+
		"\7g\2\2\u02b6\u02b7\7t\2\2\u02b7\u02b8\7K\2\2\u02b8\u02eb\7f\2\2\u02b9"+
		"\u02ba\7V\2\2\u02ba\u02bb\7k\2\2\u02bb\u02bc\7o\2\2\u02bc\u02bd\7g\2\2"+
		"\u02bd\u02be\7t\2\2\u02be\u02bf\7K\2\2\u02bf\u02eb\7f\2\2\u02c0\u02c1"+
		"\7C\2\2\u02c1\u02c2\7p\2\2\u02c2\u02c3\7p\2\2\u02c3\u02c4\7q\2\2\u02c4"+
		"\u02c5\7w\2\2\u02c5\u02c6\7p\2\2\u02c6\u02c7\7e\2\2\u02c7\u02c8\7g\2\2"+
		"\u02c8\u02c9\7o\2\2\u02c9\u02ca\7g\2\2\u02ca\u02cb\7p\2\2\u02cb\u02cc"+
		"\7v\2\2\u02cc\u02cd\7U\2\2\u02cd\u02ce\7g\2\2\u02ce\u02cf\7t\2\2\u02cf"+
		"\u02d0\7x\2\2\u02d0\u02d1\7g\2\2\u02d1\u02d2\7t\2\2\u02d2\u02d3\7\63\2"+
		"\2\u02d3\u02d4\7K\2\2\u02d4\u02eb\7f\2\2\u02d5\u02d6\7C\2\2\u02d6\u02d7"+
		"\7p\2\2\u02d7\u02d8\7p\2\2\u02d8\u02d9\7q\2\2\u02d9\u02da\7w\2\2\u02da"+
		"\u02db\7p\2\2\u02db\u02dc\7e\2\2\u02dc\u02dd\7g\2\2\u02dd\u02de\7o\2\2"+
		"\u02de\u02df\7g\2\2\u02df\u02e0\7p\2\2\u02e0\u02e1\7v\2\2\u02e1\u02e2"+
		"\7U\2\2\u02e2\u02e3\7g\2\2\u02e3\u02e4\7t\2\2\u02e4\u02e5\7x\2\2\u02e5"+
		"\u02e6\7g\2\2\u02e6\u02e7\7t\2\2\u02e7\u02e8\7\64\2\2\u02e8\u02e9\7K\2"+
		"\2\u02e9\u02eb\7f\2\2\u02ea\u027f\3\2\2\2\u02ea\u0286\3\2\2\2\u02ea\u0296"+
		"\3\2\2\2\u02ea\u02a6\3\2\2\2\u02ea\u02b9\3\2\2\2\u02ea\u02c0\3\2\2\2\u02ea"+
		"\u02d5\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02f0\5\23\n\2\u02ed\u02ef\13"+
		"\2\2\2\u02ee\u02ed\3\2\2\2\u02ef\u02f2\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f0"+
		"\u02ee\3\2\2\2\u02f1\u02f3\3\2\2\2\u02f2\u02f0\3\2\2\2\u02f3\u02f7\7*"+
		"\2\2\u02f4\u02f6\13\2\2\2\u02f5\u02f4\3\2\2\2\u02f6\u02f9\3\2\2\2\u02f7"+
		"\u02f8\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f8\u02fa\3\2\2\2\u02f9\u02f7\3\2"+
		"\2\2\u02fa\u02fb\7+\2\2\u02fb\u0090\3\2\2\2 \2\u015c\u015f\u01ad\u01b0"+
		"\u01b4\u01b8\u01bb\u01bd\u01c3\u01c9\u01ce\u01d4\u01db\u01dd\u01e3\u01e5"+
		"\u01f0\u01fb\u0206\u020c\u020f\u0216\u021f\u025e\u0263\u027b\u02ea\u02f0"+
		"\u02f7\4\b\2\2\3E\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}