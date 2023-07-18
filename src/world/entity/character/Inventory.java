package world.entity.character;

import world.entity.item.Item;
import world.entity.item.Key;

import java.awt.*;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int selectedIdx;

    public static final int maxItemCnt = 25;

    public Inventory() {
        items = new ArrayList<>();
        selectedIdx = 0;
        addItem(new Key("key01", "lock01"));
    }

    void addItem(Item item) {
        items.add(item);
    }

    Item removeItem(int i) {
        return items.remove(i);
    }

    public Item getItem(int i){
        if(i<items.size()) return items.get(i);
        else return null;
    }

    public void draw(Graphics2D g2){
        for(int i=0; i<25; i++){
            if(i<items.size()) items.get(i).draw(g2, i);
        }
    }
}