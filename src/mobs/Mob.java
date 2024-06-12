package mobs;

// Total of 3*(lvl +5) stat points for non bosses
public class Mob extends Entity {
    private Inventory drop; // Items that can drop (each with a certain %)
    private int xp_drop;


    public Mob(String name, int health, int maxHealth, int defense, int damage, int level, int xp_drop) {
        super(name, health, maxHealth, defense, damage, level);
        this.xp_drop = xp_drop;
    }

    // Default attack behavior for all mobs
    // For now all are the same because simple mobs
    @Override
    public void attack(Entity target) {
        int damage = this.damage - target.getDefense();
        if (damage < 0) {
            damage = 0; // No damage if defense is higher than damage
        }
        target.setHealth(target.getHealth() - damage);
        System.out.println(this.getName() + " attacks " + target.getName() + " for " + damage + " damage!");
    }

    public int getXp_drop() {
        return xp_drop;
    }

    public Inventory getInventory() {
        return this.drop;
    }

    public void setXp_drop(int xp_drop) {
        this.xp_drop = xp_drop;
    }

    public void setInventory(Inventory newDrop) {
        this.drop = newDrop;
    }
}