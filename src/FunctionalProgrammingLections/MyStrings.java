package FunctionalProgrammingLections;
import java.util.function.Predicate;

import java.util.function.Predicate;

public class MyStrings {
    public static Predicate<String> startsWithUppercase
            = str -> str != null
            && !str.isEmpty() && Character.isUpperCase(str.charAt(0));
}
