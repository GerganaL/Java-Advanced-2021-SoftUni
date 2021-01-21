package SetsAndMapsExercises;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        for (int i = 0; i < numbers[0]; i++) {
            set1.add(Integer.parseInt(scan.nextLine()));
        }

        for (int i = 0; i < numbers[1]; i++) {
            set2.add(Integer.parseInt(scan.nextLine()));
        }

        set1.forEach(e -> {
            if(set2.contains(e)){
                System.out.print(e + " ");
            }
        });
    }
}
