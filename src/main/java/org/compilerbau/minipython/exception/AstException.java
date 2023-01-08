package org.compilerbau.minipython.exception;

import org.compilerbau.minipython.ast.Node;

public class AstException extends RuntimeException{

    public AstException(String message, Node node) {
        super(message + "\nError at line " + node.getPosition() + " in module "
            + (node.getModule() == null ? "main" : node.getModule().getName()));
    }
}
