package mobs;

import items.*;

public class Spider extends Mob {
    public Spider() {
        super("Spider", 8, 8, 1, 2, 1, 1, generateDrop()); // level 1, so 12 stat pts
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

