package IteratorsAndComparatorsEx.listyIterato.comparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();
        String line = scan.nextLine();

        while (!line.equals("END")) {
            String[] personInfo = line.split("\\s+");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]), personInfo[2]);
            personList.add(person);
            line = scan.nextLine();
        }

        int index = Integer.parseInt(scan.nextLine());

        Person searchPerson = personList.get(index - 1);

        int equal = 0;

        for (Person person : personList) {
            if (person.compareTo(searchPerson) == 0) {
                equal++;
            }
        }

        if(equal == 1){
            System.out.println("No matches");
        }else {
            System.out.println(String.format("%d %d %d",equal,personList.size() - equal,personList.size()));
        }
    }
}
