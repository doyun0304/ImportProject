package world.stage.obstacle;

import render.Images;
import util.Vec2D;

import java.awt.*;
import java.awt.image.BufferedImage;

import static render.RenderUtil.tileSize;

public class Obstacle {
    private Vec2D position;
    private int obstacleID;
    private BufferedImage img;
    protected boolean interactable = false;

    Obstacle(Vec2D position, int obstacleID){
        this.position = position;
        this.obstacleID = obstacleID;

        if(obstacleID == 0) img = Images.testObstacleImage;
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(img, (int)(position.x*tileSize), (int)(position.y*tileSize), null);
    }

    public void setObstacleID(int ID) {
        this.obstacleID = ID;
    }

    public Vec2D getPosition() {
        return position.copy();
    }

    public boolean isInteractable() {
        return interactable;
    }
}
