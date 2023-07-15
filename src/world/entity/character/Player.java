package world.entity.character;

import render.GamePanel;
import render.Images;
import util.Vec2D;

import java.awt.*;
import java.awt.image.BufferedImage;

import static render.RenderUtil.tileSize;

public class Player {
    private Vec2D position;
    Direction direction;
    private int velocity = 1;
    private int moveCondition;
    GamePanel gamePanel;
    BufferedImage[][] img;

    public Player(){
        position = new Vec2D();
        direction = Direction.UP;
        img = Images.playerImage;
    }

    public Player(GamePanel gamePanel){
        this();
        this.gamePanel = gamePanel;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(){
        if(canMove(direction)) {
            switch (direction) {
                case UP:
                    position.add(new Vec2D(0, -velocity));
                    break;
                case LEFT:
                    position.add(new Vec2D(-velocity, 0));
                    break;
                case DOWN:
                    position.add(new Vec2D(0, velocity));
                    break;
                case RIGHT:
                    position.add(new Vec2D(velocity, 0));
                    break;
            }
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(img[direction.ordinal()][moveCondition], position.x*tileSize, position.y*tileSize, null);
    }

    private boolean canMove(Direction direction){
        return true;
    }

    public Vec2D getPosition() {
        return position;
    }

    public void updateMoveCondition(boolean stop) {
        if(stop) moveCondition = 0;
        else {
            moveCondition++;
            if (moveCondition == 4) moveCondition = 0;
        }
    }
}
