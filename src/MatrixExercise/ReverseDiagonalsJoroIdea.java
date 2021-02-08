package MatrixExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseDiagonalsJoroIdea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [][] matrix = readMatrix(scan);

        int row = matrix.length - 1;
        int col = matrix[row].length - 1;

        while (col >= 0){
            printDiagonal(col,row,matrix);
            if(col == 0){
                row--;
                while (row >= 0){
                    printDiagonal(col,row,matrix);
                    row--;
                }
            }
            col--;
        }
    }

    private static void printDiagonal(int col, int row, int[][] matrix) {
        int increaseCol = 0;
        for (int i = row; i >= 0 ; i--) {
            if((col + increaseCol < matrix[row].length)){
                System.out.printf("%d ", matrix[i][col + increaseCol]);
            }else {
                break;
            }
            increaseCol++;
        }
        System.out.println();
    }

    private static int[][] readMatrix(Scanner scan) {
        int [] size = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int [][] matrix = new int[size[0]][size[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
