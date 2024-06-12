package mobs;

public class Wolf extends Mob{
    public Wolf() {
        super("Wolf", 11, 11, 5, 8, 3, 2); // level 3 = 24 stat pts
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

}