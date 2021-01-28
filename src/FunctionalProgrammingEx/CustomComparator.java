package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0) {  //не ги размества
                return -1; // 1 , 2 т.е не ги размества и за това връщаме -1
            } else if (num1 % 2 != 0 && num2 % 2 == 0) { // размества 2 с 1
              return 1;
            }
            return num1.compareTo(num2);
        };


        numbers.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
