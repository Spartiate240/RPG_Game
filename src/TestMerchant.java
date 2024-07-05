import merchants.*;
import mobs.Inventory;
import items.*;

public class TestMerchant {
    static Player player;
    static Merchant merchant;

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        player = new Player("Test", 100, 100, 10, 3, 1,0, null, 10);
        Item SmallHealthPotion;

        SmallHealthPotion = ItemFactory.createItem("SmallHealthPotion");
        inventory.addItem(SmallHealthPotion);
        Merchant merchant = new Merchant("Test_Merchant", 0, 0, 0, 0, 0, inventory);
        
        int availableGold = player.getGold();
        Inventory goods = merchant.getInventory();
        Merchant.buying(availableGold, goods.get(0));
    }
}
