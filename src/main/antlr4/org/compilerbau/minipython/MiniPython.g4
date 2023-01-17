grammar MiniPython;

start              : statements ;

identifier         : IDENTIFIER                # BasicIdentifier
                   | SELF                      # SelfIdentifier
                   | identifier DOT IDENTIFIER # RecursiveIdentifier
                   ;

call_parameter     : expression (COMMA expression)*
                   |
                   ;
call               : identifier LBRACKET call_parameter RBRACKET ;

list               : LSQUAREBRACKET expression (COMMA expression)* RSQUAREBRACKET          # StaticList
                   | LSQUAREBRACKET expression FOR identifier IN expression RSQUAREBRACKET # ListComprehension
                   ;

expression         : call                                         # CallExpression
                   | identifier                                   # VariableExpression
                   | identifier LSQUAREBRACKET INT RSQUAREBRACKET # ElementExpression
                   | INT                                          # NumberExpression
                   | STRING                                       # TextExpression
                   | BOOLEAN                                      # TruthExpression
                   | list                                         # ListExpression
                   | LBRACKET expression RBRACKET                 # SubexpressionExpression
                   | expression MULTIPLY expression               # MultiplicationExpression
                   | expression DIVIDE expression                 # DivisionExpression
                   | expression ADD expression                    # AdditionExpression
                   | expression SUBTRACT expression               # SubtractionExpression
                   | expression EQUALS expression                 # EqualityExpression
                   | expression NOT_EQUALS expression             # InequalityExpression
                   | expression GREATER_EQUALS expression         # GreaterEqualExpression
                   | expression LESS_EQUALS expression            # LessEqualExpression
                   | expression GREATER_THAN expression           # GreaterThanExpression
                   | expression LESS_THAN expression              # LessThanExpression
                   | NOT expression                               # NegationExpression
                   | expression AND expression                    # ConjunctionExpression
                   | expression OR expression                     # DisjunctionExpression
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

imports            : MULTIPLY
                   | IDENTIFIER (COMMA IDENTIFIER)*
                   ;

import_statement   : IMPORT imports FROM STRING;

statement          : expression
                   | assignment
                   | loop
                   | conditional
                   | function
                   | return
                   | class
                   | import_statement
                   | PASS
                   ;

statements         : statement+? ;

LBRACKET           : '(';
RBRACKET           : ')';
ASSIGN             : '=';
COLON              : ':';
DOT                : '.';
COMMA              : ',';

LSQUAREBRACKET     : '[';
RSQUAREBRACKET     : ']';

FOR                : 'for' ;
IN                 : 'in' ;

MULTIPLY           : '*';
DIVIDE             : '/';
ADD                : '+';
SUBTRACT           : '-';

EQUALS             : '==';
NOT_EQUALS         : '!=';
GREATER_EQUALS     : '>=';
LESS_EQUALS        : '<=';
GREATER_THAN       : '>';
LESS_THAN          : '<';

PASS               : 'pass';
SELF               : 'self';
RETURN             : 'return';
WHILE              : 'while';
IF                 : 'if';
ELIF               : 'elif';
ELSE               : 'else';
CLASS              : 'class';
DEF                : 'def';
IMPORT             : 'import';
FROM               : 'from';

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
