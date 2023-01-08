package org.compilerbau.minipython;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.compilerbau.minipython.ast.Program;
import org.compilerbau.minipython.visitor.AstParseTreeVisitor;
import org.compilerbau.minipython.visitor.BuilderVisitor;
import org.compilerbau.minipython.visitor.InterpretingVisitor;
import org.compilerbau.minipython.visitor.SymbolVisitor;

import java.nio.file.Path;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream charStream = CharStreams.fromFileName(args[0]);
        MiniPythonLexer lexer = new MiniPythonLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniPythonParser parser = new MiniPythonParser(tokens);

        ParseTree tree = parser.start();  // Start-Regel
        AstParseTreeVisitor visitor = new AstParseTreeVisitor();
        Program program = (Program) tree.accept(visitor);

        /*
        TreeViewer viewer = new TreeViewer(Collections.emptyList(), program);
        viewer.open();
        */

        program.accept(new SymbolVisitor());

        /*
        InterpretingVisitor interpreter = new InterpretingVisitor();
        program.accept(interpreter);
         */

        program.accept(new BuilderVisitor(Path.of("out")));

    }
}
