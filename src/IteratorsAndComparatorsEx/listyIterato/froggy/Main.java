package IteratorsAndComparatorsEx.listyIterato.froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] stones = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(stones);
        Iterator<Integer> froggy = lake.iterator();

        List<String> result = new ArrayList<>();
        while (froggy.hasNext()){
            result.add(froggy.next() + "" );
        }

        System.out.println(String.join(", ",result));

    }
}
