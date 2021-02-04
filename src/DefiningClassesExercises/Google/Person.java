package DefiningClassesExercises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person(String name){
        this.name = name;
        this.parents =new ArrayList<>();
        this.pokemons = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Children> getChildren() {
        return children;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void addChildren(Children children){
        this.children.add(children);
    }

    public void addParents(Parents parent){
        this.parents.add(parent);
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company.toString()).append(System.lineSeparator());
        }

        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car.toString()).append(System.lineSeparator());
        }


        sb.append("Pokemon:").append(System.lineSeparator());
        if(pokemons != null) {
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString());
            }
        }

        sb.append("Parents:").append(System.lineSeparator());
        if(parents != null) {
            for (Parents parent : parents) {
                sb.append(parent);
            }
        }

        sb.append("Children:").append(System.lineSeparator());
        if(children != null) {
            for (Children child : children) {
                sb.append(child);
            }
        }

        return sb.toString();
    }

}
