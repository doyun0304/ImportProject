package world.entity.item;

/*
 * Item on Field
 */

import render.Images;
import util.Vec2D;

import java.awt.*;
import java.awt.image.BufferedImage;

import static render.RenderUtil.tileSize;

public class FieldItem {
    String name;
    Item item;
    Vec2D pos;
    BufferedImage img;

    public FieldItem(String name, Vec2D pos, Item item) {
        this.name = name;
        this.pos = pos;
        img = Images.playerImage[0][0];
        this.item = item;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(img, pos.x*tileSize, pos.y*tileSize, tileSize, tileSize, null);
    }
}
