package world.stage;

import render.Images;
import util.Vec2D;

import java.awt.*;

public abstract class Puzzle {
    private Image puzzleImage;
    private String roomName;
    private String puzzleName;
    private int puzzleNum;
    private puzzleObstacle obstacle;

    public Puzzle(String roomName, String puzzleName, int puzzleNum, Obstacle obstacle) {
        this.roomName = roomName;
        this.puzzleName = puzzleName;
        this.puzzleNum = puzzleNum;
        this.puzzleImage = Images.puzzleImage[puzzleNum];
        this.obstacle = (puzzleObstacle)obstacle;
    }

    public abstract boolean isCorrect();

    public Vec2D getPosition() {
        return obstacle.getPosition();
    }

    public void draw(Graphics2D g2, int x, int y, int width, int height) {
        g2.drawImage(puzzleImage, x, y, width, height, null);
    }
}
