package DefiningClassesExercises.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Person> personInfo = new HashMap<>();

        String line = scan.nextLine();
        Person person;
        while (!line.equals("End")){
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            person = new Person(name);
            switch (tokens[1]){
                case "company":
                    Company company = new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    if(personInfo.containsKey(name)) {
                        personInfo.get(name).setCompany(company);
                    }else{
                        person = new Person(name);
                        person.setCompany(company);
                        personInfo.put(name,person);
                    }
                    break;
                case "pokemon":
                    if(personInfo.containsKey(name) && personInfo.get(name).getPokemons() != null){
                        Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                           personInfo.get(name).addPokemon(pokemon);
                    }else {
                        Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                        person.addPokemon(pokemon);
                        personInfo.put(name, person);
                    }
                    break;
                case "parents":
                    if(personInfo.containsKey(name) &&  personInfo.get(name).getParents() != null){
                        Parents parents = new Parents(tokens[2], tokens[3]);
                        personInfo.get(name).addParents(parents);
                    }else {
                        Parents parents = new Parents(tokens[2], tokens[3]);
                        person.addParents(parents);
                        personInfo.put(name, person);
                    }
                    break;
                case "children":
                    if(personInfo.containsKey(name) && personInfo.get(name).getChildren() != null){
                        Children children = new Children(tokens[2],tokens[3]);
                        personInfo.get(name).addChildren(children);
                    }else {
                        Children children = new Children(tokens[2], tokens[3]);
                        person.addChildren(children);
                        personInfo.put(name, person);
                    }
                    break;
                case "car":
                    if(personInfo.containsKey(name)){
                        Car car = new Car(tokens[2],tokens[3]);
                        personInfo.get(name).setCar(car);
                    }else {
                        Car car = new Car(tokens[2], tokens[3]);
                        person = new Person(name);
                        person.setCar(car);
                        personInfo.put(name,person);
                    }
                    break;
            }
            line = scan.nextLine();
        }

        String nameToPrint = scan.nextLine();
        if(personInfo.containsKey(nameToPrint)){
            System.out.println(personInfo.get(nameToPrint).toString());
        }
    }
}
