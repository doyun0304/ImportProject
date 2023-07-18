package world.stage;

import render.panel.GamePanel;
import util.Vec2D;

public class PuzzleObstacle extends Obstacle implements Interactable {
    public PuzzleObstacle(Vec2D position, int obstacleID) {
        super(position, obstacleID);
        super.interactable = true;
    }

    @Override
    public void interact(GamePanel gamePanel) {
        gamePanel.getPuzzlePanel().checkPuzzle(getPosition());
    }
}
