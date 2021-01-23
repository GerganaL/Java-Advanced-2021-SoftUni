package SetsAndMapsLections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = scan.nextLine();

        while(!input.equals("END")){

            String reigstration = input.substring(input.indexOf(", ") + 2);
            if (input.contains("IN")){
                parking.add(reigstration);
            }else {
                parking.remove(reigstration);
            }
            input = scan.nextLine();
        }

       String output;

        if(!parking.isEmpty()){
            output = parking.stream()
                    .collect(Collectors.joining(System.lineSeparator()));
        }else {
            output = "Parking Lot is Empty";
        }



        System.out.println(output);
    }
}
