package MatrixExercise;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] nm = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] matrix = readMatrix(scan,n,m);

        int maxSum = Integer.MIN_VALUE;
        int [] bestVector = new int[2];

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int [] start = new int[]{row,col};
                if(findSum(start,matrix) > maxSum){
                    maxSum = findSum(start,matrix);
                    bestVector = start;
                }
            }
        }
        System.out.println(String.format("Sum = %d", maxSum));
        printMatrix(bestVector, matrix);

    }

    private static int findSum(int[] vector, int[][] matrix) {
        int sum = 0;
        for (int row = vector[0]; row < vector[0] + 3; row++) {
            for (int col = vector[1]; col < vector[1] + 3; col++) {
                sum+= matrix[row][col];
            }
        }
        return sum;
    }

    private static void printMatrix(int[]vector, int[][] matrix) {
        for (int row = vector[0]; row < vector[0]+3 ; row++) {
            for (int col = vector[1]; col < vector[1]+3; col++) {
                System.out.print(String.format("%d ", matrix[row][col]));
            }
            System.out.println();
        }
    }

    public static int [][] readMatrix(Scanner scan, int rows, int cols){
        int [][] firstMatrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int c = 0; c < cols; c++) {
                firstMatrix[r][c] = Integer.parseInt(line[c]);
            }
        }
        return  firstMatrix;
    }
}
