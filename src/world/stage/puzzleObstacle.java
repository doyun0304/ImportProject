package world.stage;

import render.panel.GamePanel;
import util.Vec2D;

public class puzzleObstacle extends Obstacle implements Interactable {
    public puzzleObstacle(Vec2D position, int obstacleID) {
        super(position, obstacleID);
        super.interactable = true;
    }

    @Override
    public void interact(GamePanel gamePanel) {
        gamePanel.getPuzzlePanel().checkPuzzle(getPosition());
    }
}
