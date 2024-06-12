import items.*;

public class ItemFactory {
 
    
    
    // Class that affects to each read string the class with the item's name.        
        public static Item createItem(String itemName) {
            switch (itemName) {
                case "SmallHealthPotion":
                    return new SmallHealthPotion();
                case "MediumHealthPotion":
                    return new MediumHealthPotion();
                default:
                    throw new IllegalArgumentException("Unknown item: " + itemName);
            }
        }
}