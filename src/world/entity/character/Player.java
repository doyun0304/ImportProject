package world.entity.character;

import main.GameManager;
import render.Images;
import util.DVec2D;
import util.Vec2D;
import world.entity.Direction;
import world.entity.item.Item;
import world.stage.obstacle.Door;
import world.stage.obstacle.PuzzleObstacle;
import world.stage.obstacle.Obstacle;
import world.stage.Room;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static render.RenderUtil.tileSize;

public class Player {
    private DVec2D dPosition;
    private Vec2D roomSize;
    private Vec2D iPosition;
    private Direction direction;
    private final double velocity = 0.25;
    private int moveCondition;
    private GameManager gameManager;
    private static BufferedImage[][] img;
    private Inventory inventory;
    private float radius;

    Rectangle2D.Double rect = new Rectangle2D.Double();
    Ellipse2D.Double circle = new Ellipse2D.Double();
    Area area1, area2;

    public Player(GameManager gameManager){
        dPosition = new DVec2D();
        direction = Direction.UP;
        img = Images.playerImage;
        inventory = new Inventory(this);
        this.gameManager = gameManager;
        setPosition(gameManager.getCurrentStage().getInitialPlayerPos());
        radius = 3;
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

        else {
            Obstacle obstacle = gameManager.getCurrentRoom().canBeCollided(nextPosition(direction));
            if(obstacle != null && obstacle.getClass() == Door.class) {
                ((Door)obstacle).interact(gameManager);

                switch (direction) {
                    case UP -> {
                        gameManager.getGamePanel().getKeyListener().setUpCnt(3);
                    }
                    case LEFT -> {
                        gameManager.getGamePanel().getKeyListener().setLeftCnt(3);
                    }
                    case DOWN -> {
                        gameManager.getGamePanel().getKeyListener().setDownCnt(3);
                    }
                    case RIGHT -> {
                        gameManager.getGamePanel().getKeyListener().setRightCnt(3);
                    }
                }
            }
        }
    }

    public void interact() {
        Vec2D touchPos = nextPosition(direction);

        Obstacle obstacle = gameManager.getCurrentRoom().canBeCollided(touchPos);

        if(obstacle != null && obstacle.isInteractable()) {
            ((PuzzleObstacle) obstacle).interact(gameManager);
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(img[direction.toIndex()][moveCondition], (int)(dPosition.x*tileSize), (int)(dPosition.y*tileSize), null);

        roomSize = gameManager.getCurrentRoom().getSize();

        rect.setFrame(0, 0, roomSize.x * tileSize, roomSize.y * tileSize);
        area1 = new Area(rect);

        int upCnt = getGameManager().getGamePanel().getKeyListener().getUpCnt();
        int downCnt = getGameManager().getGamePanel().getKeyListener().getDownCnt();
        int rightCnt = getGameManager().getGamePanel().getKeyListener().getRightCnt();
        int leftCnt = getGameManager().getGamePanel().getKeyListener().getLeftCnt();

        circle.setFrame((getPosition().x - radius + 0.5 + (rightCnt - leftCnt) * 0.25) * tileSize, (getPosition().y - radius + 0.5 + (downCnt - upCnt) * 0.25) * tileSize, radius * 2 * tileSize, radius * 2 * tileSize);
        area2 = new Area(circle);

        area1.subtract(area2);

        g2.setColor(Color.black);
        g2.fill(area1);
    }

    private boolean canMove(Direction direction){
        Vec2D currentPos = nextPosition(direction);

        return (currentPos.x>=0 && currentPos.x<Room.size.x && currentPos.y>=0 && currentPos.y<Room.size.y)
                && !gameManager.getCurrentRoom().getBackgroundManager().getTile(currentPos.x, currentPos.y).canBeCollided()
                && (gameManager.getCurrentRoom().canBeCollided(currentPos) == null);
    }

    private Vec2D nextPosition(Direction direction) {
        Vec2D nextPos = getPosition();
        switch (direction){
            case UP -> nextPos.add(new Vec2D(0,-1));
            case RIGHT -> nextPos.add(new Vec2D(1, 0));
            case DOWN -> nextPos.add(new Vec2D(0,1));
            case LEFT -> nextPos.add(new Vec2D(-1,0));
        }

        return nextPos;
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
