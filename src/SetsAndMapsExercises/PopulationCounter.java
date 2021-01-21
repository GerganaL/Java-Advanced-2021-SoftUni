package SetsAndMapsExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        Map<String,Map<String,Long>> info = new TreeMap<>();

        while (!line.equals("report")){
            String [] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            info.putIfAbsent(country,new HashMap<>());
            info.get(country).putIfAbsent(city,population);

            line = scan.nextLine();
        }

        info.entrySet().stream().sorted((c1,c2)->{
            long p1 = c1.getValue().values().stream().mapToLong(l->l).sum();
            long p2 = c2.getValue().values().stream().mapToLong(l->l).sum();
            return Long.compare(p2,p1);
        }).forEach(c->{
            long totalPopulation = c.getValue().values().stream().mapToLong(e->e).sum();
            System.out.println(String.format("%s (total population: %d)",c.getKey(),totalPopulation));
            Map<String, Long> cityInfo = c.getValue();
            cityInfo.entrySet().stream().sorted((city1,city2) -> Long.compare(city2.getValue(),city1.getValue()))
                    .forEach(s-> System.out.println(String.format("=>%s: %d",s.getKey(),s.getValue())));
        });
    }
}
