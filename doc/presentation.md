# Compiling
![Compiling by xkcd](https://imgs.xkcd.com/comics/compiling.png)

# Lexical analysis
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
# Syntactic analysis
## Funktions
```python
def functionA():
print("I am function A")
#end
```

```
function           : DEF IDENTIFIER LBRACKET function_parameter RBRACKET COLON statements END ;
```

## Classes
```python
class B(A):
def methodB(self):
    print("I am methodB from class B")
#end
#end
```

```
class_function     : DEF IDENTIFIER LBRACKET SELF (COMMA function_parameter)? RBRACKET COLON statements END;
class              : CLASS IDENTIFIER (COLON | LBRACKET IDENTIFIER RBRACKET COLON) class_function* END;
```

## Symbols
informations about the source code
* variables
* function names
