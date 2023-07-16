package render.panel;

import main.GameManager;
import render.Borders;

import javax.swing.*;
import java.awt.*;

public class PuzzlePanel extends JPanel {
    GameManager gameManager;

    public PuzzlePanel(GameManager gameManager) {
        this.gameManager = gameManager;

        setLayout(new GridLayout(1, 0));
        setBorder(Borders.BLACKLINE);
        setBackground(Color.GREEN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
