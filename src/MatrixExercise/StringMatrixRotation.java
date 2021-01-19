package MatrixExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int degrees = Integer.parseInt(input.substring(input.indexOf('(') + 1, input.indexOf(')'))) % 360;

        input = scan.nextLine();
        ArrayDeque<String> inputQueue = new ArrayDeque<>();
        int maxLength = 0;

        while (!input.equals("END")) {
            inputQueue.offer(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input = scan.nextLine();
        }

        char[][] charMatrix = new char[inputQueue.size()][maxLength];
        for (int i = 0; i < charMatrix.length; i++) {
            String row = inputQueue.poll();
            for (int j = 0; j < maxLength; j++) {
                if (row != null && j < row.length()) {
                    charMatrix[i][j] = row.charAt(j);
                } else {
                    charMatrix[i][j] = ' ';
                }
            }
        }

        if (degrees == 0) {
            rotationAt0(charMatrix);
        } else if (degrees == 90) {
            rotationAt90(charMatrix);
        }else if (degrees == 180) {
            rotationAt180(charMatrix);
        }else if (degrees == 270) {
            rotationAt270(charMatrix);
        }
    }

    private static void rotationAt270(char[][] charMatrix) {
            for (int col = charMatrix[0].length-1; col >= 0; col--) {
                for (char[] row : charMatrix) {
                    System.out.print(row[col]);
                }
                System.out.println();
            }
    }

    private static void rotationAt180(char[][] charMatrix) {
        for (int row = charMatrix.length -1; row >= 0; row--) {
            for (int col = charMatrix[0].length-1; col >= 0; col--) {
                System.out.print(charMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotationAt90(char[][] charMatrix) {
        for (int col = 0; col < charMatrix[0].length; col++) {
            for (int row = charMatrix.length -1 ;row >= 0 ; row--) {
                System.out.print(charMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotationAt0(char[][] charMatrix) {
        for (char[] row : charMatrix) {
            for (int col = 0; col < charMatrix[0].length; col++) {
               System.out.print(row[col]);
            }
            System.out.println();
        }
    }
}
