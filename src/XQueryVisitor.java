// Generated from /Users/cc/Desktop/coursework/232b/xquery/hw1/src/XQuery.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code xqAp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqAp(XQueryParser.XqApContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqTwoSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqTwoSlash(XQueryParser.XqTwoSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqFLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqFLWR(XQueryParser.XqFLWRContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqSlash(XQueryParser.XqSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(XQueryParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqResult}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqResult(XQueryParser.XqResultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqBracket}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqBracket(XQueryParser.XqBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqLet}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqLet(XQueryParser.XqLetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConst}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConst(XQueryParser.StringConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code xqComma}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXqComma(XQueryParser.XqCommaContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condSomeSatisfy}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondSomeSatisfy(XQueryParser.CondSomeSatisfyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condEq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondEq(XQueryParser.CondEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condIs}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondIs(XQueryParser.CondIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condEmp}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondEmp(XQueryParser.CondEmpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condBracket}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondBracket(XQueryParser.CondBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondAnd(XQueryParser.CondAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondOr(XQueryParser.CondOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondNot(XQueryParser.CondNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(XQueryParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code apSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApSlash(XQueryParser.ApSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code apTwoSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApTwoSlash(XQueryParser.ApTwoSlashContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#filePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilePath(XQueryParser.FilePathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpText(XQueryParser.RpTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpChildren(XQueryParser.RpChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpAttName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpAttName(XQueryParser.RpAttNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpSlash(XQueryParser.RpSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpParent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpParent(XQueryParser.RpParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpTagName(XQueryParser.RpTagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpCurrent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpCurrent(XQueryParser.RpCurrentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpBracket}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpBracket(XQueryParser.RpBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpComma}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpComma(XQueryParser.RpCommaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpDoubleSlash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpDoubleSlash(XQueryParser.RpDoubleSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfRp}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfRp(XQueryParser.PfRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfBracket}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfBracket(XQueryParser.PfBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfIs}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfIs(XQueryParser.PfIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfNot}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfNot(XQueryParser.PfNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfEq}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfEq(XQueryParser.PfEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfAnd}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfAnd(XQueryParser.PfAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfOr}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfOr(XQueryParser.PfOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XQueryParser.FileNameContext ctx);
}