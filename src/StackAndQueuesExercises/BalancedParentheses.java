package StackAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean result = true;
        char [] brackets = input.toCharArray();

        for (char bracket : brackets) {
            switch (bracket){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if(stack.isEmpty() || stack.pop() != bracket){
                        result = false;
                    }
                    break;
            }
            if (!result){
                break;
            }
        }
        System.out.println(result ? "YES" : "NO");

    }
}
