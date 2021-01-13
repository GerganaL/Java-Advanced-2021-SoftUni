package StackAndQuesLection;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        String command = scan.nextLine();

        while (!command.equals("print")) {

            if (command.equals("cancel")) {
                String fileName = printerQueue.poll();
                if (fileName != null) {
                    System.out.println("Canceled " + fileName);
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(command);
            }

            command = scan.nextLine();
        }

        for (String fileName : printerQueue) {
            System.out.println(fileName);
        }

//        while (!printerQueue.isEmpty()) {
//            System.out.println(printerQueue.poll());
//
//        }
    }
}
