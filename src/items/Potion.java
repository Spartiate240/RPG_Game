package items;

public class Potion extends Item {
    private int healthgain;

    public Potion(String name, String description, int price, int cost, int healthgain) {
        super(name,description, price, cost, 1);
        this.healthgain = healthgain;
    }

    public int getHeal() {
        return healthgain;
    }

    public void setHeal(int healthgain) {
        this.healthgain = healthgain;
    }

}
