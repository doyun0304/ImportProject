package world.stage;

import util.Vec2D;

public class Door extends PuzzleObstacle {
    private Vec2D outPosition;

    public Door(Vec2D position, int obstacleID, Vec2D outPosition) {
        super(position, obstacleID);
        this.outPosition = outPosition;
    }
}
