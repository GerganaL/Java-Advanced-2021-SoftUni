package CatLady;

public class Cymric extends  Cat{
    private double furLength;

    public Cymric(String name, String breed) {
        super(name, breed);
    }

    public Cymric(String name, String breed, double furLength) {
        super(name, breed);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreed(), getName(), this.furLength);
    }
}
