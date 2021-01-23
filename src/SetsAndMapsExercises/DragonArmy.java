package SetsAndMapsExercises;

import java.io.Console;
import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, int[]>> data = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String type = tokens[0];
            String name = tokens[1];
            int damage = 0;
            int health = 0;
            int armor = 0;

            damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);

            data.putIfAbsent(type, new TreeMap<>());

            data.get(type).putIfAbsent(name, new int[3]);

            int[] info = new int[3];
            info[0] = damage;
            info[1] = health;
            info[2] = armor;

            data.get(type).put(name, info);
        }

        for (Map.Entry<String, Map<String, int[]>> typeInfo : data.entrySet()) {
            double[] average = calculateAverage(typeInfo.getValue());
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", typeInfo.getKey(), average[0], average[1], average[2]);
            for (Map.Entry<String, int[]> dragonInfo : typeInfo.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                        dragonInfo.getKey(),
                        dragonInfo.getValue()[0],
                        dragonInfo.getValue()[1],
                        dragonInfo.getValue()[2]);
            }


        }
    }

    private static double[] calculateAverage(Map<String,int[]> map) {
        double totalEntries = map.size();
        int totalDamage = 0;
        int totalHealth = 0;
        int totalArmor = 0;

        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            totalDamage += entry.getValue()[0];
            totalHealth += entry.getValue()[1];
            totalArmor += entry.getValue()[2];
        }

        return new double[] {
                totalDamage / totalEntries,
                totalHealth / totalEntries,
                totalArmor / totalEntries
        };
    }
}
