package world.entity.character;

import world.entity.item.Item;
import world.entity.item.Key;

import java.awt.*;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int selectedIdx;
    private Player player;

    public static final int maxItemCnt = 25;

    public Inventory(Player player) {
        items = new ArrayList<>();
        selectedIdx = 0;
        this.player = player;
    }

    void addItem(Item item) {
        if(items.size()>=maxItemCnt) return;
        items.add(item);
        updateDisplay();
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

    public int getSelectedIdx() {
        return selectedIdx;
    }

    public Item getSelectedItem(){
        if(selectedIdx<items.size()) return items.get(selectedIdx);
        else return null;
    }

    public void setSelectedIdx(int selectedIdx) {
        int i = selectedIdx%maxItemCnt;
        this.selectedIdx = i<0?i+25:i;
        updateDisplay();
    }

    private void updateDisplay(){
        player.getGamePanel().getToolPanel().updateItems();
    }

    public void clear(){
        items.clear();
        setSelectedIdx(0);
        updateDisplay();
    }
}