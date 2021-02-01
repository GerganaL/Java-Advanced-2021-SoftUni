package CatLady;

public class StreetExtraordinaire extends  Cat{
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, String breed) {
        super(name, breed);
    }

    public StreetExtraordinaire(String name, String breed, double decibelsOfMeows) {
        super(name, breed);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreed(), getName(), this.decibelsOfMeows);
    }
}
