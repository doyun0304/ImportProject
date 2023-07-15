package world.stage;

import util.Vec2D;

import java.util.ArrayList;

public class Room {
    ArrayList<Thing> obstacles = new ArrayList<>();
    ArrayList<Thing> interactables = new ArrayList<>();
    private Background background;
    private int stageId;
    private int roomId;
    private String roomName;
    private Vec2D position;
    private Vec2D size;

    public Room(int roomId, String roomName){
        this.roomId = roomId;
        this.roomName = roomName;
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

    public void addObstacle(Thing obstacle) {
        obstacles.add(obstacle);
        obstacleCount++;
    }

    public void addInteractable(Thing interactable) {
        interactables.add(interactable);
        interactableCount++;
    }

    public void show() {
        background.show();
        for(int i=0; i<obstacleCount; i++) obstacles.get(i).show();
        for(int i=0; i<interactableCount; i++) interactables.get(i).show();
    }
}
