package mobs;

import items.Item;
import items.ItemFactory;

public class Wolf extends Mob{
    public Wolf() {
        super("Wolf", 11, 11, 5, 8, 3, 2, generateDrop()); // level 3 = 24 stat pts
    }

    // Spider-specific attack behavior
    @Override
    public void attack(Entity target) {
        int damage = this.damage - target.getDefense();
        if (damage < 0) {
            damage = 0; // No damage if defense is higher than damage
        }
        target.setHealth(target.getHealth() - damage);
        System.out.println(this.getName() + " attacks " + target.getName() + " for " + damage + " damage!");
    }

    private static Inventory generateDrop() {
        Inventory drop = new Inventory();
        // Add items to the drop inventory
        Item drop_1 = ItemFactory.createItem("Spider Silk");
        drop.addItem(drop_1);
        //drop.addItem(new Item("Spider Leg", 0.3));
        return drop;
    }
}