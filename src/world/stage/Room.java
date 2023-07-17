package world.stage;

import util.Vec2D;

import java.awt.*;
import java.util.ArrayList;

public class Room {
    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private Color backgroundColor;
    private int stageId;
    private String roomName;
    public static final Vec2D size = new Vec2D(25, 15);
    private Vec2D initialPlayerPos;
    private BackgroundManager backgroundManager;

    public Room(int stageId, String roomName, Vec2D initialPlayerPos, BackgroundManager backgroundManager) {
        this.stageId = stageId;
        this.roomName = roomName;
        this.initialPlayerPos = initialPlayerPos;
        this.backgroundManager = backgroundManager;
    }

    public void draw() {
        for (Obstacle obstacle : obstacles) obstacle.show();
    }

    public Vec2D getSize() {
        return size;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
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
