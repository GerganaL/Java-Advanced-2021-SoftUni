package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            Car car = new Car(model, Double.parseDouble(input[1]), Double.parseDouble(input[2]));
            cars.put(model, car);
        }
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            double distanceToDrive = Double.parseDouble(info[2]);

            Car carToDrive = cars.get(info[1]);
            if(!carToDrive.drive(distanceToDrive)){
                System.out.println("Insufficient fuel for the drive");
            }

            input = scan.nextLine();
        }

        cars.forEach((k, v) -> System.out.println(v.toString()));

    }
}
