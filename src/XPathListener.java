// Generated from /Users/cc/Desktop/hw1/src/XPath.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code apSlash}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterApSlash(XPathParser.ApSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code apSlash}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitApSlash(XPathParser.ApSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code apTwoSlash}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterApTwoSlash(XPathParser.ApTwoSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code apTwoSlash}
	 * labeled alternative in {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitApTwoSlash(XPathParser.ApTwoSlashContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#filePath}.
	 * @param ctx the parse tree
	 */
	void enterFilePath(XPathParser.FilePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#filePath}.
	 * @param ctx the parse tree
	 */
	void exitFilePath(XPathParser.FilePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpText(XPathParser.RpTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpText(XPathParser.RpTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpChildren}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpChildren(XPathParser.RpChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpChildren}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpChildren(XPathParser.RpChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpAttName}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpAttName(XPathParser.RpAttNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpAttName}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpAttName(XPathParser.RpAttNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpSlash(XPathParser.RpSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpSlash(XPathParser.RpSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpParent}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpParent(XPathParser.RpParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpParent}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpParent(XPathParser.RpParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpTagName(XPathParser.RpTagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpTagName(XPathParser.RpTagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpCurrent}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpCurrent(XPathParser.RpCurrentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpCurrent}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpCurrent(XPathParser.RpCurrentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(XPathParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(XPathParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpBracket}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpBracket(XPathParser.RpBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpBracket}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpBracket(XPathParser.RpBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpComma}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpComma(XPathParser.RpCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpComma}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpComma(XPathParser.RpCommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpDoubleSlash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpDoubleSlash(XPathParser.RpDoubleSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpDoubleSlash}
	 * labeled alternative in {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpDoubleSlash(XPathParser.RpDoubleSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfRp}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfRp(XPathParser.PfRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfRp}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfRp(XPathParser.PfRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfBracket}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfBracket(XPathParser.PfBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfBracket}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfBracket(XPathParser.PfBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfIs}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfIs(XPathParser.PfIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfIs}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfIs(XPathParser.PfIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfNot}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfNot(XPathParser.PfNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfNot}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfNot(XPathParser.PfNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfEq}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfEq(XPathParser.PfEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfEq}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfEq(XPathParser.PfEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfAnd}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfAnd(XPathParser.PfAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfAnd}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfAnd(XPathParser.PfAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfOr}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfOr(XPathParser.PfOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfOr}
	 * labeled alternative in {@link XPathParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfOr(XPathParser.PfOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XPathParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XPathParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XPathParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(XPathParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(XPathParser.FileNameContext ctx);
}