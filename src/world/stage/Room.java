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
    }

    public Room(int stageId, String roomName, Vec2D initialPlayerPos, BackgroundManager backgroundManager, ArrayList<Puzzle> puzzles) {
        this.stageId = stageId;
        this.roomName = roomName;
        this.initialPlayerPos = initialPlayerPos;
        this.backgroundManager = backgroundManager;
        this.puzzles = puzzles;
        obstacles = new ArrayList<>();
        puzzles = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void draw() {
        for (Obstacle obstacle : obstacles) obstacle.show();
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }
      
    public ArrayList<Puzzle> getPuzzles() {
        return puzzles;
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public BackgroundManager getBackgroundManager() {
        return backgroundManager;
    }

    public Vec2D getInitialPlayerPos() {
        return initialPlayerPos;
    }
}
