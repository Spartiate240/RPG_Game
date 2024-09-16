// Used to create level threshold

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Level_Creation {
    private static int x = 100;
    private static double y = 1.5;
    private static int levelMax = 100;

    public static void Levels() {
        String filePath = "/home/pierre/Documents/Privé/Projets_Persos/Projet_RPG_Java/src/Levels.txt";
        System.out.println(filePath);

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
            for (int i = 1; i < levelMax + 1; i++) {
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