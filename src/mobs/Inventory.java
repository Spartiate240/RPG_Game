package mobs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import items.*;



// Do  an array of objects with: name, description, price, cost and quantity
public class Inventory {
    protected List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void delItem(Item item) {
        items.remove(item);
    }


    public void displayInventory() {
        Iterator<Item> iterator = items.iterator();
        System.out.println("Inventory: ");
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();
            System.out.println("Item: " +currentItem.getName() +", quantity: " + currentItem.getQuantity());
        }
    }


    public int size() {
        return items.size();
    }


    public Item get(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }


    public static List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }


    public void setQuantity(Item item, int newQuantity) {
        for (Item item2 : items) {
            if (item2 == item) {
                item2.setQuantity(newQuantity);
            }
        }
    }

    public int getQuantity(Item item) {
        for (Item item2 : items) {
            if (item2 == item) {
                return item2.getQuantity();
            }
        }
        return 0;
    }

}
