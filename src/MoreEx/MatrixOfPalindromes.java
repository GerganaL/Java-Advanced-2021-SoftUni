package MoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        String[][] matrix = new String[row][col];
        fillMatrix(matrix);
        Arrays.stream(matrix).forEach(r -> {
            Arrays.stream(r).forEach(e -> System.out.print(e + " "));
            System.out.println();
        });
    }

    private static void fillMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.format("%c%c%c", 97 + i, 97 + i + j, 97 + i);
            }
        }
    }
}
