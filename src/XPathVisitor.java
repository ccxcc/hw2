// Generated from /Users/cc/Desktop/hw1/src/XPath.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPathParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPathVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code apSlash}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApSlash(XPathParser.ApSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code apTwoSlash}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApTwoSlash(XPathParser.ApTwoSlashContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#filePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilePath(XPathParser.FilePathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpText(XPathParser.RpTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpChildren}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpChildren(XPathParser.RpChildrenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpAttName}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpAttName(XPathParser.RpAttNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpSlash(XPathParser.RpSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpParent}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpParent(XPathParser.RpParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpTagName(XPathParser.RpTagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpCurrent}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpCurrent(XPathParser.RpCurrentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(XPathParser.RpFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpBracket}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpBracket(XPathParser.RpBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpComma}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpComma(XPathParser.RpCommaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpDoubleSlash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpDoubleSlash(XPathParser.RpDoubleSlashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfRp}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfRp(XPathParser.PfRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfBracket}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfBracket(XPathParser.PfBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfIs}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfIs(XPathParser.PfIsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfNot}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfNot(XPathParser.PfNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfEq}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfEq(XPathParser.PfEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfAnd}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfAnd(XPathParser.PfAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pfOr}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPfOr(XPathParser.PfOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XPathParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XPathParser.FileNameContext ctx);
}