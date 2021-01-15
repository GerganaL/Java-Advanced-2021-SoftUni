package StackAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] input = scan.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String s : input) {
            if (Character.isDigit(s.charAt(0)) || Character.isAlphabetic(s.charAt(0))){
                queue.offer(s);
            }else{
                if(stack.isEmpty()){
                    stack.push(s);
                }else {
                    String lastOperator = stack.peek();
                    switch (s){
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")){
                                stack.push(s);
                            }else {
                                queue.offer(stack.pop());
                                stack.push(s);
                            }
                            break;
                        case "*":
                        case "/":
                            if(lastOperator.equals("*") || lastOperator.equals("/")){
                                queue.offer(stack.pop());
                                stack.push(s);
                            }else {
                                stack.push(s);
                            }
                            break;
                        case "(":
                            stack.push(s);
                            break;
                        case ")":
                            while (!stack.peek().equals("(")){
                                queue.offer(stack.pop());
                            }
                            stack.pop();
                            break;
                    }
                }
            }
        }
        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
