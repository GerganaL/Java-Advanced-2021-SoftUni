package wotkhsopAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] coins = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(scan.nextLine());

    }
 }
