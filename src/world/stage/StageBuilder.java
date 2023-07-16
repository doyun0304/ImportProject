package world.stage;

import java.util.ArrayList;

public class StageBuilder {
    private int stageId;
    private String stageName;
    private ArrayList<Room> rooms;

    public StageBuilder(int stageId, String stageName){
        this.stageId = stageId;
        this.stageName = stageName;
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
        return new Stage(stageId, stageName, rooms);
    }
}
