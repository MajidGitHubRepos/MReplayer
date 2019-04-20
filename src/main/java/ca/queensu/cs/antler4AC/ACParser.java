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
		RULE_if_stat = 5, RULE_condition_block = 6, RULE_stat_block = 7, RULE_while_stat = 8, 
		RULE_loop_stat = 9, RULE_sendat_stat = 10, RULE_send_stat = 11, RULE_timer_stat = 12, 
		RULE_showContent_stat = 13, RULE_log = 14, RULE_expr = 15, RULE_atom = 16, 
		RULE_unknowns = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "block", "stat", "done", "assignment", "if_stat", "condition_block", 
			"stat_block", "while_stat", "loop_stat", "sendat_stat", "send_stat", 
			"timer_stat", "showContent_stat", "log", "expr", "atom", "unknowns"
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
			setState(36);
			block();
			setState(37);
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
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << LOG) | (1L << FOR) | (1L << DO) | (1L << SHOWHEAP) | (1L << SHOWLISTSEND) | (1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR) | (1L << ID))) != 0)) {
				{
				{
				setState(39);
				stat();
				}
				}
				setState(44);
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
		public Sendat_statContext sendat_stat() {
			return getRuleContext(Sendat_statContext.class,0);
		}
		public Send_statContext send_stat() {
			return getRuleContext(Send_statContext.class,0);
		}
		public ShowContent_statContext showContent_stat() {
			return getRuleContext(ShowContent_statContext.class,0);
		}
		public Timer_statContext timer_stat() {
			return getRuleContext(Timer_statContext.class,0);
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
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				if_stat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				while_stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				loop_stat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				log();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(50);
				sendat_stat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(51);
				send_stat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(52);
				showContent_stat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(53);
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
			setState(56);
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
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new NormalAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(ID);
				setState(59);
				match(ASSIGN);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(60);
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

				setState(63);
				expr(0);
				setState(64);
				match(SCOL);
				}
				break;
			case 2:
				_localctx = new BasicAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
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
				setState(67);
				match(ID);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(68);
					match(ASSIGN);
					}
				}

				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(71);
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

				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & ((1L << (T__7 - 8)) | (1L << (MINUS - 8)) | (1L << (NOT - 8)) | (1L << (OPAR - 8)) | (1L << (TRUE - 8)) | (1L << (FALSE - 8)) | (1L << (NIL - 8)) | (1L << (BACKMSG - 8)) | (1L << (GETNAME - 8)) | (1L << (RANDFUNC - 8)) | (1L << (ID - 8)) | (1L << (INT - 8)) | (1L << (FLOAT - 8)) | (1L << (STRING - 8)) | (1L << (IGNOREEXPR - 8)))) != 0)) {
					{
					setState(74);
					expr(0);
					}
				}

				setState(77);
				match(SCOL);
				}
				break;
			case 3:
				_localctx = new MinusminusAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				match(ID);
				setState(79);
				match(MINUSMINUS);
				setState(80);
				match(SCOL);
				}
				break;
			case 4:
				_localctx = new PlusplusAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				match(ID);
				setState(82);
				match(PLUSPLUS);
				setState(83);
				match(SCOL);
				}
				break;
			case 5:
				_localctx = new GetNameAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRINGVAR) {
					{
					setState(84);
					match(STRINGVAR);
					}
				}

				setState(87);
				match(ID);
				setState(88);
				match(ASSIGN);
				setState(89);
				match(GETNAME);
				setState(90);
				match(SCOL);
				}
				break;
			case 6:
				_localctx = new GetTimerAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				match(ID);
				setState(92);
				match(ASSIGN);
				setState(93);
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
		enterRule(_localctx, 10, RULE_if_stat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(IF);
			setState(97);
			condition_block();
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(98);
					match(ELSE);
					setState(99);
					match(IF);
					setState(100);
					condition_block();
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(106);
				match(ELSE);
				setState(107);
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
		enterRule(_localctx, 12, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			expr(0);
			setState(111);
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
		enterRule(_localctx, 14, RULE_stat_block);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(OBRACE);
				setState(114);
				block();
				setState(115);
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
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
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
		enterRule(_localctx, 16, RULE_while_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(WHILE);
			setState(121);
			match(OPAR);
			setState(122);
			expr(0);
			setState(123);
			match(CPAR);
			setState(124);
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
		enterRule(_localctx, 18, RULE_loop_stat);
		int _la;
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(WHILE);
				setState(127);
				match(OPAR);
				setState(128);
				expr(0);
				setState(129);
				match(CPAR);
				setState(130);
				stat_block();
				}
				break;
			case DO:
				_localctx = new DoWhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(DO);
				setState(133);
				stat_block();
				setState(134);
				match(WHILE);
				setState(135);
				match(OPAR);
				setState(136);
				expr(0);
				setState(137);
				match(CPAR);
				setState(138);
				match(SCOL);
				}
				break;
			case FOR:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(FOR);
				setState(141);
				match(OPAR);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTVAR || _la==DOUBLEVAR) {
					{
					setState(142);
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

				setState(145);
				match(ID);
				setState(146);
				match(ASSIGN);
				setState(147);
				expr(0);
				setState(148);
				match(SCOL);
				setState(149);
				expr(0);
				setState(150);
				match(SCOL);
				setState(151);
				expr(0);
				setState(152);
				match(CPAR);
				setState(153);
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
		enterRule(_localctx, 20, RULE_sendat_stat);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(ID);
				setState(158);
				match(DOT);
				setState(159);
				match(ID);
				setState(160);
				match(OPAR);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(161);
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

				setState(164);
				expr(0);
				setState(165);
				match(CPAR);
				setState(166);
				match(DOT);
				setState(167);
				match(SENDAT);
				setState(168);
				match(OPAR);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(169);
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

				setState(174);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(172);
					expr(0);
					}
					break;
				case 2:
					{
					setState(173);
					match(BACKMSG);
					}
					break;
				}
				setState(176);
				match(CPAR);
				setState(177);
				match(SCOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(ID);
				setState(180);
				match(DOT);
				setState(181);
				match(ID);
				setState(182);
				match(T__0);
				setState(183);
				match(DOT);
				setState(184);
				match(SENDAT);
				setState(185);
				match(OPAR);
				setState(188);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(186);
					expr(0);
					}
					break;
				case 2:
					{
					setState(187);
					match(BACKMSG);
					}
					break;
				}
				setState(190);
				match(CPAR);
				setState(191);
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
		enterRule(_localctx, 22, RULE_send_stat);
		int _la;
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(ID);
				setState(195);
				match(DOT);
				setState(196);
				match(ID);
				setState(197);
				match(OPAR);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(198);
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

				setState(201);
				expr(0);
				setState(202);
				match(CPAR);
				setState(203);
				match(DOT);
				setState(204);
				match(SEND);
				setState(205);
				match(T__0);
				setState(206);
				match(SCOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(ID);
				setState(209);
				match(DOT);
				setState(210);
				match(ID);
				setState(211);
				match(OPAR);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAR) | (1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) {
					{
					setState(212);
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

				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GETNAME) {
					{
					setState(215);
					match(GETNAME);
					}
				}

				setState(218);
				match(CPAR);
				setState(219);
				match(DOT);
				setState(220);
				match(SEND);
				setState(221);
				match(T__0);
				setState(222);
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
		enterRule(_localctx, 24, RULE_timer_stat);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(ID);
			setState(226);
			match(DOT);
			setState(227);
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
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(228);
					matchWildcard();
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(234);
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
		enterRule(_localctx, 26, RULE_showContent_stat);
		try {
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHOWHEAP:
				_localctx = new ShowHeapMemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(SHOWHEAP);
				setState(237);
				match(SCOL);
				}
				break;
			case SHOWLISTSEND:
				_localctx = new ShowListSendMsgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(SHOWLISTSEND);
				setState(239);
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
		enterRule(_localctx, 28, RULE_log);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(LOG);
			setState(243);
			expr(0);
			setState(244);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(247);
				match(MINUS);
				setState(248);
				expr(17);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				match(NOT);
				setState(250);
				expr(16);
				}
				break;
			case 3:
				{
				_localctx = new GetNameExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(GETNAME);
				}
				break;
			case 4:
				{
				_localctx = new BackMsgExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				match(BACKMSG);
				}
				break;
			case 5:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				atom();
				}
				break;
			case 6:
				{
				_localctx = new RandFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(254);
				match(RANDFUNC);
				}
				break;
			case 7:
				{
				_localctx = new FindFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(255);
				match(ID);
				setState(256);
				match(DOT);
				setState(257);
				match(T__4);
				setState(258);
				match(OPAR);
				setState(259);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(260);
				match(CPAR);
				}
				break;
			case 8:
				{
				_localctx = new SubstrFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(261);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(262);
				match(DOT);
				setState(263);
				match(T__5);
				setState(264);
				match(OPAR);
				setState(265);
				expr(0);
				setState(266);
				match(COMMA);
				setState(267);
				expr(0);
				setState(268);
				match(CPAR);
				}
				break;
			case 9:
				{
				_localctx = new LengthFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(271);
				match(DOT);
				setState(272);
				match(T__6);
				}
				break;
			case 10:
				{
				_localctx = new StrcmpFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				match(T__7);
				setState(274);
				match(OPAR);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRINGVAR) {
					{
					setState(275);
					match(STRINGVAR);
					}
				}

				setState(278);
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
				setState(279);
				match(COMMA);
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRINGVAR) {
					{
					setState(280);
					match(STRINGVAR);
					}
				}

				setState(283);
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
				setState(284);
				match(CPAR);
				}
				break;
			case 11:
				{
				_localctx = new IgnoreExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(IGNOREEXPR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(313);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(288);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(289);
						match(POW);
						setState(290);
						expr(21);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(291);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(292);
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
						setState(293);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new AdditiveExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(294);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(295);
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
						setState(296);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(298);
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
						setState(299);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(300);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(301);
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
						setState(302);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(303);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(304);
						match(AND);
						setState(305);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(306);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(307);
						match(OR);
						setState(308);
						expr(11);
						}
						break;
					case 8:
						{
						_localctx = new MinusminusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(309);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(310);
						match(MINUSMINUS);
						}
						break;
					case 9:
						{
						_localctx = new PlusplusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(311);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(312);
						match(PLUSPLUS);
						}
						break;
					}
					} 
				}
				setState(317);
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
		enterRule(_localctx, 32, RULE_atom);
		int _la;
		try {
			setState(327);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAR:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				match(OPAR);
				setState(319);
				expr(0);
				setState(320);
				match(CPAR);
				}
				break;
			case INT:
			case FLOAT:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(322);
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
				setState(323);
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
				setState(324);
				match(ID);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(325);
				match(STRING);
				}
				break;
			case NIL:
				_localctx = new NilAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(326);
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
		enterRule(_localctx, 34, RULE_unknowns);
		try {
			_localctx = new UnknownsExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
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
		case 15:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3I\u014e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\3\7\3+\n\3\f\3\16\3.\13\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\49\n\4\3\5\3\5\3\6\3\6\3\6\5\6@\n\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6H\n\6\3\6\5\6K\n\6\3\6\5\6N\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6X\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6a\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\7\7h\n\7\f\7\16\7k\13\7\3\7\3\7\5\7o\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\5\ty\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0092\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009e\n\13\3\f"+
		"\3\f\3\f\3\f\3\f\5\f\u00a5\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ad\n\f\3"+
		"\f\3\f\5\f\u00b1\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u00bf\n\f\3\f\3\f\5\f\u00c3\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u00ca\n\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d8\n\r\3\r\5\r\u00db"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00e2\n\r\3\16\3\16\3\16\3\16\7\16\u00e8"+
		"\n\16\f\16\16\16\u00eb\13\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00f3"+
		"\n\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0117\n\21\3\21\3\21\3\21\5\21"+
		"\u011c\n\21\3\21\3\21\3\21\5\21\u0121\n\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\7\21\u013c\n\21\f\21\16\21\u013f\13\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u014a\n\22\3\23\3\23"+
		"\3\23\3\u00e9\3 \24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\f\4\2"+
		"9;==\3\2:;\3\2\4\6\4\2>>AA\4\2\27\27\31\34\4\2\26\26\30\30\3\2\22\25\3"+
		"\2\20\21\3\2?@\3\2)*\2\u0179\2&\3\2\2\2\4,\3\2\2\2\68\3\2\2\2\b:\3\2\2"+
		"\2\n`\3\2\2\2\fb\3\2\2\2\16p\3\2\2\2\20x\3\2\2\2\22z\3\2\2\2\24\u009d"+
		"\3\2\2\2\26\u00c2\3\2\2\2\30\u00e1\3\2\2\2\32\u00e3\3\2\2\2\34\u00f2\3"+
		"\2\2\2\36\u00f4\3\2\2\2 \u0120\3\2\2\2\"\u0149\3\2\2\2$\u014b\3\2\2\2"+
		"&\'\5\4\3\2\'(\7\2\2\3(\3\3\2\2\2)+\5\6\4\2*)\3\2\2\2+.\3\2\2\2,*\3\2"+
		"\2\2,-\3\2\2\2-\5\3\2\2\2.,\3\2\2\2/9\5\n\6\2\609\5\f\7\2\619\5\22\n\2"+
		"\629\5\24\13\2\639\5\36\20\2\649\5\26\f\2\659\5\30\r\2\669\5\34\17\2\67"+
		"9\5\32\16\28/\3\2\2\28\60\3\2\2\28\61\3\2\2\28\62\3\2\2\28\63\3\2\2\2"+
		"8\64\3\2\2\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29\7\3\2\2\2:;\7\2\2\3"+
		";\t\3\2\2\2<=\7>\2\2=?\7\"\2\2>@\t\2\2\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2"+
		"AB\5 \21\2BC\7!\2\2Ca\3\2\2\2DE\t\2\2\2EG\7>\2\2FH\7\"\2\2GF\3\2\2\2G"+
		"H\3\2\2\2HJ\3\2\2\2IK\t\2\2\2JI\3\2\2\2JK\3\2\2\2KM\3\2\2\2LN\5 \21\2"+
		"ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2Oa\7!\2\2PQ\7>\2\2QR\7\31\2\2Ra\7!\2\2S"+
		"T\7>\2\2TU\7\27\2\2Ua\7!\2\2VX\7=\2\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ"+
		"\7>\2\2Z[\7\"\2\2[\\\7\65\2\2\\a\7!\2\2]^\7>\2\2^_\7\"\2\2_a\5\32\16\2"+
		"`<\3\2\2\2`D\3\2\2\2`P\3\2\2\2`S\3\2\2\2`W\3\2\2\2`]\3\2\2\2a\13\3\2\2"+
		"\2bc\7,\2\2ci\5\16\b\2de\7-\2\2ef\7,\2\2fh\5\16\b\2gd\3\2\2\2hk\3\2\2"+
		"\2ig\3\2\2\2ij\3\2\2\2jn\3\2\2\2ki\3\2\2\2lm\7-\2\2mo\5\20\t\2nl\3\2\2"+
		"\2no\3\2\2\2o\r\3\2\2\2pq\5 \21\2qr\5\20\t\2r\17\3\2\2\2st\7%\2\2tu\5"+
		"\4\3\2uv\7&\2\2vy\3\2\2\2wy\5\6\4\2xs\3\2\2\2xw\3\2\2\2y\21\3\2\2\2z{"+
		"\7.\2\2{|\7#\2\2|}\5 \21\2}~\7$\2\2~\177\5\20\t\2\177\23\3\2\2\2\u0080"+
		"\u0081\7.\2\2\u0081\u0082\7#\2\2\u0082\u0083\5 \21\2\u0083\u0084\7$\2"+
		"\2\u0084\u0085\5\20\t\2\u0085\u009e\3\2\2\2\u0086\u0087\7\61\2\2\u0087"+
		"\u0088\5\20\t\2\u0088\u0089\7.\2\2\u0089\u008a\7#\2\2\u008a\u008b\5 \21"+
		"\2\u008b\u008c\7$\2\2\u008c\u008d\7!\2\2\u008d\u009e\3\2\2\2\u008e\u008f"+
		"\7\60\2\2\u008f\u0091\7#\2\2\u0090\u0092\t\3\2\2\u0091\u0090\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7>\2\2\u0094\u0095\7\""+
		"\2\2\u0095\u0096\5 \21\2\u0096\u0097\7!\2\2\u0097\u0098\5 \21\2\u0098"+
		"\u0099\7!\2\2\u0099\u009a\5 \21\2\u009a\u009b\7$\2\2\u009b\u009c\5\20"+
		"\t\2\u009c\u009e\3\2\2\2\u009d\u0080\3\2\2\2\u009d\u0086\3\2\2\2\u009d"+
		"\u008e\3\2\2\2\u009e\25\3\2\2\2\u009f\u00a0\7>\2\2\u00a0\u00a1\7\13\2"+
		"\2\u00a1\u00a2\7>\2\2\u00a2\u00a4\7#\2\2\u00a3\u00a5\t\2\2\2\u00a4\u00a3"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\5 \21\2\u00a7"+
		"\u00a8\7$\2\2\u00a8\u00a9\7\13\2\2\u00a9\u00aa\7\63\2\2\u00aa\u00ac\7"+
		"#\2\2\u00ab\u00ad\t\2\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00b0\3\2\2\2\u00ae\u00b1\5 \21\2\u00af\u00b1\7\64\2\2\u00b0\u00ae\3"+
		"\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7$\2\2\u00b3"+
		"\u00b4\7!\2\2\u00b4\u00c3\3\2\2\2\u00b5\u00b6\7>\2\2\u00b6\u00b7\7\13"+
		"\2\2\u00b7\u00b8\7>\2\2\u00b8\u00b9\7\3\2\2\u00b9\u00ba\7\13\2\2\u00ba"+
		"\u00bb\7\63\2\2\u00bb\u00be\7#\2\2\u00bc\u00bf\5 \21\2\u00bd\u00bf\7\64"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\7$\2\2\u00c1\u00c3\7!\2\2\u00c2\u009f\3\2\2\2\u00c2\u00b5\3\2\2"+
		"\2\u00c3\27\3\2\2\2\u00c4\u00c5\7>\2\2\u00c5\u00c6\7\13\2\2\u00c6\u00c7"+
		"\7>\2\2\u00c7\u00c9\7#\2\2\u00c8\u00ca\t\2\2\2\u00c9\u00c8\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\5 \21\2\u00cc\u00cd\7$"+
		"\2\2\u00cd\u00ce\7\13\2\2\u00ce\u00cf\7\62\2\2\u00cf\u00d0\7\3\2\2\u00d0"+
		"\u00d1\7!\2\2\u00d1\u00e2\3\2\2\2\u00d2\u00d3\7>\2\2\u00d3\u00d4\7\13"+
		"\2\2\u00d4\u00d5\7>\2\2\u00d5\u00d7\7#\2\2\u00d6\u00d8\t\2\2\2\u00d7\u00d6"+
		"\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00db\7\65\2\2"+
		"\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd"+
		"\7$\2\2\u00dd\u00de\7\13\2\2\u00de\u00df\7\62\2\2\u00df\u00e0\7\3\2\2"+
		"\u00e0\u00e2\7!\2\2\u00e1\u00c4\3\2\2\2\u00e1\u00d2\3\2\2\2\u00e2\31\3"+
		"\2\2\2\u00e3\u00e4\7>\2\2\u00e4\u00e5\7\13\2\2\u00e5\u00e9\t\4\2\2\u00e6"+
		"\u00e8\13\2\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00ea\3"+
		"\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ed\7!\2\2\u00ed\33\3\2\2\2\u00ee\u00ef\7\67\2\2\u00ef\u00f3\7!\2\2"+
		"\u00f0\u00f1\78\2\2\u00f1\u00f3\7!\2\2\u00f2\u00ee\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f3\35\3\2\2\2\u00f4\u00f5\7/\2\2\u00f5\u00f6\5 \21\2\u00f6"+
		"\u00f7\7!\2\2\u00f7\37\3\2\2\2\u00f8\u00f9\b\21\1\2\u00f9\u00fa\7\30\2"+
		"\2\u00fa\u0121\5 \21\23\u00fb\u00fc\7\36\2\2\u00fc\u0121\5 \21\22\u00fd"+
		"\u0121\7\65\2\2\u00fe\u0121\7\64\2\2\u00ff\u0121\5\"\22\2\u0100\u0121"+
		"\7\66\2\2\u0101\u0102\7>\2\2\u0102\u0103\7\13\2\2\u0103\u0104\7\7\2\2"+
		"\u0104\u0105\7#\2\2\u0105\u0106\t\5\2\2\u0106\u0121\7$\2\2\u0107\u0108"+
		"\t\5\2\2\u0108\u0109\7\13\2\2\u0109\u010a\7\b\2\2\u010a\u010b\7#\2\2\u010b"+
		"\u010c\5 \21\2\u010c\u010d\7\37\2\2\u010d\u010e\5 \21\2\u010e\u010f\7"+
		"$\2\2\u010f\u0121\3\2\2\2\u0110\u0111\t\5\2\2\u0111\u0112\7\13\2\2\u0112"+
		"\u0121\7\t\2\2\u0113\u0114\7\n\2\2\u0114\u0116\7#\2\2\u0115\u0117\7=\2"+
		"\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119"+
		"\t\5\2\2\u0119\u011b\7\37\2\2\u011a\u011c\7=\2\2\u011b\u011a\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\t\5\2\2\u011e\u0121\7$"+
		"\2\2\u011f\u0121\7I\2\2\u0120\u00f8\3\2\2\2\u0120\u00fb\3\2\2\2\u0120"+
		"\u00fd\3\2\2\2\u0120\u00fe\3\2\2\2\u0120\u00ff\3\2\2\2\u0120\u0100\3\2"+
		"\2\2\u0120\u0101\3\2\2\2\u0120\u0107\3\2\2\2\u0120\u0110\3\2\2\2\u0120"+
		"\u0113\3\2\2\2\u0120\u011f\3\2\2\2\u0121\u013d\3\2\2\2\u0122\u0123\f\26"+
		"\2\2\u0123\u0124\7\35\2\2\u0124\u013c\5 \21\27\u0125\u0126\f\21\2\2\u0126"+
		"\u0127\t\6\2\2\u0127\u013c\5 \21\22\u0128\u0129\f\20\2\2\u0129\u012a\t"+
		"\7\2\2\u012a\u013c\5 \21\21\u012b\u012c\f\17\2\2\u012c\u012d\t\b\2\2\u012d"+
		"\u013c\5 \21\20\u012e\u012f\f\16\2\2\u012f\u0130\t\t\2\2\u0130\u013c\5"+
		" \21\17\u0131\u0132\f\r\2\2\u0132\u0133\7\17\2\2\u0133\u013c\5 \21\16"+
		"\u0134\u0135\f\f\2\2\u0135\u0136\7\16\2\2\u0136\u013c\5 \21\r\u0137\u0138"+
		"\f\25\2\2\u0138\u013c\7\31\2\2\u0139\u013a\f\24\2\2\u013a\u013c\7\27\2"+
		"\2\u013b\u0122\3\2\2\2\u013b\u0125\3\2\2\2\u013b\u0128\3\2\2\2\u013b\u012b"+
		"\3\2\2\2\u013b\u012e\3\2\2\2\u013b\u0131\3\2\2\2\u013b\u0134\3\2\2\2\u013b"+
		"\u0137\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2"+
		"\2\2\u013d\u013e\3\2\2\2\u013e!\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141"+
		"\7#\2\2\u0141\u0142\5 \21\2\u0142\u0143\7$\2\2\u0143\u014a\3\2\2\2\u0144"+
		"\u014a\t\n\2\2\u0145\u014a\t\13\2\2\u0146\u014a\7>\2\2\u0147\u014a\7A"+
		"\2\2\u0148\u014a\7+\2\2\u0149\u0140\3\2\2\2\u0149\u0144\3\2\2\2\u0149"+
		"\u0145\3\2\2\2\u0149\u0146\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u0148\3\2"+
		"\2\2\u014a#\3\2\2\2\u014b\u014c\13\2\2\2\u014c%\3\2\2\2 ,8?GJMW`inx\u0091"+
		"\u009d\u00a4\u00ac\u00b0\u00be\u00c2\u00c9\u00d7\u00da\u00e1\u00e9\u00f2"+
		"\u0116\u011b\u0120\u013b\u013d\u0149";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}