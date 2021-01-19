package MatrixExercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        int dimension = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix = fillMatrix(dimension, type);
        printMatrix(matrix);
    }

    private static int[][] fillMatrix(int dimension, String type) {
        int[][] matrix = new int[dimension][dimension];
        if (type.equals("A")) {
            fillPatternA(matrix);
        } else if (type.equals("B")) {
            fillPatternB(matrix);
        }
        return matrix;
    }

    private static void fillPatternB(int[][] matrix) {
        int start = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[col][row] = start++;
                }
            } else {
                for (int col =  matrix[row].length -1; col >= 0; col--) {
                    matrix[col][row] = start++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] matrix) {
        int start = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = start++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int element : rows) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

