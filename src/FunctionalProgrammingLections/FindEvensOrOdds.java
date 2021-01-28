package FunctionalProgrammingLections;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        final String even = "even";
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String filter = scan.nextLine();

        IntPredicate condition;

        if(filter.equals(even)){
            condition = x -> x % 2 == 0;
        }else {
            condition = x -> x % 2 != 0;
        }
        IntStream.range(input[0], input[1] + 1)
                .filter(condition)
                .forEach(n -> System.out.print(n + " "));
    }
}


