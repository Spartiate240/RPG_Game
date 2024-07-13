package items;
public class ItemFactory {
 
    
    
    // Class that affects to each read string the class with the item's name.        
        public static Item createItem(String itemName) {
            switch (itemName) {
                case "SmallHealthPotion":
                    return new SmallHealthPotion();
                case "MediumHealthPotion":
                    return new MediumHealthPotion();
                case "Spider Silk":
                    return new Spider_Silk();
                default:
                    throw new IllegalArgumentException("Unknown item: " + itemName);
            }
        }
}