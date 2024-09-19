import items.*;
import mobs.Entity;
import mobs.Inventory;
import weapons.*;
import head.*;
import feet.*;
import chest.*;
import legs.*;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Player extends Entity {
    private int fullMaxHealth;
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
        this.fullMaxHealth = maxHealth; // Adding all other item health after, so that it can be done at appropriate time.
        
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


    // Stats including all gear
    public int getFullDamage() {
        int fulldmg = this.getDamage();
        if (getWeapon1()!= null) {
            fulldmg += this.getWeapon1().getDamage();
        }
        if (getWeapon2()!= null) {
            fulldmg += this.getWeapon2().getDamage();
        }
        if (getHead()!= null) {
            fulldmg += this.getHead().getDamage();
        }
        if (getChest() != null) {
            fulldmg += this.getChest().getDamage();
        }
        if (getLeg() != null) {
            this.getLeg().getDamage();
        }
        if (getFeet() != null) {
            this.getFeet().getDamage();
        }
        return fulldmg;
    }


    public void setFullHealth(int newFullHealth) {
        this.fullMaxHealth = newFullHealth;
    }

    public int getFullHealth() {
        int fullHealth = this.getMaxHealth();

        return fullHealth;
    }

    public int getFullMaxHealth() {
        int fullMaxHealth = this.getMaxHealth();

        if (getHead()!= null) {
            fullMaxHealth += this.getHead().getHealth();
        }
        if (getChest() != null) {
            fullMaxHealth += this.getChest().getHealth();
        }
        if (getLeg() != null) {
            fullMaxHealth += this.getLeg().getHealth();
        }
        if (getFeet() != null) {
            fullMaxHealth += this.getFeet().getHealth();
        }
        return fullMaxHealth;
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
  
            int currentLevel = this.level;
            int currentExperience = this.experience_pts;

            // Get the XP required for the next level
            int LevelXp = getRequiredXP(currentLevel);

            // Check if the player has enough XP to level up
            if( currentExperience >= LevelXp) {
                this.setLevel(currentLevel + 1);
                this.setXP(currentExperience - LevelXp );
                
                // Increases stats
                setDamage(getDamage() + 2);
                setDefense(getDefense() + 2);
                setHealth(getHealth() + 2);;
            }

    }




    public static int getRequiredXP(int level) {
            try (BufferedReader br = new BufferedReader(new FileReader("Levels.txt"))) {
                String line;
                int lineNumber = 0;
                while ((line = br.readLine()) != null) {
                    lineNumber++;
                    if (lineNumber == level) {
                        String[] parts = line.split(": ");
                        if (parts.length > 1) {
                            String xpString = parts[1];
                            return Integer.parseInt(xpString);
                        } else {
                            System.err.println("Invalid line format for level " + level + ": " + line);
                        }
                    }
                }
            }
            catch (IOException e) {
            }
        return 9999999;
        }

}