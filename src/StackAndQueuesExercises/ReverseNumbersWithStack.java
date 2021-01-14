package StackAndQueuesExercises;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> input = new ArrayList<>();
        
        
        for (String s : scan.nextLine().split("\\s+")) {
            int i = Integer.parseInt(s);
            input.add(i);
        }
        ArrayDeque<Integer> numbers =  new ArrayDeque<>();



        for (Integer num : input) {
            numbers.push(num);
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }


    }
}
