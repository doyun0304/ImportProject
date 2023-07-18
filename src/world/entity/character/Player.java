package world.entity.character;

import main.GameManager;
import render.Images;
import util.DVec2D;
import util.Vec2D;
import world.entity.Direction;
import world.entity.item.Item;
import world.stage.PuzzleObstacle;
import world.stage.Obstacle;
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
    private GameManager gameManager;
    private BufferedImage[][] img;
    private Inventory inventory;

    public Player(GameManager gameManager){
        dPosition = new DVec2D();
        direction = Direction.UP;
        img = Images.playerImage;
        inventory = new Inventory(this);
        this.gameManager = gameManager;
        setPosition(gameManager.getCurrentRoom().getInitialPlayerPos());
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

    public void interact() {
        Vec2D touchPos = getPosition();
        switch (direction){
            case UP -> touchPos.add(new Vec2D(0,-1));
            case RIGHT -> touchPos.add(new Vec2D(1, 0));
            case DOWN -> touchPos.add(new Vec2D(0,1));
            case LEFT -> touchPos.add(new Vec2D(-1,0));
        }

        Obstacle obstacle = gameManager.getCurrentRoom().canBeCollided(touchPos);

        if(obstacle != null && obstacle.isInteractable()) {
            ((PuzzleObstacle) obstacle).interact(gameManager.getGamePanel());
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(img[direction.toIndex()][moveCondition], (int)(dPosition.x*tileSize), (int)(dPosition.y*tileSize), null);
    }

    private boolean canMove(Direction direction){
        Vec2D currentPos = getPosition();
        switch (direction){
            case UP -> currentPos.add(new Vec2D(0,-1));
            case RIGHT -> currentPos.add(new Vec2D(1, 0));
            case DOWN -> currentPos.add(new Vec2D(0,1));
            case LEFT -> currentPos.add(new Vec2D(-1,0));
        }
        return (currentPos.x>=0 && currentPos.x<Room.size.x && currentPos.y>=0 && currentPos.y<Room.size.y)
                && !gameManager.getCurrentRoom().getBackgroundManager().getTile(currentPos.x, currentPos.y).canBeCollided()
                && (gameManager.getCurrentRoom().canBeCollided(currentPos) == null);
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

    public void addItem(Item item){
        inventory.addItem(item);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public GameManager getGameManager() {
        return gameManager;
    }
}
