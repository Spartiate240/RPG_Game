package merchants;

import java.util.Scanner;

import mobs.Entity;
import mobs.Inventory;
import items.*;

public class Merchant extends Entity {
    private Inventory goods; // Items the memrchant can sell
    

    public Merchant(String name, int health, int maxHealth, int defense, int damage, int level, Inventory goods) {
        super(name, 100000000, 100000000, 100000000, 0, 100000000);
        this.goods = goods;
    }

    // Nothing happens
    @Override
    public void attack(Entity target) {
    }

    public Inventory getInventory() {
        return this.goods;
    }

    public void setInventory(Inventory newGoods) {
        this.goods = newGoods;
    }

    public static Item buying(int gold, Item item) {
        boolean valid = false;
        if (gold < item.getCost()) {
            return null;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are attempting to buy a " + item.getName());
        System.out.println("Buying this item will use up : " + item.getPrice() + " gold.\n");
        System.out.println("Are you sure you want to buy it? \n\n");
        System.out.println("-o Yes\n -n No");
        do {
            String entreeString = scanner.nextLine();

            if (entreeString.equals("o")) {
                valid = true;
                System.out.println("You have confirmed the sale.");
                return item;
            } else if (entreeString.equals("n")) {
                valid = true;
                System.out.println("You have abandonned the sale.");
                return null;
            }
            System.out.println("Input non conforming to the choices.");
        } while (!valid); // Should never be reached.
        scanner.close();
        return null;
    }
        


    public static Item selling(Item item) {
        boolean valid = false; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selling this item will reward you with : " + item.getPrice() + " gold.\n");
        System.out.println("Are you sure you want to sell it? \n\n");
        System.out.println("-o Yes\n -n No");
        String entreeString = scanner.nextLine();
        while (!valid) {
            if (entreeString.equals("o")) {
                scanner.close();
                valid = true;
                System.out.println("You have confirmed the sale.");
                return item;
            } else if (entreeString.equals("n")) {
                valid = true;
                scanner.close();
                System.out.println("You have abandonned the sale.");
                return null;
            }
            System.out.println("Input non conforming to the choices.");
        } // Should never be reached.
        scanner.close();
        return null; 
    }
}
