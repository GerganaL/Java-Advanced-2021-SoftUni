package StackAndQuesLection;

import java.util.*;

public class demo {
    public static void main(String[] args) {

        int [] number = new int[32];
        System.out.println(number.length*Integer.BYTES);
        Scanner scan = new Scanner(System.in);


        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();

        //push(T)
        // T pop() -> this will remove the top element
        // T peek()

//        stackOfNumbers.push(13);
//        stackOfNumbers.push(42);

       // System.out.println(stackOfNumbers.peek());
//        System.out.println(stackOfNumbers.pop());
//        System.out.println(stackOfNumbers.peek());
//        System.out.println(stackOfNumbers.pop());



        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.offer(42);
        priorityQueue.offer(13);
        priorityQueue.offer(73);
        priorityQueue.offer(69);

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());

        }


        // how to read queue from the console
        /*ArrayDeque<Integer> queue = Arrays.stream(scan.nextLine().split("\\s+"))
        .map(Integer::parseInt)
        .forEach();*/

    }
}
