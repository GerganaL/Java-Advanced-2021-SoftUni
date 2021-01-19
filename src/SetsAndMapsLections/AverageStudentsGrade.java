package SetsAndMapsLections;

import java.text.DecimalFormat;
import java.util.*;

public class AverageStudentsGrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,double[]> studentsWithGrades = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String name = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine()
                    .split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            studentsWithGrades.put(name,grades);
        }

        studentsWithGrades.forEach((k,v)->{
            System.out.printf("%s is graduated with %f%n",k,Arrays.stream(v).average().orElse(0));
        });

        /*studentsWithGrades.entrySet()
                .stream()
                .forEach(s -> {
                    DecimalFormat df = new DecimalFormat("#.######");
                    System.out.printf("%s -> %f%n", s.getKey()
                            , Arrays.stream(s.getValue()).average().getAsDouble());
                });*/

        /*for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());

        }*/


    }

}
