// Used to create level threshold
// TODO Adjust so that it writes in the Levels file

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Level_Creation {
    private static int x = 100;
    private static double y = 1.5;
    private static int levelMax = 20;

    public static void Levels() {
        String filePath = "/home/pierre/Documents/Privé/ProjetJeuRPG/src/Levels";

        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File updated sucessfully.");
            }


            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            double threshold = 5;
            int current_level = 0;
            for (int i = 1; i < levelMax; i++) {
                threshold = x * Math.round(Math.pow(current_level, y));
                int threshold_for_next_level = (int) threshold;
                System.out.println("Level " + i + " : " + threshold_for_next_level);
                current_level = i;
                bw.write("Level " + current_level + " : " + threshold_for_next_level + "\n");
            }
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}