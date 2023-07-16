package world.stage;

import util.Vec2D;

import java.util.ArrayList;

public class RoomBuilder {
    private int stageId;
    private String roomName;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Puzzle> puzzles;
    private Vec2D size;
    private Vec2D initialPlayerPos;
    private BackgroundManager backgroundManager;

    public RoomBuilder(int stageId, String roomName, Vec2D size, Vec2D initialPlayerPos){
        this.stageId = stageId;
        this.roomName = roomName;
        this.size = size;
        this.initialPlayerPos = initialPlayerPos;
        obstacles = new ArrayList<>();
        puzzles = new ArrayList<>();
        backgroundManager = new BackgroundManager(size);
    }

    public RoomBuilder(int stageId, String roomName, Vec2D initialPlayerPos){
        this.stageId = stageId;
        this.roomName = roomName;
        size = new Vec2D(22, 10);
        this.initialPlayerPos = initialPlayerPos;
        obstacles = new ArrayList<>();
        backgroundManager = new BackgroundManager(size);
    }

    public void addPuzzle(Puzzle puzzle) {
        puzzles.add(puzzle);
    }

    public BackgroundManager getBackgroundManager() {
        return backgroundManager;
    }

    public Room build(){
        Room output = new Room(stageId, roomName, size, initialPlayerPos, backgroundManager);
        backgroundManager.setRoom(output);
        return output;
    }
}
