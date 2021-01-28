package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       /* int [] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();*/

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> divisibleByN = x -> x % n != 0;

        numbers.stream().filter(divisibleByN).forEach(e -> System.out.print(e + " "));
    }
}
