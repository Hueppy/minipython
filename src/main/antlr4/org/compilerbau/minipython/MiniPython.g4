grammar MiniPython;

start              : statements ;

identifier         : IDENTIFIER
                   | SELF
                   | identifier DOT IDENTIFIER
                   | SELF DOT IDENTIFIER
                   ;

call_parameter     : expression (COMMA expression)*
                   |
                   ;
call               : identifier LBRACKET call_parameter RBRACKET ;

expression         : call
                   | identifier
                   | INT
                   | STRING
                   | BOOLEAN
                   | LBRACKET expression RBRACKET
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

assignment         : identifier ASSIGN expression ;

return             : RETURN expression ;

condition          : expression COLON
                   | LBRACKET expression RBRACKET COLON 
                   ;

loop               : WHILE condition statements END ;

if_statement       : IF condition statements ;
elif_statement     : ELIF condition statements ;
else_statement     : ELSE COLON statements ;

conditional        : if_statement elif_statement* else_statement? END ;

function_parameter : IDENTIFIER (COMMA IDENTIFIER)*
                   |
                   ;

function           : DEF IDENTIFIER LBRACKET function_parameter RBRACKET COLON statements END ;

class_function     : DEF IDENTIFIER LBRACKET SELF (COMMA function_parameter)? RBRACKET COLON statements END;

class              : CLASS IDENTIFIER (COLON | LBRACKET IDENTIFIER RBRACKET COLON) class_function* END;

statement          : expression
                   | assignment
                   | loop
                   | conditional
                   | function
                   | return
                   | class
                   | PASS
                   ;
                   
statements         : statement+? ;

LBRACKET           : '(';
RBRACKET           : ')';
ASSIGN             : '=';
COLON              : ':';
DOT                : '.';
COMMA              : ',';

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
                   
PASS               : 'pass';
SELF               : 'self';
RETURN             : 'return';
WHILE              : 'while';
IF                 : 'if';
ELIF               : 'elif';
ELSE               : 'else';
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