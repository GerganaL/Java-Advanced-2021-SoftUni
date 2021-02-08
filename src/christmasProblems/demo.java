package christmasProblems;

import java.util.Scanner;

public class demo {
    static int kindKids = 0;
    static int newRowHero = 0;
    static int newColHero = 0;
    static int presentsCountToSpread;
    static int givenPresentsToNiceKid;
    static boolean notRanOut = false;


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        presentsCountToSpread = Integer.parseInt(scan.nextLine());

        int n = Integer.parseInt(scan.nextLine());

        char[][] field = new char[n][n];

        for (int row = 0; row < n; row++) {
            String line = scan.nextLine().replaceAll(" ", "");
            if (line.contains("S")) {
                newRowHero = row;
                newColHero = line.indexOf("S");
            }
            if (line.contains("V")) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'V') {
                        kindKids++;
                    }
                }
            }
            field[row] = line.toCharArray();
        }

        boolean wasOutOfField = false;

//        int newRow = -1;
//        int newCol = -1;


        String command = scan.nextLine();
        while (!command.equals("Christmas morning") && presentsCountToSpread > 0) {

            if (command.equals("up")) {
                // row - 1
                if (isOutOfBounds(newRowHero - 1, newColHero, field)) {
                    wasOutOfField = true;
                    field[newRowHero][newColHero] = '-';
                    break;
                } else {
                    moveHero(newRowHero, newColHero, newRowHero - 1, newColHero, field);
                }
            } else if (command.equals("down")) {
                // row + 1
                if (isOutOfBounds(newRowHero + 1, newColHero, field)) {
                    wasOutOfField = true;
                    field[newRowHero][newColHero] = '-';
                    break;
                } else {
                    moveHero(newRowHero, newColHero, newRowHero + 1, newColHero, field);
                }
            } else if (command.equals("left")) {
                // col - 1
                if (isOutOfBounds(newRowHero, newColHero - 1, field)) {
                    wasOutOfField = true;
                    field[newRowHero][newColHero] = '-';
                    break;
                } else {
                    moveHero(newRowHero, newColHero, newRowHero, newColHero - 1, field);
                }
            } else if (command.equals("right")) {
                // col + 1
                if (isOutOfBounds(newRowHero, newColHero + 1, field)) {
                    wasOutOfField = true;
                    field[newRowHero][newColHero] = '-';
                    break;
                } else {
                    moveHero(newRowHero, newColHero, newRowHero, newColHero + 1, field);
                }
            }
            if (presentsCountToSpread > 0) {
                command = scan.nextLine();
            } else {
                break;
            }
        }

        int niceKidsWoPresents = kindKids - givenPresentsToNiceKid;


        if (presentsCountToSpread <= 0 && !notRanOut) {
            System.out.println("Santa ran out of presents!");
        }

        if (wasOutOfField) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(field);

        if (givenPresentsToNiceKid >= kindKids) {
            System.out.println(String.format("Good job, Santa! %d happy nice kid/s.", givenPresentsToNiceKid));
        } else {
            System.out.println(String.format("No presents for %s nice kid/s.", niceKidsWoPresents));
        }
    }

    private static void moveHero(int currentRowHero, int currentColHero, int willBeAtRow, int willBeAtCol, char[][] field) {
        if (field[willBeAtRow][willBeAtCol] == 'V') {
            presentsCountToSpread--;
            givenPresentsToNiceKid++;
            field[willBeAtRow][willBeAtCol] = 'S';
            field[currentRowHero][currentColHero] = '-';
            newRowHero = willBeAtRow;
            newColHero = willBeAtCol;

        } else if (field[willBeAtRow][willBeAtCol] == 'X') {
            field[willBeAtRow][willBeAtCol] = 'S';
            field[currentRowHero][currentColHero] = '-';
            newRowHero = willBeAtRow;
            newColHero = willBeAtCol;

        } else if (field[willBeAtRow][willBeAtCol] == 'C') {
            checkForKidsAround(willBeAtRow, willBeAtCol, field);
            field[willBeAtRow][willBeAtCol] = 'S';
            field[currentRowHero][currentColHero] = '-';
            newRowHero = willBeAtRow;
            newColHero = willBeAtCol;
        } else {
            field[willBeAtRow][willBeAtCol] = 'S';
            field[currentRowHero][currentColHero] = '-';
            newRowHero = willBeAtRow;
            newColHero = willBeAtCol;
        }
    }

    private static void checkForKidsAround(int rowHero, int colHero, char[][] field) {
        if (field[rowHero][colHero - 1] == 'V' && presentsCountToSpread > 0) {
            presentsCountToSpread--;
            givenPresentsToNiceKid++;
            field[rowHero][colHero - 1] = '-';
        }else if (field[rowHero][colHero - 1] == 'X' && presentsCountToSpread > 0) {
            presentsCountToSpread--;
            field[rowHero][colHero - 1] = '-';
        }
        if (field[rowHero][colHero + 1] == 'V' && presentsCountToSpread > 0){
            presentsCountToSpread--;
            givenPresentsToNiceKid++;
            field[rowHero][colHero + 1] = '-';
        } else if (field[rowHero][colHero + 1] == 'X' && presentsCountToSpread > 0) {
            presentsCountToSpread--;
            field[rowHero][colHero + 1] = '-';
        }
        if (field[rowHero - 1][colHero] == 'V' && presentsCountToSpread > 0) {
            presentsCountToSpread--;
            givenPresentsToNiceKid++;
            field[rowHero - 1][colHero] = '-';
        }else if (field[rowHero - 1][colHero] == 'X' && presentsCountToSpread > 0) {
            presentsCountToSpread--;
            field[rowHero - 1][colHero] = '-';
        }
        if (field[rowHero + 1][colHero] == 'V' && presentsCountToSpread > 0) {
            presentsCountToSpread--;
            givenPresentsToNiceKid++;
            field[rowHero + 1][colHero] = '-';
        }else if (field[rowHero + 1][colHero] == 'X' && presentsCountToSpread > 0) {
            presentsCountToSpread--;
            field[rowHero + 1][colHero] = '-';
        }
        if (kindKids == givenPresentsToNiceKid && presentsCountToSpread == 0) {
            notRanOut = true;
        }
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length
                || col < 0 || col >= field[row].length;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
