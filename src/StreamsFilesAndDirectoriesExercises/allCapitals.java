package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class allCapitals {
    private static final String path = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\input.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            FileWriter writer = new FileWriter("out.txt");
            String line = reader.readLine();
            while (line != null){
                for (int i = 0; i < line.length(); i++) {
                    line = line.toUpperCase(Locale.ROOT);
                }
                writer.write(line);
                writer.write(System.lineSeparator());
                line = reader.readLine();
            }
            writer.close();
        } catch (IOException ioe) {

        }
    }
}
