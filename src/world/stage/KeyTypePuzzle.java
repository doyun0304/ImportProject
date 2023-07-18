package world.stage;

import util.Vec2D;

public class KeyTypePuzzle extends Puzzle {
    public KeyTypePuzzle(String roomName, String puzzleName, int puzzleNum, Obstacle obstacle, String answer) {
        super(roomName, puzzleName, puzzleNum, obstacle, answer);
    }

    @Override
    public boolean isCorrect(String text) {
        if(text.equals(answer)) return true;

        return false;
    }
}
