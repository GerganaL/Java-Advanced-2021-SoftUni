package DefiningClassesExercises.FamilyTree;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;

    private List<Person> children;
    private List<Person> parents;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return  name + " "+ birthDate + System.lineSeparator() ;
    }



}
