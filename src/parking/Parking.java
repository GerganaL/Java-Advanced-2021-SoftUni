package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
   private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity){
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car){
        if(data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove (String manufacturer, String model){
        return this.data.removeIf(car -> car.getModel().equals(model));
    }

    public Car getLatestCar(){
        return this.data.stream().min((c1,c2) -> Integer.compare(c2.getYear(),c1.getYear()))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model){
        return this.data.stream().filter(car -> car.getManufacturer().equals(manufacturer) &&
                car.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ").append(this.type).append(":");
        sb.append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(String.format("%s %s (%s)%n",car.getManufacturer(),car.getModel(),car.getYear()));
        }
        return sb.toString();
    }
}
