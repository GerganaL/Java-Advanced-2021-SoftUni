package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.List;

public class SerializeCustomObject {
    private static final String PATH = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\course.ser";

    public static void main(String[] args) {
        Course course = new Course("Java Advanced", 200);
        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(course);
        }catch (IOException ios){
            ios.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream oos = new ObjectInputStream(fis)){
            Course deserializedCourse = (Course) oos.readObject();
            System.out.println(deserializedCourse);
        }catch (IOException | ClassNotFoundException e ){
            e.printStackTrace();
        }
    }

    private static class Course implements Serializable {
        private  String name;
        private  int studentsCount;

        public Course(String name, int studentsCount) {
            this.name = name;
            this.studentsCount = studentsCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStudentsCount() {
            return studentsCount;
        }

        public void setStudentsCount(int studentsCount) {
            this.studentsCount = studentsCount;
        }

        @Override
        public String toString() {
            return String.format("%s -> %d",this.getName(),this.getStudentsCount());
        }
    }
}
