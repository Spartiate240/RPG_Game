import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("Levels.txt"))) {
            int levelKey = 12;
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == levelKey) {
                    String[] parts = line.split(": ");
                    if (parts.length > 1) {
                        try {
                            System.out.println(parts[1]);
                        } catch (NumberFormatException e) {
                            System.err.println("Failed to parse number for level " + levelKey + ": " + e.getMessage());
                        }
                    } else {
                        System.err.println("Invalid line format for level " + levelKey + ": " + line);
                    }
                }
            }
        }
        catch (IOException e) {
        }
    }
}
