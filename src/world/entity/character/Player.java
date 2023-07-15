package world.entity.character;

import main.MainKeyListener;
import render.GamePanel;
import render.Images;
import util.Vec2D;

import java.awt.*;

import static render.RenderUtil.tileSize;

public class Player {
    private Vec2D position;
    Direction direction;
    private int velocity = 1;
    GamePanel gamePanel;

    public Player(){
        position = new Vec2D();
        direction = Direction.TOP;
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
                case TOP:
                    position.add(new Vec2D(0, -velocity));
                    break;
                case LEFT:
                    position.add(new Vec2D(-velocity, 0));
                    break;
                case BOTTOM:
                    position.add(new Vec2D(0, velocity));
                    break;
                case RIGHT:
                    position.add(new Vec2D(velocity, 0));
                    break;
            }
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(Images.gshsImage, position.x*tileSize, position.y*tileSize, null);
    }

    private boolean canMove(Direction direction){
        return true;
    }

    public Vec2D getPosition() {
        return position;
    }
}
