package SetsAndMapsExercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String input = scan.nextLine();
        int count = 0;
        String lastResource = "";

        while (!input.equals("stop")){
            count++;
            if (count % 2 == 0){
                resources.put(lastResource,resources.get(lastResource) + Integer.parseInt(input));
            }else {
                resources.putIfAbsent(input,0);
                lastResource = input;
            }

          input =  scan.nextLine();
        }

        resources.forEach((k,v) ->{
            System.out.printf("%s -> %d%n",k,v);
        });
    }
}
