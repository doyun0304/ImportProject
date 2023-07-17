package world.stage;

import render.Images;
import util.Vec2D;

import java.awt.*;

import static render.RenderUtil.tileSize;

public abstract class Puzzle {
    private Image puzzleImage;
    private String roomName;
    private String puzzleName;
    private int puzzleNum;
    private Vec2D position;

    public Puzzle(String roomName, String puzzleName, int puzzleNum, Vec2D position) {
        this.roomName = roomName;
        this.puzzleName = puzzleName;
        this.puzzleNum = puzzleNum;
        this.puzzleImage = Images.puzzleImage[puzzleNum];
        this.position = position;
    }

    public abstract boolean isCorrect();

    public Vec2D getPosition() {
        return position;
    }

    public void draw(Graphics2D g2, int x, int y, int width, int height) {
        g2.drawImage(puzzleImage, x, y, width, height, null);
    }
}
