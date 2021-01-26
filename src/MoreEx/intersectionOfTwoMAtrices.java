package MoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class intersectionOfTwoMAtrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = readMatrix(scan,rows,cols);
        char[][] secondMatrix = readMatrix(scan,rows,cols);

        checkDifference(firstMatrix,secondMatrix);
    }

    private static void checkDifference(char[][] firstMatrix, char[][] secondMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]){
                    System.out.print(firstMatrix[row][col] + " ");
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static char[][] readMatrix(Scanner scan,int rows, int cols){
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String [] symbols = scan.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }
        return matrix;
    }
}
