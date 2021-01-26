package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    private static final String PATH = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\list.ser";

    public static void main(String[] args) {
        List<Double> list = List.of(4.5, 3.2, 1.0, 8.8);
        try (FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(list);
        }catch (IOException ios){
            ios.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream oos = new ObjectInputStream(fis)){
            List<Double> deserializedList = (List<Double>) oos.readObject();
            deserializedList.forEach(System.out::println);
        }catch (IOException | ClassNotFoundException e ){
            e.printStackTrace();
        }
    }
}
