package weapons;
import items.*;
public abstract class Weapon extends Item {
    private int damage;
    private int level;
    private boolean heavy;

    public Weapon(String name, String description, int damage, int level, int price, int cost, boolean heavy) {
        super(name, description, price, cost, 1);
        this.damage = damage;
        this.level = level;
        this.heavy = heavy;
    }



    public int getDamage() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean getHeavy() {
        return this.heavy;
    }


    // If addition of damage (buff stone or other, needs to be
    // new_damage = this.getDamage() + added_value)
    public void setDamange(int new_damage) {
        this.damage = new_damage;
    }

    // Same as setDamage
    public void setLevel(int new_level) {
        this.level = new_level;
    }

    public void setHeavy(boolean new_heavy) {
        this.heavy = new_heavy;
    }

}