package world.stage;

import util.Vec2D;

import java.util.ArrayList;

public class RoomBuilder {
    private int stageId;
    private String roomName;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Puzzle> puzzles;
    private Vec2D initialPlayerPos;
    private BackgroundManager backgroundManager;

    public RoomBuilder(int stageId, String roomName, Vec2D initialPlayerPos){
        this.stageId = stageId;
        this.roomName = roomName;
        this.initialPlayerPos = initialPlayerPos;
        obstacles = new ArrayList<>();
        puzzles = new ArrayList<>();
      
        backgroundManager = new BackgroundManager();
    }

    public void addPuzzle(Puzzle puzzle) {
        puzzles.add(puzzle);
    }

    public void addObstacle(Obstacle obstacle) {
        obstacle.setObstacleID(obstacles.size());
        obstacles.add(obstacle);
    }

    public BackgroundManager getBackgroundManager() {
        return backgroundManager;
    }

    public Obstacle getObstacle(int ID) {
        return obstacles.get(ID);
    }

    public Room build(){
        Room output = new Room(stageId, roomName, initialPlayerPos, backgroundManager, puzzles, obstacles);
        backgroundManager.setRoom(output);
        return output;
    }
}
