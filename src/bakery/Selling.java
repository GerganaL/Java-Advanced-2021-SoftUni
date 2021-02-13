package bakery;

import java.util.Scanner;

public class Selling {
    static int playerRow;
    static int playerCol;
    static int money = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = readMatrix(scan, n);
        boolean isOut = true;

        while (money < 50 && isOut) {
            String command = scan.nextLine();
            int rowToGo = playerRow;
            int colToGo = playerCol;
            switch (command) {
                case "up":
                    isOut = move(playerRow, playerCol, rowToGo - 1, colToGo, matrix);
                    break;
                case "down":
                    isOut = move(playerRow, playerCol, rowToGo + 1, colToGo, matrix);
                    break;
                case "left":
                    isOut = move(playerRow, playerCol, rowToGo, colToGo - 1, matrix);
                    break;
                case "right":
                    isOut = move(playerRow, playerCol, rowToGo, colToGo + 1, matrix);
                    break;
            }
        }


        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }else {
            System.out.println("Bad news, you are out of the bakery.");
        }

        System.out.println("Money: " + money);

        printMatrix(matrix);

    }

    private static boolean move(int currentRow, int currentCol, int row, int col, char[][] matrix) {
        matrix[currentRow][currentCol] = '-';
        if (!inBounds(row, col, matrix)) {
            return false;

        }
        char symbol = matrix[row][col];
        if (Character.isDigit(symbol)) {
            money += Integer.parseInt(String.valueOf(symbol));
            matrix[row][col] = 'S';
        }else if(symbol == 'O'){
            matrix[row][col] = '-';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[row].length; j++) {
                    if(matrix[i][j] == 'O'){
                        matrix[i][j] = 'S';
                        row = i;
                        col = j;
                    }
                }
            }
        }else {
            matrix[row][col] = 'S';
        }

        playerRow = row;
        playerCol = col;
        return true;
    }

    private static boolean inBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }


    private static char[][] readMatrix(Scanner scan, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String line = scan.nextLine();
            if (line.contains("S")) {
                playerRow = row;
                playerCol = line.indexOf("S");
            }
            matrix[row] = line.toCharArray();
        }

        return matrix;
    }
}
