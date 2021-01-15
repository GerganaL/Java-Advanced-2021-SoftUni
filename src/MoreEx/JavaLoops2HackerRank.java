package MoreEx;

import java.util.Scanner;

public class JavaLoops2HackerRank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //number of queries
        int q = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < q; i++) {
            String [] lineOfNumbers = scan.nextLine().split("\\s+");
            int a = Integer.parseInt(lineOfNumbers[0]);
            int b = Integer.parseInt(lineOfNumbers[1]);
            int n = Integer.parseInt(lineOfNumbers[2]);

            int result = 0;

            for (int j = 0; j < n; j++) {

                result += Math.pow(b,j) * b;
                System.out.print(result + a + " ");
            }
        }
        System.out.println();

    }
}
