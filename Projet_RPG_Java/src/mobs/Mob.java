package mobs;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import items.*;

/** Class that Hosts the general methods which all mobs share
 * @author	DUROLLET Pierre
 * @version	1.4
 */


// Total of 3*(lvl +5) stat points for non bosses
public class Mob extends Entity {
    private Inventory drop; // Items that can drop (each with a certain %)
    private int xp_drop;


    public Mob(String name, int health, int maxHealth, int defense, int damage, int level, int xp_drop, Inventory drop) {
        super(name, health, maxHealth, defense, damage, level);
        this.xp_drop = xp_drop;
        this.drop = drop;
    }

    // Default attack behavior for all mobs
    @Override
    public void attack(Entity target) {
        int damage = this.damage - target.getDefense();
        if (damage < 0) {
            damage = 0; // No damage if defense is higher than damage
        }
        target.setHealth(target.getHealth() - damage);
        System.out.println(this.getName() + " attacks " + target.getName() + " for " + damage + " damage!");
    }

    public int getXp_drop() {
        return xp_drop;
    }

    public Inventory getInventory() {
        return this.drop;
    }

    public void setXp_drop(int xp_drop) {
        this.xp_drop = xp_drop;
    }
    
    public void setInventory(Inventory newDrop) {
        this.drop = newDrop;
    }

    public Inventory getDrop() {
        Random rand = new Random();
        Inventory drops = new Inventory();
        for (Item item : drop.getItems()) {
            double dropChance = item.getDropChance();
            if (rand.nextDouble() < dropChance) {
                drops.addItem(item);
            }
        }
        return drops;
    }
}