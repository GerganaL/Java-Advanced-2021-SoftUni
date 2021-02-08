package genericExercises.swap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
            Box<Integer> box = new Box<>();
        /*for (int i = 0; i < n; i++) {
            box.addValue(scan.nextLine());
        }*/

        for (int i = 0; i < n; i++) {
            box.addValue(Integer.parseInt(scan.nextLine()));
        }

        int index1 = scan.nextInt();
        int index2 = scan.nextInt();

        box.swap(index1,index2);

        System.out.println(box.toString());

    }
}
