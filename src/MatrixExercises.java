import java.util.Scanner;

public class MatrixExercises {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input = scan.nextLine().split(", ");
        int dimension = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] newMatrix = fillMAtrix(dimension,type);
        printMatrix(newMatrix);
    }

    private static void printMatrix(int[][] newMatrix) {
        for (int[] row : newMatrix) {
            for (int element : row) {
                System.out.print(String.format("%d ",element));
            }
            System.out.println();
        }
    }

    /**
     *
     * @param dimension големина на матрицата
     * @param type тип А или В
     * @return
     */

    private static int[][] fillMAtrix(int dimension, String type) {
        int[][] matrix = new int [dimension][dimension];
        if(type.equals("A")) {
            fillPatternA(matrix);
        }else if (type.equals("B")) {
            fillPatternB(matrix);
        }
        return matrix;
    }

    private static void fillPatternB(int[][] matrix) {
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            if( i%2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = number++;
                }
            }else {
                for (int j = matrix[i].length - 1; j >= 0 ; j--) {
                    matrix[j][i] = number++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] matrix) {
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = number++;
            }
        }
    }


}
