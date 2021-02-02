package CarSalesman;

public class Car {
    private final String model;
    private final Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine,String weight,String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine){
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(String weight){
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Weight: %s\nColor: %s",weight,color);
    }

}
