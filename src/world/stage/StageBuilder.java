package world.stage;

import util.Vec2D;

import java.util.ArrayList;

public class StageBuilder {
    private int stageId;
    private String stageName;
    private ArrayList<Room> rooms;
    private Vec2D initialPlayerPos;

    public StageBuilder(int stageId, String stageName, Vec2D initialPlayerPos){
        this.stageId = stageId;
        this.stageName = stageName;
        this.initialPlayerPos = initialPlayerPos;
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        room.setStageId(stageId);
        rooms.add(room);
    }

    public int getStageId() {
        return stageId;
    }

    public Stage build(){
        return new Stage(stageId, stageName, rooms, initialPlayerPos);
    }
}
