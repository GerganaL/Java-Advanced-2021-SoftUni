package StackAndQuesLection;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expressions = scan.nextLine();

        ArrayDeque<Integer> indexesOfOpenBrackets = new ArrayDeque<>();

        for (int i = 0; i < expressions.length(); i++) {
            char symbol = expressions.charAt(i);
            if (symbol == '(') {
            indexesOfOpenBrackets.push(i);
            } else if (symbol == ')') {
                System.out.println(expressions.substring(indexesOfOpenBrackets.pop(),i+1));
            }
        }
    }
}
