# Compiling
![Compiling by xkcd](https://imgs.xkcd.com/comics/compiling.png)

# Overview
![Overview](https://github.com/Hueppy/minipython/blob/presentation/doc/overview.svg)

# Lexical analysis
converts a sequence of characters from the source code into a sequence of tokens.
```
...
DEF                : 'def';
CLASS              : 'class';
SELF               : 'self';
IDENTIFIER         : [a-zA-Z_] [a-zA-Z0-9_]* ;
END                : '#end' ('\n' | '\r\n')?;
WHITESPACE         : [ \t\r\n]+ -> skip ;
...
```
ANTLR generates a scanner for us from the given grammar, so we can use the tokens in our syntactic analyses.

# Syntactic analysis
arranges the tokens into a Parse-Tree that represents the syntactic structure.

## Functions
This syntactic structure describes a definition of a function,
```
function           : DEF IDENTIFIER LBRACKET function_parameter RBRACKET COLON statements END ;
```
so we are able to encapsulate instructions with the following code.
```python
def functionA():
print("I am function A")
#end
```

## Classes
We also want to define a class structure
```
class_function     : DEF IDENTIFIER LBRACKET SELF (COMMA function_parameter)? RBRACKET COLON statements END;
class              : CLASS IDENTIFIER (COLON | LBRACKET IDENTIFIER RBRACKET COLON) class_function* END;
```
and use it in our source code.
```python
class B(A):
def methodB(self):
    print("I am methodB from class B")
#end
#end
```
# Abstract syntax tree
## Function node
```mermaid
graph TD;
  Function-->Identifier;
  Function-->Parameter;
  Parameter-->Identifiers;
  Function-->Body;
  Body-->Statements;
```

## Class node
```mermaid
graph TD;
  Class-->Identifier;
  Class-->Parent;
  Class-->Functions;
```

# Symbol table
holds information about the source code
* variables
* function names
* class names

# Interpreter
We can use the AST structure to visit the nodes. With the additional information in the symbol table we can resolve the elements and execute the code.

# Test Cases
## Parameter handling
```python
def setParam(b):
b = 4
#end
...
a = 3
setParam(a)
...
```

# Perspective
The interpreter should give detailed information about the errors in the source code so the developer will be able to find them easier.
