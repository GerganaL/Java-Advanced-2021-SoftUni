package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeTwoFiles {
    private static final String first_input_PATH = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\inputOne.txt";
    private static final String second_input_PATH = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\inputTwo.txt";
    private static final String OUTPUT_PATH = "src/streamsFilesAndDirectoriesExercises/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader firstReader = new BufferedReader(new FileReader(first_input_PATH));
             BufferedReader secondReader = new BufferedReader(new FileReader(second_input_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = firstReader.readLine();
            while (line != null){
                writer.println(line);
                line = firstReader.readLine();
            }

            line = secondReader.readLine();
            while (line != null){
                writer.println(line);
                line = secondReader.readLine();
            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
