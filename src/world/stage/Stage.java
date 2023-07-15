package world.stage;

import java.util.ArrayList;

public class Stage {
    ArrayList<Room> rooms = new ArrayList<Room>();
    int stageId;
    int roomCount = 0;
    String stageName = "";

    public Stage(int stageId, String stageName, ArrayList<Room> rooms) {
        this.stageId = stageId;
        this.stageName = stageName;
        this.rooms = rooms;
        roomCount = rooms.size();
    }

    public void setRooms(ArrayList<Room> rooms){
        this.rooms = rooms;
        roomCount = rooms.size();
    }

    public void show() {
        for(int i=0; i<roomCount; i++) rooms.get(i).show();
    }
}
