package SetsAndMapsLections;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

      double[] numbers =  Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double,Integer> numbersWithCounts = new LinkedHashMap<>();

        for (double number : numbers) {
            numbersWithCounts.putIfAbsent(number,0);
            numbersWithCounts.put(number,numbersWithCounts.get(number)+1);
        }
       numbersWithCounts.forEach((k,v) ->
               System.out.printf("%.1f -> %d%n",k,v));
    }
}
