package world.stage.obstacle;

import main.GameManager;
import util.Vec2D;

public class PuzzleObstacle extends Obstacle implements Interactable {
    private Puzzle puzzle;

    public PuzzleObstacle(Vec2D position, int obstacleID) {
        super(position, obstacleID);
        super.interactable = true;
    }

    @Override
    public void interact(GameManager gameManager) {
        gameManager.getGamePanel().getPuzzlePanel().checkPuzzle(getPosition());
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }
}
