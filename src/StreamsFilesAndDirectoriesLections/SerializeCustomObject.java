package StreamsFilesAndDirectoriesLections;
import java.io.*;


public class SerializeCustomObject {
    public static class Cube implements Serializable {
        String color;
        double width;
        double height;
        double depth;

         @Override
         public String toString() {
             return "Cube{" +
                     "color='" + color + '\'' +
                     ", width=" + width +
                     ", height=" + height +
                     ", depth=" + depth +
                     '}';
         }
     }

    public static void main(String[] args) throws IOException {
      SerializeCustomObject.Cube cub = new SerializeCustomObject.Cube();
        cub.color = "green";
        cub.width = 15.3d;
        cub.height = 12.4d;
        cub.depth = 3d;


        String path = "out.txt";

        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(cub);

        System.out.println(cub.toString());

    }
}
