import java.util.Scanner;


public class MenuSystem {
    static Player player;


    public static void displayMenu() {
        System.out.println("Choose what to do:");
        System.out.println("1. Fight");
        System.out.println("2. Access Player Profile");
        System.out.println("3. Other");
        // Add more options as needed

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Fight.FightLoop(player);
            case 2:
                player.dispInventory();
            case 3:
                break;
            // Handle other cases
        }
        scanner.close();
    }
}