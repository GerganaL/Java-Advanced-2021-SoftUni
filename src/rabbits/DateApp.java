package rabbits;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DateApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(males::push);

        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(females::offer);

        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {

            if (males.peek() % 25 == 0 || females.peek() % 25 == 0 || males.peek() <= 0 || females.peek() <= 0) {
                removeFromCollection(males);
                removeFromCollection(females);
            } else {
                if (females.peek().equals(males.peek())) {
                    males.poll();
                    matches++;
                } else {
                    males.push(males.pop() - 2);
                }
                females.pop();
            }
        }
        System.out.println("Matches: " + matches);

        if(males.isEmpty()){
            System.out.println("Males left: none");
        }else{
            System.out.println("Males left: " + males.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if(females.isEmpty()){
            System.out.println("Females left: none");
        }else{
            System.out.println("Females left: " + females.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

    }


    private static void removeFromCollection(ArrayDeque<Integer> collection) {
        if (collection.peek() <= 0) {
            collection.pop();
        } else if (collection.peek() % 25 == 0) {
            collection.pop();
            collection.pop();
        }
    }
}
