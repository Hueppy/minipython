grammar MiniPython;

parenthesized: OPENING operation CLOSING;
variable: ID;
number: INTEGER;
boolean: BOOLEAN;
atom: parenthesized | number | boolean | variable;

tupleListItem: operation;
tupleList_: (PARAMETERLIST tupleListItem tupleList_) | ;
tupleList: (tupleListItem tupleList_) | (tupleListItem PARAMETERLIST) | ;
tupleCall: OPENING tupleList CLOSING;

listListItem: operation;
listList_: (PARAMETERLIST listListItem listList_) | ;
listList: (listListItem listList_) | ;
listCall: LBRACKET listList RBRACKET;

reference: atom;

negativeFactor: MINUS reference;
factor: reference | negativeFactor ;

multiplication: MULTIPLY product;
division: DIVIDE product;
remainder: PERCENT product;
product_: multiplication | division | remainder | ;
product: factor product_;

addition: PLUS sum;
substaction: MINUS sum;
sum_: addition | substaction | ;
sum: product sum_;

lowerThen: LOWER_THEN sum;
lowerEquals: LOWER_EQUALS sum;
greaterThen: GREATER_THEN sum;
greaterEquals: GREATER_EQUALS sum;
notEquls: NOT_EQUALS sum;
equals: EQUALS sum;
comparison_: lowerThen | lowerEquals | greaterThen | greaterEquals | notEquls | equals | ;
comparison: sum comparison_;

operation: comparison;

tupleUnpackingListParameter: variable;
tupleUnpackingList_: (PARAMETERLIST tupleUnpackingListParameter tupleUnpackingList_) | ;
tupleUnpackingList: (tupleUnpackingListParameter tupleUnpackingList_) | (tupleUnpackingListParameter PARAMETERLIST);
tupleUnpacking: OPENING tupleUnpackingList CLOSING ASSIGMENT ID;

variableAssigment_: operation | tupleCall | listCall;
variableAssigment: ID ASSIGMENT variableAssigment_;
assigment: tupleUnpacking | variableAssigment;

statement: assigment;
statements_: statements | ;
statements: statement ENDOFLINE statements_;

start: statements EOF;

FAULT_INTEGER: ZERO_DIGIT+ DIGIT*;
INTEGER: (NON_ZERO_DIGIT DIGIT*) | (ZERO_DIGIT+);
fragment ZERO_DIGIT: '0';
fragment NON_ZERO_DIGIT: [1-9];
fragment DIGIT: [0-9];

ID: CHARACTER+ DIGIT*;
fragment CHARACTER: [a-zA-Z_];

OPENING: '(';
CLOSING: ')';
LBRACKET: '[';
RBRACKET: ']';
PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';
PERCENT: '%';
ASSIGMENT: '=';
PARAMETERLIST: ',';
METHODOPERATOR: '.';
LOWER_THEN: '<';
LOWER_EQUALS: '<=';
GREATER_THEN: '>';
GREATER_EQUALS: '>=';
NOT_EQUALS: '!=';
EQUALS: '==';
BOOLEAN: 'true' | 'false';
ENDOFLINE: '\r'? '\n';