grammar minipython;

start              : statements ;

identifier         : IDENTIFIER
                   | identifier '.' IDENTIFIER
                   | SELF '.' IDENTIFIER
                   ;

call_parameter     : expression (',' expression)*
                   |
                   ;
call               : identifier '(' call_parameter ')' ;

expression         : call
                   | identifier
                   | INT
                   | STRING
                   | BOOLEAN
                   | '(' expression ')'
                   | expression MULTIPLY expression
                   | expression DIVIDE expression
                   | expression ADD expression
                   | expression SUBTRACT expression
                   | expression EQUALS expression
                   | expression NOT_EQUALS expression
                   | expression GREATER_EQUALS expression
                   | expression LOWER_EQUALS expression
                   | expression GREATER_THAN expression
                   | expression LOWER_THAN expression
                   | NOT expression
                   | expression AND expression
                   | expression OR expression
                   ;

assignment         : identifier '=' expression ;

return             : RETURN expression ;

condition          : expression ':'
                   | '(' expression '):'
                   ;

loop               : WHILE condition statements END ;

if_statement       : IF condition statements ;
elif_statement     : ELIF condition statements ;
else_statement     : ELSE statements ;

conditional        : if_statement elif_statement* else_statement? END ;

function_parameter : IDENTIFIER (',' IDENTIFIER)*
                   |
                   ;

function           : DEF IDENTIFIER '(' function_parameter '):' statements END ;

class_function     : DEF IDENTIFIER '(' SELF (',' function_parameter)? '):' statements END;

class              : CLASS IDENTIFIER (':' | '(' IDENTIFIER '):') class_function* END;

statement          : expression
                   | assignment
                   | loop
                   | conditional
                   | function
                   | return
                   | class
                   | 'pass'
                   ;
                   
statements         : statement+? ;

LBRACKET           : '(';
RBRACKET           : ')';
ASSIGN             : '=';
COLON              : ':';
DOT                : '.';

MULTIPLY           : '*';
DIVIDE             : '/';
ADD                : '+';
SUBTRACT           : '-';

EQUALS             : '==';
NOT_EQUALS         : '!=';
GREATER_EQUALS     : '<=';
LOWER_EQUALS       : '>=';
LOWER_THAN         : '<';
GREATER_THAN       : '>';
                   
SELF               : 'self';
RETURN             : 'return';
WHILE              : 'while';
IF                 : 'if';
ELIF               : 'elif';
ELSE               : 'else:';
CLASS              : 'class';
DEF                : 'def';

NOT                : 'not' ;
AND                : 'and' ;
OR                 : 'or' ;

INT                : [0-9]+ ;

STRING             : '"' .*? '"'
                   | '\'' .*? '\''
                   ;

BOOLEAN            : 'True'
                   | 'False'
                   ;

END                : '#end' ('\n' | '\r\n')?;

IDENTIFIER         : [a-zA-Z_] [a-zA-Z0-9_]* ;

COMMENT            : '#' .*? ('\n' | '\r\n') -> skip ;
WHITESPACE         : [ \t\r\n]+ -> skip ;