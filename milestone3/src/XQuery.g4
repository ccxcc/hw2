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
   | joinClause		#XqJoin

//   | 'join' '(' xq ',' xq ',' attlist ',' attlist ')'  #xqJoin
//   | 'for' var 'in' path (','  var 'in' path)* 'where' condJoin 'return' returnJoin #xqforpath
   ;
   joinClause
   	: 'join' '(' xq ',' xq ',' attlist ',' attlist ')'
   	;
//path : (filePath|var) Sep rp #pathvar
//     | (filePath|var) Sep rp #pathtext
//     ;
//Sep :  '/'
//    |  '//';
//returnJoin : var
//           | returnJoin ',' returnJoin
//           | '<' ID '>' returnJoin '<' '/' ID '>'
//           | path
//           ;
//condJoin : (var | constant) 'eq' (var|constant) #condJoinEq
//         | condJoin 'and' condJoin #condJoinAnd
//         ;
//constant : ID
//         ;

attlist : '[' ID (',' ID)*']';

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
StringConstant: '"'+[a-zA-Z0-9,.!?; '"-]+'"';