package world.stage;

import java.util.ArrayList;

public class Stage {
    ArrayList<Room> rooms;
    int stageId;
    String stageName = "";

    public Stage(int stageId, String stageName){
        this(stageId, stageName, new ArrayList<>());
        rooms = new ArrayList<>();
    }

    public Stage(int stageId, String stageName, ArrayList<Room> rooms) {
        this.stageId = stageId;
        this.stageName = stageName;
        this.rooms = rooms;
    }

    public void draw() {
        for (Room room : rooms) room.draw();
    }

    public void setRooms(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public Room getRoom(int id){
        return rooms.get(id);
    }
}
