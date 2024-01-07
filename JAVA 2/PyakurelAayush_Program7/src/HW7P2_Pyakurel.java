import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HW7P2_Pyakurel {
    public static void main(String[] args) {
        Map<Integer, StringBuilder> wordLengthMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim();
                int length = word.length();

                StringBuilder currentValue = wordLengthMap.getOrDefault(length, new StringBuilder());

                if (currentValue.length() > 0) {
                    currentValue.append(", ");
                }
                currentValue.append(word);

                wordLengthMap.put(length, currentValue);
            }
        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
            return;
        }

        System.out.println("Words by length:");
        wordLengthMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    int length = entry.getKey();
                    String words = entry.getValue().toString();
                    System.out.printf("length %d: %s%n", length, words);
                });
    }
}