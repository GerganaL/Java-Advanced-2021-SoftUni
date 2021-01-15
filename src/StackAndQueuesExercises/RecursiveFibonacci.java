package StackAndQueuesExercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long [] fibMemoryArray = new long[60];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        fibMemoryArray[0] = 1;
        fibMemoryArray[1] = 1;
        System.out.println(Fibonacci(input + 1));
    }

    private static long Fibonacci(long n) {
        long fib = 0;
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else if (fibMemoryArray[(int) n] != 0){
            return fibMemoryArray[(int) n];
        }else {
            fib = Fibonacci(n - 1) + Fibonacci(n - 2);
            fibMemoryArray[(int) n] = fib;
            return fib;
        }
    }
}
