package FunctionalProgrammingLections;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Supplier<Integer> supplier = () -> new Random().nextInt(130);
        Predicate<Integer> isEven = Math::isEven;
        Predicate<Integer> isEven1 = num -> num % 2 == 0;
        Function<Integer,Boolean> isEven3 = num ->  num % 2 == 0;


        //Get first number greater than 3 is odd and print it * 2

        AtomicInteger order = new AtomicInteger(1);
        Consumer<Integer> printer = num -> System.out.println((order.incrementAndGet()) + ". -> " + num );

      /*  int[] order = {1};
        Consumer<Integer> printer = num -> System.out.println((order[0]++) + ". -> " + num );*/

        numbers.stream().forEach(printer);

       /* numbers.stream().filter(n -> n > 3 && n % 2 ==0 )
                .forEach(n -> System.out.println(n*2));

        System.out.println(numbers.stream()
                .filter(test::isGreaterThanThree)
                .filter(test::isEven)
                .map(test::byTwo)
                .findFirst()
                .get());*/

        /*for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > 3 && numbers.get(i) % 2 == 0){
                System.out.println(numbers.get(i) * 2 );
                break;
            }
        }*/
    }
    public static Integer byTwo (int number){
        return number*2;
    }

    public static  boolean isGreaterThanThree(int number){
        return  number > 3;
    }

    public static boolean isEven(int number){
        return number % 2 == 0;
    }
}
