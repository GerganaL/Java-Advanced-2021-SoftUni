package guild;

import java.util.Scanner;

public class ReVolt {
    static int playerRow;
    static int playerCol;
    static int[] position;
    static boolean won;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int countOfCommands = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][];

        readMatrix(scan, size, matrix);

        won = false;

        while (countOfCommands-- > 0 && !won) {
            String command = scan.nextLine();
            matrix[playerRow][playerCol] = '-';
            position = new int[]{playerRow, playerCol};
            checkMove(command, matrix);
            moveTo(matrix, command);
        }

        if (!won) {
            System.out.println("Player lost!");
        } else {
            System.out.println("Player won!");
        }

        printMatrix(matrix);


    }

    private static boolean moveTo(char[][] matrix, String command) {
        if (matrix[playerRow][playerCol] == 'B') {
            checkMove(command, matrix);
            moveTo(matrix,command);
        } else if (matrix[playerRow][playerCol] == 'T') {
            playerRow = position[0];
            playerCol = position[1];
            matrix[playerRow][playerCol] = 'f';
        } else if (matrix[playerRow][playerCol] == 'F') {
            matrix[playerRow][playerCol] = 'f';
            won = true;
        } else {
            matrix[playerRow][playerCol] = 'f';

        }
        return won;
    }

    private static void checkMove(String command, char[][] matrix) {
        switch (command) {
            case "up":
                playerRow--;
                if (playerRow < 0) {
                    playerRow = matrix.length - 1;
                }
                break;
            case "down":
                playerRow++;
                if (playerRow > matrix.length - 1) {
                    playerRow = 0;
                }
                break;
            case "left":
                playerCol--;
                if (playerCol < 0) {
                    playerCol = matrix.length - 1;
                }
                break;
            case "right":
                playerCol++;
                if (playerCol > matrix.length - 1) {
                    playerCol = 0;
                }
                break;
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public static void readMatrix(Scanner scan, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            String currentRow = scan.nextLine();
            matrix[row] = currentRow.toCharArray();
            if (currentRow.contains("f")) {
                playerRow = row;
                for (int i = 0; i < currentRow.length(); i++) {
                    if (currentRow.charAt(i) == 'f') {
                        playerCol = i;
                    }
                }
            }
        }
    }
}
