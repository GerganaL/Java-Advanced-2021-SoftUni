package StreamsFilesAndDirectoriesLections;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String filePath = "input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
        String line = reader.readLine();

        int lineNumber = 1;
        while (line != null){
            line = reader.readLine();
            lineNumber++;
            if(lineNumber % 3 == 0){
                writer.write(line);
                writer.newLine();
            }
        }

        writer.flush();
        writer.close();

    }
}
