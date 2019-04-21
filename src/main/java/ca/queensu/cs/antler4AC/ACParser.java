package ca.queensu.cs.antler4AC; // Generated from AC.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ACParser extends Parser {
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
	public static final int
		RULE_parse = 0, RULE_block = 1, RULE_stat = 2, RULE_done = 3, RULE_assignment = 4, 
		RULE_ignore_stat = 5, RULE_if_stat = 6, RULE_condition_block = 7, RULE_stat_block = 8, 
		RULE_while_stat = 9, RULE_loop_stat = 10, RULE_sendat_stat = 11, RULE_send_stat = 12, 
		RULE_timer_stat = 13, RULE_showContent_stat = 14, RULE_log = 15, RULE_expr = 16, 
		RULE_atom = 17, RULE_unknowns = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "block", "stat", "done", "assignment", "ignore_stat", "if_stat", 
			"condition_block", "stat_block", "while_stat", "loop_stat", "sendat_stat", 
			"send_stat", "timer_stat", "showContent_stat", "log", "expr", "atom", 
			"unknowns"
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

	@Override
	public String getGrammarFileName() { return "AC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ACParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ACParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			block();
			setState(39);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & ((1L << (IF - 42)) | (1L << (WHILE - 42)) | (1L << (LOG - 42)) | (1L << (FOR - 42)) | (1L << (DO - 42)) | (1L << (SHOWHEAP - 42)) | (1L << (SHOWLISTSEND - 42)) | (1L << (BOOLVAR - 42)) | (1L << (INTVAR - 42)) | (1L << (DOUBLEVAR - 42)) | (1L << (STRINGVAR - 42)) | (1L << (ID - 42)) | (1L << (IGNORELINE - 42)))) != 0)) {
				{
				{
				setState(41);
				stat();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class StatContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public While_statContext while_stat() {
			return getRuleContext(While_statContext.class,0);
		}
		public Loop_statContext loop_stat() {
			return getRuleContext(Loop_statContext.class,0);
		}
		public LogContext log() {
			return getRuleContext(LogContext.class,0);
		}
		public Send_statContext send_stat() {
			return getRuleContext(Send_statContext.class,0);
		}
		public Sendat_statContext sendat_stat() {
			return getRuleContext(Sendat_statContext.class,0);
		}
		public ShowContent_statContext showContent_stat() {
			return getRuleContext(ShowContent_statContext.class,0);
		}
		public Timer_statContext timer_stat() {
			return getRuleContext(Timer_statContext.class,0);
		}
		public Ignore_statContext ignore_stat() {
			return getRuleContext(Ignore_statContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				if_stat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				while_stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				loop_stat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				log();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(52);
				send_stat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(53);
				sendat_stat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(54);
				showContent_stat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(55);
				timer_stat();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(56);
				ignore_stat();
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

	public static class DoneContext extends ParserRuleContext {
		public DoneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_done; }
	 
		public DoneContext() { }
		public void copyFrom(DoneContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProcessingDoneContext extends DoneContext {
		public TerminalNode EOF() { return getToken(ACParser.EOF, 0); }
		public ProcessingDoneContext(DoneContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterProcessingDone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitProcessingDone(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitProcessingDone(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoneContext done() throws RecognitionException {
		DoneContext _localctx = new DoneContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_done);
		try {
			_localctx = new ProcessingDoneContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
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

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MinusminusAssignmentContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public TerminalNode MINUSMINUS() { return getToken(ACParser.MINUSMINUS, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public MinusminusAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterMinusminusAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitMinusminusAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitMinusminusAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusplusAssignmentContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public TerminalNode PLUSPLUS() { return getToken(ACParser.PLUSPLUS, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public PlusplusAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterPlusplusAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitPlusplusAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitPlusplusAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NormalAssignmentContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(ACParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public TerminalNode INTVAR() { return getToken(ACParser.INTVAR, 0); }
		public TerminalNode DOUBLEVAR() { return getToken(ACParser.DOUBLEVAR, 0); }
		public TerminalNode STRINGVAR() { return getToken(ACParser.STRINGVAR, 0); }
		public TerminalNode BOOLVAR() { return getToken(ACParser.BOOLVAR, 0); }
		public NormalAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterNormalAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitNormalAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitNormalAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BasicAssignmentContext extends AssignmentContext {
		public Token op;
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public List<TerminalNode> INTVAR() { return getTokens(ACParser.INTVAR); }
		public TerminalNode INTVAR(int i) {
			return getToken(ACParser.INTVAR, i);
		}
		public List<TerminalNode> DOUBLEVAR() { return getTokens(ACParser.DOUBLEVAR); }
		public TerminalNode DOUBLEVAR(int i) {
			return getToken(ACParser.DOUBLEVAR, i);
		}
		public List<TerminalNode> STRINGVAR() { return getTokens(ACParser.STRINGVAR); }
		public TerminalNode STRINGVAR(int i) {
			return getToken(ACParser.STRINGVAR, i);
		}
		public List<TerminalNode> BOOLVAR() { return getTokens(ACParser.BOOLVAR); }
		public TerminalNode BOOLVAR(int i) {
			return getToken(ACParser.BOOLVAR, i);
		}
		public TerminalNode ASSIGN() { return getToken(ACParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BasicAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterBasicAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitBasicAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitBasicAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetTimerAssignmentContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(ACParser.ASSIGN, 0); }
		public Timer_statContext timer_stat() {
			return getRuleContext(Timer_statContext.class,0);
		}
		public GetTimerAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterGetTimerAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitGetTimerAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitGetTimerAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetNameAssignmentContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(ACParser.ASSIGN, 0); }
		public TerminalNode GETNAME() { return getToken(ACParser.GETNAME, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public TerminalNode STRINGVAR() { return getToken(ACParser.STRINGVAR, 0); }
		public GetNameAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterGetNameAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitGetNameAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitGetNameAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		int _la;
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new NormalAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(ID);
				setState(62);
				match(ASSIGN);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(63);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(66);
				expr(0);
				setState(67);
				match(SCOL);
				}
				break;
			case 2:
				_localctx = new BasicAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				((BasicAssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) ) {
					((BasicAssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(70);
				match(ID);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(71);
					match(ASSIGN);
					}
				}

				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(74);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & ((1L << (T__7 - 8)) | (1L << (MINUS - 8)) | (1L << (NOT - 8)) | (1L << (OPAR - 8)) | (1L << (TRUE - 8)) | (1L << (FALSE - 8)) | (1L << (NIL - 8)) | (1L << (BACKMSG - 8)) | (1L << (GETNAME - 8)) | (1L << (RANDFUNC - 8)) | (1L << (ID - 8)) | (1L << (INT - 8)) | (1L << (FLOAT - 8)) | (1L << (STRING - 8)) | (1L << (IGNOREEXPR - 8)))) != 0)) {
					{
					setState(77);
					expr(0);
					}
				}

				setState(80);
				match(SCOL);
				}
				break;
			case 3:
				_localctx = new MinusminusAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(ID);
				setState(82);
				match(MINUSMINUS);
				setState(83);
				match(SCOL);
				}
				break;
			case 4:
				_localctx = new PlusplusAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				match(ID);
				setState(85);
				match(PLUSPLUS);
				setState(86);
				match(SCOL);
				}
				break;
			case 5:
				_localctx = new GetNameAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRINGVAR) {
					{
					setState(87);
					match(STRINGVAR);
					}
				}

				setState(90);
				match(ID);
				setState(91);
				match(ASSIGN);
				setState(92);
				match(GETNAME);
				setState(93);
				match(SCOL);
				}
				break;
			case 6:
				_localctx = new GetTimerAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				match(ID);
				setState(95);
				match(ASSIGN);
				setState(96);
				timer_stat();
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

	public static class Ignore_statContext extends ParserRuleContext {
		public Ignore_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ignore_stat; }
	 
		public Ignore_statContext() { }
		public void copyFrom(Ignore_statContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IgnoreLineContext extends Ignore_statContext {
		public TerminalNode IGNORELINE() { return getToken(ACParser.IGNORELINE, 0); }
		public IgnoreLineContext(Ignore_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterIgnoreLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitIgnoreLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitIgnoreLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ignore_statContext ignore_stat() throws RecognitionException {
		Ignore_statContext _localctx = new Ignore_statContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ignore_stat);
		try {
			_localctx = new IgnoreLineContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(IGNORELINE);
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

	public static class If_statContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(ACParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(ACParser.IF, i);
		}
		public List<Condition_blockContext> condition_block() {
			return getRuleContexts(Condition_blockContext.class);
		}
		public Condition_blockContext condition_block(int i) {
			return getRuleContext(Condition_blockContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(ACParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(ACParser.ELSE, i);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterIf_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitIf_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitIf_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if_stat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(IF);
			setState(102);
			condition_block();
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(103);
					match(ELSE);
					setState(104);
					match(IF);
					setState(105);
					condition_block();
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(111);
				match(ELSE);
				setState(112);
				stat_block();
				}
				break;
			}
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

	public static class Condition_blockContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public Condition_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterCondition_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitCondition_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitCondition_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_blockContext condition_block() throws RecognitionException {
		Condition_blockContext _localctx = new Condition_blockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			expr(0);
			setState(116);
			stat_block();
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

	public static class Stat_blockContext extends ParserRuleContext {
		public TerminalNode OBRACE() { return getToken(ACParser.OBRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode CBRACE() { return getToken(ACParser.CBRACE, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Stat_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterStat_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitStat_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitStat_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_blockContext stat_block() throws RecognitionException {
		Stat_blockContext _localctx = new Stat_blockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stat_block);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(OBRACE);
				setState(119);
				block();
				setState(120);
				match(CBRACE);
				}
				break;
			case IF:
			case WHILE:
			case LOG:
			case FOR:
			case DO:
			case SHOWHEAP:
			case SHOWLISTSEND:
			case BOOLVAR:
			case INTVAR:
			case DOUBLEVAR:
			case STRINGVAR:
			case ID:
			case IGNORELINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				stat();
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

	public static class While_statContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ACParser.WHILE, 0); }
		public TerminalNode OPAR() { return getToken(ACParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public While_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterWhile_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitWhile_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitWhile_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statContext while_stat() throws RecognitionException {
		While_statContext _localctx = new While_statContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_while_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(WHILE);
			setState(126);
			match(OPAR);
			setState(127);
			expr(0);
			setState(128);
			match(CPAR);
			setState(129);
			stat_block();
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

	public static class Loop_statContext extends ParserRuleContext {
		public Loop_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_stat; }
	 
		public Loop_statContext() { }
		public void copyFrom(Loop_statContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileLoopContext extends Loop_statContext {
		public TerminalNode WHILE() { return getToken(ACParser.WHILE, 0); }
		public TerminalNode OPAR() { return getToken(ACParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public WhileLoopContext(Loop_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoWhileLoopContext extends Loop_statContext {
		public TerminalNode DO() { return getToken(ACParser.DO, 0); }
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(ACParser.WHILE, 0); }
		public TerminalNode OPAR() { return getToken(ACParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public DoWhileLoopContext(Loop_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterDoWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitDoWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitDoWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForLoopContext extends Loop_statContext {
		public Token op;
		public TerminalNode FOR() { return getToken(ACParser.FOR, 0); }
		public TerminalNode OPAR() { return getToken(ACParser.OPAR, 0); }
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(ACParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SCOL() { return getTokens(ACParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(ACParser.SCOL, i);
		}
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public TerminalNode INTVAR() { return getToken(ACParser.INTVAR, 0); }
		public TerminalNode DOUBLEVAR() { return getToken(ACParser.DOUBLEVAR, 0); }
		public ForLoopContext(Loop_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_statContext loop_stat() throws RecognitionException {
		Loop_statContext _localctx = new Loop_statContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_loop_stat);
		int _la;
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(WHILE);
				setState(132);
				match(OPAR);
				setState(133);
				expr(0);
				setState(134);
				match(CPAR);
				setState(135);
				stat_block();
				}
				break;
			case DO:
				_localctx = new DoWhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(DO);
				setState(138);
				stat_block();
				setState(139);
				match(WHILE);
				setState(140);
				match(OPAR);
				setState(141);
				expr(0);
				setState(142);
				match(CPAR);
				setState(143);
				match(SCOL);
				}
				break;
			case FOR:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				match(FOR);
				setState(146);
				match(OPAR);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTVAR || _la==DOUBLEVAR) {
					{
					setState(147);
					((ForLoopContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==INTVAR || _la==DOUBLEVAR) ) {
						((ForLoopContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(150);
				match(ID);
				setState(151);
				match(ASSIGN);
				setState(152);
				expr(0);
				setState(153);
				match(SCOL);
				setState(154);
				expr(0);
				setState(155);
				match(SCOL);
				setState(156);
				expr(0);
				setState(157);
				match(CPAR);
				setState(158);
				stat_block();
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

	public static class Sendat_statContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ACParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ACParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(ACParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ACParser.DOT, i);
		}
		public List<TerminalNode> OPAR() { return getTokens(ACParser.OPAR); }
		public TerminalNode OPAR(int i) {
			return getToken(ACParser.OPAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> CPAR() { return getTokens(ACParser.CPAR); }
		public TerminalNode CPAR(int i) {
			return getToken(ACParser.CPAR, i);
		}
		public TerminalNode SENDAT() { return getToken(ACParser.SENDAT, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public TerminalNode BACKMSG() { return getToken(ACParser.BACKMSG, 0); }
		public List<TerminalNode> INTVAR() { return getTokens(ACParser.INTVAR); }
		public TerminalNode INTVAR(int i) {
			return getToken(ACParser.INTVAR, i);
		}
		public List<TerminalNode> DOUBLEVAR() { return getTokens(ACParser.DOUBLEVAR); }
		public TerminalNode DOUBLEVAR(int i) {
			return getToken(ACParser.DOUBLEVAR, i);
		}
		public List<TerminalNode> STRINGVAR() { return getTokens(ACParser.STRINGVAR); }
		public TerminalNode STRINGVAR(int i) {
			return getToken(ACParser.STRINGVAR, i);
		}
		public List<TerminalNode> BOOLVAR() { return getTokens(ACParser.BOOLVAR); }
		public TerminalNode BOOLVAR(int i) {
			return getToken(ACParser.BOOLVAR, i);
		}
		public Sendat_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sendat_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterSendat_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitSendat_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitSendat_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sendat_statContext sendat_stat() throws RecognitionException {
		Sendat_statContext _localctx = new Sendat_statContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sendat_stat);
		int _la;
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(ID);
				setState(163);
				match(DOT);
				setState(164);
				match(ID);
				setState(165);
				match(OPAR);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(166);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(169);
				expr(0);
				setState(170);
				match(CPAR);
				setState(171);
				match(DOT);
				setState(172);
				match(SENDAT);
				setState(173);
				match(OPAR);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(174);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(177);
					expr(0);
					}
					break;
				case 2:
					{
					setState(178);
					match(BACKMSG);
					}
					break;
				}
				setState(181);
				match(CPAR);
				setState(182);
				match(SCOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(ID);
				setState(185);
				match(DOT);
				setState(186);
				match(ID);
				setState(187);
				match(T__0);
				setState(188);
				match(DOT);
				setState(189);
				match(SENDAT);
				setState(190);
				match(OPAR);
				setState(193);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(191);
					expr(0);
					}
					break;
				case 2:
					{
					setState(192);
					match(BACKMSG);
					}
					break;
				}
				setState(195);
				match(CPAR);
				setState(196);
				match(SCOL);
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

	public static class Send_statContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ACParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ACParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(ACParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ACParser.DOT, i);
		}
		public TerminalNode OPAR() { return getToken(ACParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public TerminalNode SEND() { return getToken(ACParser.SEND, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public TerminalNode INTVAR() { return getToken(ACParser.INTVAR, 0); }
		public TerminalNode DOUBLEVAR() { return getToken(ACParser.DOUBLEVAR, 0); }
		public TerminalNode STRINGVAR() { return getToken(ACParser.STRINGVAR, 0); }
		public TerminalNode BOOLVAR() { return getToken(ACParser.BOOLVAR, 0); }
		public TerminalNode GETNAME() { return getToken(ACParser.GETNAME, 0); }
		public Send_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_send_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterSend_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitSend_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitSend_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Send_statContext send_stat() throws RecognitionException {
		Send_statContext _localctx = new Send_statContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_send_stat);
		int _la;
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(ID);
				setState(200);
				match(DOT);
				setState(201);
				match(ID);
				setState(202);
				match(OPAR);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(203);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(206);
				expr(0);
				setState(207);
				match(CPAR);
				setState(208);
				match(DOT);
				setState(209);
				match(SEND);
				setState(210);
				match(T__0);
				setState(211);
				match(SCOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(ID);
				setState(214);
				match(DOT);
				setState(215);
				match(ID);
				setState(216);
				match(OPAR);
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(217);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GETNAME) {
					{
					setState(220);
					match(GETNAME);
					}
				}

				setState(223);
				match(CPAR);
				setState(224);
				match(DOT);
				setState(225);
				match(SEND);
				setState(226);
				match(T__0);
				setState(227);
				match(SCOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				match(ID);
				setState(229);
				match(DOT);
				setState(230);
				match(ID);
				setState(231);
				match(T__0);
				setState(232);
				match(DOT);
				setState(233);
				match(SEND);
				setState(234);
				match(T__0);
				setState(235);
				match(SCOL);
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

	public static class Timer_statContext extends ParserRuleContext {
		public Token op;
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public TerminalNode DOT() { return getToken(ACParser.DOT, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public Timer_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timer_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterTimer_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitTimer_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitTimer_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Timer_statContext timer_stat() throws RecognitionException {
		Timer_statContext _localctx = new Timer_statContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_timer_stat);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(ID);
			setState(239);
			match(DOT);
			setState(240);
			((Timer_statContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) ) {
				((Timer_statContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(241);
					matchWildcard();
					}
					} 
				}
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(247);
			match(SCOL);
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

	public static class ShowContent_statContext extends ParserRuleContext {
		public ShowContent_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showContent_stat; }
	 
		public ShowContent_statContext() { }
		public void copyFrom(ShowContent_statContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ShowHeapMemContext extends ShowContent_statContext {
		public TerminalNode SHOWHEAP() { return getToken(ACParser.SHOWHEAP, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public ShowHeapMemContext(ShowContent_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterShowHeapMem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitShowHeapMem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitShowHeapMem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowListSendMsgContext extends ShowContent_statContext {
		public TerminalNode SHOWLISTSEND() { return getToken(ACParser.SHOWLISTSEND, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public ShowListSendMsgContext(ShowContent_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterShowListSendMsg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitShowListSendMsg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitShowListSendMsg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowContent_statContext showContent_stat() throws RecognitionException {
		ShowContent_statContext _localctx = new ShowContent_statContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_showContent_stat);
		try {
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHOWHEAP:
				_localctx = new ShowHeapMemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				match(SHOWHEAP);
				setState(250);
				match(SCOL);
				}
				break;
			case SHOWLISTSEND:
				_localctx = new ShowListSendMsgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(SHOWLISTSEND);
				setState(252);
				match(SCOL);
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

	public static class LogContext extends ParserRuleContext {
		public TerminalNode LOG() { return getToken(ACParser.LOG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public LogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_log; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitLog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitLog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogContext log() throws RecognitionException {
		LogContext _localctx = new LogContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_log);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(LOG);
			setState(256);
			expr(0);
			setState(257);
			match(SCOL);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FindFuncExprContext extends ExprContext {
		public List<TerminalNode> ID() { return getTokens(ACParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ACParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(ACParser.DOT, 0); }
		public TerminalNode OPAR() { return getToken(ACParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public TerminalNode STRING() { return getToken(ACParser.STRING, 0); }
		public FindFuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterFindFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitFindFuncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitFindFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(ACParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusplusExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUSPLUS() { return getToken(ACParser.PLUSPLUS, 0); }
		public PlusplusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterPlusplusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitPlusplusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitPlusplusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(ACParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ACParser.MINUS, 0); }
		public AdditiveExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterAdditiveExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitAdditiveExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LTEQ() { return getToken(ACParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(ACParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(ACParser.LT, 0); }
		public TerminalNode GT() { return getToken(ACParser.GT, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitRelationalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BackMsgExprContext extends ExprContext {
		public TerminalNode BACKMSG() { return getToken(ACParser.BACKMSG, 0); }
		public BackMsgExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterBackMsgExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitBackMsgExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitBackMsgExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IgnoreExprContext extends ExprContext {
		public TerminalNode IGNOREEXPR() { return getToken(ACParser.IGNOREEXPR, 0); }
		public IgnoreExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterIgnoreExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitIgnoreExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitIgnoreExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(ACParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryMinusExprContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(ACParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterUnaryMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitUnaryMinusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitUnaryMinusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(ACParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(ACParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(ACParser.MOD, 0); }
		public TerminalNode MINUSMINUS() { return getToken(ACParser.MINUSMINUS, 0); }
		public TerminalNode PLUSPLUS() { return getToken(ACParser.PLUSPLUS, 0); }
		public MultiplicationExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterMultiplicationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitMultiplicationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitMultiplicationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusminusExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MINUSMINUS() { return getToken(ACParser.MINUSMINUS, 0); }
		public MinusminusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterMinusminusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitMinusminusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitMinusminusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrcmpFuncExprContext extends ExprContext {
		public Token op1;
		public Token op2;
		public TerminalNode OPAR() { return getToken(ACParser.OPAR, 0); }
		public TerminalNode COMMA() { return getToken(ACParser.COMMA, 0); }
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public List<TerminalNode> ID() { return getTokens(ACParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ACParser.ID, i);
		}
		public List<TerminalNode> STRING() { return getTokens(ACParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ACParser.STRING, i);
		}
		public List<TerminalNode> STRINGVAR() { return getTokens(ACParser.STRINGVAR); }
		public TerminalNode STRINGVAR(int i) {
			return getToken(ACParser.STRINGVAR, i);
		}
		public StrcmpFuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterStrcmpFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitStrcmpFuncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitStrcmpFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LengthFuncExprContext extends ExprContext {
		public TerminalNode DOT() { return getToken(ACParser.DOT, 0); }
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public TerminalNode STRING() { return getToken(ACParser.STRING, 0); }
		public LengthFuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterLengthFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitLengthFuncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitLengthFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RandFuncExprContext extends ExprContext {
		public TerminalNode RANDFUNC() { return getToken(ACParser.RANDFUNC, 0); }
		public RandFuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterRandFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitRandFuncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitRandFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubstrFuncExprContext extends ExprContext {
		public TerminalNode DOT() { return getToken(ACParser.DOT, 0); }
		public TerminalNode OPAR() { return getToken(ACParser.OPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(ACParser.COMMA, 0); }
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public TerminalNode STRING() { return getToken(ACParser.STRING, 0); }
		public SubstrFuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterSubstrFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitSubstrFuncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitSubstrFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POW() { return getToken(ACParser.POW, 0); }
		public PowExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitPowExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitPowExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetNameExprContext extends ExprContext {
		public TerminalNode GETNAME() { return getToken(ACParser.GETNAME, 0); }
		public GetNameExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterGetNameExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitGetNameExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitGetNameExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(ACParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ACParser.NEQ, 0); }
		public EqualityExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitEqualityExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(ACParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(260);
				match(MINUS);
				setState(261);
				expr(17);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				match(NOT);
				setState(263);
				expr(16);
				}
				break;
			case 3:
				{
				_localctx = new GetNameExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				match(GETNAME);
				}
				break;
			case 4:
				{
				_localctx = new BackMsgExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				match(BACKMSG);
				}
				break;
			case 5:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				atom();
				}
				break;
			case 6:
				{
				_localctx = new RandFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267);
				match(RANDFUNC);
				}
				break;
			case 7:
				{
				_localctx = new FindFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				match(ID);
				setState(269);
				match(DOT);
				setState(270);
				match(T__4);
				setState(271);
				match(OPAR);
				setState(272);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(273);
				match(CPAR);
				}
				break;
			case 8:
				{
				_localctx = new SubstrFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(275);
				match(DOT);
				setState(276);
				match(T__5);
				setState(277);
				match(OPAR);
				setState(278);
				expr(0);
				setState(279);
				match(COMMA);
				setState(280);
				expr(0);
				setState(281);
				match(CPAR);
				}
				break;
			case 9:
				{
				_localctx = new LengthFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(284);
				match(DOT);
				setState(285);
				match(T__6);
				}
				break;
			case 10:
				{
				_localctx = new StrcmpFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(286);
				match(T__7);
				setState(287);
				match(OPAR);
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRINGVAR) {
					{
					setState(288);
					match(STRINGVAR);
					}
				}

				setState(291);
				((StrcmpFuncExprContext)_localctx).op1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING) ) {
					((StrcmpFuncExprContext)_localctx).op1 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(292);
				match(COMMA);
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRINGVAR) {
					{
					setState(293);
					match(STRINGVAR);
					}
				}

				setState(296);
				((StrcmpFuncExprContext)_localctx).op2 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING) ) {
					((StrcmpFuncExprContext)_localctx).op2 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(297);
				match(CPAR);
				}
				break;
			case 11:
				{
				_localctx = new IgnoreExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				match(IGNOREEXPR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(328);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(326);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(301);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(302);
						match(POW);
						setState(303);
						expr(21);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(304);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(305);
						((MultiplicationExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MultiplicationExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(306);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new AdditiveExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(307);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(308);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(309);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(310);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(311);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(312);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(313);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(314);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(315);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(316);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(317);
						match(AND);
						setState(318);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(319);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(320);
						match(OR);
						setState(321);
						expr(11);
						}
						break;
					case 8:
						{
						_localctx = new MinusminusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(322);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(323);
						match(MINUSMINUS);
						}
						break;
					case 9:
						{
						_localctx = new PlusplusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(324);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(325);
						match(PLUSPLUS);
						}
						break;
					}
					} 
				}
				setState(330);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParExprContext extends AtomContext {
		public TerminalNode OPAR() { return getToken(ACParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public ParExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitParExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(ACParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ACParser.FALSE, 0); }
		public BooleanAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterBooleanAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitBooleanAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitBooleanAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdAtomContext extends AtomContext {
		public TerminalNode ID() { return getToken(ACParser.ID, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterIdAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitIdAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitIdAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringAtomContext extends AtomContext {
		public TerminalNode STRING() { return getToken(ACParser.STRING, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterStringAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitStringAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitStringAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NilAtomContext extends AtomContext {
		public TerminalNode NIL() { return getToken(ACParser.NIL, 0); }
		public NilAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterNilAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitNilAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitNilAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberAtomContext extends AtomContext {
		public TerminalNode INT() { return getToken(ACParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ACParser.FLOAT, 0); }
		public NumberAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterNumberAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitNumberAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitNumberAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_atom);
		int _la;
		try {
			setState(340);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAR:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				match(OPAR);
				setState(332);
				expr(0);
				setState(333);
				match(CPAR);
				}
				break;
			case INT:
			case FLOAT:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==FLOAT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(336);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case ID:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(337);
				match(ID);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(338);
				match(STRING);
				}
				break;
			case NIL:
				_localctx = new NilAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(339);
				match(NIL);
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

	public static class UnknownsContext extends ParserRuleContext {
		public UnknownsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unknowns; }
	 
		public UnknownsContext() { }
		public void copyFrom(UnknownsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnknownsExprContext extends UnknownsContext {
		public UnknownsExprContext(UnknownsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterUnknownsExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitUnknownsExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitUnknownsExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnknownsContext unknowns() throws RecognitionException {
		UnknownsContext _localctx = new UnknownsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_unknowns);
		try {
			_localctx = new UnknownsExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			matchWildcard();
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
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 19);
		case 8:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3I\u015b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\5\3\5\3\6\3\6\3\6\5\6C\n\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6K\n\6\3\6\5\6N\n\6\3\6\5\6Q\n\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6[\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6d\n\6\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\7\bm\n\b\f\b\16\bp\13\b\3\b\3\b\5\bt\n\b\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n~\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u0097\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a3\n\f\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00aa\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b2\n\r\3"+
		"\r\3\r\5\r\u00b6\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u00c4\n\r\3\r\3\r\5\r\u00c8\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u00cf"+
		"\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00dd\n\16\3\16\5\16\u00e0\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ef\n\16\3\17\3\17\3\17\3\17\7\17"+
		"\u00f5\n\17\f\17\16\17\u00f8\13\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20"+
		"\u0100\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0124\n\22\3\22\3\22\3\22"+
		"\5\22\u0129\n\22\3\22\3\22\3\22\5\22\u012e\n\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0149\n\22\f\22\16\22\u014c\13"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0157\n\23\3\24"+
		"\3\24\3\24\3\u00f6\3\"\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"\2\f\4\29;==\3\2:;\3\2\4\6\4\2>>AA\4\2\27\27\31\34\4\2\26\26\30\30\3\2"+
		"\22\25\3\2\20\21\3\2?@\3\2)*\2\u0187\2(\3\2\2\2\4.\3\2\2\2\6;\3\2\2\2"+
		"\b=\3\2\2\2\nc\3\2\2\2\fe\3\2\2\2\16g\3\2\2\2\20u\3\2\2\2\22}\3\2\2\2"+
		"\24\177\3\2\2\2\26\u00a2\3\2\2\2\30\u00c7\3\2\2\2\32\u00ee\3\2\2\2\34"+
		"\u00f0\3\2\2\2\36\u00ff\3\2\2\2 \u0101\3\2\2\2\"\u012d\3\2\2\2$\u0156"+
		"\3\2\2\2&\u0158\3\2\2\2()\5\4\3\2)*\7\2\2\3*\3\3\2\2\2+-\5\6\4\2,+\3\2"+
		"\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\5\3\2\2\2\60.\3\2\2\2\61<\5\n\6"+
		"\2\62<\5\16\b\2\63<\5\24\13\2\64<\5\26\f\2\65<\5 \21\2\66<\5\32\16\2\67"+
		"<\5\30\r\28<\5\36\20\29<\5\34\17\2:<\5\f\7\2;\61\3\2\2\2;\62\3\2\2\2;"+
		"\63\3\2\2\2;\64\3\2\2\2;\65\3\2\2\2;\66\3\2\2\2;\67\3\2\2\2;8\3\2\2\2"+
		";9\3\2\2\2;:\3\2\2\2<\7\3\2\2\2=>\7\2\2\3>\t\3\2\2\2?@\7>\2\2@B\7\"\2"+
		"\2AC\t\2\2\2BA\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\5\"\22\2EF\7!\2\2Fd\3\2\2"+
		"\2GH\t\2\2\2HJ\7>\2\2IK\7\"\2\2JI\3\2\2\2JK\3\2\2\2KM\3\2\2\2LN\t\2\2"+
		"\2ML\3\2\2\2MN\3\2\2\2NP\3\2\2\2OQ\5\"\22\2PO\3\2\2\2PQ\3\2\2\2QR\3\2"+
		"\2\2Rd\7!\2\2ST\7>\2\2TU\7\31\2\2Ud\7!\2\2VW\7>\2\2WX\7\27\2\2Xd\7!\2"+
		"\2Y[\7=\2\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7>\2\2]^\7\"\2\2^_\7\65"+
		"\2\2_d\7!\2\2`a\7>\2\2ab\7\"\2\2bd\5\34\17\2c?\3\2\2\2cG\3\2\2\2cS\3\2"+
		"\2\2cV\3\2\2\2cZ\3\2\2\2c`\3\2\2\2d\13\3\2\2\2ef\7G\2\2f\r\3\2\2\2gh\7"+
		",\2\2hn\5\20\t\2ij\7-\2\2jk\7,\2\2km\5\20\t\2li\3\2\2\2mp\3\2\2\2nl\3"+
		"\2\2\2no\3\2\2\2os\3\2\2\2pn\3\2\2\2qr\7-\2\2rt\5\22\n\2sq\3\2\2\2st\3"+
		"\2\2\2t\17\3\2\2\2uv\5\"\22\2vw\5\22\n\2w\21\3\2\2\2xy\7%\2\2yz\5\4\3"+
		"\2z{\7&\2\2{~\3\2\2\2|~\5\6\4\2}x\3\2\2\2}|\3\2\2\2~\23\3\2\2\2\177\u0080"+
		"\7.\2\2\u0080\u0081\7#\2\2\u0081\u0082\5\"\22\2\u0082\u0083\7$\2\2\u0083"+
		"\u0084\5\22\n\2\u0084\25\3\2\2\2\u0085\u0086\7.\2\2\u0086\u0087\7#\2\2"+
		"\u0087\u0088\5\"\22\2\u0088\u0089\7$\2\2\u0089\u008a\5\22\n\2\u008a\u00a3"+
		"\3\2\2\2\u008b\u008c\7\61\2\2\u008c\u008d\5\22\n\2\u008d\u008e\7.\2\2"+
		"\u008e\u008f\7#\2\2\u008f\u0090\5\"\22\2\u0090\u0091\7$\2\2\u0091\u0092"+
		"\7!\2\2\u0092\u00a3\3\2\2\2\u0093\u0094\7\60\2\2\u0094\u0096\7#\2\2\u0095"+
		"\u0097\t\3\2\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\7>\2\2\u0099\u009a\7\"\2\2\u009a\u009b\5\"\22\2\u009b"+
		"\u009c\7!\2\2\u009c\u009d\5\"\22\2\u009d\u009e\7!\2\2\u009e\u009f\5\""+
		"\22\2\u009f\u00a0\7$\2\2\u00a0\u00a1\5\22\n\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u0085\3\2\2\2\u00a2\u008b\3\2\2\2\u00a2\u0093\3\2\2\2\u00a3\27\3\2\2"+
		"\2\u00a4\u00a5\7>\2\2\u00a5\u00a6\7\13\2\2\u00a6\u00a7\7>\2\2\u00a7\u00a9"+
		"\7#\2\2\u00a8\u00aa\t\2\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\5\"\22\2\u00ac\u00ad\7$\2\2\u00ad\u00ae\7\13"+
		"\2\2\u00ae\u00af\7\63\2\2\u00af\u00b1\7#\2\2\u00b0\u00b2\t\2\2\2\u00b1"+
		"\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b6\5\""+
		"\22\2\u00b4\u00b6\7\64\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b8\7$\2\2\u00b8\u00b9\7!\2\2\u00b9\u00c8\3\2\2"+
		"\2\u00ba\u00bb\7>\2\2\u00bb\u00bc\7\13\2\2\u00bc\u00bd\7>\2\2\u00bd\u00be"+
		"\7\3\2\2\u00be\u00bf\7\13\2\2\u00bf\u00c0\7\63\2\2\u00c0\u00c3\7#\2\2"+
		"\u00c1\u00c4\5\"\22\2\u00c2\u00c4\7\64\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2"+
		"\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7$\2\2\u00c6\u00c8\7!\2\2\u00c7"+
		"\u00a4\3\2\2\2\u00c7\u00ba\3\2\2\2\u00c8\31\3\2\2\2\u00c9\u00ca\7>\2\2"+
		"\u00ca\u00cb\7\13\2\2\u00cb\u00cc\7>\2\2\u00cc\u00ce\7#\2\2\u00cd\u00cf"+
		"\t\2\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00d1\5\"\22\2\u00d1\u00d2\7$\2\2\u00d2\u00d3\7\13\2\2\u00d3\u00d4\7"+
		"\62\2\2\u00d4\u00d5\7\3\2\2\u00d5\u00d6\7!\2\2\u00d6\u00ef\3\2\2\2\u00d7"+
		"\u00d8\7>\2\2\u00d8\u00d9\7\13\2\2\u00d9\u00da\7>\2\2\u00da\u00dc\7#\2"+
		"\2\u00db\u00dd\t\2\2\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df"+
		"\3\2\2\2\u00de\u00e0\7\65\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2"+
		"\u00e0\u00e1\3\2\2\2\u00e1\u00e2\7$\2\2\u00e2\u00e3\7\13\2\2\u00e3\u00e4"+
		"\7\62\2\2\u00e4\u00e5\7\3\2\2\u00e5\u00ef\7!\2\2\u00e6\u00e7\7>\2\2\u00e7"+
		"\u00e8\7\13\2\2\u00e8\u00e9\7>\2\2\u00e9\u00ea\7\3\2\2\u00ea\u00eb\7\13"+
		"\2\2\u00eb\u00ec\7\62\2\2\u00ec\u00ed\7\3\2\2\u00ed\u00ef\7!\2\2\u00ee"+
		"\u00c9\3\2\2\2\u00ee\u00d7\3\2\2\2\u00ee\u00e6\3\2\2\2\u00ef\33\3\2\2"+
		"\2\u00f0\u00f1\7>\2\2\u00f1\u00f2\7\13\2\2\u00f2\u00f6\t\4\2\2\u00f3\u00f5"+
		"\13\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f7\3\2\2\2"+
		"\u00f6\u00f4\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa"+
		"\7!\2\2\u00fa\35\3\2\2\2\u00fb\u00fc\7\67\2\2\u00fc\u0100\7!\2\2\u00fd"+
		"\u00fe\78\2\2\u00fe\u0100\7!\2\2\u00ff\u00fb\3\2\2\2\u00ff\u00fd\3\2\2"+
		"\2\u0100\37\3\2\2\2\u0101\u0102\7/\2\2\u0102\u0103\5\"\22\2\u0103\u0104"+
		"\7!\2\2\u0104!\3\2\2\2\u0105\u0106\b\22\1\2\u0106\u0107\7\30\2\2\u0107"+
		"\u012e\5\"\22\23\u0108\u0109\7\36\2\2\u0109\u012e\5\"\22\22\u010a\u012e"+
		"\7\65\2\2\u010b\u012e\7\64\2\2\u010c\u012e\5$\23\2\u010d\u012e\7\66\2"+
		"\2\u010e\u010f\7>\2\2\u010f\u0110\7\13\2\2\u0110\u0111\7\7\2\2\u0111\u0112"+
		"\7#\2\2\u0112\u0113\t\5\2\2\u0113\u012e\7$\2\2\u0114\u0115\t\5\2\2\u0115"+
		"\u0116\7\13\2\2\u0116\u0117\7\b\2\2\u0117\u0118\7#\2\2\u0118\u0119\5\""+
		"\22\2\u0119\u011a\7\37\2\2\u011a\u011b\5\"\22\2\u011b\u011c\7$\2\2\u011c"+
		"\u012e\3\2\2\2\u011d\u011e\t\5\2\2\u011e\u011f\7\13\2\2\u011f\u012e\7"+
		"\t\2\2\u0120\u0121\7\n\2\2\u0121\u0123\7#\2\2\u0122\u0124\7=\2\2\u0123"+
		"\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\t\5"+
		"\2\2\u0126\u0128\7\37\2\2\u0127\u0129\7=\2\2\u0128\u0127\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\t\5\2\2\u012b\u012e\7$"+
		"\2\2\u012c\u012e\7I\2\2\u012d\u0105\3\2\2\2\u012d\u0108\3\2\2\2\u012d"+
		"\u010a\3\2\2\2\u012d\u010b\3\2\2\2\u012d\u010c\3\2\2\2\u012d\u010d\3\2"+
		"\2\2\u012d\u010e\3\2\2\2\u012d\u0114\3\2\2\2\u012d\u011d\3\2\2\2\u012d"+
		"\u0120\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u014a\3\2\2\2\u012f\u0130\f\26"+
		"\2\2\u0130\u0131\7\35\2\2\u0131\u0149\5\"\22\27\u0132\u0133\f\21\2\2\u0133"+
		"\u0134\t\6\2\2\u0134\u0149\5\"\22\22\u0135\u0136\f\20\2\2\u0136\u0137"+
		"\t\7\2\2\u0137\u0149\5\"\22\21\u0138\u0139\f\17\2\2\u0139\u013a\t\b\2"+
		"\2\u013a\u0149\5\"\22\20\u013b\u013c\f\16\2\2\u013c\u013d\t\t\2\2\u013d"+
		"\u0149\5\"\22\17\u013e\u013f\f\r\2\2\u013f\u0140\7\17\2\2\u0140\u0149"+
		"\5\"\22\16\u0141\u0142\f\f\2\2\u0142\u0143\7\16\2\2\u0143\u0149\5\"\22"+
		"\r\u0144\u0145\f\25\2\2\u0145\u0149\7\31\2\2\u0146\u0147\f\24\2\2\u0147"+
		"\u0149\7\27\2\2\u0148\u012f\3\2\2\2\u0148\u0132\3\2\2\2\u0148\u0135\3"+
		"\2\2\2\u0148\u0138\3\2\2\2\u0148\u013b\3\2\2\2\u0148\u013e\3\2\2\2\u0148"+
		"\u0141\3\2\2\2\u0148\u0144\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014c\3\2"+
		"\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b#\3\2\2\2\u014c\u014a"+
		"\3\2\2\2\u014d\u014e\7#\2\2\u014e\u014f\5\"\22\2\u014f\u0150\7$\2\2\u0150"+
		"\u0157\3\2\2\2\u0151\u0157\t\n\2\2\u0152\u0157\t\13\2\2\u0153\u0157\7"+
		">\2\2\u0154\u0157\7A\2\2\u0155\u0157\7+\2\2\u0156\u014d\3\2\2\2\u0156"+
		"\u0151\3\2\2\2\u0156\u0152\3\2\2\2\u0156\u0153\3\2\2\2\u0156\u0154\3\2"+
		"\2\2\u0156\u0155\3\2\2\2\u0157%\3\2\2\2\u0158\u0159\13\2\2\2\u0159\'\3"+
		"\2\2\2 .;BJMPZcns}\u0096\u00a2\u00a9\u00b1\u00b5\u00c3\u00c7\u00ce\u00dc"+
		"\u00df\u00ee\u00f6\u00ff\u0123\u0128\u012d\u0148\u014a\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}