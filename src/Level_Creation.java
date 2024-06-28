// Used to create level threshold
// TODO Adjust so that it writes in the Levels file


public class Level_Creation {
    private static int x = 100;
    private static double y = 1.5;
    private static int levelMax = 20;

    public static void Levels() {
        double threshold = 5;
        int current_level = 0;
        for (int i = 1; i < levelMax; i++) {
            threshold = x * Math.round(Math.pow(current_level, y));
            int threshold_for_next_level = (int) threshold;
            System.out.println("Level " + i + " : " + threshold_for_next_level);
            current_level = i;
        }
    }
 
    public static void main(String[] args) {
        Levels();
    }

}
