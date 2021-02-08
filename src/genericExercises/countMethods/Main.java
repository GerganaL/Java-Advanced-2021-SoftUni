package genericExercises.countMethods;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Box<Double> box = new Box<>();
       /* for (int i = 0; i < n; i++) {
            box.addValue(scan.nextLine());
        }*/

        for (int i = 0; i < n; i++) {
            box.addValue(Double.parseDouble(scan.nextLine()));
        }
        double toCompare = Double.parseDouble(scan.nextLine());
        System.out.println(box.countElements(toCompare));

    }
}
