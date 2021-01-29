package MoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int [] currentRow = Arrays.stream(scan.nextLine().split("\\s+"))
            .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = currentRow[col];
            }
        }

        findBiggestSum(matrix);
    }

    private static void findBiggestSum(int[][] matrix) {
        int biggestSum = Integer.MIN_VALUE;
        int[] bestVector = new int[2];
        for (int row = 0; row < matrix.length - 2 ; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int[] begin = {row,col};
                if(getSum(begin,matrix) > biggestSum){
                    biggestSum = getSum(begin,matrix);
                    bestVector = begin;
                }
            }
        }

        System.out.println("Sum = " + biggestSum);
        for (int row = bestVector[0]; row < bestVector[0]+3; row++) {
            for (int col = bestVector[1]; col < bestVector[1]+3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static int getSum(int[] begin, int[][] matrix) {
        int sum = 0;
        for (int row = begin[0]; row < begin[0] + 3 ; row++) {
            for (int col = begin[1]; col < begin[1] + 3 ; col++) {
                sum+= matrix[row][col];
            }
        }

        return sum;
    }
}
