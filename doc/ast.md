# Programm
Ein Programm besteht aus einer Liste beliebig vieler Statements
```mermaid
graph TD;
    Program-->Statements;
```

## Statement
Ein Statement kann 
 * ein Ausdruck, 
 * eine Zuweisung, 
 * eine Schleife, 
 * eine bedingten Anwesiung, 
 * eine Funktionsdefinition, 
 * eine Rückgabeanweisung,
 * eine Klassendefinition
 * oder das Keyword `pass`  
 
sein
```mermaid
graph TD;
    Statement-->Expression;
    Statement-->Assignment;
    Statement-->Loop;
    Statement-->Condition;
    Statement-->Function;
    Statement-->Return;
    Statement-->Class;
    Statement-->Pass;
```

### Ausdruck
Ein Ausdruck kann
 * ein Funktionsaufruf
 * ein Identifier
 * ein Wert
 * eine Berechnung
 * ein Vergleich
 * ein bool'sche Negation
 * oder eine bool'sche Verknüpfung  
 
sein
```mermaid
graph TD;
  Expression-->Call;
  Expression-->Identifier;
  Expression-->Value;
  Expression-->Calculation;
  Expression-->Comparison;
  Expression-->Negation;
  Expression-->Connective;
```

#### Funktionsaufruf
Ein Funktionsaufruf besteht aus dem Namen der aufzurufenden Funktion und den Parametern, welche wiederum aus einer Liste von Ausdrücke besteht
```mermaid
graph TD;
  Call-->Function;
  Call-->Parameter;
  Parameter-->Expressions;
```

#### Wert
Ein Wert kann ein Integer-, String- oder Booleanliteral sein
```mermaid
graph TD;
  Value-->Integer;
  Value-->String;
  Value-->Boolean;
```

#### Berechnung
Eine Berechnung besteht aus der Operation (Multiplikation, Division, Addition oder Subtraktion) und den Operanden, welche jeweils Ausdrücke sind
```mermaid
graph TD;
  Calculation-->Operation;
  Calculation-->Operands;
  Operands-->Expression;
```

#### Vergleich
Ein Vergleich besteht aus der Vergleichsoperation (Gleich, Ungleich, Größer gleich, Kleiner gleich, Größer als, Kleiner als) und den Operanden, welche jeweils Ausdrücke sind
```mermaid
graph TD;
  Comparison-->Operation;
  Comparison-->Operands;
  Operands-->Expression;
```

#### Bool'sche Negation
Eine bool'sche Negation besteht aus dem zu negierenden Ausdruck
```mermaid
graph TD;
  Negation-->Expression;
```

#### Bool'sche Verknüpfung
Eine bool'sche Negation besteht aus aus der Verknüpfungsoperation (Und, Oder) und den Operanden, welche jeweils Ausdrücke sind
```mermaid
graph TD;
  Connective-->Operation;
  Connective-->Operands;
  Operands-->Expression;
```

## Zuweisung
Eine Zuweisung besteht aus dem Namen der zuzuweisenden Variable und dem Wert, welcher ein Ausdruck ist
```mermaid
graph TD;
  Assignment-->Identifier;
  Assignment-->Expression;
```

## Schleife
Eine Schleife besteht aus einer Bedingung, welche ein Ausdruck ist, und den Schleifenkörper, welche eine Liste beliebig vieler Statements ist
```mermaid
graph TD;
  Loop-->Condition;
  Condition-->Expression;
  Loop-->Body;
  Body-->Statements;
```

## Bedingte Anwesiung
Eine bedingte Anweisung besthet aus einer Bedingung, welche ein Ausdruck ist, dem zutreffenden Körper und optional dem nicht zutreffenden Körper, welche jeweils aus einer Liste beliebig vieler Statements bestehen
```mermaid
graph TD;
  Conditional-->Condition;
  Condition-->Expression;
  Conditional-->IfBody;
  IfBody-->Statements;
  Conditional-->ElseBody;
  ElseBody-->Statements;
```

## Funktionsdefinition
Eine Funktionsdefinition besteht aus dem Namen der Funktion, einer Liste von Funktionsparameter und dem Funktionskörper
```mermaid
graph TD;
  Function-->Identifier;
  Function-->Parameter;
  Parameter-->Identifiers;
  Function-->Body;
  Body-->Statements;
```

## Rückgabeanweisung
Eine Rückgabeanweisung besteht aus dem zurückzugebenden Ausdruck
```mermaid
graph TD;
  Return-->Expression;
```

## Klassendefinition
Eine Klassendefinition besteht aus dem Namen der Klasse, optional dem Namen der Elternklasse und beliebig vieler Definitionen von Funktionen
```mermaid
graph TD;
  Class-->Identifier;
  Class-->Parent;
  Class-->Functions;
```
