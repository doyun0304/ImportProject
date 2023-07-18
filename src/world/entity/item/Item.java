package world.entity.item;

import java.awt.*;
import java.awt.image.BufferedImage;

import static render.RenderUtil.tileSize;

/*
 * Item on Toolbar
 */

public abstract class Item {
    int stageId;
    protected String name;
    protected BufferedImage img;

    public Item(String name) {
        this.name = name;
    }

    public void draw(Graphics2D g2, int idx){
        g2.drawImage(img, idx*tileSize, tileSize, tileSize, tileSize, null);
    }

    public BufferedImage getImg() {
        return img;
    }

    public String getName() {
        return name;
    }
}
