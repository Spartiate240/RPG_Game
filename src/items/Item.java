package items;

public class Item {
    private String name;
    private int price;
    private int cost;
    private String description;
    private int quantity;

    public Item(String name, String description, int price, int cost, int quantity) {
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrice() {
        return this.price;
    }

    public int getCost() {
        return this.cost;
    }

    public int getQuantity() {
        return this.quantity;
    }


    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setprice(int newPrice) {
        this.price = newPrice;
    }

    public void setCost(int newCost) {
        this.cost = newCost;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

}
