package world.stage;

import util.Vec2D;

import java.util.ArrayList;

public class RoomBuilder {
    int stageId;
    int roomId;
    String roomName;
    ArrayList<Obstacle> obstacles;
    Vec2D initialPlayerPos;

    public RoomBuilder(int stageId, int roomId, String roomName, Vec2D initialPlayerPos){
        this.stageId = stageId;
        this.roomId = roomId;
        this.roomName = roomName;
        this.initialPlayerPos = initialPlayerPos;
        obstacles = new ArrayList<>();
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setObstacles(ArrayList<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public Room build(){
        return new Room(stageId, roomId, roomName, initialPlayerPos);
    }
}
