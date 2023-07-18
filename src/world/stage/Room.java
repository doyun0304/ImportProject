package world.stage;

import util.Vec2D;
import world.entity.item.FieldItem;

import java.awt.*;
import java.util.ArrayList;

public class Room {
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Puzzle> puzzles;
    private ArrayList<FieldItem> items;
    private int stageId;
    private String roomName;
    public static final Vec2D size = new Vec2D(25, 15);
    private Vec2D initialPlayerPos;
    private BackgroundManager backgroundManager;

    public Room(int stageId, String roomName, Vec2D initialPlayerPos, BackgroundManager backgroundManager) {
        this(stageId, roomName, initialPlayerPos, backgroundManager, new ArrayList<>());
        puzzles = new ArrayList<>();
        obstacles = new ArrayList<>();
    }

    public Room(int stageId, String roomName, Vec2D initialPlayerPos, BackgroundManager backgroundManager, ArrayList<Puzzle> puzzles) {
        this(stageId, roomName, initialPlayerPos, backgroundManager, puzzles, new ArrayList<>());
        obstacles = new ArrayList<>();
        items = new ArrayList<>();
    }

    public Room(int stageId, String roomName, Vec2D initialPlayerPos, BackgroundManager backgroundManager, ArrayList<Puzzle> puzzles, ArrayList<Obstacle> obstacles) {
        this.stageId = stageId;
        this.roomName = roomName;
        this.initialPlayerPos = initialPlayerPos;
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
        for (Obstacle obstacle : obstacles) obstacle.show(g2);
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

    public Vec2D getInitialPlayerPos() {
        return initialPlayerPos;
    }
}
