package SetsAndMapsLections;

import java.text.DecimalFormat;
import java.util.*;

public class AverageStudentsGrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,List<Double>> students = new TreeMap<>();
        List<Double> grades = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String [] tokens = scan.nextLine().split("\\s+");
            String student = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            grades.add(grade);

            students.putIfAbsent(student,new ArrayList<>());
            students.get(student).add(grade);

        }

        students.entrySet().stream()
                .forEach(entry -> {
                    double sum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum += entry.getValue().get(i);
                    }

                    double average = sum / entry.getValue().size();

                    System.out.printf(entry.getKey() + " -> ");
                    entry.getValue().forEach(e -> System.out.printf("%.2f ",e));
                    System.out.printf("(avg: %.2f)%n",average);
                });

    }

}
