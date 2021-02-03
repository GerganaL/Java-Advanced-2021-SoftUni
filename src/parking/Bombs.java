package parking;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        int datura = 0;
        int cherry = 0;
        int smoke = 0;

        String[] inputNumbers = scan.nextLine().split(", ");
        for (String number : inputNumbers) {
            bombEffects.push(Integer.parseInt(number));
        }

        inputNumbers = scan.nextLine().split(", ");
        for (String number : inputNumbers) {
            bombCasing.push(Integer.parseInt(number));
        }
        boolean isfull = false;
        while (!bombCasing.isEmpty() && !bombEffects.isEmpty() && !isfull) {
            int sum = bombEffects.getLast() + bombCasing.getFirst();
            if (sum == 40) {
                datura++;
                bombEffects.removeLast();
                bombCasing.removeFirst();
            } else if (sum > 40 && sum < 60) {
                int currentCase = bombCasing.removeFirst();
                currentCase -= 5;
                bombCasing.addFirst(currentCase);
            } else if (sum == 60) {
                bombEffects.removeLast();
                bombCasing.removeFirst();
                cherry++;
            } else if (sum > 60 && sum < 120) {
                int currentCase = bombCasing.removeFirst();
                currentCase -= 5;
                bombCasing.addFirst(currentCase);
            } else if (sum == 120) {
                bombEffects.removeLast();
                bombCasing.removeFirst();
                smoke++;
            } else if (sum > 120) {
                int currentCase = bombCasing.removeFirst();
                currentCase -= 5;
                bombCasing.addFirst(currentCase);
            }

            if (datura >= 3 && cherry >= 3 && smoke >= 3) {
                isfull = true;
            }
        }
        if (datura >= 3 && cherry >= 3 && smoke >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (!bombEffects.isEmpty()) {
            System.out.print("Bomb Effects: ");
            if (bombEffects.size() == 1) {
                System.out.println(bombEffects.removeLast());
            } else {
                for (int i = 0; i <= bombEffects.size(); i++) {
                    if (i == bombEffects.size()) {
                        System.out.print(bombEffects.removeLast());
                    } else {
                        System.out.print(bombEffects.removeLast() + ", ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Bomb Effects: empty");
        }
        if (!bombCasing.isEmpty()) {
            System.out.print("Bomb Casings: ");
            if (bombCasing.size() == 1) {
                System.out.println(bombCasing.removeFirst());

            } else {
                for (int i = 0; i <= bombCasing.size(); i++) {
                    if (i == bombCasing.size()) {
                        System.out.print(bombCasing.removeFirst());
                    } else {
                        System.out.println(bombCasing.removeFirst() + ", ");
                    }
                }
                System.out.println();
            }

        } else {
            System.out.println("Bomb Casings: empty");
        }
        System.out.println("Cherry Bombs: " + cherry);
        System.out.println("Datura Bombs: " + datura);
        System.out.println("Smoke Decoy Bombs: " + smoke);
    }
}
