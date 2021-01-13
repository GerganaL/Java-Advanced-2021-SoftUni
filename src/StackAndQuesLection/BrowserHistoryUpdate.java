package StackAndQuesLection;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        while (!command.equals("Home")){

            if(command.equals("back")){
                if(history.size() < 2){
                    System.out.println("no previous URLs");
                }else {
                    forwardHistory.addFirst(history.peek());
                    history.pop();
                    System.out.println(history.peek());
                }
            }else if (command.equals("forward")){
                if(forwardHistory.size() < 1){
                    System.out.println("no next URLs");
                }else {
                    System.out.println(forwardHistory.peek());
                    history.push(forwardHistory.pop());
                }
            } else {
                System.out.println(command);
                history.push(command);
                forwardHistory.clear();
            }
            command = scan.nextLine();
        }
    }
}
