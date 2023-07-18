package world.stage;

import util.Vec2D;

public class KeyTypePuzzle extends Puzzle {
    public KeyTypePuzzle(String roomName, String puzzleName, int puzzleNum, Obstacle obstacle) {
        super(roomName, puzzleName, puzzleNum, obstacle);
    }

    @Override
    public boolean isCorrect() {
        return false;
    }
}
