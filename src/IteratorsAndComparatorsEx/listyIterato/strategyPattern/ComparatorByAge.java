package IteratorsAndComparatorsEx.listyIterato.strategyPattern;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {
    public int compare (Person p1, Person p2){
        return p1.getAge() - p2.getAge();
    }
}
