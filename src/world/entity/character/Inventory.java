package world.entity.character;

import world.entity.item.Item;

import java.awt.*;
import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> itemList;
    boolean isDisplayed;

    public Inventory() {
        itemList = new ArrayList<>();
        isDisplayed = false;
    }

    void addItem(Item item) {
        itemList.add(item);
    }

    Item removeItem(int i) {
        Item item = itemList.get(i);
        itemList.remove(i);

        return item;
    }

    public void draw(Graphics2D g2){

    }
}