package MatrixExercise;

import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rowAndCols = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowAndCols[0]);
        int cols = Integer.parseInt(rowAndCols[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        // print "/" diagonal for upper-left half of the matrix
        for (int r = 0; r < rows; r++)
        {
            // start from each cell of first column of the matrix
            for (int i = r, j = 0; j < cols && i >= 0; i--, j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.print(System.lineSeparator());
        }

        // print "/" diagonal for lower-right half of the matrix
        for (int c = 1; c < cols; c++)
        {
            // start from each cell of the last row
            for (int i = rows - 1, j = c; j < cols && i >= 0; i--, j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.print(System.lineSeparator());
        }
    }


        /*for(int j=cols-1; j>=0; j--){
            for(int k=0; k<rows; k++){
                if((j + k) < cols){
                    System.out.print(matrix[k][j + k] + " ");
                } else {
                    break;
                }
            }
            System.out.println();
        }
        for(int i=1; i<rows; i++){
            for(int j=i, k=0; j<rows && k<cols; j++, k++){
                System.out.print(matrix[j][k] + " ");
            }
            System.out.println();
        }*/


    public static void print(int [][] a){

        //print first half
        int row =0;
        int col;

        while(row<a.length){
            col =0;
            int rowTemp = row;
            while(rowTemp>=0){
                System.out.print(a[rowTemp][col] + " ");
                rowTemp--;
                col++;
            }
            System.out.println();
            row++;
        }

        //print second half
        col = 1;

        while(col<a.length){
            int colTemp = col;
            row = a.length-1;
            while(colTemp<=a.length-1){
                System.out.print(a[row][colTemp] + " ");
                row--;
                colTemp++;
            }
            System.out.println();
            col++;
        }

    }
}
