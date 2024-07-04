package merchants;

import org.junit.runner.OrderWith;

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

    public Item buying(int gold, Item item) {
        if (gold >= item.getCost()) {
            return item;
        }
        System.out.println("You do not have the necessary funds to buy this item.");
        return null;
    }
}
