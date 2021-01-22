package SetsAndMapsExercises;

import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equals("stop")){

            String email = scan.nextLine();

            if(!email.endsWith(".com") && !email.endsWith(".uk") && !email.endsWith(".us")){
                System.out.printf("%s -> %s%n",input,email);
            }

            input = scan.nextLine();
        }

    }
}
