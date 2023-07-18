package world.stage;

import render.Images;
import util.Vec2D;

import java.awt.*;

public abstract class Puzzle {
    private Image puzzleImage;
    private String roomName;
    protected String answer;
    private String puzzleName;
    private int puzzleNum;
    private PuzzleObstacle obstacle;

    public Puzzle(String roomName, String puzzleName, int puzzleNum, Obstacle obstacle, String answer) {
        this.roomName = roomName;
        this.puzzleName = puzzleName;
        this.puzzleNum = puzzleNum;
        this.puzzleImage = Images.puzzleImage[puzzleNum];
        this.obstacle = (PuzzleObstacle)obstacle;
        this.answer = answer;
    }

    public abstract boolean isCorrect(String text);

    public Vec2D getPosition() {
        return obstacle.getPosition();
    }

    public void draw(Graphics2D g2, int x, int y, int width, int height) {
        g2.drawImage(puzzleImage, x, y, width, height, null);
    }
}
