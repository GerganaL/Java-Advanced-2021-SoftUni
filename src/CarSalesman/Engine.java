package CarSalesman;

public class Engine {
    private final String model;
    private final String power;
    private String displacement;
    private String efficiency;

    public  Engine (String model, String power, String displacement, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, String power){
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }


    public String getModel() {
        return model;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }


    @Override
    public String toString() {
        return String.format("%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s\n"
                ,model,power,displacement,efficiency);
    }
}
