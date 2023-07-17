package world.stage;

import render.Images;
import render.panel.StagePanel;
import util.Vec2D;

import java.awt.*;
import java.awt.image.BufferedImage;

import static render.RenderUtil.tileSize;
import static world.stage.TileType.*;

public class BackgroundTile {
    private BufferedImage img;
    private TileType type;
    private boolean collision;

    public BackgroundTile(TileType type){
        this.type = type;
        switch (type) {
            case WALL -> {
                img = Images.playerImage[3][3];
                collision = true;
            }
            case GSHS -> {
                img = Images.gshsImage;
            }
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
