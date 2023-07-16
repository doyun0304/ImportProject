package render.panel;

import main.GameManager;
import render.Borders;

import javax.swing.*;
import java.awt.*;

public class AnswerPanel extends JPanel {
    GameManager gameManager;

    public AnswerPanel(GameManager gameManager) {
        this.gameManager = gameManager;

        setLayout(new GridLayout(1, 0));
        setBorder(Borders.BLACKLINE);
        setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
