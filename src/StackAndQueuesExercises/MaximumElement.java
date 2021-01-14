package StackAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String [] commands = scan.nextLine().split("\\s+");
            switch (commands[0]){
                case "1":
                    numbers.push(Integer.valueOf(commands[1]));
                break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    int max = Integer.MIN_VALUE;
                    for (Integer num : numbers) {
                        int current = num;
                        if (max < current){
                            max = num;
                        }
                    }
                    System.out.println(max);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
    }
}
