package world.entity.character;

import render.panel.GamePanel;
import render.Images;
import util.DVec2D;
import util.Vec2D;
import world.entity.Direction;
import world.stage.Room;

import java.awt.*;
import java.awt.image.BufferedImage;

import static render.RenderUtil.tileSize;

public class Player {
    private DVec2D dPosition;
    private Vec2D iPosition;
    private Direction direction;
    private final double velocity = 0.25;
    private int moveCondition;
    private GamePanel gamePanel;
    private BufferedImage[][] img;
    private Inventory inventory;

    public Player(){
        dPosition = new DVec2D();
        direction = Direction.UP;
        img = Images.playerImage;
        inventory = new Inventory();
    }

    public Player(GamePanel gamePanel){
        this();
        this.gamePanel = gamePanel;
        setPosition(gamePanel.getStagePanel().getCurrentRoom().getInitialPlayerPos());
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(){
        if(canMove(direction)) {
            switch (direction) {
                case UP -> {
                    dPosition.add(new DVec2D(0, -velocity));
                    iPosition.y = (int) Math.ceil(dPosition.y);
                }
                case LEFT -> {
                    dPosition.add(new DVec2D(-velocity, 0));
                    iPosition.x = (int) Math.ceil(dPosition.x);
                }
                case DOWN -> {
                    dPosition.add(new DVec2D(0, velocity));
                    iPosition.y = (int) Math.floor(dPosition.y);
                }
                case RIGHT -> {
                    dPosition.add(new DVec2D(velocity, 0));
                    iPosition.x = (int) Math.floor(dPosition.x);
                }
            }
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(img[direction.toIndex()][moveCondition], (int)(dPosition.x*tileSize), (int)(dPosition.y*tileSize), null);
    }

    private boolean canMove(Direction direction){
        Vec2D currentPos = iPosition.copy();
        switch (direction){
            case UP -> currentPos.add(new Vec2D(0,-1));
            case RIGHT -> currentPos.add(new Vec2D(1, 0));
            case DOWN -> currentPos.add(new Vec2D(0,1));
            case LEFT -> currentPos.add(new Vec2D(-1,0));
        }
        return (currentPos.x>=0 && currentPos.x<Room.size.x && currentPos.y>=0 && currentPos.y<Room.size.y)
                && !gamePanel.getStagePanel().getBackgroundManager().getTile(currentPos.x, currentPos.y).canBeCollided();
    }

    public Vec2D getPosition() {
        return iPosition.copy();
    }

    public void setPosition(Vec2D pos){
        iPosition = pos;
        dPosition = new DVec2D(pos.x, pos.y);
    }

    public void updateMoveCondition(boolean stop) {
        if(stop) moveCondition = 0;
        else {
            moveCondition++;
            if (moveCondition == 4) moveCondition = 0;
        }
    }
}
