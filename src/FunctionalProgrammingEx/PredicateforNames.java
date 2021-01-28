package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateforNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

       String[] names = scan.nextLine().split("\\s+");

        Predicate<String> predicate = name -> name.length() <= n;

        Arrays.stream(names).filter(predicate).forEach(e -> System.out.println(e));

    }
}
