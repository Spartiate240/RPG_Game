import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import weapons.*;
import head.*;
import chest.*;
import feet.*;
import legs.*;
import items.*;



public class PlayerFile {

    public static Player createPlayer(String argsString) {
        // Path to the player file
        String filePath = "/home/pierre/Documents/Privé/ProjetJeuRPG/src/PlayerFiles/Example.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
                // Creating player
            Player player = new Player();


            // Read player data
            while ((line = br.readLine())!= null) {
                if (!line.startsWith("#")) { // Skip comment lines
                    if (line.contains(":")) {
                        String[] parts = line.split(":");
                        String key = parts[0].trim().toLowerCase();
                        String value = parts[1].trim();
                        // Determine where to store the value based on the key
                        switch (key) {
                            case "username":
                                player.setName(value);
                                break;
                            case "level":
                                player.setLevel(Integer.parseInt(value));
                                break;
                            case "xp":
                                player.setXP(Integer.parseInt(value));;
                                break;
                            case "maxhealth":
                                player.setMaxHealth(Integer.parseInt(value));;
                                break;
                            case "damage":
                                player.setDamage(Integer.parseInt(value));;
                                break;
                            case "defense":
                                player.setDefense(Integer.parseInt(value));
                            break;
                            case "head": // Index 6
                                Head headGear = GearFactory.createHead(value); // Assuming the factory method exists and creates a gear based on the string
                                player.setHead(headGear);
                                break;
                            case "leg":
                                Leg legGear = GearFactory.createLeg(value);
                                player.setLeg(legGear);   
                                break;
                            case "feet":
                                Feet feetGear = GearFactory.createFeet(value);
                                player.setFeet(feetGear);
                                break;
                            case "chest":
                               Chest chestGear = GearFactory.createChest(value);
                                player.setChest(chestGear);
                                break;
                            case "weapon_1": // Index 10
                                Weapon weapon1 = GearFactory.createWeapon(value);
                                player.setWeapon(weapon1, 1);
                                break;
                            case "weapon_2":
                                Weapon weapon2 = GearFactory.createWeapon(value);
                                player.setWeapon(weapon2, 2);
                                break;
                        }
                    }
                }
                //Creating Inventory
                // Separating Item names and quantity
                if (line.startsWith("Inventory :")) {
                    String[] parts = line.split(": ");
                    String[] items = parts[1].split(", ");
                    for (int i = 0; i< items.length; i++) {
                        String[] allItem = items[i].split(" x");
                        Item addToInventory = ItemFactory.createItem(allItem[0]);
                        player.addPlayerItem(addToInventory);
                        player.getInventory().setQuantity(addToInventory, Integer.parseInt(allItem[1]));
                    }
                }
            }
            return player;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
            return null;
        }
    }

public static void createFile(Player player, String filePath) {

    try {
        File file = new File(filePath);
        if (file.createNewFile()) {
          System.out.println("File created: " + file.getName());
        } else {
          System.out.println("File updated sucessfully.");
        }


        BufferedWriter bw = new BufferedWriter(new FileWriter(file));



        // Write player username
        bw.write("Username: " + player.getName() + "\n\n");

        // Write level and xp
        bw.write("level: " + player.getLevel() + "\n");
        bw.write("XP: " + player.getXP() + "\n\n");

        // Write player stats
        bw.write("Stats\n\n");
        bw.write("MaxHealth : " + player.getMaxHealth() + "\n");
        bw.write("damage : " + player.getDamage() + "\n");
        bw.write("Defense : " + player.getDefense() + "\n\n");

        // Write equipment
        bw.write("Equipment\n\n");
        bw.write("Head : " + player.getHead().getName() + "\n");
        bw.write("Leg : " + player.getLeg().getName() + "\n");
        bw.write("Feet : " + player.getFeet().getName() + "\n");
        bw.write("Chest : " + player.getChest().getName() + "\n");
        bw.write("weapon_1 : " + player.getWeapon1().getName() + "\n");
        bw.write("weapon_2 : " + player.getWeapon2().getName() + "\n");

        // Write inventory
        bw.write("Inventory :\n");
        for (Item item : player.getInventory().getItems()) {
            bw.write(item.getName() + " x" + player.getInventory().getQuantity(item) + ", ");
        }
        // Remove trailing comma and space before closing tag
        bw.write("\n");
        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error writing file.");
    }
}

}
