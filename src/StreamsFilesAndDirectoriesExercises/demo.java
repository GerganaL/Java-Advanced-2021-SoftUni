package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class demo {
    public static void main(String[] args) throws IOException {
        //reading from the console with buffer reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
    }
}
