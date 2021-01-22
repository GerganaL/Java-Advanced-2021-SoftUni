package StreamsFilesAndDirectoriesLections;

import java.io.File;

public class NestedFolders {
    public  static int foldersCount = 0;
    public static void main(String[] args) {
        String fileName = "C:\\Users\\lulch\\OneDrive\\Desktop\\JavaAdvance\\Lections\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File file = new File(fileName);

        dfs(file);
        System.out.println();
        System.out.println(foldersCount + " folders");
    }

    public static void dfs(File file) {
        //Bottom-case - stop recursion
        //Step

        foldersCount++;
        for (File f : file.listFiles()) {
            if(f.isDirectory()){
                dfs(f);
            }
        }
        System.out.println(file.getName());
    }
}
