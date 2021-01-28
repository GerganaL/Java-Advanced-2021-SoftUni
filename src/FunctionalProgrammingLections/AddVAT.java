package FunctionalProgrammingLections;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // !a ++ и т.н.
        // UnaryOperator<Double>

        List<String> line = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        UnaryOperator<Double> vatAdder = val -> val * 1.20;
        Function<Double,Double> vatAddFunc = val -> val * 1.20;

        System.out.println("Prices with VAT:");
        line.stream()
                .map(e -> String.format("%.2f", vatAdder.apply(Double.parseDouble(e))))
                .forEach(System.out::println);

        System.out.println();

    }
}
