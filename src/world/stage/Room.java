package world.stage;

import util.Vec2D;
import world.entity.item.FieldItem;
import world.stage.obstacle.Obstacle;
import world.stage.obstacle.Puzzle;
import world.stage.tile.BackgroundManager;

import java.awt.*;
import java.util.ArrayList;

public class Room {
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Puzzle> puzzles;
    private ArrayList<FieldItem> items;
    private int stageId;
    public static final Vec2D size = new Vec2D(25, 15);
    private BackgroundManager backgroundManager;

    public Room(int stageId, BackgroundManager backgroundManager, ArrayList<Puzzle> puzzles, ArrayList<Obstacle> obstacles) {
        this.stageId = stageId;
        this.backgroundManager = backgroundManager;
        this.puzzles = puzzles;
        this.obstacles = obstacles;
        items = new ArrayList<>();
    }

    public Obstacle canBeCollided(Vec2D touchPos) {
        for(Obstacle obstacle : obstacles) {
            if(touchPos.x == obstacle.getPosition().x && touchPos.y == obstacle.getPosition().y) {
                return obstacle;
            }
        }

        return null;
    }

    public void draw(Graphics2D g2) {
        for (Obstacle obstacle : obstacles) obstacle.draw(g2);
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }
      
    public ArrayList<Puzzle> getPuzzles() {
        return puzzles;
    }

    public BackgroundManager getBackgroundManager() {
        return backgroundManager;
    }
}
