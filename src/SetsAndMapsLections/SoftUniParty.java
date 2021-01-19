package SetsAndMapsLections;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();


        String guestName = scan.nextLine();

        while (!guestName.equals("PARTY")) {
            guests.add(guestName);
            guestName = scan.nextLine();
        }

        guestName = scan.nextLine();

        while (!guestName.equals("END")){
            guests.remove(guestName);
            guestName = scan.nextLine();
        }

        System.out.println(guests.size());
        System.out.println(getSetElementOnNewLine(guests));
    }

    public  static  String getSetElementOnNewLine (Set<String>set){
        return set.stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
