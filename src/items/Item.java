package items;

/** Class centralizing the methods for the items
 * @author	DUROLLET Pierre
 * @version	1.4
 */

public class Item {
    private String name;
    private int price;
    private int cost;
    private String description;
    private int quantity;
    // 1 = certain drop rate
    private double drop_chance;

    // Constructor
    public Item(String name, String description, int price, int cost, int quantity, double drop_chance) {
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.description = description;
        this.quantity = quantity;
        this.drop_chance = drop_chance;
    }

     /** Method giving the name of the item
     * @return the name of the item
     */
    public String getName() {
        return this.name;
    }
     /** Method giving the description of the item
     * @return the description of the item
     */
    public String getDescription() {
        return this.description;
    }

     /** Method giving the price of the item
     * @return int price to sell the item
     */
    public int getPrice() {
        return this.price;
    }

     /** Method giving the cost of the item
     * @return int cost to buy the item
     */
    public int getCost() {
        return this.cost;
    }

     /** Method giving the quantity of the item
     * @return int amount of the item is possessed
     */
    public int getQuantity() {
        return this.quantity;
    }

     /** Method giving the drop chance of an item when a mob is killed
     * @return double, chance of the item being dropped of the inventory
     */
    public double getDropChance() {
        return this.drop_chance;
    }

     /** Method setting a new item name
     * @param newName new name of the item 
     */
    public void setName(String newName) {
        this.name = newName;
    }

     /** Method setting a new item description
     * @param newDescription new description of the item 
     */
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

     /** Method setting a new item price
     * @param newPrice new price of the item 
     */
    public void setprice(int newPrice) {
        this.price = newPrice;
    }

     /** Method setting a new item cost
     * @param newCost new cost of the item 
     */
    public void setCost(int newCost) {
        this.cost = newCost;
    }

     /** Method setting a new item quantity
     * @param newQuantity new quantity of the item 
     */
    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

     /** Method setting a new item drop chance
     * @param new_DropChance new drop chance of the item 
     */
    public void setDropChance(float new_DropChance) {
        this.drop_chance = new_DropChance;
    }
}
