package world.stage;

import util.Vec2D;

import java.util.ArrayList;

public class RoomBuilder {
    private int stageId;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Puzzle> puzzles;
    private Vec2D initialPlayerPos;
    private BackgroundManager backgroundManager;

    public RoomBuilder(int stageId, Vec2D initialPlayerPos){
        this.stageId = stageId;
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
        Room output = new Room(stageId, initialPlayerPos, backgroundManager, puzzles, obstacles);
        backgroundManager.setRoom(output);
        return output;
    }
}
