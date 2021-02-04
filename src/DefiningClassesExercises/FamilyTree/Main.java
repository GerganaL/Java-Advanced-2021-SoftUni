package DefiningClassesExercises.FamilyTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in));

            String parentNameChildName = "^[\\w\\s]+ - [\\w\\s]+$";
            String parentNameChildBDate = "^[\\w\\s]+ - [\\w\\/]+$";
            String parentBDateChildName = "^[\\w\\/]+ - [\\w\\s]+$";
            String parentBDateChildBDate = "^[\\w\\/]+ - [\\w\\/]+$";
            String personNameBDate = "^[\\w\\s]+ [\\w\\/]+$";

            String searchPersonNameOrDate = bufferedReader.readLine();

            List<Person> relatives = new ArrayList<>();
            List<String> relations = new ArrayList<>();

            String input = null;
            while (!"End".equals(input = bufferedReader.readLine())) {

                if (input.matches(personNameBDate)) {
                    String[] inputArgs = input.split("\\s+");

                    String name = inputArgs[0] + " " + inputArgs[1];
                    String birthday = inputArgs[2];

                    Person person = new Person(name, birthday);

                    relatives.add(person);
                } else {
                    relations.add(input);
                }
            }

            Person searchPerson = new Person();

            if (searchPersonNameOrDate.contains("/")) {
                searchPerson.setBirthDate(searchPersonNameOrDate);

                relatives.stream()
                        .filter(r -> searchPersonNameOrDate.equals(r.getBirthDate()))
                        .forEach(r -> searchPerson.setName(r.getName()));
            } else {
                searchPerson.setName(searchPersonNameOrDate);

                relatives.stream()
                        .filter(r -> searchPersonNameOrDate.equals(r.getName()))
                        .forEach(r -> searchPerson.setBirthDate(r.getBirthDate()));
            }

            for (String relation : relations) {

                String[] relationArgs = relation.split(" - ");
                String parent = relationArgs[0];
                String child = relationArgs[1];

                if (!parent.equals(searchPerson.getName())
                        && !parent.equals(searchPerson.getBirthDate())
                        && !child.equals(searchPerson.getName())
                        && !child.equals(searchPerson.getBirthDate())) {
                    continue;
                }


                if (relation.matches(parentNameChildName)) {

                    if (parent.equals(searchPerson.getName())) {
                        relatives.stream()
                                .filter(r -> child.equals(r.getName()))
                                .forEach(r -> searchPerson.getChildren().add(r));
                    } else {
                        relatives.stream()
                                .filter(r -> parent.equals(r.getName()))
                                .forEach(r -> searchPerson.getParents().add(r));
                    }
                } else if (relation.matches(parentNameChildBDate)) {

                    if (parent.equals(searchPerson.getName())) {
                        relatives.stream()
                                .filter(r -> child.equals(r.getBirthDate()))
                                .forEach(r -> searchPerson.getChildren().add(r));
                    } else {
                        relatives.stream()
                                .filter(r -> parent.equals(r.getName()))
                                .forEach(r -> searchPerson.getParents().add(r));
                    }
                } else if (relation.matches(parentBDateChildName)) {

                    if (parent.equals(searchPerson.getBirthDate())) {
                        relatives.stream()
                                .filter(r -> child.equals(r.getName()))
                                .forEach(r -> searchPerson.getChildren().add(r));
                    } else {
                        relatives.stream()
                                .filter(r -> parent.equals(r.getBirthDate()))
                                .forEach(r -> searchPerson.getParents().add(r));
                    }
                } else if (relation.matches(parentBDateChildBDate)) {

                    if (parent.equals(searchPerson.getBirthDate())) {
                        relatives.stream()
                                .filter(r -> child.equals(r.getBirthDate()))
                                .forEach(r -> searchPerson.getChildren().add(r));
                    } else {
                        relatives.stream()
                                .filter(r -> parent.equals(r.getBirthDate()))
                                .forEach(r -> searchPerson.getParents().add(r));
                    }
                }
            }
            System.out.print(searchPerson);
            System.out.println("Parents:");
            searchPerson.getParents().forEach(System.out::print);
            System.out.println("Children:");
            searchPerson.getChildren().forEach(System.out::print);

        }
}
