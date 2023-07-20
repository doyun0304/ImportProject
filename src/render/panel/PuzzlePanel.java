package render.panel;

import main.GameManager;
import render.Borders;
import util.Vec2D;
import world.stage.*;
import world.stage.obstacle.Puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static render.RenderUtil.tileSize;

public class PuzzlePanel extends JPanel {
    private GameManager gameManager;
    private Puzzle puzzle;

    private Stage currentStage;
    private int currentStageId;
    private Room currentRoom;
    private int currentRoomId;

    public PuzzlePanel(GameManager gameManager) {
        this(gameManager, 0, 0);
    }

    public PuzzlePanel(GameManager gameManager, int currentStageId, int currentRoomId) {
        this.gameManager = gameManager;
        this.currentStageId = currentStageId;
        this.currentRoomId = currentRoomId;

        this.currentStage = gameManager.getStage(currentStageId);
        this.currentRoom = this.currentStage.getRoom(currentRoomId);

        setLayout(new GridLayout(1, 0));
        setBorder(Borders.BLACKLINE);
        setBackground(Color.GREEN);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                requestFocus();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        puzzle.draw(g2, 0, 0, tileSize * 25, tileSize * 15);
    }

    public void checkPuzzle(Vec2D checkPosition) {
        ArrayList<Puzzle> puzzles = currentRoom.getPuzzles();

        for (Puzzle currentPuzzle : puzzles) {
            if (checkPosition.x == currentPuzzle.getPosition().x && checkPosition.y == currentPuzzle.getPosition().y) {
                puzzle = currentPuzzle;
                if(!puzzle.isSolved()) gameManager.getGamePanel().setPuzzlePanel();

                return;
            }
        }
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }
}
