package world.stage;

import java.util.ArrayList;

public class StageBuilder {
    int stageId;
    String stageName;
    ArrayList<Room> rooms;

    public StageBuilder(int stageId, String stageName){
        this.stageId = stageId;
        this.stageName = stageName;
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        room.setStageId(stageId);
        rooms.add(room);
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Stage build(){
        return new Stage(stageId, stageName, rooms);
    }
}
