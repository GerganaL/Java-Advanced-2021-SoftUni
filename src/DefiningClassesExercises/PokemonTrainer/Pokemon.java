package DefiningClassesExercises.PokemonTrainer;

public class Pokemon {
    private final String name;
    private final String element;
    private final int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}
