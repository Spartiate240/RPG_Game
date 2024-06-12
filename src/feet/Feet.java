package feet;

import items.*;

public class Feet extends Item {
    private int armor;
    private int damage;
    private int health;
    private int level;

    public Feet(String name, String description, int armor, int damage, int health, int level, int price, int cost) {
        super(name, description, price, cost,1);
        this.armor = armor;
        this.damage = damage;
        this.health = health;
        this.level = level;
    }

    public int getArmor() {
        return this.armor;
    }
 
    public int getDamage() {
        return this.damage;
    }

    public int getHealth() {
        return this.health;
    }

    public int getLevel() {
        return this.level;
    }




    public void gsetArmor(int new_armor) {
        this.armor = new_armor;
    }
 
    public void setDamage(int new_damage) {
        this.damage = new_damage;
    }

    public void setHealth(int new_health) {
        this.health = new_health;
    }

    public void setLevel(int new_level) {
        this.level = new_level;
    }

}


