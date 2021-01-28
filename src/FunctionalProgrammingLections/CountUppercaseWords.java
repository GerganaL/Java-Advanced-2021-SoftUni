package FunctionalProgrammingLections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       // String [] input = scan.nextLine().split(" ");

       List<String> uppercaseWords =  Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(MyStrings.startsWithUppercase)
                .collect(Collectors.toList());

        System.out.println(uppercaseWords.size());
        System.out.println(uppercaseWords.stream().collect(Collectors.joining(System.lineSeparator())));

       /* Predicate<String> checkUpperCase = str -> Character.isUpperCase(str.charAt(0));

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (checkUpperCase.test(input[i]))
                result.add(input[i]);
        }
        System.out.println(result.size());
         result.forEach(System.out::println);*/
    }
}
