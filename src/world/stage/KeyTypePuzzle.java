package world.stage;

import util.Vec2D;

public class KeyTypePuzzle extends Puzzle {
    public KeyTypePuzzle(String puzzleName, int puzzleNum, Obstacle obstacle, String answer, String hint) {
        super(puzzleName, puzzleNum, obstacle, answer, hint);
    }

    @Override
    public void checkAnswer(String text) {
        if(text.equals(answer)) {
            solved = true;
        }
    }
}
