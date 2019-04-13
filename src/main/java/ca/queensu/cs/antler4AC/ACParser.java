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
		T__0=1, T__1=2, INTVAR=3, DOUBLEVAR=4, STRINGVAR=5, OR=6, AND=7, EQ=8, 
		NEQ=9, GT=10, LT=11, GTEQ=12, LTEQ=13, PLUS=14, PLUSPLUS=15, MINUS=16, 
		MINUSMINUS=17, MULT=18, DIV=19, MOD=20, POW=21, NOT=22, COMMA=23, COLON=24, 
		SCOL=25, ASSIGN=26, OPAR=27, CPAR=28, OBRACE=29, CBRACE=30, LBRACKET=31, 
		RBRACKET=32, TRUE=33, FALSE=34, NIL=35, IF=36, ELSE=37, WHILE=38, LOG=39, 
		FOR=40, DO=41, SEND=42, SENDAT=43, BACKMSG=44, SHOWHEAP=45, SHOWLISTSEND=46, 
		ID=47, INT=48, FLOAT=49, STRING=50, COMMENT=51, BLOCKCOMMENT=52, SPACE=53, 
		NEWLINE=54;
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

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		int _la;
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
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
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << OPAR) | (1L << TRUE) | (1L << FALSE) | (1L << NIL) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
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
			setState(74);
			match(IF);
			setState(75);
			condition_block();
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(76);
					match(ELSE);
					setState(77);
					match(IF);
					setState(78);
					condition_block();
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(84);
				match(ELSE);
				setState(85);
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
			setState(88);
			expr(0);
			setState(89);
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
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(OBRACE);
				setState(92);
				block();
				setState(93);
				match(CBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
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
			setState(98);
			match(WHILE);
			setState(99);
			match(OPAR);
			setState(100);
			expr(0);
			setState(101);
			match(CPAR);
			setState(102);
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
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(WHILE);
				setState(105);
				match(OPAR);
				setState(106);
				expr(0);
				setState(107);
				match(CPAR);
				setState(108);
				stat_block();
				}
				break;
			case DO:
				_localctx = new DoWhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(DO);
				setState(111);
				stat_block();
				setState(112);
				match(WHILE);
				setState(113);
				match(OPAR);
				setState(114);
				expr(0);
				setState(115);
				match(CPAR);
				setState(116);
				match(SCOL);
				}
				break;
			case FOR:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(FOR);
				setState(119);
				match(OPAR);
				setState(120);
				match(ID);
				setState(121);
				match(ASSIGN);
				setState(122);
				expr(0);
				setState(123);
				match(SCOL);
				setState(124);
				expr(0);
				setState(125);
				match(SCOL);
				setState(126);
				expr(0);
				setState(127);
				match(CPAR);
				setState(128);
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
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(ID);
				setState(133);
				match(T__0);
				setState(134);
				match(ID);
				setState(135);
				match(OPAR);
				setState(136);
				expr(0);
				setState(137);
				match(CPAR);
				setState(138);
				match(T__0);
				setState(139);
				match(SENDAT);
				setState(140);
				match(OPAR);
				setState(143);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MINUS:
				case NOT:
				case OPAR:
				case TRUE:
				case FALSE:
				case NIL:
				case ID:
				case INT:
				case FLOAT:
				case STRING:
					{
					setState(141);
					expr(0);
					}
					break;
				case BACKMSG:
					{
					setState(142);
					match(BACKMSG);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(145);
				match(CPAR);
				setState(146);
				match(SCOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(ID);
				setState(149);
				match(T__0);
				setState(150);
				match(ID);
				setState(151);
				match(T__1);
				setState(152);
				match(T__0);
				setState(153);
				match(SENDAT);
				setState(154);
				match(OPAR);
				setState(157);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MINUS:
				case NOT:
				case OPAR:
				case TRUE:
				case FALSE:
				case NIL:
				case ID:
				case INT:
				case FLOAT:
				case STRING:
					{
					setState(155);
					expr(0);
					}
					break;
				case BACKMSG:
					{
					setState(156);
					match(BACKMSG);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(159);
				match(CPAR);
				setState(160);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(ACParser.CPAR, 0); }
		public TerminalNode SEND() { return getToken(ACParser.SEND, 0); }
		public TerminalNode SCOL() { return getToken(ACParser.SCOL, 0); }
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
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(ID);
				setState(164);
				match(T__0);
				setState(165);
				match(ID);
				setState(166);
				match(OPAR);
				setState(167);
				expr(0);
				setState(168);
				match(CPAR);
				setState(169);
				match(T__0);
				setState(170);
				match(SEND);
				setState(171);
				match(T__1);
				setState(172);
				match(SCOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(ID);
				setState(175);
				match(T__0);
				setState(176);
				match(ID);
				setState(177);
				match(T__1);
				setState(178);
				match(T__0);
				setState(179);
				match(SEND);
				setState(180);
				match(T__1);
				setState(181);
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
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHOWHEAP:
				_localctx = new ShowHeapMemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(SHOWHEAP);
				setState(185);
				match(SCOL);
				}
				break;
			case SHOWLISTSEND:
				_localctx = new ShowListSendMsgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(SHOWLISTSEND);
				setState(187);
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
			setState(190);
			match(LOG);
			setState(191);
			expr(0);
			setState(192);
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
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new UnaryMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(195);
				match(MINUS);
				setState(196);
				expr(11);
				}
				break;
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(NOT);
				setState(198);
				expr(10);
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
				setState(199);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(227);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(202);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(203);
						match(POW);
						setState(204);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(206);
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
						setState(207);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new AdditiveExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(209);
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
						setState(210);
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(211);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(212);
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
						setState(213);
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(214);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(215);
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
						setState(216);
						expr(7);
						}
						break;
					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(217);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(218);
						match(AND);
						setState(219);
						expr(6);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(220);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(221);
						match(OR);
						setState(222);
						expr(5);
						}
						break;
					case 8:
						{
						_localctx = new MinusminusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(223);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(224);
						match(MINUSMINUS);
						}
						break;
					case 9:
						{
						_localctx = new PlusplusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(226);
						match(PLUSPLUS);
						}
						break;
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAR:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				match(OPAR);
				setState(233);
				expr(0);
				setState(234);
				match(CPAR);
				}
				break;
			case INT:
			case FLOAT:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
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
				setState(237);
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
				setState(238);
				match(ID);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				match(STRING);
				}
				break;
			case NIL:
				_localctx = new NilAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(240);
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
			setState(243);
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
			return precpred(_ctx, 12);
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
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u00f8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4\65\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\5\5\5B\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5K\n\5\3\6\3\6\3\6\3\6\3\6\7\6R\n\6\f\6\16\6"+
		"U\13\6\3\6\3\6\5\6Y\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\bc\n\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0085\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0092\n\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a0\n\13"+
		"\3\13\3\13\5\13\u00a4\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b9\n\f\3\r\3\r\3\r\3\r\5\r\u00bf"+
		"\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00cb\n\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00e6\n\17"+
		"\f\17\16\17\u00e9\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\u00f4\n\20\3\21\3\21\3\21\2\3\34\22\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \2\t\3\2\5\7\4\2\21\21\23\26\4\2\20\20\22\22\3\2\f\17\3\2\n"+
		"\13\3\2\62\63\3\2#$\2\u010f\2\"\3\2\2\2\4(\3\2\2\2\6\64\3\2\2\2\bJ\3\2"+
		"\2\2\nL\3\2\2\2\fZ\3\2\2\2\16b\3\2\2\2\20d\3\2\2\2\22\u0084\3\2\2\2\24"+
		"\u00a3\3\2\2\2\26\u00b8\3\2\2\2\30\u00be\3\2\2\2\32\u00c0\3\2\2\2\34\u00ca"+
		"\3\2\2\2\36\u00f3\3\2\2\2 \u00f5\3\2\2\2\"#\5\4\3\2#$\7\2\2\3$\3\3\2\2"+
		"\2%\'\5\6\4\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*(\3"+
		"\2\2\2+\65\5\b\5\2,\65\5\n\6\2-\65\5\20\t\2.\65\5\22\n\2/\65\5\32\16\2"+
		"\60\65\5\24\13\2\61\65\5\26\f\2\62\65\5\30\r\2\63\65\5 \21\2\64+\3\2\2"+
		"\2\64,\3\2\2\2\64-\3\2\2\2\64.\3\2\2\2\64/\3\2\2\2\64\60\3\2\2\2\64\61"+
		"\3\2\2\2\64\62\3\2\2\2\64\63\3\2\2\2\65\7\3\2\2\2\66\67\7\61\2\2\678\7"+
		"\34\2\289\5\34\17\29:\7\33\2\2:K\3\2\2\2;<\t\2\2\2<>\7\61\2\2=?\7\34\2"+
		"\2>=\3\2\2\2>?\3\2\2\2?A\3\2\2\2@B\5\34\17\2A@\3\2\2\2AB\3\2\2\2BC\3\2"+
		"\2\2CK\7\33\2\2DE\7\61\2\2EF\7\23\2\2FK\7\33\2\2GH\7\61\2\2HI\7\21\2\2"+
		"IK\7\33\2\2J\66\3\2\2\2J;\3\2\2\2JD\3\2\2\2JG\3\2\2\2K\t\3\2\2\2LM\7&"+
		"\2\2MS\5\f\7\2NO\7\'\2\2OP\7&\2\2PR\5\f\7\2QN\3\2\2\2RU\3\2\2\2SQ\3\2"+
		"\2\2ST\3\2\2\2TX\3\2\2\2US\3\2\2\2VW\7\'\2\2WY\5\16\b\2XV\3\2\2\2XY\3"+
		"\2\2\2Y\13\3\2\2\2Z[\5\34\17\2[\\\5\16\b\2\\\r\3\2\2\2]^\7\37\2\2^_\5"+
		"\4\3\2_`\7 \2\2`c\3\2\2\2ac\5\6\4\2b]\3\2\2\2ba\3\2\2\2c\17\3\2\2\2de"+
		"\7(\2\2ef\7\35\2\2fg\5\34\17\2gh\7\36\2\2hi\5\16\b\2i\21\3\2\2\2jk\7("+
		"\2\2kl\7\35\2\2lm\5\34\17\2mn\7\36\2\2no\5\16\b\2o\u0085\3\2\2\2pq\7+"+
		"\2\2qr\5\16\b\2rs\7(\2\2st\7\35\2\2tu\5\34\17\2uv\7\36\2\2vw\7\33\2\2"+
		"w\u0085\3\2\2\2xy\7*\2\2yz\7\35\2\2z{\7\61\2\2{|\7\34\2\2|}\5\34\17\2"+
		"}~\7\33\2\2~\177\5\34\17\2\177\u0080\7\33\2\2\u0080\u0081\5\34\17\2\u0081"+
		"\u0082\7\36\2\2\u0082\u0083\5\16\b\2\u0083\u0085\3\2\2\2\u0084j\3\2\2"+
		"\2\u0084p\3\2\2\2\u0084x\3\2\2\2\u0085\23\3\2\2\2\u0086\u0087\7\61\2\2"+
		"\u0087\u0088\7\3\2\2\u0088\u0089\7\61\2\2\u0089\u008a\7\35\2\2\u008a\u008b"+
		"\5\34\17\2\u008b\u008c\7\36\2\2\u008c\u008d\7\3\2\2\u008d\u008e\7-\2\2"+
		"\u008e\u0091\7\35\2\2\u008f\u0092\5\34\17\2\u0090\u0092\7.\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\36\2\2"+
		"\u0094\u0095\7\33\2\2\u0095\u00a4\3\2\2\2\u0096\u0097\7\61\2\2\u0097\u0098"+
		"\7\3\2\2\u0098\u0099\7\61\2\2\u0099\u009a\7\4\2\2\u009a\u009b\7\3\2\2"+
		"\u009b\u009c\7-\2\2\u009c\u009f\7\35\2\2\u009d\u00a0\5\34\17\2\u009e\u00a0"+
		"\7.\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a2\7\36\2\2\u00a2\u00a4\7\33\2\2\u00a3\u0086\3\2\2\2\u00a3\u0096\3"+
		"\2\2\2\u00a4\25\3\2\2\2\u00a5\u00a6\7\61\2\2\u00a6\u00a7\7\3\2\2\u00a7"+
		"\u00a8\7\61\2\2\u00a8\u00a9\7\35\2\2\u00a9\u00aa\5\34\17\2\u00aa\u00ab"+
		"\7\36\2\2\u00ab\u00ac\7\3\2\2\u00ac\u00ad\7,\2\2\u00ad\u00ae\7\4\2\2\u00ae"+
		"\u00af\7\33\2\2\u00af\u00b9\3\2\2\2\u00b0\u00b1\7\61\2\2\u00b1\u00b2\7"+
		"\3\2\2\u00b2\u00b3\7\61\2\2\u00b3\u00b4\7\4\2\2\u00b4\u00b5\7\3\2\2\u00b5"+
		"\u00b6\7,\2\2\u00b6\u00b7\7\4\2\2\u00b7\u00b9\7\33\2\2\u00b8\u00a5\3\2"+
		"\2\2\u00b8\u00b0\3\2\2\2\u00b9\27\3\2\2\2\u00ba\u00bb\7/\2\2\u00bb\u00bf"+
		"\7\33\2\2\u00bc\u00bd\7\60\2\2\u00bd\u00bf\7\33\2\2\u00be\u00ba\3\2\2"+
		"\2\u00be\u00bc\3\2\2\2\u00bf\31\3\2\2\2\u00c0\u00c1\7)\2\2\u00c1\u00c2"+
		"\5\34\17\2\u00c2\u00c3\7\33\2\2\u00c3\33\3\2\2\2\u00c4\u00c5\b\17\1\2"+
		"\u00c5\u00c6\7\22\2\2\u00c6\u00cb\5\34\17\r\u00c7\u00c8\7\30\2\2\u00c8"+
		"\u00cb\5\34\17\f\u00c9\u00cb\5\36\20\2\u00ca\u00c4\3\2\2\2\u00ca\u00c7"+
		"\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00e7\3\2\2\2\u00cc\u00cd\f\16\2\2"+
		"\u00cd\u00ce\7\27\2\2\u00ce\u00e6\5\34\17\17\u00cf\u00d0\f\13\2\2\u00d0"+
		"\u00d1\t\3\2\2\u00d1\u00e6\5\34\17\f\u00d2\u00d3\f\n\2\2\u00d3\u00d4\t"+
		"\4\2\2\u00d4\u00e6\5\34\17\13\u00d5\u00d6\f\t\2\2\u00d6\u00d7\t\5\2\2"+
		"\u00d7\u00e6\5\34\17\n\u00d8\u00d9\f\b\2\2\u00d9\u00da\t\6\2\2\u00da\u00e6"+
		"\5\34\17\t\u00db\u00dc\f\7\2\2\u00dc\u00dd\7\t\2\2\u00dd\u00e6\5\34\17"+
		"\b\u00de\u00df\f\6\2\2\u00df\u00e0\7\b\2\2\u00e0\u00e6\5\34\17\7\u00e1"+
		"\u00e2\f\5\2\2\u00e2\u00e6\7\23\2\2\u00e3\u00e4\f\4\2\2\u00e4\u00e6\7"+
		"\21\2\2\u00e5\u00cc\3\2\2\2\u00e5\u00cf\3\2\2\2\u00e5\u00d2\3\2\2\2\u00e5"+
		"\u00d5\3\2\2\2\u00e5\u00d8\3\2\2\2\u00e5\u00db\3\2\2\2\u00e5\u00de\3\2"+
		"\2\2\u00e5\u00e1\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\35\3\2\2\2\u00e9\u00e7\3\2\2"+
		"\2\u00ea\u00eb\7\35\2\2\u00eb\u00ec\5\34\17\2\u00ec\u00ed\7\36\2\2\u00ed"+
		"\u00f4\3\2\2\2\u00ee\u00f4\t\7\2\2\u00ef\u00f4\t\b\2\2\u00f0\u00f4\7\61"+
		"\2\2\u00f1\u00f4\7\64\2\2\u00f2\u00f4\7%\2\2\u00f3\u00ea\3\2\2\2\u00f3"+
		"\u00ee\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f3\u00f2\3\2\2\2\u00f4\37\3\2\2\2\u00f5\u00f6\13\2\2\2\u00f6!"+
		"\3\2\2\2\24(\64>AJSXb\u0084\u0091\u009f\u00a3\u00b8\u00be\u00ca\u00e5"+
		"\u00e7\u00f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}