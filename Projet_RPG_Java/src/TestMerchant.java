import merchants.*;
import mobs.Inventory;
import items.*;

public class TestMerchant {
    static Player player;
    static Merchant merchant;

    public static void main(String[] args) {
        Inventory inventoryP = new Inventory();
        Item MedHealthPotion;
        MedHealthPotion = ItemFactory.createItem("MediumHealthPotion");
        inventoryP.addItem(MedHealthPotion);
        player = new Player("Test", 100, 100, 10, 3, 1,0, inventoryP, 10);

        Item SmallHealthPotion;
        Inventory inventoryM = new Inventory();
        SmallHealthPotion = ItemFactory.createItem("SmallHealthPotion");
        inventoryM.addItem(SmallHealthPotion);
        Merchant merchant = new Merchant("Test_Merchant", 0, 0, 0, 0, 0, inventoryM);
        
        int availableGold = player.getGold();
        Inventory goods = merchant.getInventory();
        Merchant.buying(availableGold, goods.get(0));


        Inventory pInventory = player.getInventory();
        Merchant.selling(pInventory, SmallHealthPotion);
    }
}
