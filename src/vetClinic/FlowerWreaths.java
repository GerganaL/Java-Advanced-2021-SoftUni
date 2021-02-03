package vetClinic;

import java.util.ArrayDeque;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        int wreaths = 0;
        int store = 0;

        String[] inputNumbers = scan.nextLine().split(", ");
        for (String number : inputNumbers) {
            lilies.push(Integer.parseInt(number));
        }

        inputNumbers = scan.nextLine().split(", ");
        for (String number : inputNumbers) {
            roses.offer(Integer.parseInt(number));
        }

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lil = lilies.pop();
            int ros = roses.poll();
            int sum = lil + ros;
            if (sum == 15) {
                wreaths++;
            } else if (sum > 15) {
                while (sum > 15) {
                    lil -= 2;
                    sum = lil + ros;
                }
                if (sum == 15) {
                    wreaths++;
                } else {
                    store += sum;
                }
            } else {
                store += sum;
            }
        }

        if (wreaths > 5 || wreaths == 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            if (store > 15) {
                int left = store / 15;
                wreaths += left;
            }
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreaths);
        }

    }
}
