package feet;

import items.*;

/** Class centralizing the common methods of all feet pieces
 * @author	DUROLLET Pierre
 * @version	1.4
 */
public class Feet extends Item {
    private int armor;
    private int damage;
    private int health;
    private int level;

    // Constructor
    public Feet(String name, String description, int armor, int damage, int health, int level, int price, int cost, double drop_chance) {
        super(name, description, price, cost,1, drop_chance);
        this.armor = armor;
        this.damage = damage;
        this.health = health;
        this.level = level;
    }

     /** Method giving the armor of the feet piece
     * @return int armor that the feet adds
     */
    public int getArmor() {
        return this.armor;
    }
 
     /** Method giving the damage of the feet piece
     * @return int damage that the feet adds
     */
    public int getDamage() {
        return this.damage;
    }

     /** Method giving the health of the feet piece
     * @return int health that the feet adds
     */
    public int getHealth() {
        return this.health;
    }

     /** Method giving the level of the feet piece
     * @return int level of the feet, a small indicator of the feet's stats
     */
    public int getLevel() {
        return this.level;
    }



     /** Method allowing to change the defense of the feet piece
     * @param new_armor new defense of the feet
     */
    public void setArmor(int new_armor) {
        this.armor = new_armor;
    }
 
     /** Method allowing to change the damage of the feet piece
     * @param new_damage new damage of the feet
     */
    public void setDamage(int new_damage) {
        this.damage = new_damage;
    }
     /** Method allowing to change the health of the feet piece
     * @param new_health new health of the feet
     */
    public void setHealth(int new_health) {
        this.health = new_health;
    }

     /** Method allowing to change the level of the feet piece
     * @param new_level new level of the feet
     */
    public void setLevel(int new_level) {
        this.level = new_level;
    }

}


