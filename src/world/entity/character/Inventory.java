package world.entity.character;

import world.entity.item.Item;
import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> itemList;
    boolean isDisplayed;

    public Inventory() {
        itemList = new ArrayList<>();
        isDisplayed = false;
    }

    void display() {

    }

    void addItem(Item item) {
        itemList.add(item);
    }

    Item removeItem(int i) {
        Item item = itemList.get(i);
        itemList.remove(i);

        return item;
    }

    void openInventory() {

    }
}