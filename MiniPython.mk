ANTLR4 = ./lib/antlr-4.11.1-complete.jar
ANTLR4TESTGUI = org.antlr.v4.gui.TestRig
MINIPYTHON = MiniPython
MINIPYTHONPACKAGE = minipython.antlr
MINIPYTHONGRAMMARDIR = ./src/minipython/antlr/
MINIPYTHONGRAMMAR = $(MINIPYTHONGRAMMARDIR)MiniPython.g4
MINIPYTHONGRAMMARSTART = start
MINIPYTHONASTDIR = src/minipython/ast/

.PHONY: info
info:
	java -jar $(ANTLR4)
    
.PHONY: build
build: $(MINIPYTHONGRAMMAR)
	java -Xmx500M -cp $(ANTLR4) org.antlr.v4.Tool $(MINIPYTHONGRAMMAR) -no-listener -visitor -package $(MINIPYTHONPACKAGE)
	javac -cp $(ANTLR4) $(MINIPYTHONGRAMMARDIR)MiniPython*.java -d ./bin/
	javac -cp $(ANTLR4):./bin/ $(MINIPYTHONASTDIR)*.java -d ./bin/
	javac -cp $(ANTLR4):./bin/ src/MiniPython.java -d ./bin/

.PHONY: lexer
lexer:  
	java -Xmx500M -cp $(ANTLR4):./bin/ $(ANTLR4TESTGUI) $(MINIPYTHONPACKAGE).$(MINIPYTHON) $(MINIPYTHONGRAMMARSTART) -tokens

.PHONY: gparser
gparser:  
	java -Xmx500M -cp $(ANTLR4):./bin/ $(ANTLR4TESTGUI) $(MINIPYTHONPACKAGE).$(MINIPYTHON) $(MINIPYTHONGRAMMARSTART) -gui

.PHONY: parser
parser:  
	java -Xmx500M -cp $(ANTLR4):./bin/ $(ANTLR4TESTGUI) $(MINIPYTHONPACKAGE).$(MINIPYTHON) $(MINIPYTHONGRAMMARSTART) -tree

.PHONY: run
run:
	java -cp $(ANTLR4):./bin/ $(MINIPYTHON) ./src/Programm.txt

.PHONY: test
test:
	javac -cp $(ANTLR4):./bin/ ./test/MiniPythonTest.java -d ./bin/
	java ./bin/MiniPythonTest