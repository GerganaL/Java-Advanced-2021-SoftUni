package StackAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();
        scan.nextLine();
        String [] inputNumbers = scan.nextLine().split("\\s+");
        for (String number : inputNumbers) {
            queue.offer(Integer.parseInt(number));
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if(queue.contains(x)){
            System.out.println("true");
        }else if(queue.isEmpty()){
            System.out.println(0);
        }else{
           // Integer maxNumber = Collections.max(queue);
            int min = Integer.MAX_VALUE;
            for (Integer num : queue) {
                int current = num;
                if (min > current){
                    min = num;
                }
            }
            System.out.println(min);
        }

    }
}
