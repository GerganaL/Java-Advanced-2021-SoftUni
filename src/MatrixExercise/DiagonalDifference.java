package MatrixExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scan, "\\s+");
        }

        sumDiagonals(matrix);

    }

    private static void sumDiagonals(int[][] matrix) {
        int sum = 0;
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            primaryDiagonal += matrix[row][row] ;
            secondaryDiagonal += matrix[row][matrix.length-1-row];
        }
        System.out.println(Math.abs(primaryDiagonal-secondaryDiagonal));
    }

    public static int[] readArray(Scanner scan, String separator) {
        return Arrays.stream(scan.nextLine().split(separator))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

}
