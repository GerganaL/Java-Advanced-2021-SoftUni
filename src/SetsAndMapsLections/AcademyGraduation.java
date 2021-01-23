package SetsAndMapsLections;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scan.nextLine());

        Map<String, double[]> graduationList = new TreeMap<>();


        for (int i = 0; i < numberOfStudents; i++) {
            String name = scan.nextLine();
            double [] score = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            graduationList.put(name,score);
        }

        graduationList.entrySet().stream().forEach(entry ->{
            System.out.println(String.format("%s is graduated with %s",entry.getKey(),getAverage(entry.getValue())));
        });
    }

    public static  String getAverage(double [] arr){
        double allElements = 0;
        for (double element : arr) {
            allElements += element;
        }
        String average = String.valueOf(allElements / arr.length);

        return average;

    }}
