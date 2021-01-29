package MoreEx;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        int degrees = Integer.parseInt(line.substring(line.indexOf('(') + 1,line.indexOf(')'))) % 360;

        line = scan.nextLine();
        int biggestLenght = 0;
        List<String> rows = new ArrayList<>();

        while (!line.equals("END")){
            rows.add(line);
           if(line.length() > biggestLenght){
               biggestLenght = line.length();
           }


            line = scan.nextLine();
        }

        char[][] matrix = new char[rows.size()][biggestLenght];
        for (int i = 0; i < matrix.length; i++) {
            String row =  rows.get(i);
            for (int j = 0; j < matrix[i].length; j++) {
                if(row != null && j < row.length()){
                    matrix[i][j] = row.charAt(j);
                }else {
                    matrix[i][j] = ' ';
                }
            }
        }

        if (degrees == 0) {
            rotationAt0(matrix);
        } else if (degrees == 90) {
            rotationAt90(matrix);
        }else if (degrees == 180) {
            rotationAt180(matrix);
        }else if (degrees == 270) {
            rotationAt270(matrix);
        }
    }

    private static void rotationAt270(char[][] matrix) {
        for (int col = matrix[0].length - 1; col >= 0 ; col--) {
            for (int row = 0; row < matrix.length ; row++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void rotationAt180(char[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0 ; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotationAt90(char[][] matrix) {
        for (int col = 0; col < matrix[0].length ; col++) {
            for (int row = matrix.length - 1; row >= 0 ; row--) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void rotationAt0(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
