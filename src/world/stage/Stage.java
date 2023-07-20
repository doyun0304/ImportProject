package world.stage;

import util.Vec2D;

import java.util.ArrayList;

public class Stage {
    private ArrayList<Room> rooms;
    private int stageId;
    private String stageName;
    private Vec2D initialPlayerPos;

    public Stage(int stageId, String stageName, ArrayList<Room> rooms, Vec2D initialPlayerPos) {
        this.stageId = stageId;
        this.stageName = stageName;
        this.rooms = rooms;
        this.initialPlayerPos = initialPlayerPos;
    }

    public Room getRoom(int id){
        return rooms.get(id);
    }

    public Vec2D getInitialPlayerPos() {
        return initialPlayerPos;
    }
}
