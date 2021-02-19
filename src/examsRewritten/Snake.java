package examsRewritten;

import java.util.Scanner;

public class Snake {
    static int snakeRow;
    static int snakeCol;
    static int foodQuantity;
    static boolean isOut;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = readMatrix(scan, n);

        while (!isOut) {
            String command = scan.nextLine();
            matrix[snakeRow][snakeCol] = '.';
            switch (command) {
                case "up":
                    snakeRow--;
                    isOut = move(snakeRow, snakeCol, matrix);
                    break;
                case "down":
                    snakeRow++;
                    isOut = move(snakeRow, snakeCol, matrix);
                    break;
                case "left":
                    snakeCol--;
                    isOut = move(snakeRow, snakeCol, matrix);
                    break;
                case "right":
                    snakeCol++;
                    isOut = move(snakeRow, snakeCol, matrix);
                    break;
            }
            if (foodQuantity >= 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }
        }
        if (isOut) {
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: " + foodQuantity);
        printMatrix(matrix);
    }

    private static boolean move(int row, int col, char[][] matrix) {
        if (inBounds(row, col, matrix)) {
            char symbol = matrix[row][col];
            switch (symbol) {
                case '*':
                    foodQuantity++;
                    break;
                case 'B':
                    matrix[row][col] = '.';
                    for (int r = 0; r < matrix.length; r++) {
                        for (int c = 0; c < matrix[r].length; c++) {
                            if (matrix[r][c] == 'B') {
                                row = r;
                                col = c;
                                break;
                            }
                        }
                    }
                    break;
            }
            matrix[row][col] = 'S';
            snakeRow = row;
            snakeCol = col;
        } else {
            isOut = true;
        }
        return isOut;
    }

    private static boolean inBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
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
        char[][] matrix = new char[n][];
        for (int row = 0; row < matrix.length; row++) {
            String currentLine = scan.nextLine();
            if (currentLine.contains("S")) {
                snakeRow = row;
                snakeCol = currentLine.indexOf("S");
            }
            matrix[row] = currentLine.toCharArray();
        }
        return matrix;
    }


}
