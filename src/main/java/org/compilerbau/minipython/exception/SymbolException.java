package org.compilerbau.minipython.exception;

import org.compilerbau.minipython.ast.Node;

public class SymbolException extends RuntimeException  {
    public SymbolException(String message, Node node) {
        super(message + "\nError at line " + node.getPosition() + " in module "
            + (node.getModule() == null ? "main" : node.getModule().getName()));
    }
}
