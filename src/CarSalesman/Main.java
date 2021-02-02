package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Engine engine;
        Car car;
        Map<String, Engine> engineList = new LinkedHashMap<>();
        List<Car> carList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            String power = input[1];
            if(input.length == 3){
                engine = new Engine(model,power);
                if(Character.isAlphabetic(input[2].charAt(0))){
                    String efficiency = input[2];
                    engine.setEfficiency(efficiency);

                }else {
                    String displacement = input[2];
                    engine.setDisplacement(displacement);
                }
                engineList.put(model,engine);
            }else if(input.length == 4){
                String displacement = input[2];
                String efficiency = input[3];
                engine = new Engine(model,power,displacement,efficiency);
                engineList.put(model,engine);
            }else {
                engine = new Engine(model,power);
                engineList.put(model,engine);
            }
        }

       int m = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < m; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            String engineModel = input[1];
            if(engineList.containsKey(engineModel)) {
                if (input.length == 3) {
                    if (Character.isAlphabetic(input[2].charAt(0))) {
                        String color = input[2];
                        car = new Car(model, engineList.get(engineModel));
                        car.setColor(color);
                    } else {
                        String weight = input[2];
                        car = new Car(model, engineList.get(engineModel));
                        car.setWeight(weight);
                    }
                    carList.add(car);
                } else if (input.length == 4) {
                    String weight = input[2];
                    String color = input[3];
                    car = new Car(model, engineList.get(engineModel), weight, color);
                    carList.add(car);
                } else {
                    car = new Car(model, engineList.get(engineModel));
                    carList.add(car);
                }
            }
        }

        carList.forEach((car1 ) -> {
            System.out.println(car1.getModel() + ":");
            System.out.print(car1.getEngine().toString());
            System.out.println(car1.toString());
        });
    }
}
