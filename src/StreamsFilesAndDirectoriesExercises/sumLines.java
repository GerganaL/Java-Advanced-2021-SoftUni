package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class sumLines {
    private  static  final String path = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\input.txt";
    public static void main(String[] args) {

       // String path = "C:\\Users\\lulch\\OneDrive\\Desktop\\JavaAdvance\\Exercises\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(path))){

            String line = reader.readLine();

            while (line != null){
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
                line = reader.readLine();
            }
        }catch (IOException ioe ){
            ioe.printStackTrace();
        }
    }
}
