package world.stage;

import java.util.ArrayList;

public class Stage {
    ArrayList<Room> rooms;
    int stageId;
    String stageName;

    public Stage(int stageId, String stageName, ArrayList<Room> rooms) {
        this.stageId = stageId;
        this.stageName = stageName;
        this.rooms = rooms;
    }

    public Room getRoom(int id){
        return rooms.get(id);
    }
}
