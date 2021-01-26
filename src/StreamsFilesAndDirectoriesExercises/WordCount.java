package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    private static final String words_PATH = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\words.txt";
    private static final String text_PATH = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\text.txt";
    private static final String OUTPUT_PATH = "src/streamsFilesAndDirectoriesExercises/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader wordReader = new BufferedReader(new FileReader(words_PATH));
             BufferedReader textReader = new BufferedReader(new FileReader(text_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String[] words = wordReader.readLine().split("\\s+");
            Map<String, Integer> wordsOccurrences = new HashMap<>();
            for (String word : words) {
                wordsOccurrences.put(word, 0);
            }

            String[] text = textReader.readLine().split("\\s+");
            for (String word : text) {
                if (wordsOccurrences.containsKey(word)) {
                    wordsOccurrences.put(word, wordsOccurrences.get(word) + 1);
                }
            }

            wordsOccurrences
                    .entrySet()
                    .stream()
                    .sorted((w1,w2)-> w2.getValue().compareTo(w1.getValue()))
                    .forEach(entry -> {
                        writer.println(entry.getKey() + " - " + entry.getValue());
                    });

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
