package world.stage;

import java.util.ArrayList;

public class Stage {
    ArrayList<Room> rooms = new ArrayList<>();
    int stageId;
    String stageName = "";

    public Stage(int stageId, String stageName, ArrayList<Room> rooms) {
        this.stageId = stageId;
        this.stageName = stageName;
        this.rooms = rooms;
    }

    public void setRooms(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    public void draw() {
        for (Room room : rooms) room.draw();
    }
}
