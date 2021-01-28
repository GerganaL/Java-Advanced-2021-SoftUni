package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class customMinFunction {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Function<int[],Integer> getMinElement = numbers -> Arrays.stream(numbers).min().getAsInt();

       int [] array = Arrays.stream(scan.nextLine().split("\\s+"))
               .mapToInt(Integer::parseInt).toArray();

        int minElement = getMinElement.apply(array);
        System.out.println(minElement);
    }
}
