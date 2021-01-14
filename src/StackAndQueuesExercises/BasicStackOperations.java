package StackAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();
        scan.nextLine();
        String [] inputNumbers = scan.nextLine().split("\\s+");
        for (String number : inputNumbers) {
            stack.push(Integer.parseInt(number));
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if(stack.contains(x)){
            System.out.println("true");
        }else if(stack.isEmpty()){
            System.out.println(0);
        }else{
            int min = Integer.MAX_VALUE;
            for (Integer num : stack) {
                int current = num;
                if (min > current){
                    min = num;
                }
            }
            System.out.println(min);
        }

    }
}
