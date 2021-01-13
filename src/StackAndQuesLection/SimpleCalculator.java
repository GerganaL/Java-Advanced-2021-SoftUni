package StackAndQuesLection;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] tokens = scan.nextLine().split("\\s+");
        ArrayDeque<Integer>  numbers = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if(Character.isDigit(token.charAt(0))){
                numbers.push(Integer.parseInt(token));
            }else {
                int rightOperand = Integer.parseInt((tokens[++i]));
                int leftOperand = numbers.peek();
                numbers.push(rightOperand);

                int result = token.equals("+")
                        ? leftOperand + rightOperand
                        : leftOperand - rightOperand;

                numbers.push(result);
            }
        }

        System.out.println(numbers.peek());

        while (!numbers.isEmpty()){
            System.out.println(numbers.pop());
        }

    }
}
