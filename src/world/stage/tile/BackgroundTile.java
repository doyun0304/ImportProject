package world.stage.tile;

import render.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

import static render.RenderUtil.tileSize;
import static world.stage.tile.TileType.*;

public class BackgroundTile {
    private BufferedImage img;
    private TileType type;
    private boolean collision;

    public BackgroundTile(TileType type){
        this.type = type;
        img = Images.tileImage[type.toIndex()];
        if (type == WALL) {
            collision = true;
        }
    }

    public void draw(Graphics2D g2, int x, int y){
        g2.drawImage(img, x*tileSize, y*tileSize, tileSize, tileSize, null);
    }

    public static BackgroundTile fromInt(int i){
        return new BackgroundTile(TileType.get(i));
    }

    public boolean canBeCollided(){
        return collision;
    }
}
