package head;

import items.*;

/** Class centralizing the common methods of all feet pieces
 * @author	DUROLLET Pierre
 * @version	1.4
 */
public class Head extends Item{
    private int armor;
    private int damage;
    private int health;
    private int level;

    // Constructor
    public Head(String name, String description, int armor, int damage, int health, int level, int price, int cost, double drop_chance) {
        super(name, description, price, cost, 1, drop_chance);
        this.armor = armor;
        this.damage = damage;
        this.health = health;
        this.level = level;
    }

     /** Method giving the armor of the head piece
     * @return int armor that the head adds
     */
    public int getArmor() {
        return this.armor;
    }
 
     /** Method giving the damage of the head piece
     * @return int damage that the head adds
     */
    public int getDamage() {
        return this.damage;
    }

     /** Method giving the health of the head piece
     * @return int health that the head adds
     */
    public int getHealth() {
        return this.health;
    }

     /** Method giving the level of the head piece
     * @return int level of the head, a small indicator of the head's stats
     */
    public int getLevel() {
        return this.level;
    }



     /** Method allowing to change the defense of the head piece
     * @param new_armor new defense of the head
     */
    public void ssetArmor(int new_armor) {
        this.armor = new_armor;
    }
 
     /** Method allowing to change the damage of the head piece
     * @param new_damage new damage of the head
     */
    public void setDamage(int new_damage) {
        this.damage = new_damage;
    }

     /** Method allowing to change the health of the head piece
     * @param new_health new health of the head
     */
    public void setHealth(int new_health) {
        this.health = new_health;
    }

     /** Method allowing to change the defense of the head piece
     * @param new_level new defense of the head
     */
    public void setLevel(int new_level) {
        this.level = new_level;
    }

}
