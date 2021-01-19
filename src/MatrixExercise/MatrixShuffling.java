package MatrixExercise;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] nm = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[][] matrix = readMatrix(scan,n,m);

        String input = scan.nextLine();
        while (!input.equals("END")){
            String [] commands = input.split("\\s+");
            if(commands[0].equals("swap")){
                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);
                swapElements(matrix,row1,col1,row2,col2);
            }else{
                System.out.println("Invalid output!");
            }
            input = scan.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void swapElements(String[][] matrix, int row1, int col1, int row2, int col2) {
        if(isValid(row1,col1,matrix) && isValid(row2,col2,matrix)){
            String current = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = current;
            printMatrix(matrix);
        }else{
            System.out.println("Invalid input!");
        }
    }

    private static boolean isValid(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static String [][] readMatrix(Scanner scan, int rows, int cols){
        String [][] firstMatrix = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int c = 0; c < cols; c++) {
                firstMatrix[r][c] = line[c];
            }
        }
        return  firstMatrix;
    }
}
