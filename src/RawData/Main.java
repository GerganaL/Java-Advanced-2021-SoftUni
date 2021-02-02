package RawData;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<Car> carList = new LinkedHashSet<>();
        Car car;
        Engine engine;
        Cargo cargo;
        Tire tire1;
        Tire tire2;
        Tire tire3;
        Tire tire4;

        for (int i = 0; i < n; i++) {

            String[] input = scan.nextLine().split("\\s+");

            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            int weight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double pressure1 = Double.parseDouble(input[5]);
            int age1 = Integer.parseInt(input[6]);
            double pressure2 = Double.parseDouble(input[7]);
            int age2 = Integer.parseInt(input[8]);
            double pressure3 = Double.parseDouble(input[9]);
            int age3 = Integer.parseInt(input[10]);
            double pressure4 = Double.parseDouble(input[11]);
            int age4 = Integer.parseInt(input[12]);
            engine = new Engine(speed,power);
            cargo = new Cargo(weight,cargoType);
            tire1 = new Tire(pressure1,age1);
            tire2 = new Tire(pressure2,age2);
            tire3 = new Tire(pressure3,age3);
            tire4 = new Tire(pressure4,age4);
            car = new Car(model,engine,cargo,tire1,tire2,tire3,tire4);
            carList.add(car);
        }

        String command = scan.nextLine();
        ArrayList<String> output = new ArrayList<>();
        if(command.equals("fragile")){
            carList.forEach(c -> {
                if(c.getCargo().getType().equals("fragile")){
                    for (Tire tireSet : c.getTires()) {
                        if(tireSet.getPressure() < 1){
                            output.add(c.getModel());
                            break;
                        }
                    }
                }
            });
        }else {
            carList.forEach(car1 -> {
                if(car1.getCargo().getType().equals("flamable") &&  car1.getEngine().getPower() > 250){
                    output.add(car1.getModel());
                }
            });
        }

        output.forEach(System.out::println);
    }
}
