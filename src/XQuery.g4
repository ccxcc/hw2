grammar XQuery;
import XPath;
xq : var             #variable
   | StringConstant  #stringConst
   | ap              #xqAp
   | '(' xq ')'      #xqBracket
   | xq ',' xq       #xqComma
   | xq '/' rp       #xqSlash
   | xq '//' rp      #xqTwoSlash
   | '<' ID '>' '{' xq '}' '<' '/' ID '>'  #xqResult
   | forClause letClause? whereClause? returnClause  #xqFLWR
   | letClause xq    #xqLet
   ;

forClause : 'for' var 'in' xq (','  var 'in' xq)*
          ;
letClause : 'let' var ':=' xq (',' var ':=' xq )*;
whereClause : 'where' cond;
returnClause : 'return' xq;

cond : xq '=' xq    #condEq
     | xq 'eq' xq   #condEq
     | xq '==' xq    #condIs
     | xq 'is' xq    #condIs
     | 'empty' '(' xq ')'  #condEmp
     | 'some' var 'in' xq (',' var 'in' xq)* 'satisfies' cond #condSomeSatisfy
     | '(' cond ')'              #condBracket
     | cond 'and' cond           #condAnd
     | cond 'or' cond            #condOr
     | 'not' cond                #condNot
     ;



var :'$' ID
    ;
StringConstant: '"'+[a-zA-Z0-9,.!?; ''""-]+'"';