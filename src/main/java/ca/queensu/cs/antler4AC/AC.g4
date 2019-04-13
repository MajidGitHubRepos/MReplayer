grammar AC;

parse
 : block EOF
 ;

block
 : stat*
 ;

stat
 : assignment
 | if_stat
 | while_stat
 | loop_stat
 | log
 | sendat_stat
 | send_stat
 | showContent_stat
 | unknowns
 ;

assignment
 : ID ASSIGN expr SCOL     										 #normalAssignment
 | op=(INTVAR | DOUBLEVAR | STRINGVAR) ID ASSIGN? expr? SCOL	 #basicAssignment
 | ID MINUSMINUS SCOL       									 #minusminusAssignment
 | ID PLUSPLUS SCOL	    										 #plusplusAssignment
 ;

if_stat
 : IF condition_block (ELSE IF condition_block)* (ELSE stat_block)?
 ;

condition_block
 : expr stat_block
 ;

stat_block
 : OBRACE block CBRACE
 | stat
 ;

while_stat
 : WHILE OPAR expr CPAR stat_block
 ;
 
loop_stat
   : WHILE '(' expr ')' stat_block                     			#whileLoop
   | DO stat_block WHILE '(' expr ')' ';'			   			#doWhileLoop
   | FOR '(' ID ASSIGN expr ';' expr ';' expr ')' stat_block    #forLoop
   ;
 
sendat_stat
   : ID '.' ID '(' expr ')' '.' SENDAT '(' (expr | BACKMSG) ')' SCOL
   | ID '.' ID '()' '.' SENDAT '(' (expr | BACKMSG) ')' SCOL
   ;

send_stat
   : ID '.' ID '(' expr ')' '.' SEND '()' SCOL
   | ID '.' ID '()' '.' SEND '()' SCOL
   ;

showContent_stat
   : SHOWHEAP SCOL     #showHeapMem
   | SHOWLISTSEND SCOL #showListSendMsg
   ;

log
 : LOG expr SCOL
 ;

expr
 : expr POW<assoc=right> expr           						#powExpr
 | MINUS expr                          							#unaryMinusExpr
 | NOT expr                             						#notExpr
 | expr op=(MULT | DIV | MOD | MINUSMINUS | PLUSPLUS) expr      #multiplicationExpr
 | expr op=(PLUS | MINUS) expr          						#additiveExpr
 | expr op=(LTEQ | GTEQ | LT | GT) expr 						#relationalExpr
 | expr op=(EQ | NEQ) expr              						#equalityExpr
 | expr AND expr                        						#andExpr
 | expr OR expr                         						#orExpr
 | expr MINUSMINUS					    						#minusminusExpr
 | expr PLUSPLUS					    						#plusplusExpr
 | atom                                 						#atomExpr
 ;

atom
 : OPAR expr CPAR #parExpr
 | (INT | FLOAT)  #numberAtom
 | (TRUE | FALSE) #booleanAtom
 | ID             #idAtom
 | STRING         #stringAtom
 | NIL            #nilAtom
 ;

INTVAR : 'int';
DOUBLEVAR : 'double';
STRINGVAR : 'String';

OR : '||';
AND : '&&';
EQ : '==';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
PLUS : '+';
PLUSPLUS : '++';
MINUS : '-';
MINUSMINUS : '--';
MULT : '*';
DIV : '/';
MOD : '%';
POW : '^';
NOT : '!';

COMMA : ',';
COLON : ':' ;
SCOL : ';';
ASSIGN : '=';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';
LBRACKET : '[' ;
RBRACKET : ']' ;

TRUE : 'true';
FALSE : 'false';
NIL : 'nil';
IF : 'if';
ELSE : 'else';
WHILE : 'while';
LOG : 'log';
FOR : 'for';
DO  : 'do' ;

SEND : 'send';
SENDAT : 'sendAt';
BACKMSG: 'msg->sapIndex0_';

SHOWHEAP : 'showHeap';
SHOWLISTSEND : 'showListSendMsg';

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

INT
 : [0-9]+
 ;

FLOAT
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

COMMENT
 : '//' ~[\r\n]* -> skip
 ;
BLOCKCOMMENT
 : '/*' .*? '*/' -> skip
 ;

SPACE
 : [ \t\r\n] -> skip
 ;

NEWLINE
 : ('\r' '\n'? | '\n') -> skip
 ;

unknowns : . ; 

