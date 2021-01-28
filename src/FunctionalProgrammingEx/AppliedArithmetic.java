package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[],int []> addOne = arr -> Arrays.stream(arr).map(num -> num + 1 ).toArray();
        Function<int[],int []> multiplyByTwo = arr -> Arrays.stream(arr).map(num -> num * 2 ).toArray();
        Function<int[],int []> subtractOne = arr -> Arrays.stream(arr).map(num -> num - 1 ).toArray();

        Consumer<int []> printConsumer = arr -> Arrays.stream(arr).forEach(e -> System.out.print( e + " ") );

        String command = scan.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add":
                numbers = addOne.apply(numbers);
                case "multiply":
                   numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractOne.apply(numbers);
                    break;
                case "print":
                   printConsumer.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scan.nextLine();
        }
    }
}
