import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DisplayCommonWords {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java DisplayCommonWords file1.txt file2.txt");
            return;
        }

        String file1Path = args[0];
        String file2Path = args[1];

        List<String> file1Words = getWordsFromFile(file1Path);
        List<String> file2Words = getWordsFromFile(file2Path);

        List<WordDetails> commonWords = new ArrayList<>();

        // Find common words and their details
        for (int i = 0; i < file1Words.size(); i++) {
            String word = file1Words.get(i);
            if (file2Words.contains(word)) {
                WordDetails details = new WordDetails(word);
                details.addAppearance(i + 1, file1Path);
                details.addAppearance(file2Words.indexOf(word) + 1, file2Path);
                commonWords.add(details);
            }
        }

        // Display common words and their details
        System.out.println("The following words are common in both files with the following details:");
        for (WordDetails details : commonWords) {
            System.out.println(details);
        }
    }

    private static List<String> getWordsFromFile(String filePath) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return words;
    }

    static class WordDetails {
        private String word;
        private List<String> appearances = new ArrayList<>();

        public WordDetails(String word) {
            this.word = word;
        }

        public void addAppearance(int lineNumber, String filePath) {
            appearances.add(lineNumber + " th line in " + filePath);
        }

        @Override
        public String toString() {
            return word + ": length " + word.length() + ", appeared in " + String.join(" and ", appearances);
        }
    }
}
