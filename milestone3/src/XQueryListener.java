// Generated from /Users/cc/Desktop/coursework/232b/xquery/hw2/src/XQuery.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code xqAp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqAp(XQueryParser.XqApContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqAp}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqAp(XQueryParser.XqApContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqTwoSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqTwoSlash(XQueryParser.XqTwoSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqTwoSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqTwoSlash(XQueryParser.XqTwoSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqFLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqFLWR(XQueryParser.XqFLWRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqFLWR}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqFLWR(XQueryParser.XqFLWRContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XqJoin}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqJoin(XQueryParser.XqJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XqJoin}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqJoin(XQueryParser.XqJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqSlash(XQueryParser.XqSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqSlash}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqSlash(XQueryParser.XqSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterVariable(XQueryParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitVariable(XQueryParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqResult}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqResult(XQueryParser.XqResultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqResult}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqResult(XQueryParser.XqResultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqBracket}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqBracket(XQueryParser.XqBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqBracket}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqBracket(XQueryParser.XqBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqLet}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqLet(XQueryParser.XqLetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqLet}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqLet(XQueryParser.XqLetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConst}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterStringConst(XQueryParser.StringConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConst}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitStringConst(XQueryParser.StringConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xqComma}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXqComma(XQueryParser.XqCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xqComma}
	 * labeled alternative in {@link XQueryParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXqComma(XQueryParser.XqCommaContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinClause(XQueryParser.JoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinClause(XQueryParser.JoinClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#attlist}.
	 * @param ctx the parse tree
	 */
	void enterAttlist(XQueryParser.AttlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#attlist}.
	 * @param ctx the parse tree
	 */
	void exitAttlist(XQueryParser.AttlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condSomeSatisfy}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondSomeSatisfy(XQueryParser.CondSomeSatisfyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condSomeSatisfy}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondSomeSatisfy(XQueryParser.CondSomeSatisfyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condEq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondEq(XQueryParser.CondEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condEq}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondEq(XQueryParser.CondEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condIs}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondIs(XQueryParser.CondIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condIs}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondIs(XQueryParser.CondIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condEmp}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondEmp(XQueryParser.CondEmpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condEmp}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondEmp(XQueryParser.CondEmpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condBracket}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondBracket(XQueryParser.CondBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condBracket}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondBracket(XQueryParser.CondBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondAnd(XQueryParser.CondAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condAnd}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondAnd(XQueryParser.CondAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondOr(XQueryParser.CondOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condOr}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondOr(XQueryParser.CondOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondNot(XQueryParser.CondNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condNot}
	 * labeled alternative in {@link XQueryParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondNot(XQueryParser.CondNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(XQueryParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(XQueryParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code apSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterApSlash(XQueryParser.ApSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code apSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitApSlash(XQueryParser.ApSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code apTwoSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterApTwoSlash(XQueryParser.ApTwoSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code apTwoSlash}
	 * labeled alternative in {@link XQueryParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitApTwoSlash(XQueryParser.ApTwoSlashContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#filePath}.
	 * @param ctx the parse tree
	 */
	void enterFilePath(XQueryParser.FilePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#filePath}.
	 * @param ctx the parse tree
	 */
	void exitFilePath(XQueryParser.FilePathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpText(XQueryParser.RpTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpText}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpText(XQueryParser.RpTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpChildren(XQueryParser.RpChildrenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpChildren}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpChildren(XQueryParser.RpChildrenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpAttName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpAttName(XQueryParser.RpAttNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpAttName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpAttName(XQueryParser.RpAttNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpSlash(XQueryParser.RpSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpSlash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpSlash(XQueryParser.RpSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpParent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpParent(XQueryParser.RpParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpParent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpParent(XQueryParser.RpParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpTagName(XQueryParser.RpTagNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpTagName}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpTagName(XQueryParser.RpTagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpCurrent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpCurrent(XQueryParser.RpCurrentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpCurrent}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpCurrent(XQueryParser.RpCurrentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpBracket}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpBracket(XQueryParser.RpBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpBracket}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpBracket(XQueryParser.RpBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpComma}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpComma(XQueryParser.RpCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpComma}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpComma(XQueryParser.RpCommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpDoubleSlash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRpDoubleSlash(XQueryParser.RpDoubleSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpDoubleSlash}
	 * labeled alternative in {@link XQueryParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRpDoubleSlash(XQueryParser.RpDoubleSlashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfRp}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfRp(XQueryParser.PfRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfRp}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfRp(XQueryParser.PfRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfBracket}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfBracket(XQueryParser.PfBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfBracket}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfBracket(XQueryParser.PfBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfIs}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfIs(XQueryParser.PfIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfIs}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfIs(XQueryParser.PfIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfNot}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfNot(XQueryParser.PfNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfNot}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfNot(XQueryParser.PfNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfEq}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfEq(XQueryParser.PfEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfEq}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfEq(XQueryParser.PfEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfAnd}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfAnd(XQueryParser.PfAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfAnd}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfAnd(XQueryParser.PfAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pfOr}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPfOr(XQueryParser.PfOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pfOr}
	 * labeled alternative in {@link XQueryParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPfOr(XQueryParser.PfOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XQueryParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(XQueryParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(XQueryParser.FileNameContext ctx);
}