package world.entity.item;

import java.awt.image.BufferedImage;

/*
 * Item on Toolbar
 */

public abstract class Item {
    int stageId;
    String name;
    BufferedImage img;

    public Item(String name) {
        this.name = name;
    }

    public void draw(){

    }
}
