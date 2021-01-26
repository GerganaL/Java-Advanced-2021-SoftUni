package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class sumBytes {
    private static final String path = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\input.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int sum = 0;
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (IOException ioe) {
        }

    }
}
