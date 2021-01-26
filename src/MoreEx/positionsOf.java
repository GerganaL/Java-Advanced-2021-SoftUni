package MoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class positionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        int[][] matrix = new int[rows][cols];
        readMatrix(scan, matrix);

        int number = scan.nextInt();

        findOccurences(number,matrix);
    }

    private static void findOccurences(int number, int[][] matrix) {
        boolean isOccured = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == number){
                    isOccured = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if(!isOccured){
            System.out.println("not found");
        }
    }

    private static void readMatrix(Scanner scan, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int [] line = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = line[j];
            }
        }
    }
}
