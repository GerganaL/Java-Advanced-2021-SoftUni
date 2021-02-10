package guild;

import java.util.Scanner;

public class ReVolt {
    static int playerRow;
    static int playerCol;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int countOfCommands = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][];

        readMatrix(scan, size, matrix);

        boolean won = false;

        for (int i = 0; i < countOfCommands; i++) {
            if(!won) {
                String command = scan.nextLine();
                switch (command) {
                    case "up":
                        matrix[playerRow][playerCol] = '-';
                        playerRow--;
                        if (isOut(playerRow, playerCol, matrix)) {
                            playerRow = matrix.length - 1;
                            matrix[playerRow][playerCol] = 'f';
                        } else {
                            if (matrix[playerRow][playerCol] == 'B') {
                                playerRow--;
                                if (isOut(playerRow, playerCol, matrix)) {
                                    playerRow = matrix.length - 1;
                                    matrix[playerRow][playerCol] = 'f';
                                }
                                matrix[playerRow][playerCol] = 'f';
                            } else if (matrix[playerRow][playerCol] == 'T') {
                                playerRow++;
                                matrix[playerRow][playerCol] = 'f';

                            } else if (matrix[playerRow][playerCol] == 'F') {
                                matrix[playerRow][playerCol] = 'f';
                                System.out.println("Player won!");
                                won = true;
                                break;
                            } else {
                                matrix[playerRow][playerCol] = 'f';

                            }
                        }
                        break;
                    case "down":
                        matrix[playerRow][playerCol] = '-';
                        playerRow++;
                        if (isOut(playerRow, playerCol, matrix)) {
                            playerRow = 0;
                            matrix[playerRow][playerCol] = 'f';
                        } else {
                            //move(playerRow,playerCol,matrix);
                            if (matrix[playerRow][playerCol] == 'B') {
                                playerRow++;
                                if (isOut(playerRow, playerCol, matrix)) {
                                    playerRow = 0;
                                    matrix[playerRow][playerCol] = 'f';
                                }
                                matrix[playerRow][playerCol] = 'f';
                            } else if (matrix[playerRow][playerCol] == 'T') {
                                playerRow--;
                                matrix[playerRow][playerCol] = 'f';

                            } else if (matrix[playerRow][playerCol] == 'F') {
                                matrix[playerRow][playerCol] = 'f';
                                System.out.println("Player won!");
                                won = true;
                                break;
                            } else {
                                matrix[playerRow][playerCol] = 'f';

                            }
                        }
                        break;
                    case "left":
                        matrix[playerRow][playerCol] = '-';
                        playerCol--;
                        if (isOut(playerRow, playerCol, matrix)) {
                            playerCol = matrix[playerRow].length - 1;
                            matrix[playerRow][playerCol] = 'f';
                        } else {
                            //move(playerRow,playerCol,matrix);
                            if (matrix[playerRow][playerCol] == 'B') {
                                playerCol--;
                                if (isOut(playerRow, playerCol, matrix)) {
                                    playerCol = matrix[playerRow].length - 1;
                                    matrix[playerRow][playerCol] = 'f';
                                }
                                matrix[playerRow][playerCol] = 'f';
                            } else if (matrix[playerRow][playerCol] == 'T') {
                                playerCol++;
                                matrix[playerRow][playerCol] = 'f';

                            } else if (matrix[playerRow][playerCol] == 'F') {
                                matrix[playerRow][playerCol] = 'f';
                                System.out.println("Player won!");
                                won = true;
                                break;
                            } else {
                                matrix[playerRow][playerCol] = 'f';

                            }
                        }
                        break;
                    case "right":
                        matrix[playerRow][playerCol] = '-';
                        playerCol++;
                        if (isOut(playerRow, playerCol, matrix)) {
                            playerCol = 0;
                            matrix[playerRow][playerCol] = 'f';
                        }   //move(playerRow,playerCol,matrix);
                        if (matrix[playerRow][playerCol] == 'B') {
                            playerCol++;
                            if (isOut(playerRow, playerCol, matrix)) {
                                playerCol = 0;
                                matrix[playerRow][playerCol] = 'f';
                            }
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow][playerCol] == 'T') {
                            playerCol--;
                            matrix[playerRow][playerCol] = 'f';

                        } else if (matrix[playerRow][playerCol] == 'F') {
                            matrix[playerRow][playerCol] = 'f';
                            System.out.println("Player won!");
                            won = true;
                            break;
                        } else {
                            matrix[playerRow][playerCol] = 'f';

                        }
                        break;
                }
            }
        }

        if (!won) {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);


    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void moveForwards(int playerRow, int playerCol, char[][] matrix) {
        if (matrix[playerRow][playerCol] == 'B') {

        } else if (matrix[playerRow][playerCol] == 'T') {

        } else if (matrix[playerRow][playerCol] == 'F') {

        }
    }

    public static boolean isOut(int row, int col, char[][] matrix) {
        return row < 0 || row > matrix.length || col < 0 || col > matrix[row].length;
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
