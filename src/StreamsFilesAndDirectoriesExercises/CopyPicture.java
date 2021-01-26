package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class CopyPicture {
    private static final String picture_PATH = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\picture.jpg";
    private static final String picture_copy_PATH = "src/streamsFilesAndDirectoriesExercises/resources/picture-cpy.jpg";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(picture_PATH);
                FileOutputStream fos = new FileOutputStream(picture_copy_PATH)) {
            int oneByte = fis.read();
            while (oneByte != -1){
                fos.write(oneByte);
                oneByte = fis.read();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
