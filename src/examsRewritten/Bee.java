package examsRewritten;

import java.util.Scanner;

public class Bee {
    static int  beeRow;
    static  int beeCol;
    static int[] bonus;
    static boolean haveBonus = false;
    static boolean isOut = true;
    static  int polinateFlowers;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = readMatrix(scan,size);
        findBonus(matrix);

        String command = scan.nextLine();

        while (!command.equals("End")){
            matrix[beeRow][beeCol] = '.';
            checkCommand(command,matrix);
            if(!isOut) {
               break;
            }
            command = scan.nextLine();
        }

        if(!isOut){
                System.out.println("The bee got lost!");
        }

        if(polinateFlowers < 5){
            System.out.println("The bee couldn't pollinate the flowers, she needed "+(5 -polinateFlowers)+" flowers more");
        }else {
            System.out.println("Great job, the bee manage to pollinate "+polinateFlowers+" flowers!");
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


    private static boolean move(int row, int col, char[][] matrix, String command) {
        if(inBounds(row,col,matrix)){
            if(matrix[row][col] == 'f'){
                polinateFlowers++;
                matrix[row][col] = 'B';
                beeRow = row;
                beeCol = col;
            }else if(matrix[row][col] == 'O'){
                matrix[row][col] = '.';
                checkCommand(command,matrix);
               // move(beeRow,beeCol,matrix,command);
            }else {
                matrix[row][col] = 'B';
                beeRow = row;
                beeCol = col;
            }
            return true;
        }
        return false;
    }

    private static void checkCommand(String command,char[][] matrix) {
        switch (command){
            case "up":
                beeRow--;
                isOut = move(beeRow,beeCol,matrix,command);
                break;
            case "down":
                beeRow++;
                isOut = move(beeRow,beeCol,matrix,command);
                break;
            case "left":
                beeCol--;
                isOut = move(beeRow,beeCol,matrix,command);
                break;
            case "right":
                beeCol++;
                isOut = move(beeRow,beeCol,matrix,command);
                break;
        }
    }

    private static boolean inBounds(int row, int col, char[][] matrix) {
        return row < matrix.length && col < matrix[row].length && row >= 0 && col >= 0;
    }

    private static void findBonus(char[][] matrix) {
        bonus = new int[2];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c] == 'O'){
                    bonus[0] = r;
                    bonus[1] = c;
                    haveBonus = true;
                }
            }
        }
    }

    private static char[][] readMatrix(Scanner scan, int size) {
        char[][] matrix = new char[size][];
        for (int r = 0; r < matrix.length; r++) {
            String currentRow = scan.nextLine();
            if(currentRow.contains("B")){
                beeRow = r;
                beeCol = currentRow.indexOf("B");
            }
            matrix[r] = currentRow.toCharArray();
        }

        return matrix;
    }
}
