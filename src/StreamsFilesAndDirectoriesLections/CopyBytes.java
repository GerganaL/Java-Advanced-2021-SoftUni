package StreamsFilesAndDirectoriesLections;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        int singleByte = inputStream.read();

        FileOutputStream outputStream = new FileOutputStream("out.txt");
        PrintWriter writer = new PrintWriter(outputStream);

        while (singleByte >= 0 ){

            if(singleByte == 10 || singleByte == 32){
            writer.print((char)singleByte);
            }else {
                writer.print(singleByte);
            }

            singleByte = inputStream.read();
        }

        writer.close();

        inputStream.close();
    }
}
