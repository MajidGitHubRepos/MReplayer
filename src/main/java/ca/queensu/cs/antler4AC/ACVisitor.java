package ca.queensu.cs.antler4AC; // Generated from AC.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ACParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ACVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ACParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(ACParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ACParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ACParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ACParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(ACParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code normalAssignment}
	 * labeled alternative in {@link ACParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalAssignment(ACParser.NormalAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicAssignment}
	 * labeled alternative in {@link ACParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicAssignment(ACParser.BasicAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusminusAssignment}
	 * labeled alternative in {@link ACParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusminusAssignment(ACParser.MinusminusAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusplusAssignment}
	 * labeled alternative in {@link ACParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusplusAssignment(ACParser.PlusplusAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ACParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(ACParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link ACParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(ACParser.Condition_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ACParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(ACParser.Stat_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ACParser#while_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stat(ACParser.While_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link ACParser#loop_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(ACParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doWhileLoop}
	 * labeled alternative in {@link ACParser#loop_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileLoop(ACParser.DoWhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link ACParser#loop_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(ACParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ACParser#sendat_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSendat_stat(ACParser.Sendat_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link ACParser#send_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSend_stat(ACParser.Send_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showHeapMem}
	 * labeled alternative in {@link ACParser#showContent_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowHeapMem(ACParser.ShowHeapMemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showListSendMsg}
	 * labeled alternative in {@link ACParser#showContent_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowListSendMsg(ACParser.ShowListSendMsgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ACParser#log}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLog(ACParser.LogContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(ACParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpr(ACParser.UnaryMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(ACParser.MultiplicationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusminusExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusminusExpr(ACParser.MinusminusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(ACParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(ACParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusplusExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusplusExpr(ACParser.PlusplusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(ACParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(ACParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(ACParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(ACParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link ACParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(ACParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link ACParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(ACParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link ACParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(ACParser.NumberAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link ACParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(ACParser.BooleanAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link ACParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(ACParser.IdAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link ACParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(ACParser.StringAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nilAtom}
	 * labeled alternative in {@link ACParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNilAtom(ACParser.NilAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ACParser#unknowns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnknowns(ACParser.UnknownsContext ctx);
}