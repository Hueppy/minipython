# Compiling
![Compiling by xkcd](https://imgs.xkcd.com/comics/compiling.png)

# Overview
![Overview](https://github.com/Hueppy/minipython/blob/presentation/doc/overview.svg)

# Lexical analysis
converting a sequence of characters from the source code into a sequence of tokens.
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
ANTLR generate a scanner from the given grammar for us, so we can use the tokens in our syntactic analyses.

# Syntactic analysis
arrange the tokens into a Parse-Tree that represents the syntactic structure.

## Funktions
This syntactic structure describes a definition of a function,
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
We also want to define a class structure
```
class_function     : DEF IDENTIFIER LBRACKET SELF (COMMA function_parameter)? RBRACKET COLON statements END;
class              : CLASS IDENTIFIER (COLON | LBRACKET IDENTIFIER RBRACKET COLON) class_function* END;
```
and use it in our source code
```python
class B(A):
def methodB(self):
    print("I am methodB from class B")
#end
#end
```
# Abstract syntax tree
The AST is generated from the parse tree
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

# Symbol
Binds variables, functions and class names in symbol table
During this steps it already does some semantic analysis
for example if function or classes are defined more than once the compiler will throw an error

# Symbol table
The symbol table is seperated into scopes each scope holds information about
* List of symbols
    * Variables
    * Functions
    * Classes
    * BuiltIn Function (print, input) 
* Parent scope (none if global scope)

Both the symbol visitor and interpreter have access to this symbol table

## Example
```mermaid
classDiagram
    GlobalScope <|-- Function
    GlobalScope <|-- Class
    GlobalScope <|-- Scope
    Function <|-- FunctionScope
    Class <|-- ClassScope
    ClassFunction <|-- ClassFunctionScope
    ClassScope <|-- ClassFunction
    class GlobalScope {
        +symbols [methodA, classA, a, b]
    }
    class Function{
    }
    class FunctionScope{
        symbols [parameter_a, parameter_b]
    }
    class Class{
    }
    class ClassScope{
        symbols [classMethodA]
    }
    class ClassFunction {
    
    }
    class ClassFunctionScope{
        symbols [parameter_a, parameter_b]
    }
    class Scope{
        symbols [a, b]
    }
```

# Interpreter
We can use the AST structure and the information in the symbol table to execute the code
## Instantiating classes
Classes must be instantiated by specifying for example ```a = A()```

The following steps are happening
1. ```visit(Assignment node)``` gets called to assign a value to variable ```a``` 
2. Because ```A()``` has to be instantiated it calls ```visit(Call node)```
3. The function checks if the symbol is a instance of Class (symbol) and calls the
```((Class) symbol).instantiate()``` method of that symbol
4. ```instantiate()``` creates a new scope with a parent in the symbol table and returns it
5. The newly created instance (scope) is then assigned to variable ```a```

```java
public class InterpretingVisitor extends AstVisitorBase<Object> {
    ...
    @Override
    public Object visit(Assignment node) {
        super.visit(node);

        Symbol symbol;
        if(node.getIdentifier().getIdentifier().equals("self")) {
            ...
        } else {
            symbol = scope.resolve(node.getIdentifier());
            if (symbol instanceof Variable) {
                ((Variable) symbol).setValue(node.getExpression().accept(this));
            }
        }

        return null;
    }
    
    @Override
    public Object visit(Call node) {
        ...
        Symbol symbol = scope.resolve(node.getIdentifier());
        if (symbol instanceof org.compilerbau.minipython.symbol.Function) {
            ...
        } else if (symbol instanceof org.compilerbau.minipython.symbol.Class) {
            return ((Class) symbol).instantiate();
        } else if (symbol instanceof BuiltInFunction) {
            ...
        } else {
            throw new InterpreterException("Call error on " + node.getIdentifier());
        }
    }
    ...
}

public class Class extends Symbol implements Scoped {
    ...
    public Instance instantiate() {
        Scope scope = new Scope();
        scope.setParent(this.scope);
        return new Instance(scope);
    }
}
```

## Binding symbols to instances
You may noticed that during instantiating no symbols are binded to that newly created instance

The actual binding happens when a class function is called
1. By calling ```a.setA(10)``` it eventually lands in the ```visit(Assignment node)``` method because we try to assign a value ```self.a = a```
2. Because the assignment starts with ```self``` it will first get the scope symbol of our newly created instance ```scope.resolve(node.getIdentifier().getIdentifier())```
3. The scope symbol is casted to a class instance ```Class.Instance instance = (Class.Instance) ((Variable) symbol).getValue()```
4. By doing ```node.getIdentifier().getNext()``` we get variable ```a``` after the ```self.``` and now we can try to resolve it **locally** (```if(instance.getScope().resolveLocally(var) == null)```)
5. If the variable is not resolved we will simply bind it to this instance ```instance.getScope().bind(var, new Variable())```
6. The last step would be to just assign the value to that variable ```((Variable) selfSymbol).setValue(node.getExpression().accept(this))```

Now what if we called ```a.getA()``` before ```a.setA(10)``` the program would simply crash because ```self.a``` is not binded 

To avoid that we will simply bind it in the ``` visit(Identifier node)``` method to the instance and ```return null```

```python
class A():
    def setA(self, a):
        self.a = a
    #end
    def getA(self):
        return self.a
    #end
#end
```

```java
public class InterpretingVisitor extends AstVisitorBase<Object> {
    ...
    @Override
    public Object visit(Assignment node) {
        ...
        Symbol symbol;
        if(node.getIdentifier().getIdentifier().equals("self")) {
            if(node.getIdentifier().getNext() == null) {
                throw new InterpreterException("Can't assign values directly to self");
            }
            symbol = scope.resolve(node.getIdentifier().getIdentifier());
            String var = node.getIdentifier().getNext().getIdentifier();
            Class.Instance instance = (Class.Instance) ((Variable) symbol).getValue();
            if(instance.getScope().resolveLocally(var) == null) {
                instance.getScope().bind(var, new Variable());
            }
            Symbol selfSymbol = instance.getScope().resolveLocally(var);
            if(selfSymbol instanceof Variable) {
                ((Variable) selfSymbol).setValue(node.getExpression().accept(this));
            }
        } else {
        ...
    }
    
    @Override
    public Object visit(Identifier node) {
        Symbol symbol = scope.resolve(node);

        if (symbol instanceof Variable) {
            return ((Variable) symbol).getValue();
        } else if (symbol == null && node.getIdentifier().equals("self")) {
            // Bind class attribute if not found
            symbol = scope.resolve(node.getIdentifier());
            Class.Instance instance = (Class.Instance) ((Variable) symbol).getValue();
            instance.getScope().bind(node.getNext().getIdentifier(), new Variable());

            return null;
        } else if (symbol == null) {
            throw new InterpreterException(node.getIdentifier() + " doesn't exist");
        } else {
            throw new InterpreterException(node.getIdentifier() + " is not a variable");
        }
    }
    ...
}
```

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
The interpreter should give detailed information about the errors in the source code so the developer able to find them easier 
