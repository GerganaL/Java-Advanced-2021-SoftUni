package parkingRewritten;

import parking.Car;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<parking.Car> data;

    public Parking(String type, int capacity){
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(parking.Car car){
        if(this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public parking.Car getLatestCar(){
        return this.data.stream().min((c1,c2) -> Integer.compare(c2.getYear(), c1.getYear())).orElse(null);
    }

    public Car getCar(String manufacturer, String model){
        return this.data.stream().filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder("The cars are parked in ");
        sb.append(this.type).append(":");
        this.data.forEach(c -> sb.append(System.lineSeparator()).append(c));
        return sb.toString();
    }
}
