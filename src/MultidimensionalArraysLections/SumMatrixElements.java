package MultidimensionalArraysLections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] arr = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = arr[0];
        int cols = arr[1];


        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] =  Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        //int sum = 0;

        /*int sum = Arrays.stream(matrix)
                .flatMapToInt(IntStream::of)
                .sum();
*/
        int sum = Arrays.stream(matrix)
                .mapToInt(ar -> Arrays.stream(ar).sum())
                .sum();
/*
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];
                sum += currentNumber;
            }
        }*/

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
