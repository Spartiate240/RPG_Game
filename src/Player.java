import items.*;
import mobs.Entity;
import mobs.Inventory;
import weapons.*;
import head.*;
import feet.*;
import chest.*;
import legs.*;

import java.util.Map;
import java.io.IOException;

public class Player extends Entity {
    private int experience_pts;
    private Inventory playerInventory;
    private Head head;
    private Leg leg;
    private Feet feet;
    private Chest chest;
    private Weapon weapon_1;
    private Weapon weapon_2;
    private int gold;

    public Player(String name, int health, int maxHealth, int defense, int damage, int level, int experience_pts, Inventory playerInventory, int gold) {
        super(name, health, maxHealth, defense, damage, level);
        this.experience_pts = experience_pts;
        this.playerInventory = playerInventory;
        this.gold = gold;
    }

    public Player() {
        super("None", 0, 0, 0, 0, 0);
        this.experience_pts = 0;
        this.playerInventory = new Inventory();
        this.gold = 0;
    }




    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    public int getXP() {
        return this.experience_pts;
    }


    public void setXP(int newXP) {
        this.experience_pts = newXP;
    }

    public void addPlayerItem(Item item) {
        this.playerInventory.addItem(item);
    }


    public void delPlayerItem(Item item) {
        this.playerInventory.delItem(item);
    }


    public void setHead(Head head) {
        if (this.head != null) {
            this.playerInventory.addItem(this.head);
        } 
        this.head = head;
        this.playerInventory.delItem(head);
    }

    public void setChest(Chest chest) {
        if (this.chest != null) {
            this.playerInventory.addItem(this.chest);
        } 
        this.chest = chest;
        this.playerInventory.delItem(chest);
    }

    public void setLeg(Leg leg) {
        if (this.leg != null) {
            this.playerInventory.addItem(this.leg);
        } 
        this.leg = leg;
        this.playerInventory.delItem(leg);
    }

    public void setFeet(Feet feet) {
        if (this.feet != null) {
            this.playerInventory.addItem(this.feet);
        } 
        this.feet = feet;
        this.playerInventory.delItem(feet);
    }


    public void setWeapon(Weapon weapon, int slot) {
        if (weapon.getHeavy() == true) { // If the weapon takes both slots
            this.playerInventory.addItem(this.weapon_1);
            this.playerInventory.addItem(this.weapon_2);
            this.weapon_1 = weapon;
            Weapon EmptyForHeavy = new Empty();
            this.weapon_2 = EmptyForHeavy;
            this.playerInventory.delItem(weapon);
        } else {
            switch (slot) {
                case 1:
                    if (this.weapon_1 != null) {
                        this.playerInventory.addItem(weapon_1);
                    }
                    this.weapon_1 = weapon;
                    break;
                case 2:
                    if (this.weapon_2 != null) {
                        this.playerInventory.addItem(weapon_2);
                    }
                    this.weapon_2 = weapon;
                    break;
            }
        }
    }

    public void setGold(int newGold) {
        this.gold = newGold;
    }



    public int getDamage() {
        return this.damage;
    }

    // Stats including all gear
    public int getFullDamage() {
        return this.getDamage() + this.getWeapon1().getDamage() + this.getWeapon2().getDamage() + this.getHead().getDamage()
                + this.getChest().getDamage() + this.getLeg().getDamage() + this.getFeet().getDamage();
    }

    public int getFullDefense() {
        return this.getDefense() + this.getWeapon1().getDefense() + this.getWeapon2().getDefense() + this.getHead().getHealth()
                + this.getChest().getArmor() + this.getLeg().getArmor() + this.getFeet().getArmor();
    }

    public int getFullHealth() {
        return this.getHealth() + this.getWeapon1().getDefense() +  this.getHead().getHealth() + this.getChest().getHealth() + 
        this.getLeg().getHealth() + this.getFeet().getHealth();
    }

    public int getFullMaxHealth() {
        return this.getFullHealth() + this.getWeapon1().getDefense() +  this.getHead().getHealth() + this.getChest().getHealth() + 
        this.getLeg().getHealth() + this.getFeet().getHealth();
    }


    public Head getHead() {
        return this.head;
    }

    public Leg getLeg() {
        return this.leg;
    }

    public Feet getFeet() {
        return this.feet;
    }

    public Chest getChest() {
        return this.chest;
    }

    public Weapon getWeapon1() {
        return this.weapon_1;
    }

    public Weapon getWeapon2() {
        return this.weapon_2;
    }

    public Inventory getInventory() {
        return this.playerInventory;
    }

    public int getGold() {
        return this.gold;
    }


    @Override
    public void attack(Entity target) {
        // Player-specific attack logic
        int damage = this.getFullDamage() - target.getDefense();
        if (damage < 0) {
            damage = 0; // No damage if defense is higher than damage
        }
        target.setHealth(target.getHealth() - damage);
        System.out.println(this.getName() + " attacks " + target.getName() + " for " + damage + " damage!");
    }



    // String avoids having to change numbers everywhere
    public int heal(String amount) {
        if (amount == "small") {
            SmallHealthPotion potion = new SmallHealthPotion();
            return potion.getHeal();
        } else if (amount == "medium") {
            MediumHealthPotion potion = new MediumHealthPotion();
            return potion.getHeal();
        } else {
            return 0;
        }
    }

    public void checkLevelUp() {
        LevelChecker levelChecker = new LevelChecker();
        Map<Integer, Integer> levelXpThresholds;
        try {
            levelXpThresholds = levelChecker.loadLevelXpThresholds();

            int currentLevel = this.level; // Assuming 'level' is a member variable of Player
            int currentExperience = this.experience_pts; // Assuming 'xp' is a member variable of Player

            // Get the XP required for the next level
            int nextLevelXp = levelXpThresholds.getOrDefault(currentLevel + 1, 0);

            // Check if the player has enough XP to level up
            if( currentExperience >= nextLevelXp) {
                this.setLevel(currentLevel + 1);
                this.setXP(currentExperience -nextLevelXp );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}