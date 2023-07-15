package world.stage;

import util.Vec2D;

import java.awt.*;
import java.util.ArrayList;

public class Room {
    ArrayList<Obstacle> obstacles = new ArrayList<>();
    private Color backgroundColor;
    private int stageId;
    private int roomId;
    private String roomName;
    private Vec2D position;
    private Vec2D size;
    private Vec2D initialPlayerPos;

    public Room(int roomId, String roomName){
        this.roomId = roomId;
        this.roomName = roomName;
        position = new Vec2D();
        size = new Vec2D(22,18);
    }

    public Room(int stageId, int roomId, String roomName){
        this(roomId, roomName);
        this.stageId = stageId;
    }

    public Room(int stageId, int roomId, String roomName, Vec2D initialPlayerPos){
        this(stageId, roomId, roomName);
        this.initialPlayerPos = initialPlayerPos;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public void setPosition(Vec2D position) {
        this.position = position;
    }

    public void setSize(Vec2D size) {
        this.size = size;
    }

    int obstacleCount = 0;
    int interactableCount = 0;

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
        obstacleCount++;
    }

    public void show() {
        for(int i=0; i<obstacleCount; i++) obstacles.get(i).show();
    }
}
