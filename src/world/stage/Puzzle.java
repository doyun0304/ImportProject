package world.stage;

import render.Images;
import util.Vec2D;

import java.awt.*;

public abstract class Puzzle {
    private Image puzzleImage;
    private String roomName;
    protected String answer;
    private String hint;
    private String puzzleName;
    private int puzzleNum;
    private PuzzleObstacle obstacle;
    protected boolean solved = false;

    public Puzzle(String roomName, String puzzleName, int puzzleNum, Obstacle obstacle, String answer, String hint) {
        this.roomName = roomName;
        this.puzzleName = puzzleName;
        this.puzzleNum = puzzleNum;
        this.puzzleImage = Images.puzzleImage[puzzleNum];
        this.obstacle = (PuzzleObstacle)obstacle;
        this.answer = answer;
        this.hint = hint;
    }

    public abstract void checkAnswer(String text);
    public boolean isSolved() {
        return solved;
    }

    public Vec2D getPosition() {
        return obstacle.getPosition();
    }

    public void draw(Graphics2D g2, int x, int y, int width, int height) {
        g2.drawImage(puzzleImage, x, y, width, height, null);
    }

    public String getHint() {
        return hint;
    }
}
