package wotkhsopAlgorithms;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int index = 0;
        System.out.println(sum(numbers,index));
    }

    private static int sum(int[] arr, int index) {
        int sum = 0;
        if(index == arr.length -1){
            return arr[index];
        }

        return arr[index] + sum(arr,index + 1);
    }

}
