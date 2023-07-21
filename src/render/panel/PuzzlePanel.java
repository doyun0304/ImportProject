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
    private int puzzleNum;
    private String[] text = {"Previous puzzle haven’t been completed yet", "Solve the previous puzzles first", "Current Puzzle Number : "};

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
        setBackground(Color.WHITE);

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

        if(checkPreviousPuzzles()) puzzle.draw(g2, 0, 0, tileSize * 25, tileSize * 15);
        else {
            g2.setFont(new Font("Arial", Font.PLAIN, 48));
            text[2] = "Current Puzzle Number : " + puzzleNum;

            int x, y;

            for(int i = 0; i < text.length; i++) {
                x = getWidth() / 2 - g2.getFontMetrics().stringWidth(text[i]) / 2;
                y = (int) (getHeight() * 0.35) + i * 100;

                g2.drawString(text[i], x, y);
            }
        }
    }

    public void checkPuzzle(Vec2D checkPosition) {
        ArrayList<Puzzle> puzzles = currentRoom.getPuzzles();

        for (int i = 0; i < puzzles.size(); i++) {
            Puzzle currentPuzzle = puzzles.get(i);

            if (checkPosition.x == currentPuzzle.getPosition().x && checkPosition.y == currentPuzzle.getPosition().y) {
                puzzle = currentPuzzle;
                puzzleNum = i + 1;

                if(!puzzle.isSolved()) gameManager.getGamePanel().setPuzzlePanel();

                return;
            }
        }
    }

    private boolean checkPreviousPuzzles() {
        ArrayList<Puzzle> puzzles = currentRoom.getPuzzles();

        for (Puzzle currentPuzzle : puzzles) {
            if(currentPuzzle == puzzle) return true;

            if(!currentPuzzle.isSolved()) return false;
        }

        return true;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }
}
