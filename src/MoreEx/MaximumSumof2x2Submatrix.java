package MoreEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumSumof2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] size = scan.nextLine().split(", ");
        int [][] matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

        for (int i = 0; i < matrix.length; i++) {
            String [] currentRow = scan.nextLine().split(", ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(currentRow[j]);
            }
        }
        
        getBiggestMatrix(matrix);
    }

    private static void getBiggestMatrix(int[][] matrix) {
        int biggestSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int [][] littleMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                currentSum = matrix[row][col] + matrix[row][col+1]
                        + matrix[row + 1] [col] + matrix[row + 1][col + 1];

                if(currentSum > biggestSum){
                    biggestSum = currentSum;
                    littleMatrix[0][0] = matrix[row][col];
                    littleMatrix[0][1] = matrix[row][col + 1];
                    littleMatrix[1][0] = matrix[row + 1][col];
                    littleMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }
        for (int i = 0; i < littleMatrix.length; i++) {
            for (int j = 0; j < littleMatrix[i].length; j++) {
                System.out.print(littleMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(biggestSum);
    }
}
