package world.stage;

import util.Vec2D;

public class KeyTypePuzzle extends Puzzle {
    public KeyTypePuzzle(String roomName, String puzzleName, int puzzleNum, Vec2D position) {
        super(roomName, puzzleName, puzzleNum, position);
    }

    @Override
    public boolean isCorrect() {
        return false;
    }
}
