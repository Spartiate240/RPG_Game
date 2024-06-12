import chest.*;
import feet.*;
import head.*;
import items.*;
import legs.*;
import weapons.*;


// Class that affects to each read string the class with the item's name.
public class GearFactory {
    
    public static Weapon createWeapon(String weaponName) {
        switch (weaponName) {
            case "Damaged_Bow":
                return new Damaged_Bow();
            case "Damaged_Sword":
                return new Damaged_Sword();
            default:
                throw new IllegalArgumentException("Unknown weapon: " + weaponName);
        }
    }


    public static Head createHead(String headName) {
        switch (headName) {
            case "Worn_Down_Cap":
                return new Worn_Down_Cap();
            default:
                throw new IllegalArgumentException("Unknown Head: " + headName);
        }
    }


    public static Leg createLeg(String legName) {
        switch (legName) {
            case "Torn_Leggings":
                return new Torn_Leggings();
            default:
                throw new IllegalArgumentException("Unknown Head: " + legName);
        }
    }    


    public static Feet createFeet(String feetName) {
        switch (feetName) {
            case "Worn_Down_Sandals":
                return new Worn_Down_Sandals();
            default:
                throw new IllegalArgumentException("Unknown Head: " + feetName);
        }

    }


    public static Chest createChest(String chestName) {
        switch (chestName) {
            case "Worn_Down_Chestplate":
                return new Worn_Down_Chestplate();
            default:
                throw new IllegalArgumentException("Unknown Head: " + chestName);
        }

    }
}


