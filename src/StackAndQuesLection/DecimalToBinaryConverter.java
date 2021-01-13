package StackAndQuesLection;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> number = new ArrayDeque<>();
        int input = Integer.parseInt(scan.nextLine());

        if (input == 0){
            System.out.println(0);
        }else{
            while (input != 0){
                number.push(input%2);
                input = input/2;
            }

            for (Integer num : number) {
                System.out.print(num);
            }
        }
    }
}
