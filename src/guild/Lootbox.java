package guild;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(firstBox::offer);

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondBox::push);

        int sum = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int first = firstBox.peek();
            int second = secondBox.peek();
            if ((first + second) % 2 == 0) {
                sum += (first + second);
                firstBox.poll();
                secondBox.pop();
            } else {
                secondBox.pop();
                firstBox.addLast(second);
            }
        }

        if(firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if(secondBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }
        if(sum >= 100){
            System.out.println("Your loot was epic! Value: " + sum);
        }else {
            System.out.println("Your loot was poor... Value: " + sum);
        }
    }
}
