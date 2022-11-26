package org.compilerbau.minipython.symbol;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class BuiltInFunction extends Symbol {
    public static final BuiltInFunction PRINT = new BuiltInFunction() {
        @Override
        public Object run(List<Object> args) {
            System.out.println(
                args.stream()
                    .filter(Objects::nonNull)
                    .map(Object::toString)
                    .reduce((x, y) -> String.join(" ", x, y))
                    .orElse("NULL")
            );

            return null;
        }
    };

    public static final BuiltInFunction INPUT = new BuiltInFunction() {
        private final Scanner scanner = new Scanner(System.in);

        @Override
        public Object run(List<Object> args) {
            String value = scanner.nextLine();

            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                return value;
            }
        }
    };

    public abstract Object run(List<Object> args);
}
