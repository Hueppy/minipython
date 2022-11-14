package org.compilerbau.minipython;

import java.util.Arrays;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.compilerbau.minipython.ast.Program;
import org.compilerbau.minipython.visitor.AstVisitor;
import org.compilerbau.minipython.ast.Node;
import org.compilerbau.minipython.visitor.AstVisitor;
import org.compilerbau.minipython.visitor.PrintTree;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream charStream = CharStreams.fromFileName(args[0]);
        MiniPythonLexer lexer = new MiniPythonLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniPythonParser parser = new MiniPythonParser(tokens);

        ParseTree tree = parser.start();  // Start-Regel
        AstVisitor visitor = new AstVisitor();
        Program program = (Program) tree.accept(visitor);

        TreeViewer viewer = new TreeViewer(Arrays.asList(), program);
        viewer.open();
        String printTree = new PrintTree().visit((Node) program);

        System.out.print(printTree);
/*
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewer.open();

 */
    }
}
