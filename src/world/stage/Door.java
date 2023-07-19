package world.stage;

import main.GameManager;
import render.panel.GamePanel;
import util.Vec2D;

public class Door extends PuzzleObstacle {
    private int currentRoomID;
    private Vec2D outPosition;
    private Door nextDoor;

    public Door(Vec2D position, int obstacleID,int currentRoomID, Vec2D outPosition) {
        super(position, obstacleID);
        this.currentRoomID = currentRoomID;
        this.outPosition = outPosition;
    }

    @Override
    public void interact(GameManager gameManager) {
        super.interact(gameManager);
        if(gameManager.getGamePanel().getPuzzlePanel().getPuzzle().isSolved()) {
            gameManager.setRoom(nextDoor.currentRoomID, nextDoor.outPosition);
        }
    }

    public void setNextDoor(Door nextDoor) {
        this.nextDoor = nextDoor;
    }
}
