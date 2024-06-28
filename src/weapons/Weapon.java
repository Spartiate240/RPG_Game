package weapons;
import items.*;
public abstract class Weapon extends Item {
    private int damage;
    private int defense;
    private int level;
    private boolean heavy;

    public Weapon(String name, String description, int damage,  int defense, int level, int price, int cost, boolean heavy, double drop_chance) {
        super(name, description, price, cost, 1, drop_chance);
        this.defense = defense;
        this.damage = damage;
        this.level = level;
        this.heavy = heavy;
    }



    public int getDamage() {
        return this.damage;
    }

    public int getDefense() {
        return this.defense;
    }


    public int getLevel() {
        return this.level;
    }

    public boolean getHeavy() {
        return this.heavy;
    }


    public void setDamange(int new_damage) {
        this.damage = new_damage;
    }

    public void setDefense(int new_defense) {
        this.defense = new_defense;
    }

    public void setLevel(int new_level) {
        this.level = new_level;
    }

    public void setHeavy(boolean new_heavy) {
        this.heavy = new_heavy;
    }

}