package IteratorsAndComparatorsEx.listyIterato.strategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Person> personByName = new TreeSet<>(new ComparatorByName());
        Set<Person> personByAge = new TreeSet<>(new ComparatorByAge());

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split("\\s+");
            Person person = new Person(tokens[0],Integer.parseInt(tokens[1]));
            personByAge.add(person);
            personByName.add(person);
        }

        personByName.forEach(System.out::println);
        personByAge.forEach(System.out::println);
    }
}
