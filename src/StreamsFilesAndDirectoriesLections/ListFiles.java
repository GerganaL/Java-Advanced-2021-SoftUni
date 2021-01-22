package StreamsFilesAndDirectoriesLections;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        String fileName = "C:\\Users\\lulch\\OneDrive/Desktop/JavaAdvance/Lections/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File file = new File(fileName);

        File [] innerFiles = file.listFiles();

        for (File innerFile : innerFiles) {
            if(!innerFile.isDirectory()){
                System.out.printf("%s: [%d]%n",innerFile.getName(),innerFile.length());
            }
        }

        boolean delete = file.delete();
        if(delete){
            System.out.println("Deleted");
        }else{
            System.out.println("Still there");
        }
    }
}
