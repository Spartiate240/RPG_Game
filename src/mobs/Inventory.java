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
        if (contains(item)) {
            item.setQuantity(item.getQuantity() + 1); // If item already in the inventory, adds 1 to quantity
        } else {
            items.add(item); // If item !in the inventory, adds it
        }
    }

    public void addItems(Inventory addedItems) {
        for (Item item : addedItems.getItems()) {
            this.items.add(item);
        }
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


    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }


    public void setQuantity(Item item, int newQuantity) {
        item.setQuantity(newQuantity);
    }


    public int getQuantity(Item item) {
        return item.getQuantity();
    }

    public boolean contains(Item item) {
        for (Item item2 : items) {
            if (item2 == item) {
                return true;
            }
        }
        return false;
    }

}
