# Compiling
![Compiling by xkcd](https://imgs.xkcd.com/comics/compiling.png)

# Lexical analysis
converting a sequenc of characters from the sorce code into a sequence of tokens.
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
ANTLR generate a scanner from the given grammar for us, so we can use the tokens in our syntatic analyse.

# Syntactic analysis
arrange the tokens into a Parse-Tree that represents the syntactic structure.

## Funktions
This syntactic structure describes a definition of a funktion,
```
function           : DEF IDENTIFIER LBRACKET function_parameter RBRACKET COLON statements END ;
```
so we are able to encapsulate instructions with the following code
```python
def functionA():
print("I am function A")
#end
```

## Classes
We also want to define a class stukture
```
class_function     : DEF IDENTIFIER LBRACKET SELF (COMMA function_parameter)? RBRACKET COLON statements END;
class              : CLASS IDENTIFIER (COLON | LBRACKET IDENTIFIER RBRACKET COLON) class_function* END;
```

```python
class B(A):
def methodB(self):
    print("I am methodB from class B")
#end
#end
```

## Symbols
informations about the source code
* variables
* function names

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
