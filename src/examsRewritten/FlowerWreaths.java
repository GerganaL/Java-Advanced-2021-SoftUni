package examsRewritten;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(lilies::push);

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(roses::offer);

        int wreaths = 0;
        int store = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lili = lilies.pop();
            int rose = roses.poll();
            int sum = lili + rose;
            while(sum > 15){
                sum -= 2;
            }
            if(sum == 15){
                wreaths++;
            }else {
                store += sum;
            }
        }
        wreaths += store / 15;
        if (wreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreaths + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5 - wreaths) + " wreaths more!");
        }
    }
}
