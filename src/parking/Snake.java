package parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        char[][] board = readCharMatrix(n, n, scan);
        int[] snake = findSnake(board);
        List<Integer> borrows = findBorrows(board);

        int eatenFood = 0;
        boolean isOut = false;
        boolean eaten = false;
        String command = scan.nextLine();
        while (true) {
            switch (command) {
                case "up":
                    int row = snake[0];
                    int col = snake[1];
                    if (inBounds(row - 1, col, board)) {
                        char symbol = board[row - 1][col];
                        if (symbol == '*') {
                            eatenFood++;
                            moveStar(board, snake, row - 1, col, col, board[row], 0, row - 1);
                        } else if (symbol == 'B') {
                            int[] borrow1 = new int[]{borrows.get(0), borrows.get(1)};
                            if (inBounds(borrows.get(2), borrows.get(3), board) && inBounds(borrows.get(0), borrows.get(1), board)) {
                                borrowMove(board, snake, borrows, col, borrow1, row - 1);
                            } else {
                                isOut = true;
                            }
                        } else {
                            moveStar(board, snake, row - 1, col, col, board[row], 0, row - 1);

                        }
                    } else {
                        isOut = true;
                    }
                    break;
                case "down":
                    row = snake[0];
                    col = snake[1];
                    if (inBounds(row + 1, col, board)) {
                        char symbol = board[row + 1][col];
                        if (symbol == '*') {
                            eatenFood++;
                            moveStar(board, snake, row + 1, col, col, board[row], 0, row + 1);
                        } else if (symbol == 'B') {
                            int[] borrow1 = new int[]{borrows.get(0), borrows.get(1)};
                            if (inBounds(borrows.get(2), borrows.get(3), board) && inBounds(borrows.get(0), borrows.get(1), board)) {
                                borrowMove(board, snake, borrows, col, borrow1, row + 1);
                            } else {
                                isOut = true;
                            }
                        } else {
                            moveStar(board, snake, row + 1, col, col, board[row], 0, row + 1);
                        }
                    } else {
                        isOut = true;
                        break;
                    }
                    break;
                case "left":
                    row = snake[0];
                    col = snake[1];
                    if (inBounds(row, col - 1, board)) {
                        char symbol = board[row][col - 1];
                        if (symbol == '*') {
                            eatenFood++;
                            moveStar(board, snake, row, col, col - 1, board[row], 1, col - 1);
                        } else if (symbol == 'B') {
                            int[] borrow1 = new int[]{borrows.get(0), borrows.get(1)};
                            if (inBounds(borrows.get(2), borrows.get(3), board) && inBounds(borrows.get(0), borrows.get(1), board)) {
                                if (row == borrow1[0] && col - 1 == borrow1[1]) {
                                    moveStar(board, snake, borrows.get(2), col, borrows.get(3), board[row], 0, borrows.get(2));
                                    snake[1] = borrows.get(3);
                                } else {
                                    moveStar(board, snake, borrows.get(0), col, borrows.get(1), board[row], 0, borrows.get(0));
                                    snake[1] = borrows.get(1);
                                }
                                board[row][col - 1] = '.';
                            } else {
                                isOut = true;
                            }
                        } else {
                            moveStar(board, snake, row, col, col - 1, board[row], 1, col - 1);
                        }
                    } else {
                        isOut = true;
                    }
                    break;
                case "right":
                    row = snake[0];
                    col = snake[1];
                    if (inBounds(row, col + 1, board)) {
                        char symbol = board[row][col + 1];
                        if (symbol == '*') {
                            eatenFood++;
                            moveStar(board, snake, row, col, col + 1, board[row], 1, col + 1);
                        } else if (symbol == 'B') {
                            int[] borrow1 = new int[]{borrows.get(0), borrows.get(1)};
                            if (inBounds(borrows.get(2), borrows.get(3), board) && inBounds(borrows.get(0), borrows.get(1), board)) {
                                if (row == borrow1[0] && col + 1 == borrow1[1]) {
                                    moveStar(board, snake, borrows.get(2), col, borrows.get(3), board[row], 0, borrows.get(2));
                                    snake[1] = borrows.get(3);
                                } else {
                                    moveStar(board, snake, borrows.get(0), col, borrows.get(1), board[row], 0, borrows.get(0));
                                    snake[1] = borrows.get(1);
                                }
                                board[row][col + 1] = '.';
                            } else {
                                isOut = true;
                            }
                        } else {
                            moveStar(board, snake, row, col, col + 1, board[row], 1, col + 1);
                        }
                    } else {
                        isOut = true;
                    }
                    break;
            }
            if (eatenFood >= 10) {
                eaten = true;
                break;
            } else if (isOut) {
                break;
            }
            command = scan.nextLine();
        }

        if (eatenFood > 9) {
            System.out.println("You won! You fed the snake.");
            System.out.println("Food eaten: " + eatenFood);
            printMatrixOri(board);
        } else {
            System.out.println("Game over!");
            System.out.println("Food eaten: " + eatenFood);
            printMatrix(board);
        }
    }

    private static void moveStar(char[][] board, int[] snake, int row, int col, int i, char[] chars, int i2, int i3) {
        board[row][i] = 'S';
        chars[col] = '.';
        snake[i2] = i3;
    }


    private static void borrowMove(char[][] board, int[] snake, List<Integer> borrows, int col, int[] borrow1, int i) {
        char c;
        if (i == borrow1[0] && col == borrow1[1]) {
            board[borrows.get(2)][borrows.get(3)] = 'S';
            c = '.';
            snake[0] = borrows.get(2);
            snake[1] = borrows.get(3);
        } else {
            board[borrows.get(0)][borrows.get(1)] = 'S';
            c = '.';
            snake[0] = borrows.get(0);
            snake[1] = borrows.get(1);
        }
        board[i][col] = '.';
    }

    private static void printMatrix(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == 'S') {
                    System.out.print('.');
                } else {
                    System.out.print(aChar);
                }
            }
            System.out.println();
        }
    }


    private static void printMatrixOri(char[][] matrix) {
        Arrays.stream(matrix).forEach(chars -> {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        });
    }

    private static boolean inBounds(int row, int col, char[][] board) {
        return row >= 0 && col >= 0 && row < board.length && col < board[row].length;
    }

    private static List<Integer> findBorrows(char[][] board) {
        List<Integer> borrows = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'B') {
                    borrows.add(row);
                    borrows.add(col);
                }
            }
        }
        return borrows;
    }

    private static int[] findSnake(char[][] board) {
        int[] snake = new int[2];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'S') {
                    snake[0] = row;
                    snake[1] = col;
                }
            }
        }
        return snake;
    }


    private static char[][] readCharMatrix(int rows, int cols, Scanner scanner) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readCharArray(scanner);

        }
        return matrix;
    }

    private static char[] readCharArray(Scanner scanner) {
        return scanner.nextLine().replaceAll("\\s+", "").toCharArray();
    }
}
