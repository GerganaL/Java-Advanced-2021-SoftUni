package MoreEx;

import java.util.Scanner;

public class findTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = 8;
        int cols = 8;

        char[][] matrix = readCharMatrix(scan, rows, cols);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    if (checkIfQueen(matrix, row, col)) {
                        System.out.println(row + " " + col);
                    }
                }
            }
        }
    }

    private static boolean checkIfQueen(char[][] matrix, int row, int col) {
        int finalCol = col;
        int finalRow = row;

        while (--col >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        col = finalCol;
        while (++col < matrix.length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        col = finalCol;
        while (--row >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        row = finalRow;
        while (++row < matrix.length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        row = finalRow;
        while (--row >= 0 && --col >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        row = finalRow;
        col = finalCol;
        while (++row < matrix.length && ++col < matrix.length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        row = finalRow;
        col = finalCol;
        while (++row < matrix.length && --col >= 0) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }

        row = finalRow;
        col = finalCol;
        while (--row >= 0 && ++col < matrix.length) {
            if (matrix[row][col] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static char[][] readCharMatrix(Scanner scan, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] symbols = scan.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }
        return matrix;
    }
}
