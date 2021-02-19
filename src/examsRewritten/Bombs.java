package examsRewritten;

import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombEffects::offer);

        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombCasings::push);

        //•	Datura Bombs: 40
        //•	Cherry Bombs: 60
        //•	Smoke Decoy Bombs: 120

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        while (!bombEffects.isEmpty() && !bombCasings.isEmpty()) {
            int effect = bombEffects.peek();
            int casing = bombCasings.peek();
            int sum = effect + casing;

            if (sum == 120 || sum == 60 || sum == 40) {
                switch (sum) {
                    case 120:
                        bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                        break;
                    case 60:
                        bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                        break;
                    case 40:
                        bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                        break;
                }
                bombEffects.poll();
                bombCasings.pop();
            } else {
                bombCasings.push(bombCasings.pop() - 5);
            }

            if (bombs.get("Smoke Decoy Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3 && bombs.get("Datura Bombs") >= 3) {
                break;
            }
        }
        if (bombs.get("Smoke Decoy Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3 && bombs.get("Datura Bombs") >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.printf("Bomb Effects: %s%n", String.join(", ", bombEffects.toString().replaceAll("[\\[\\]]", "")));
        }

        if (bombCasings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.printf("Bomb Casings: %s%n", String.join(", ", bombCasings.toString().replaceAll("[\\[\\]]", "")));
        }

        bombs.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));

    }
}
