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
		T__0=1, T__1=2, OR=3, AND=4, EQ=5, NEQ=6, GT=7, LT=8, GTEQ=9, LTEQ=10, 
		PLUS=11, PLUSPLUS=12, MINUS=13, MINUSMINUS=14, MULT=15, DIV=16, MOD=17, 
		POW=18, NOT=19, COMMA=20, COLON=21, SCOL=22, ASSIGN=23, OPAR=24, CPAR=25, 
		OBRACE=26, CBRACE=27, LBRACKET=28, RBRACKET=29, TRUE=30, FALSE=31, NIL=32, 
		IF=33, ELSE=34, WHILE=35, LOG=36, FOR=37, DO=38, SEND=39, SENDAT=40, BACKMSG=41, 
		GETNAME=42, RANDFUNC=43, SHOWHEAP=44, SHOWLISTSEND=45, INTVAR=46, DOUBLEVAR=47, 
		CHARVAR=48, STRINGVAR=49, ID=50, INT=51, FLOAT=52, STRING=53, COMMENT=54, 
		BLOCKCOMMENT=55, SPACE=56, NEWLINE=57, Space=58, IGNORE=59;
	public static final int
		RULE_parse = 0, RULE_block = 1, RULE_stat = 2, RULE_assignment = 3, RULE_if_stat = 4, 
		RULE_condition_block = 5, RULE_stat_block = 6, RULE_while_stat = 7, RULE_loop_stat = 8, 
		RULE_sendat_stat = 9, RULE_send_stat = 10, RULE_showContent_stat = 11, 
		RULE_log = 12, RULE_expr = 13, RULE_atom = 14, RULE_unknowns = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "block", "stat", "assignment", "if_stat", "condition_block", 
			"stat_block", "while_stat", "loop_stat", "sendat_stat", "send_stat", 
			"showContent_stat", "log", "expr", "atom", "unknowns"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'()'", "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", 
			"'<='", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", "'%'", "'^'", "'!'", 
			"','", "':'", "';'", "'='", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"'true'", "'false'", "'nil'", "'if'", "'else'", "'while'", "'log'", "'for'", 
			"'do'", "'send'", "'sendAt'", "'msg->sapIndex0_'", null, "'rand()'", 
			"'showHeap'", "'showListSendMsg'", "'int'", "'double'", "'char'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", 
			"PLUS", "PLUSPLUS", "MINUS", "MINUSMINUS", "MULT", "DIV", "MOD", "POW", 
			"NOT", "COMMA", "COLON", "SCOL", "ASSIGN", "OPAR", "CPAR", "OBRACE", 
			"CBRACE", "LBRACKET", "RBRACKET", "TRUE", "FALSE", "NIL", "IF", "ELSE", 
			"WHILE", "LOG", "FOR", "DO", "SEND", "SENDAT", "BACKMSG", "GETNAME", 
			"RANDFUNC", "SHOWHEAP", "SHOWLISTSEND", "INTVAR", "DOUBLEVAR", "CHARVAR", 
			"STRINGVAR", "ID", "INT", "FLOAT", "STRING", "COMMENT", "BLOCKCOMMENT", 
			"SPACE", "NEWLINE", "Space", "IGNORE"
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
			setState(32);
			block();
			setState(33);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(35);
					stat();
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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
		public UnknownsContext unknowns() {
			return getRuleContext(UnknownsContext.class,0);
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
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				if_stat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				while_stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				loop_stat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				log();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				sendat_stat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(47);
				send_stat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(48);
				showContent_stat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(49);
				unknowns();
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
		public TerminalNode INTVAR() { return getToken(ACParser.INTVAR, 0); }
		public TerminalNode DOUBLEVAR() { return getToken(ACParser.DOUBLEVAR, 0); }
		public TerminalNode STRINGVAR() { return getToken(ACParser.STRINGVAR, 0); }
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
		enterRule(_localctx, 6, RULE_assignment);
		int _la;
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new NormalAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(ID);
				setState(53);
				match(ASSIGN);
				setState(54);
				expr(0);
				setState(55);
				match(SCOL);
				}
				break;
			case 2:
				_localctx = new BasicAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				((BasicAssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTVAR) | (1L << DOUBLEVAR) | (1L << STRINGVAR))) != 0)) ) {
					((BasicAssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(58);
				match(ID);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(59);
					match(ASSIGN);
					}
				}

				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << OPAR) | (1L << TRUE) | (1L << FALSE) | (1L << NIL) | (1L << GETNAME) | (1L << RANDFUNC) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
					{
					setState(62);
					expr(0);
					}
				}

				setState(65);
				match(SCOL);
				}
				break;
			case 3:
				_localctx = new MinusminusAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(ID);
				setState(67);
				match(MINUSMINUS);
				setState(68);
				match(SCOL);
				}
				break;
			case 4:
				_localctx = new PlusplusAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				match(ID);
				setState(70);
				match(PLUSPLUS);
				setState(71);
				match(SCOL);
				}
				break;
			case 5:
				_localctx = new GetNameAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRINGVAR) {
					{
					setState(72);
					match(STRINGVAR);
					}
				}

				setState(75);
				match(ID);
				setState(76);
				match(ASSIGN);
				setState(77);
				match(GETNAME);
				setState(78);
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
		enterRule(_localctx, 8, RULE_if_stat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(IF);
			setState(82);
			condition_block();
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(83);
					match(ELSE);
					setState(84);
					match(IF);
					setState(85);
					condition_block();
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(91);
				match(ELSE);
				setState(92);
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
		enterRule(_localctx, 10, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			expr(0);
			setState(96);
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
		enterRule(_localctx, 12, RULE_stat_block);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(OBRACE);
				setState(99);
				block();
				setState(100);
				match(CBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				stat();
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
		enterRule(_localctx, 14, RULE_while_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(WHILE);
			setState(106);
			match(OPAR);
			setState(107);
			expr(0);
			setState(108);
			match(CPAR);
			setState(109);
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
		enterRule(_localctx, 16, RULE_loop_stat);
		int _la;
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(WHILE);
				setState(112);
				match(OPAR);
				setState(113);
				expr(0);
				setState(114);
				match(CPAR);
				setState(115);
				stat_block();
				}
				break;
			case DO:
				_localctx = new DoWhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(DO);
				setState(118);
				stat_block();
				setState(119);
				match(WHILE);
				setState(120);
				match(OPAR);
				setState(121);
				expr(0);
				setState(122);
				match(CPAR);
				setState(123);
				match(SCOL);
				}
				break;
			case FOR:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(FOR);
				setState(126);
				match(OPAR);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTVAR || _la==DOUBLEVAR) {
					{
					setState(127);
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

				setState(130);
				match(ID);
				setState(131);
				match(ASSIGN);
				setState(132);
				expr(0);
				setState(133);
				match(SCOL);
				setState(134);
				expr(0);
				setState(135);
				match(SCOL);
				setState(136);
				expr(0);
				setState(137);
				match(CPAR);
				setState(138);
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
		enterRule(_localctx, 18, RULE_sendat_stat);
		try {
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(ID);
				setState(143);
				match(T__0);
				setState(144);
				match(ID);
				setState(145);
				match(OPAR);
				setState(146);
				expr(0);
				setState(147);
				match(CPAR);
				setState(148);
				match(T__0);
				setState(149);
				match(SENDAT);
				setState(150);
				match(OPAR);
				setState(153);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MINUS:
				case NOT:
				case OPAR:
				case TRUE:
				case FALSE:
				case NIL:
				case GETNAME:
				case RANDFUNC:
				case ID:
				case INT:
				case FLOAT:
				case STRING:
					{
					setState(151);
					expr(0);
					}
					break;
				case BACKMSG:
					{
					setState(152);
					match(BACKMSG);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(155);
				match(CPAR);
				setState(156);
				match(SCOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(ID);
				setState(159);
				match(T__0);
				setState(160);
				match(ID);
				setState(161);
				match(T__1);
				setState(162);
				match(T__0);
				setState(163);
				match(SENDAT);
				setState(164);
				match(OPAR);
				setState(167);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MINUS:
				case NOT:
				case OPAR:
				case TRUE:
				case FALSE:
				case NIL:
				case GETNAME:
				case RANDFUNC:
				case ID:
				case INT:
				case FLOAT:
				case STRING:
					{
					setState(165);
					expr(0);
					}
					break;
				case BACKMSG:
					{
					setState(166);
					match(BACKMSG);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(169);
				match(CPAR);
				setState(170);
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
		public TerminalNode OPAR() { return getToken(ACParser.OPAR, 0); }
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public TerminalNode SEND() { return getToken(ACParser.SEND, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		enterRule(_localctx, 20, RULE_send_stat);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(ID);
				setState(174);
				match(T__0);
				setState(175);
				match(ID);
				setState(176);
				match(OPAR);
				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(177);
					expr(0);
					}
					break;
				case 2:
					{
					setState(178);
					match(GETNAME);
					}
					break;
				}
				setState(181);
				match(CPAR);
				setState(182);
				match(T__0);
				setState(183);
				match(SEND);
				setState(184);
				match(T__1);
				setState(185);
				match(SCOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(ID);
				setState(187);
				match(T__0);
				setState(188);
				match(ID);
				setState(189);
				match(T__1);
				setState(190);
				match(T__0);
				setState(191);
				match(SEND);
				setState(192);
				match(T__1);
				setState(193);
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
		enterRule(_localctx, 22, RULE_showContent_stat);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHOWHEAP:
				_localctx = new ShowHeapMemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(SHOWHEAP);
				setState(197);
				match(SCOL);
				}
				break;
			case SHOWLISTSEND:
				_localctx = new ShowListSendMsgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(SHOWLISTSEND);
				setState(199);
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
		enterRule(_localctx, 24, RULE_log);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(LOG);
			setState(203);
			expr(0);
			setState(204);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new UnaryMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(207);
				match(MINUS);
				setState(208);
				expr(11);
				}
				break;
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(NOT);
				setState(210);
				expr(10);
				}
				break;
			case RANDFUNC:
				{
				_localctx = new RandFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				match(RANDFUNC);
				}
				break;
			case GETNAME:
				{
				_localctx = new GetNameExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(GETNAME);
				}
				break;
			case OPAR:
			case TRUE:
			case FALSE:
			case NIL:
			case ID:
			case INT:
			case FLOAT:
			case STRING:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(241);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(216);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(217);
						match(POW);
						setState(218);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(219);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(220);
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
						setState(221);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new AdditiveExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(223);
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
						setState(224);
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(226);
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
						setState(227);
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(228);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(229);
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
						setState(230);
						expr(7);
						}
						break;
					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(231);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(232);
						match(AND);
						setState(233);
						expr(6);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(234);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(235);
						match(OR);
						setState(236);
						expr(5);
						}
						break;
					case 8:
						{
						_localctx = new MinusminusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(237);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(238);
						match(MINUSMINUS);
						}
						break;
					case 9:
						{
						_localctx = new PlusplusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(240);
						match(PLUSPLUS);
						}
						break;
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		enterRule(_localctx, 28, RULE_atom);
		int _la;
		try {
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAR:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(OPAR);
				setState(247);
				expr(0);
				setState(248);
				match(CPAR);
				}
				break;
			case INT:
			case FLOAT:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
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
				setState(251);
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
				setState(252);
				match(ID);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(253);
				match(STRING);
				}
				break;
			case NIL:
				_localctx = new NilAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(254);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).enterUnknowns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ACListener ) ((ACListener)listener).exitUnknowns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ACVisitor ) return ((ACVisitor<? extends T>)visitor).visitUnknowns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnknownsContext unknowns() throws RecognitionException {
		UnknownsContext _localctx = new UnknownsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unknowns);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
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
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u0106\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4\65\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\5\5\5B\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5L\n\5\3\5\3\5\3\5\3\5\5\5R\n\5\3\6\3\6\3"+
		"\6\3\6\3\6\7\6Y\n\6\f\6\16\6\\\13\6\3\6\3\6\5\6`\n\6\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\5\bj\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0083\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008f\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009c\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00aa\n\13\3\13\3\13\5\13\u00ae"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b6\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c5\n\f\3\r\3\r\3\r\3\r\5\r\u00cb\n\r"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d9"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00f4"+
		"\n\17\f\17\16\17\u00f7\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\5\20\u0102\n\20\3\21\3\21\3\21\2\3\34\22\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \2\n\4\2\60\61\63\63\3\2\60\61\4\2\16\16\20\23\4\2\r\r\17"+
		"\17\3\2\t\f\3\2\7\b\3\2\65\66\3\2 !\2\u0123\2\"\3\2\2\2\4(\3\2\2\2\6\64"+
		"\3\2\2\2\bQ\3\2\2\2\nS\3\2\2\2\fa\3\2\2\2\16i\3\2\2\2\20k\3\2\2\2\22\u008e"+
		"\3\2\2\2\24\u00ad\3\2\2\2\26\u00c4\3\2\2\2\30\u00ca\3\2\2\2\32\u00cc\3"+
		"\2\2\2\34\u00d8\3\2\2\2\36\u0101\3\2\2\2 \u0103\3\2\2\2\"#\5\4\3\2#$\7"+
		"\2\2\3$\3\3\2\2\2%\'\5\6\4\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2"+
		")\5\3\2\2\2*(\3\2\2\2+\65\5\b\5\2,\65\5\n\6\2-\65\5\20\t\2.\65\5\22\n"+
		"\2/\65\5\32\16\2\60\65\5\24\13\2\61\65\5\26\f\2\62\65\5\30\r\2\63\65\5"+
		" \21\2\64+\3\2\2\2\64,\3\2\2\2\64-\3\2\2\2\64.\3\2\2\2\64/\3\2\2\2\64"+
		"\60\3\2\2\2\64\61\3\2\2\2\64\62\3\2\2\2\64\63\3\2\2\2\65\7\3\2\2\2\66"+
		"\67\7\64\2\2\678\7\31\2\289\5\34\17\29:\7\30\2\2:R\3\2\2\2;<\t\2\2\2<"+
		">\7\64\2\2=?\7\31\2\2>=\3\2\2\2>?\3\2\2\2?A\3\2\2\2@B\5\34\17\2A@\3\2"+
		"\2\2AB\3\2\2\2BC\3\2\2\2CR\7\30\2\2DE\7\64\2\2EF\7\20\2\2FR\7\30\2\2G"+
		"H\7\64\2\2HI\7\16\2\2IR\7\30\2\2JL\7\63\2\2KJ\3\2\2\2KL\3\2\2\2LM\3\2"+
		"\2\2MN\7\64\2\2NO\7\31\2\2OP\7,\2\2PR\7\30\2\2Q\66\3\2\2\2Q;\3\2\2\2Q"+
		"D\3\2\2\2QG\3\2\2\2QK\3\2\2\2R\t\3\2\2\2ST\7#\2\2TZ\5\f\7\2UV\7$\2\2V"+
		"W\7#\2\2WY\5\f\7\2XU\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[_\3\2\2\2"+
		"\\Z\3\2\2\2]^\7$\2\2^`\5\16\b\2_]\3\2\2\2_`\3\2\2\2`\13\3\2\2\2ab\5\34"+
		"\17\2bc\5\16\b\2c\r\3\2\2\2de\7\34\2\2ef\5\4\3\2fg\7\35\2\2gj\3\2\2\2"+
		"hj\5\6\4\2id\3\2\2\2ih\3\2\2\2j\17\3\2\2\2kl\7%\2\2lm\7\32\2\2mn\5\34"+
		"\17\2no\7\33\2\2op\5\16\b\2p\21\3\2\2\2qr\7%\2\2rs\7\32\2\2st\5\34\17"+
		"\2tu\7\33\2\2uv\5\16\b\2v\u008f\3\2\2\2wx\7(\2\2xy\5\16\b\2yz\7%\2\2z"+
		"{\7\32\2\2{|\5\34\17\2|}\7\33\2\2}~\7\30\2\2~\u008f\3\2\2\2\177\u0080"+
		"\7\'\2\2\u0080\u0082\7\32\2\2\u0081\u0083\t\3\2\2\u0082\u0081\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\64\2\2\u0085\u0086"+
		"\7\31\2\2\u0086\u0087\5\34\17\2\u0087\u0088\7\30\2\2\u0088\u0089\5\34"+
		"\17\2\u0089\u008a\7\30\2\2\u008a\u008b\5\34\17\2\u008b\u008c\7\33\2\2"+
		"\u008c\u008d\5\16\b\2\u008d\u008f\3\2\2\2\u008eq\3\2\2\2\u008ew\3\2\2"+
		"\2\u008e\177\3\2\2\2\u008f\23\3\2\2\2\u0090\u0091\7\64\2\2\u0091\u0092"+
		"\7\3\2\2\u0092\u0093\7\64\2\2\u0093\u0094\7\32\2\2\u0094\u0095\5\34\17"+
		"\2\u0095\u0096\7\33\2\2\u0096\u0097\7\3\2\2\u0097\u0098\7*\2\2\u0098\u009b"+
		"\7\32\2\2\u0099\u009c\5\34\17\2\u009a\u009c\7+\2\2\u009b\u0099\3\2\2\2"+
		"\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\7\33\2\2\u009e\u009f"+
		"\7\30\2\2\u009f\u00ae\3\2\2\2\u00a0\u00a1\7\64\2\2\u00a1\u00a2\7\3\2\2"+
		"\u00a2\u00a3\7\64\2\2\u00a3\u00a4\7\4\2\2\u00a4\u00a5\7\3\2\2\u00a5\u00a6"+
		"\7*\2\2\u00a6\u00a9\7\32\2\2\u00a7\u00aa\5\34\17\2\u00a8\u00aa\7+\2\2"+
		"\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac"+
		"\7\33\2\2\u00ac\u00ae\7\30\2\2\u00ad\u0090\3\2\2\2\u00ad\u00a0\3\2\2\2"+
		"\u00ae\25\3\2\2\2\u00af\u00b0\7\64\2\2\u00b0\u00b1\7\3\2\2\u00b1\u00b2"+
		"\7\64\2\2\u00b2\u00b5\7\32\2\2\u00b3\u00b6\5\34\17\2\u00b4\u00b6\7,\2"+
		"\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8"+
		"\7\33\2\2\u00b8\u00b9\7\3\2\2\u00b9\u00ba\7)\2\2\u00ba\u00bb\7\4\2\2\u00bb"+
		"\u00c5\7\30\2\2\u00bc\u00bd\7\64\2\2\u00bd\u00be\7\3\2\2\u00be\u00bf\7"+
		"\64\2\2\u00bf\u00c0\7\4\2\2\u00c0\u00c1\7\3\2\2\u00c1\u00c2\7)\2\2\u00c2"+
		"\u00c3\7\4\2\2\u00c3\u00c5\7\30\2\2\u00c4\u00af\3\2\2\2\u00c4\u00bc\3"+
		"\2\2\2\u00c5\27\3\2\2\2\u00c6\u00c7\7.\2\2\u00c7\u00cb\7\30\2\2\u00c8"+
		"\u00c9\7/\2\2\u00c9\u00cb\7\30\2\2\u00ca\u00c6\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00cb\31\3\2\2\2\u00cc\u00cd\7&\2\2\u00cd\u00ce\5\34\17\2\u00ce\u00cf"+
		"\7\30\2\2\u00cf\33\3\2\2\2\u00d0\u00d1\b\17\1\2\u00d1\u00d2\7\17\2\2\u00d2"+
		"\u00d9\5\34\17\r\u00d3\u00d4\7\25\2\2\u00d4\u00d9\5\34\17\f\u00d5\u00d9"+
		"\7-\2\2\u00d6\u00d9\7,\2\2\u00d7\u00d9\5\36\20\2\u00d8\u00d0\3\2\2\2\u00d8"+
		"\u00d3\3\2\2\2\u00d8\u00d5\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2"+
		"\2\2\u00d9\u00f5\3\2\2\2\u00da\u00db\f\20\2\2\u00db\u00dc\7\24\2\2\u00dc"+
		"\u00f4\5\34\17\21\u00dd\u00de\f\13\2\2\u00de\u00df\t\4\2\2\u00df\u00f4"+
		"\5\34\17\f\u00e0\u00e1\f\n\2\2\u00e1\u00e2\t\5\2\2\u00e2\u00f4\5\34\17"+
		"\13\u00e3\u00e4\f\t\2\2\u00e4\u00e5\t\6\2\2\u00e5\u00f4\5\34\17\n\u00e6"+
		"\u00e7\f\b\2\2\u00e7\u00e8\t\7\2\2\u00e8\u00f4\5\34\17\t\u00e9\u00ea\f"+
		"\7\2\2\u00ea\u00eb\7\6\2\2\u00eb\u00f4\5\34\17\b\u00ec\u00ed\f\6\2\2\u00ed"+
		"\u00ee\7\5\2\2\u00ee\u00f4\5\34\17\7\u00ef\u00f0\f\17\2\2\u00f0\u00f4"+
		"\7\20\2\2\u00f1\u00f2\f\16\2\2\u00f2\u00f4\7\16\2\2\u00f3\u00da\3\2\2"+
		"\2\u00f3\u00dd\3\2\2\2\u00f3\u00e0\3\2\2\2\u00f3\u00e3\3\2\2\2\u00f3\u00e6"+
		"\3\2\2\2\u00f3\u00e9\3\2\2\2\u00f3\u00ec\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\35\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7\32\2\2\u00f9\u00fa"+
		"\5\34\17\2\u00fa\u00fb\7\33\2\2\u00fb\u0102\3\2\2\2\u00fc\u0102\t\b\2"+
		"\2\u00fd\u0102\t\t\2\2\u00fe\u0102\7\64\2\2\u00ff\u0102\7\67\2\2\u0100"+
		"\u0102\7\"\2\2\u0101\u00f8\3\2\2\2\u0101\u00fc\3\2\2\2\u0101\u00fd\3\2"+
		"\2\2\u0101\u00fe\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102"+
		"\37\3\2\2\2\u0103\u0104\13\2\2\2\u0104!\3\2\2\2\27(\64>AKQZ_i\u0082\u008e"+
		"\u009b\u00a9\u00ad\u00b5\u00c4\u00ca\u00d8\u00f3\u00f5\u0101";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}