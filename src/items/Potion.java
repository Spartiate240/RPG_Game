package items;

/** Class centralizing the methods for the potions
 * @author	DUROLLET Pierre
 * @version	1.4
 */
public class Potion extends Item {
    private int healthgain;

    // Constructor
    public Potion(String name, String description, int price, int cost, int healthgain, double drop_chance) {
        super(name,description, price, cost, 1, drop_chance);
        this.healthgain = healthgain;
    }
    
     /** Method giving the healing of a potion
     * @return int life gained by the user
     */
    public int getHeal() {
        return healthgain;
    }
     /** Method setting the heal gained by using a potion
     * @param new_healthgain new amount of HP gained by using a potion 
     */
    public void setHeal(int new_healthgain) {
        this.healthgain = new_healthgain;
    }

}
