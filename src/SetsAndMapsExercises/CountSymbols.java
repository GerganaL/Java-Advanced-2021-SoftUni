package SetsAndMapsExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<Character, Integer> charOccurnces = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            //variant 1
            if (!charOccurnces.containsKey(symbol)) {
                charOccurnces.put(symbol, 1);
            }else {
                charOccurnces.put(symbol, charOccurnces.get(symbol) + 1);
            }

           /* //variant 2
            charOccurnces.putIfAbsent(symbol,0);
            charOccurnces.put(symbol,charOccurnces.get(symbol) + 1);

            //variant 3
           int currentValue = charOccurnces.getOrDefault(symbol,0);
           charOccurnces.put(symbol,currentValue + 1);*/
        }

        charOccurnces.forEach((key, value) -> {
            System.out.printf("%c: %d time/s%n", key, value);
            // S: 1 time/s
        });
    }
}
