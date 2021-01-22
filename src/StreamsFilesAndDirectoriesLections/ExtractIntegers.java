package StreamsFilesAndDirectoriesLections;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

      FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        FileWriter writer = new FileWriter("out.txt");

        while (scanner.hasNext()){
            if(scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.write(String.valueOf(number));
                writer.write(System.lineSeparator());
            }
            scanner.next();
        }
        writer.flush();
        writer.close();
    }
}
