package world.stage;

import render.Images;
import render.panel.StagePanel;
import util.Vec2D;

import java.awt.*;
import java.awt.image.BufferedImage;

import static render.RenderUtil.tileSize;

public class BackgroundTile {
    private BufferedImage img;
    private String type;

    public BackgroundTile(String type){
        this.type = type;
        img = Images.gshsImage;
    }

    public void setType(String type){
        this.type = type;
    }
    public void draw(Graphics2D g2, int x, int y){
        g2.drawImage(img, x*tileSize, y*tileSize, tileSize, tileSize, null);
    }

    public static BackgroundTile fromInt(int i){
        return new BackgroundTile("");
    }
}
