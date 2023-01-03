package org.compilerbau.minipython.symbol;


public class Class extends Symbol implements Scoped {
    public static class Instance implements Scoped {
        private final Scope scope;

        public Instance(Scope scope) {
            this.scope = scope;
        }

        @Override
        public Scope getScope() {
            return scope;
        }
    }

    private org.compilerbau.minipython.ast.Class clazz;

    private final Scope scope;

    public Class(Scope scope) {
        this.scope = scope;
    }

    public Scope getScope() {
        return scope;
    }

    public org.compilerbau.minipython.ast.Class getClazz() {
        return clazz;
    }

    public void setClass(org.compilerbau.minipython.ast.Class clazz) {
        this.clazz = clazz;
    }

    public Instance instantiate() {
        Scope scope = new Scope();
        scope.setParent(this.scope);
        return new Instance(scope);
    }
}
