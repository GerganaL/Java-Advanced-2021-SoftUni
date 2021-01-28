package MoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {
            int [] currentRow = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }

        printResult(matrix);
    }

    private static void printResult(int[][] matrix) {
        int primaryDiagonal = findPrimaryDiagonal(matrix);
        int secondaryDiagonal = findSecondaryDiagonal(matrix);

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }

    private static int findPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        int row = 0;
        while (row < matrix.length){
            sum += matrix[row][row];
            row++;
        }
        return sum;
    }

    private static int findSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int row = matrix.length - 1;

        while (row >= 0){
            sum += matrix[row][matrix.length - 1 - row];
            row--;
        }
        return sum;
    }
}
