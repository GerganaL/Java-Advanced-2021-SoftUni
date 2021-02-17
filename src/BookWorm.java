package rabbits;

import java.util.Arrays;
import java.util.Scanner;

public class BookWorm {
    static int playerRow;
    static int playerCol;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        sb = new StringBuilder(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = readMatrix(scan, n);

        String command = scan.nextLine();

        while (!command.equals("end")) {
            int rows = playerRow;
            int col = playerCol;

            switch (command) {
                case "up":
                    move(rows - 1, col, matrix);
                    break;
                case "down":
                    move(rows + 1, col, matrix);
                    break;
                case "left":
                    move(rows, col - 1, matrix);
                    break;
                case "right":
                    move(rows, col + 1, matrix);
                    break;
            }
            command = scan.nextLine();
        }

        System.out.println(sb.toString());
        printMatrix(matrix);
    }

    private static void move(int currentRow, int currentCol, char[][] matrix) {
        matrix[playerRow][playerCol] = '-';
        if (inBounds(currentRow, currentCol, matrix)) {
            char symbol = matrix[currentRow][currentCol];
            if (symbol != 'P' && Character.isAlphabetic(symbol)) {
                sb.append(symbol);
            }
            playerRow = currentRow;
            playerCol = currentCol;
        } else {
            if(sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        matrix[playerRow][playerCol] = 'P';
    }

    private static boolean inBounds(int row, int col, char[][] matrix) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner scan, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String currentLine = scan.nextLine();
            if (currentLine.contains("P")) {
                playerRow = row;
                playerCol = currentLine.indexOf("P");
            }
            matrix[row] = currentLine.toCharArray();
        }
        return matrix;
    }

}
