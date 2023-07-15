package world.entity.character;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> itemList;
    boolean isShowing;

    public Inventory() {
        itemList = new ArrayList<>();
        isShowing = false;
    }

    void display() {
        
    }

    void pushItem(Item item) {
        itemList.add(item);
    }

    Item popItem(int i) {
        Item item = itemList.get(i);
        itemList.remove(i);

        return item;
    }

    void openInventory() {

    }
}