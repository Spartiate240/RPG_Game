package mobs;

/** Class centralizing the common methods of all feet pieces
 * @author	DUROLLET Pierre
 * @version	1.4
 */
public abstract class Entity {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int defense;
    protected int damage;
    protected int level;
    protected int positionX;
    protected int positionY;

    // Constructor
    public Entity(String name, int health, int maxHealth, int defense, int damage, int level) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.defense = defense;
        this.damage = damage;
        this.level = level;
    }

     /** Method giving the name of the entity
     * @return String name of the entity
     */
    public String getName() {
        return name;
    }

     /** Method changing the name of the entity
     * @param new_name new name of the entity
     */
    public void setName(String new_name) {
        this.name = new_name;
    }

     /** Method giving the health of the entity
     * @return int health of the entity
     */
    public int getHealth() {
        return health;
    }

     /** Method changing the health of the entity
     * @param new_health new health of the entity
     */
    public void setHealth(int new_health) {
        this.health = new_health;
    }

     /** Method giving the max health of the entity
     * @return int max health of the entity
     */
    public int getMaxHealth() {
        return maxHealth;
    }

     /** Method changing the max heaath of the entity
     * @param new_maxHealth new max health of the entity
     */
    public void setMaxHealth(int new_maxHealth) {
        this.maxHealth = new_maxHealth;
    }

     /** Method giving the defense of the entity
     * @return int defense of the entity
     */
    public int getDefense() {
        return defense;
    }

     /** Method changing the defense of the entity
     * @param new_defense new defense of the entity
     */
    public void setDefense(int new_defense) {
        this.defense = new_defense;
    }

     /** Method giving the damage of the entity
     * @return int damage of the entity
     */
    public int getDamage() {
        return damage;
    }

     /** Method changing the damage of the entity
     * @param new_damage new damage of the entity
     */
    public void setDamage(int new_damage) {
        this.damage = new_damage;
    }

     /** Method giving the level of the entity
     * @return int level of the entity
     */
    public int getLevel() {
        return level;
    }

     /** Method changing the level of the entity
     * @param new_level new level of the entity
     */
    public void setLevel(int new_level) {
        this.level = new_level;
    }

     /** Method giving the X coordinate of the entity
     * @return int coordinate of the X axis of the entity
     */
    public int getPositionX() {
        return positionX;
    }

     /** Method changing the X coordinate of the entity
     * @param new_positionX new X coordinate of the entity
     */
    public void setPositionX(int new_positionX) {
        this.positionX = new_positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    // Method to move the entity
    public void move(int dx, int dy) {
        this.positionX += dx;
        this.positionY += dy;
    }

    // Abstract method for attack behavior, to be implemented by subclasses
    public abstract void attack(Entity target);
}