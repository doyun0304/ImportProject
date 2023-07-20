package world.stage;

import world.stage.obstacle.Obstacle;
import world.stage.obstacle.Puzzle;
import world.stage.obstacle.PuzzleObstacle;
import world.stage.tile.BackgroundManager;

import java.util.ArrayList;

public class RoomBuilder {
    private int stageId;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Puzzle> puzzles;
    private BackgroundManager backgroundManager;

    public RoomBuilder(int stageId){
        this.stageId = stageId;
        obstacles = new ArrayList<>();
        puzzles = new ArrayList<>();
      
        backgroundManager = new BackgroundManager();
    }

    public void addPuzzle(Puzzle puzzle, int ID) {
        ((PuzzleObstacle)getObstacle(ID)).setPuzzle(puzzle);
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
        Room output = new Room(stageId, backgroundManager, puzzles, obstacles);
        backgroundManager.setRoom(output);
        return output;
    }
}
