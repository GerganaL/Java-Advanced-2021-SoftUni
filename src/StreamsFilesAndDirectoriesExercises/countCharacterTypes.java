package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class countCharacterTypes {
    private static final String path = "C:\\Users\\lulch\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercises\\resources\\input.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            FileWriter writer = new FileWriter("out.txt");
            String line = reader.readLine();
            int vowels = 0;
            int consonants = 0;
            int punctuation = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'a' ||
                            line.charAt(i) == 'e' ||
                            line.charAt(i) == 'i' ||
                            line.charAt(i) == 'o' ||
                            line.charAt(i) == 'u' &&
                                    Character.isLowerCase(line.charAt(i))) {
                        vowels++;
                    } else if (line.charAt(i) == '.' ||
                            line.charAt(i) == ',' ||
                            line.charAt(i) == '!' ||
                            line.charAt(i) == '?') {
                        punctuation++;

                    } else if (line.charAt(i) != ' ') {
                        consonants++;

                    }
                }
                line = reader.readLine();
            }
            String vow = "Vowels: " + vowels;
            String con = "Consonants: " + consonants;
            String pun = "Punctuation: " + punctuation;
            writer.write(vow);
            writer.write(System.lineSeparator());
            writer.write(con);
            writer.write(System.lineSeparator());
            writer.write(pun);
            writer.write(System.lineSeparator());
            writer.close();
        } catch (IOException ioe) {

        }
    }
}
