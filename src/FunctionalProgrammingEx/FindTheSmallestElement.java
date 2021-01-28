package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getLastIndexOfMinElement =
                list -> list.lastIndexOf(list.stream().min(Integer::compare).get());

        System.out.println(getLastIndexOfMinElement.apply(numbers));
    }

    public static int getMinElement (List<Integer> list){
        return list.stream().min(Integer::compare).get();
    }
}
