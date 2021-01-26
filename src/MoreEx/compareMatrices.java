package MoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class compareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row1 = scan.nextInt();
        int col1 = scan.nextInt();
        scan.nextLine();
        int[][] matrix1 = new int[row1][col1];

        readMatrix(scan, row1, col1, matrix1);

        int row2 = scan.nextInt();
        int col2 = scan.nextInt();
        scan.nextLine();
        int[][] matrix2 = new int[row2][col2];

        readMatrix(scan, row2, col2, matrix2);

        if (checkEqual(matrix1, matrix2, row1, col1, row2, col2)) {
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }

    private static boolean checkEqual(int[][] matrix1, int[][] matrix2, int row1, int col1, int row2, int col2) {
        if (row1 != row2 || col1 != col2) {
            return false;
        }else {
            for (int row = 0; row < matrix1.length; row++) {
                for (int col = 0; col < matrix1[row].length; col++) {
                    if(matrix1[row][col] != matrix2[row][col]){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static void readMatrix(Scanner scan, int row, int col, int[][] matrix1) {
        for (int i = 0; i < row; i++) {
            int[] line = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < col; j++) {
                matrix1[i][j] = line[j];
            }
        }
    }
}
