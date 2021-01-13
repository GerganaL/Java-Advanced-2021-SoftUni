package StackAndQuesLection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        String currentURL = null;
        ArrayDeque<String> history = new ArrayDeque<>();

        while (!command.equals("Home")){
            if(command.equals("back")){
                if(history.isEmpty()){
                    System.out.println("no previous URLs");
                    command = scan.nextLine();
                    continue;
                }else {
                    currentURL = history.pop();
                }
            }else {
                if (currentURL!= null){
                    history.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);

            command = scan.nextLine();
        }
    }
}
