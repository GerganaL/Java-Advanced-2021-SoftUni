package LabDefiningClasses;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car(String brandParam, String modelParam, int horsepowerParam) {
        this.brand = brandParam;
        this.model = modelParam;
        this.horsepower = horsepowerParam;
    }
    public Car(String brand){
        this(brand,"unkown",-1);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
}
