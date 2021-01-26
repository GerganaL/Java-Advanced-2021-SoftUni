package MoreEx;

import java.util.Scanner;

public class sumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] sizes = scan.nextLine().split(", ");
        int[][] matrix = new int[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            String[] row = scan.nextLine().split(", ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
                sum += Integer.parseInt(row[j]);
            }
        }

        System.out.println(sizes[0]);
        System.out.println(sizes[1]);
        System.out.println(sum);
    }
}
