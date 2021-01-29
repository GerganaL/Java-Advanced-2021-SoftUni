package LabDefiningClasses;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, BankAccount> idInfo = new HashMap<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String output = null;
            switch (tokens[0]) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    idInfo.put(bankAccount.getId(), bankAccount);
                    System.out.println((String.format("Account ID%d created", bankAccount.getId())));
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int deposit = Integer.parseInt(tokens[2]);
                    if (idInfo.containsKey(id)) {
                        idInfo.get(id).deposit(deposit);
                        output = String.format("Deposited %d to ID%d", deposit, id);
                        System.out.println(output);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double setInterest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(setInterest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int interest = Integer.parseInt(tokens[2]);
                    if (idInfo.containsKey(id)) {
                        double interest1 = idInfo.get(id).getInterest(interest);
                        output = String.format("%.2f", interest1);
                        System.out.println(output);
                    }else{
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scan.nextLine();
        }

        //Car
       /* int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            if(input.length > 2) {
                String brand = input[0];
                String model = input[1];
                int horsepower = Integer.parseInt(input[2]);
                Car car = new Car(brand,model,horsepower);
                cars.add(car);
            }else{
                String brand = input[0];
                Car car = new Car(brand,"unknown",-1);
                cars.add(car);
            }
        }
        for (Car car : cars) {
            System.out.printf("The car is: %s %s - %d HP.\n",car.getBrand(),car.getModel(),car.getHorsepower());
        }*/


    }
}
