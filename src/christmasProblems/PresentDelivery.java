package christmasProblems;
import java.util.Scanner;

public class PresentDelivery {
    static int kindKids = 0;
    static int newRowSanta = 0;
    static  int  newColSanta = 0;
    static int countOfPresents;
    static int givenToNiceKids;
    static boolean notRanOut = false;
    static char[][] matrix;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        countOfPresents = Integer.parseInt(scan.nextLine());

        int size = Integer.parseInt(scan.nextLine());

        matrix = readCharMatrix(scan, size);

        findSanta(matrix);
        findKindKids(matrix);

        boolean isOut = false;

        String command = scan.nextLine();
        while (!command.equals("Christmas morning")) {
            switch (command) {
                case "up":
                    isOut = checkIfContinue(isOut, newRowSanta - 1, newColSanta);
                    break;
                case "down":
                    isOut = checkIfContinue(isOut, newRowSanta + 1, newColSanta);
                    break;
                case "left":
                    isOut = checkIfContinue(isOut, newRowSanta, newColSanta -1);
                    break;
                case "right":
                    isOut = checkIfContinue(isOut, newRowSanta, newColSanta + 1);
                    break;
            }
            if (countOfPresents > 0) {
                command = scan.nextLine();
            } else {
                break;
            }

        }

        int notGiven = kindKids - givenToNiceKids;

        if (countOfPresents <= 0 && !notRanOut) {
            System.out.println("Santa ran out of presents!");
        }

        if (isOut) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(matrix);

        if (givenToNiceKids >= kindKids) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", givenToNiceKids);
        } else {
            System.out.printf("No presents for %s nice kid/s.%n", notGiven);
        }
    }

    private static boolean checkIfContinue(boolean isOut, int row, int col) {
        if (outOfBounds(row, col, matrix)) {
            isOut = true;
            matrix[row][col] = '-';
        } else {
            move(newRowSanta, newColSanta, row, col, matrix);
        }
        return isOut;
    }

    private static void move(int currentRow, int currentCol, int toRow, int toCol, char[][] matrix) {
        if(matrix[toRow][toCol] == 'V'){
            countOfPresents--;
            givenToNiceKids++;
            matrix[toRow][toCol] = 'S';
            matrix[currentRow][currentCol] = '-';
            newRowSanta = toRow;
            newColSanta = toCol;
        }else if(matrix[toRow][toCol] == 'X'){
            matrix[toRow][toCol] = 'S';
            matrix[currentRow][currentCol] = '-';
            newRowSanta = toRow;
            newColSanta = toCol;
        }else if(matrix[toRow][toCol] == 'C'){
            checkForKids(toRow,toCol,matrix);
            matrix[toRow][toCol] = 'S';
            matrix[currentRow][currentCol] ='-';
            newRowSanta = toRow;
            newColSanta = toCol;
        }else {
            matrix[toRow][toCol] = 'S';
            matrix[currentRow][currentCol] = '-';
            newRowSanta = toRow;
            newColSanta = toCol;
        }
    }

    private static void checkForKids(int toRow, int toCol, char[][] matrix) {
        checkSides(toRow, matrix, toCol - 1);
        checkSides(toRow, matrix, toCol + 1);
        checkSides(toRow - 1, matrix, toCol);
        checkSides(toRow + 1, matrix, toCol);
        if (kindKids == givenToNiceKids && countOfPresents == 0) {
            notRanOut = true;
        }
    }

    private static void checkSides(int toRow, char[][] matrix, int i) {
        if (matrix[toRow][i] == 'V' && countOfPresents > 0) {
            countOfPresents--;
            givenToNiceKids++;
            matrix[toRow][i] = '-';
        } else if (matrix[toRow][i] == 'X' && countOfPresents > 0) {
            countOfPresents--;
            matrix[toRow][i] = '-';
        }
    }

    private static void findKindKids(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'V') {
                    kindKids++;
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static boolean outOfBounds(int row, int col, char[][] matrix) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void findSanta(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'S') {
                    newRowSanta = i;
                    newColSanta = j;
                }
            }
        }
    }

    private static char[][] readCharMatrix(Scanner scan, int size) {
        char[][] matrix = new char[size][];
        for (int i = 0; i < size; i++) {
            String row = scan.nextLine().replaceAll("\\s+", "");
            matrix[i] = row.toCharArray();
        }
        return matrix;
    }
}
