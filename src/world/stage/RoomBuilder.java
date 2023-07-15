package world.stage;

import java.util.ArrayList;

public class RoomBuilder {
    int stageId;
    int roomId;
    String roomName;
    ArrayList<Obstacle> obstacles;

    public RoomBuilder(int stageId, int roomId, String roomName){
        this.stageId = stageId;
        this.roomId = roomId;
        this.roomName = roomName;
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
        return new Room(stageId, roomId, roomName);
    }
}
