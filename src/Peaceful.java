import java.util.Scanner;

public class Peaceful {
    static Player player;


    // Allows to chose other submenu that doesn't involve fighting
    // begins with only equipement change, and will add merchants and moving on the map
    public void subMenu() {
        
        System.out.println("Choose what to do:");
        System.out.println("1. Change gear");
        System.out.println("2. Access Merchants");
        System.out.println("3. Moving");
        // Add more options as needed

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Fight.FightLoop(player);
            case 2:
                player.getInventory().displayInventory();
            case 3:
                break;
            // Handle other cases
        }
        scanner.close();
    }
}
