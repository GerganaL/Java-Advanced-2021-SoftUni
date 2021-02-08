package genericExercises.threeTuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");
        String name = String.format("%s %s",tokens[0],tokens[1]);
        String address = tokens[2];
        String town = tokens[3];
        Tuple<String,String,String> tuple = new Tuple<>(name,address,town);
        System.out.println(tuple);

        tokens = scan.nextLine().split("\\s+");
        name = tokens[0];
        int beers = Integer.parseInt(tokens[1]);
        boolean drunk = "drunk".equals(tokens[2]);
        Tuple<String,Integer,Boolean> personBeer = new Tuple<>(name,beers,drunk);
        System.out.println(personBeer);

        tokens = scan.nextLine().split("\\s+");
        String accName = tokens[0];
        double floatNum = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];
        Tuple<String,Double,String> numbers = new Tuple<>(accName,floatNum,bankName);
        System.out.println(numbers);

    }
}
