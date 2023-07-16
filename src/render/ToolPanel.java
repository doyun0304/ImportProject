package render;

import javax.swing.*;
import java.awt.*;

// panel for toolbar - on playing / exists with PlayPanel

public class ToolPanel extends JPanel {
    GameManager gameManager;
    public ToolPanel(GameManager gameManager){
        this.gameManager = gameManager;
        setLayout(new GridLayout(1, 0));
        setBorder(Borders.BLACKLINE);
        setBackground(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
