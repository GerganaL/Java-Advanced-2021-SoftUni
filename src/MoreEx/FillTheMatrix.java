package MoreEx;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix;
        if (pattern.equals("A")) {
            matrix = fillMatrixA(size);
        } else {
            matrix = fillMatrixB(size);
        }
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] numbers : matrix) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixB(int size) {
        int[][] matrix = new int[size][size];
        int number = 1;
        int col = 0;
        int row = 0;

        while (col < matrix.length) {
            if (col % 2 == 0) {
                row = 0;
                while (row < matrix.length) {
                    matrix[row][col] = number++;
                    row++;
                }
            } else {
                row = matrix.length - 1;
                while (row >= 0){
                    matrix[row][col] = number++;
                    row--;
                }
            }
            col++;
        }


        return matrix;
    }

    private static int[][] fillMatrixA(int size) {
        int[][] matrix = new int[size][size];
        int number = 1;
        int row = 0;
        int col = 0;

        while (row < matrix.length) {
            while (col < matrix.length){
                matrix[col][row] = number++;
                col++;
            }
            col = 0;
            row++;
        }

        return matrix;
    }

}
