package StreamsFilesAndDirectoriesLections;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

     //   System.err.println("Optimus Prime");

        String fileName = "input.txt";

        Path path = Paths.get("");
        List<String> lines = Files.readAllLines(Paths.get(fileName))
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Paths.get("out.txt"),lines);
    }
}
