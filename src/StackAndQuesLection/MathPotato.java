package StackAndQuesLection;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] kids = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        int cycle = 1;

        ArrayDeque<String> names = new ArrayDeque<>();

        for (String kid : kids) {
            names.offer(kid);
        }

        while (names.size() > 1){

            for (int i = 1; i < n ; i++) {
                names.offer(names.poll());
            }
            if(isPrime(cycle)){
                System.out.println("Prime " + names.peek());
            }else{
                System.out.println("Removed " + names.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + names.poll());
    }

    private static boolean isPrime (int n){
        boolean primeCheck = true;
        if(n == 0 || n == 1){
           primeCheck = false;
        }else {
            for (int i = 2; i <= Math.sqrt(n)  ; i++) {
                if (n % i == 0){
                    primeCheck = false;
                }
            }
        }
        return primeCheck;
    }}
