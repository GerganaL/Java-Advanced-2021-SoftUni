package MoreEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        String[][] matrix = new String[rows][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split("\\s+");

        }

        String regex = "^swap (\\d+) (\\d+) (\\d+) (\\d+)$";
        Pattern pattern = Pattern.compile(regex);

        String line = scan.nextLine();

        while (!line.equals("END")) {
            Matcher matcher = pattern.matcher(line);
            boolean isValid = true;
            if (matcher.matches()) {
                int row1 = Integer.parseInt(matcher.group(1));
                int col1 = Integer.parseInt(matcher.group(2));
                int row2 = Integer.parseInt(matcher.group(3));
                int col2 = Integer.parseInt(matcher.group(4));
                boolean isInArray = row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows
                        && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols;
                if (isInArray) {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    printArray(matrix);
                } else {
                    isValid = false;
                }
            } else {
                isValid = false;
            }
            if (!isValid) {
                System.out.println("Invalid input!");
            }

            line = scan.nextLine();
        }

    }


    private static void printArray(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element : row) {
                System.out.printf("%s ", element);
            }
            System.out.println();
        }
    }
}

