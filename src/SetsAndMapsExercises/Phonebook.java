package SetsAndMapsExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<String, String> phoneBook = new HashMap<>();

        while (!input.equals("search")){
            String [] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];

            phoneBook.putIfAbsent(name,phoneNumber);
            if(phoneBook.containsKey(name)){
                phoneBook.put(name,phoneNumber);
            }

            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("stop")){
            String name = input;
            if(phoneBook.containsKey(name)){
                System.out.printf("%s -> %s\n", name, phoneBook.get(name));
            }else {
                System.out.println("Contact " + name + " does not exist.");
            }
            input = scan.nextLine();
        }
    }
}
