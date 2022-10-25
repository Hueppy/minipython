grammar minipython;

INT                : [0-9]+ ;
STRING             : '"' .*? '"'
                   | '\'' .*? '\''
                   ;
BOOLEAN            : 'True'
                   | 'False'
                   ;

END                : '#end' '\n'?;

IDENTIFIER         : [a-zA-Z_] [a-zA-Z0-9_]* ;

MULTIPLICATION     : '*'
                   | '/'
                   ;
ADDITION           : '+'
                   | '-'
                   ;
RELATIONAL         : '=='
                   | '!='
                   | '<='
                   | '>='
                   | '>'
                   | '<'
                   ;
NOT                : 'not' ;
AND                : 'and' ;
OR                 : 'or' ;

COMMENT            : '#' .*? '\n' -> skip ;
WHITESPACE         : [ \n]+ -> skip ;

start              : statements ;

identifier         : IDENTIFIER
                   | identifier '.' IDENTIFIER
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
                   | expression MULTIPLICATION expression
                   | expression ADDITION expression
                   | expression RELATIONAL expression
                   | NOT expression
                   | expression AND expression
                   | expression OR expression
                   ;

assignment         : identifier '=' expression ;

return             : 'return' expression ;

condition          : expression ':'
                   | '(' expression '):'
                   ;

loop               : 'while' condition statements END ;

if_statement       : 'if' condition statements ;
elif_statement     : 'elif' condition statements ;
else_statement     : 'else:' statements ;
conditional        : if_statement elif_statement* else_statement? END ;

function_parameter : IDENTIFIER (',' IDENTIFIER)*
                   |
                   ;
function           : 'def' IDENTIFIER '(' function_parameter '):' statements END ;

class              : 'class' IDENTIFIER (':' | '(' IDENTIFIER '):') function* END;

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

