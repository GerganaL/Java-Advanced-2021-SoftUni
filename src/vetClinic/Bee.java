package vetClinic;

import java.util.Arrays;
import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[] bee = new int[2];
        int polinateFlowers = 0;

        char[][] matrix = new char[n][n];
        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine();
            char[] row = input.toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = row[j];
                if (row[j] == 'B') {
                    bee[0] = i;
                    bee[1] = j;
                }
            }
        }

        String command = scan.nextLine();

        boolean isOut = false;
        while (!command.equals("End") && !isOut) {
            int row = bee[0];
            int col = bee[1];
            switch (command) {
                case "right":
                    if (inBounds(row, col + 1, matrix)) {
                        polinateFlowers = move(bee, polinateFlowers, matrix, row, col, col + 1, matrix[row], 1, col + 1, row, col + 2, col + 2);
                    } else {
                        lostBee();
                        isOut = true;
                        break;
                    }
                    break;
                case "left":
                    row = bee[0];
                    col = bee[1];
                    if (inBounds(row, col - 1, matrix)) {
                        polinateFlowers = move(bee, polinateFlowers, matrix, row, col, col - 1, matrix[row], 1, col - 1, row, col - 2, col - 2);
                    } else {
                        lostBee();
                        isOut = true;
                        break;
                    }
                    break;
                case "down":
                    row = bee[0];
                    col = bee[1];
                    if (inBounds(row + 1, col, matrix)) {
                        polinateFlowers = move(bee, polinateFlowers, matrix, row + 1, col, col, matrix[row], 0, row + 1, row + 2, col, row + 2);
                    } else {
                        lostBee();
                        isOut = true;
                        break;
                    }
                    break;
                case "up":
                    row = bee[0];
                    col = bee[1];
                    if (inBounds(row - 1, col, matrix)) {
                        polinateFlowers = move(bee, polinateFlowers, matrix, row - 1, col, col, matrix[row], 0, row - 1, row - 2, col, row - 2);
                    } else {
                        lostBee();
                        isOut = true;
                        break;
                    }
                    break;
            }
            if (!isOut) {
                command = scan.nextLine();
            }
        }
        if (polinateFlowers < 5) {
            System.out.println("The bee couldn't pollinate the flowers, she needed " + (5 - polinateFlowers) + " flowers more");
        } else {
            System.out.println("Great job, the bee manage to pollinate " + polinateFlowers + " flowers!");
        }

        if (isOut) {
            printMatrix(matrix);
        } else {
            printMatrixOri(matrix);
        }
    }



    public static void lostBee() {
        System.out.println("The bee got lost!");
    }

    private static int move(int[] bee, int polinateFlowers, char[][] matrix, int row, int col, int i2, char[] matrix2, int i3, int i4, int row2, int i5, int i6) {
        char symbol = matrix[row][i2];
        if (symbol == 'f') {
            polinateFlowers++;
            matrix[row][i2] = 'B';
            matrix2[col] = '.';
            bee[i3] = i4;
        } else if (symbol == 'O') {
            matrix[row][i2] = '.';
            if (inBounds(row, i2, matrix)) {
                if (matrix[row2][i5] == 'f') {
                    polinateFlowers++;
                }
                matrix[row2][i5] = 'B';
                matrix2[col] = '.';
                bee[i3] = i6;
            }
        } else {
            matrix[row][i2] = 'B';
            matrix2[col] = '.';
            bee[i3] = i4;
        }
        return polinateFlowers;
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).forEach(Bee::accept);
    }

    private static void accept(char[] chars) {
        for (char aChar : chars) {
            if (aChar == 'B') {
                System.out.print(".");
            } else {
                System.out.print(aChar);
            }
        }
        System.out.println();
    }

    private static void printMatrixOri(char[][] matrix) {
        Arrays.stream(matrix).forEach(chars -> {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        });
    }

    private static boolean inBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }


}
