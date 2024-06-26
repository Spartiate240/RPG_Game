import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LevelChecker {

    public Map<Integer, Integer> loadLevelXpThresholds() throws IOException {
        Map<Integer, Integer> levelXpThresholds = new HashMap<>();
        String filePath = "Levels.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine())!= null) {
                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    int level = Integer.parseInt(parts[0].trim());
                    int xp = Integer.parseInt(parts[1].trim());
                    levelXpThresholds.put(level, xp);
                }
            }
        }
        return levelXpThresholds;
    }
}