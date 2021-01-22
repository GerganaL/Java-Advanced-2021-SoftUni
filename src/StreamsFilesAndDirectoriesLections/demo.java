package StreamsFilesAndDirectoriesLections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {

        try {
            FileInputStream inputStream = new FileInputStream(
                    "C:\\Users\\lulch\\OneDrive\\Desktop\\demo-stream.txt");
            Scanner scan = new Scanner(inputStream);

            int oneByte = inputStream.read();
            while (oneByte >= 0){
                System.out.print((char)(oneByte));
                oneByte = inputStream.read();
            }

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
