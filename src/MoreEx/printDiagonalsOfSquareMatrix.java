package MoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class printDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimension = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            String[] currentRow = scan.nextLine().split("\\s+");
            for (int col = 0; col < currentRow.length; col++) {
                matrix[row][col] = Integer.parseInt(currentRow[col]);
            }
        }

       /* for (int row = 0; row < dimension; row++) {
            int [] currentRow = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }*/

        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }

        System.out.println();
        for (int index = 0; index < matrix.length; index++) {
            System.out.print(matrix[(matrix.length-1)-index][index] + " ");
        }

    }
}

