import java.io.IOException;
import java.util.Arrays;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromFileName(args[0]);
        MiniPythonLexer lexer = new MiniPythonLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniPythonParser parser = new MiniPythonParser(tokens);

        ParseTree tree = parser.start();  // Start-Regel

        ParseTreeWalker walker = new ParseTreeWalker();
        MyListener eval = new MyListener();
        walker.walk(eval, tree);

        TreeViewer viewer2 = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewer2.open();
    }
}
