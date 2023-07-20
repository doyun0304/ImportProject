package world.stage.obstacle;

import world.stage.obstacle.Obstacle;
import world.stage.obstacle.Puzzle;

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
