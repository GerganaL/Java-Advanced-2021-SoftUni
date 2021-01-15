package MultidimensionalArraysLections;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [][] firstMatrix = readMatrix(scan);
        int [][] secondMatrix = readMatrix(scan);

        boolean areEqual = compareMatrices(firstMatrix,secondMatrix);

        System.out.println(areEqual? "equal" : "not equal");

        System.out.println();
     }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        //length rows
        //броя на масивите
        if(firstMatrix.length != secondMatrix.length){
            return false;
        }

        //взимаме всеки един масив
        for (int row = 0; row < firstMatrix.length; row++) {
            int [] firstArr = firstMatrix[row];
            int [] secondArr = secondMatrix[row];
            if(firstArr.length != secondArr.length){
                return false;
            }

            for (int cols = 0; cols < firstArr.length; cols++) {
                if(firstArr[cols] != secondArr[cols]){
                    return false;
                }
            }
        }
        return true;
    }


    public static int [][] readMatrix(Scanner scan){
         String [] tokens = scan.nextLine().split("\\s+");
         int rows = Integer.parseInt(tokens[0]);
         int cols = Integer.parseInt(tokens[1]);

         int [][] firstMatrix = new int[rows][cols];

        /*for (int i = 0; i < rows; i++) {
            int [] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            firstMatrix[i] = arr;
        }*/

         for (int r = 0; r < rows; r++) {
             String[] line = scan.nextLine().split("\\s+");
             for (int c = 0; c < cols; c++) {
                 firstMatrix[r][c] = Integer.parseInt(line[c]);
             }
         }
         return  firstMatrix;

     }}
