package chest;

import items.*;

/** Class centralizing the common methods of all Chest pieces
 * @author	DUROLLET Pierre
 * @version	1.4
 */

public class Chest extends Item {
    private int armor;
    private int damage;
    private int health;
    private int level;

    // Constructor
    public Chest(String name, String description, int armor, int damage, int health, int level, int price, int cost, double drop_chance) {
        super(name, description, price, cost, 1, drop_chance);
        this.armor = armor;
        this.damage = damage;
        this.health = health;
        this.level = level;
    }


    
     /** Method giving the armor of the Chest piece
     * @return int armor that the chest adds
     */
    public int getArmor() {
        return this.armor;
    }

     /** Method giving the damage of the Chest piece
     * @return int damage that the chest adds
     */
    public int getDamage() {
        return this.damage;
    }

     /** Method giving the health of the Chest piece
     * @return int health that the chest adds
     */
    public int getHealth() {
        return this.health;
    }

     /** Method giving the level of the Chest piece
     * @return int level of the chest, a small indicator of the chest's stats
     */
    public int getLevel() {
        return this.level;
    }

     /** Method allowing to change the defense of the Chest piece
     * @param new_armor new defense of the chest
     */
    public void setArmor(int new_armor) {
        this.armor = new_armor;
    }

     /** Method allowing to change the damage of the Chest piece
     * @param new_damage new damage of the chest
     */
    public void setDamage(int new_damage) {
        this.damage = new_damage;
    }

     /** Method allowing to change the health of the Chest piece
     * @param new_health new health of the chest
     */
    public void setHealth(int new_health) {
        this.health = new_health;
    }

     /** Method allowing to change the level of the Chest piece
     * @param new_level new level of the chest
     */
    public void setLevel(int new_level) {
        this.level = new_level;
    }

}
