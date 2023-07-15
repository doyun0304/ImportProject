package world.stage;

import java.util.ArrayList;

public class Stage {
    ArrayList<Room> rooms = new ArrayList<Room>();
    int stageNumber = 0;
    int roomNumber = 0;
    int roomCount = 0;

    public Stage(int stageNumber) {
        this.stageNumber = stageNumber;
    }
    public void addRoom(Room room) {
        rooms.add(room);
        roomNumber++;
    }

    public void show() {
        for(int i=0; i<roomNumber; i++) rooms.get(i).show();
    }
}
