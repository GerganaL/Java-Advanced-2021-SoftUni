package MatrixExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
/*
        int r = scan.nextInt();
        int c = scan.nextInt();
        if(r + c <= 27 && r >= 1 && r <= 26 && c >= 1 && c <= 26){
            String[][] matrix = new String[r][c];
            StringBuilder startLetter = new StringBuilder();
            startLetter.append("aaa");
            char start = 'a';
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = startLetter.toString();
                    char cha = (char) (startLetter.charAt(1) + 1);
                    startLetter.insert(1,cha);
                    startLetter.deleteCharAt(2);
                }
                start++;
                startLetter = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    startLetter.append(start);
                }
            }

            for (String[] row : matrix) {
                for (String element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }*/

        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        String[][] matrix = new String[input[0]][input[1]];
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
