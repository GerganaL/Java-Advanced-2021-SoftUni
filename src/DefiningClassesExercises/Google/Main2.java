package DefiningClassesExercises.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();

        String input;
        while(!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String personName = tokens[0];

            if (!people.containsKey(personName)) {
                Person person = new Person(personName);
                people.put(personName, person);
            }

            if ("company".equals(tokens[1])) {
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);

                Company currentCompany = new Company(companyName, department, salary);
                people.get(personName).setCompany(currentCompany);
            } else if ("pokemon".equals(tokens[1])) {
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];
                Pokemon pokemon = new Pokemon(pokemonName,pokemonType);
                people.get(personName).getPokemons().add(pokemon);
            } else if ("parents".equals(tokens[1])) {
                String parentName = tokens[2];
                String parentBirthday = tokens[3];

                Parents parents = new Parents(parentName,parentBirthday);
                people.get(personName).getParents().add(parents);
            } else if ("children".equals(tokens[1])) {
                String childName = tokens[2];
                String childBirthday = tokens[3];

                Children children = new Children(childName,childBirthday);
                people.get(personName).getChildren().add(children);
            } else if ("car".equals(tokens[1])) {
                String carModel = tokens[2];
                String carSpeed = tokens[3];
                Car car = new Car(carModel,carSpeed);
                people.get(personName).setCar(car);
            }
        }

        String printInfoOnThisPerson = reader.readLine();
        reader.close();

        System.out.println(people.get(printInfoOnThisPerson));

    }
}
