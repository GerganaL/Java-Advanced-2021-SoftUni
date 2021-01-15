package StackAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] robots = scan.nextLine().split(";");
        String[] names = new String[robots.length];
        int[] processTime = new int[robots.length];

        for (int i = 0; i < robots.length; i++) {
            String[] tokens = robots[i].split(("-"));
            String name = tokens[0];
            int time = Integer.parseInt(tokens[1]);

            names[i] = name;
            processTime[i] = time;
        }

        String startTime = scan.nextLine();
        String inputProduct = scan.nextLine();
        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        while (!inputProduct.equals("End")) {
            productsQueue.offer(inputProduct);
            inputProduct = scan.nextLine();
        }

        String[] timeData = startTime.split(":"); // 8:00:00
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        // converting time to seconds
        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        int[] robotsWorkLeft = new int[robots.length];

        while (!productsQueue.isEmpty()) {
            // robots should take a inputProduct if they are available
            startTimeInSeconds++;
            String product = productsQueue.poll();
            int index = -1; // assume that the robot is NOT available to take a product

            for (int i = 0; i < robotsWorkLeft.length; i++) {
                if (robotsWorkLeft[i] > 0) {
                    // robot is working
                    robotsWorkLeft[i]--;
                }

                if (robotsWorkLeft[i] == 0 && index == -1) {
                    // robot is available
                    index = i;
                }
            }

            if (index != -1) {
                //assign the product to a robot
                robotsWorkLeft[index] = processTime[index];
                System.out.println(printRobotData(names[index], product, startTimeInSeconds));
            } else {
                // all robots are busy
                productsQueue.offer(product);
            }
        }
    }

    private static String printRobotData(String name, String product, int beginTime) {
        long seconds = beginTime % 60;
        long minutes = (beginTime / 60) % 60;
        long hours = (beginTime / (60 * 60)) % 24;
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        return String.format("%s - %s [%s]", name, product, time);
    }
}
