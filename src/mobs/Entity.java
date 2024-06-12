package mobs;

public abstract class Entity {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int defense;
    protected int damage;
    protected int level;
    protected int positionX;
    protected int positionY;

    public Entity(String name, int health, int maxHealth, int defense, int damage, int level) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.defense = defense;
        this.damage = damage;
        this.level = level;
    }

    // Getters and setters for the entity's attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
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