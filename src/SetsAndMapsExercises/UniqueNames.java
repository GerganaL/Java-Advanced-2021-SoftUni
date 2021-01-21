package SetsAndMapsExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueNames {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int n = Integer.parseInt(scan.nextLine());

            Set<String> names = new LinkedHashSet<>();

            for (int i = 0; i < n; i++) {
                String input = scan.nextLine();
                names.add(input);
            }

            /*for (String name : names) {
                System.out.println(name);
            }*/

            names.forEach(System.out::println);
        }
    }


