package render;

import javax.swing.*;
import java.awt.*;

import static render.RenderUtil.tileSize;

public class StagePanel extends JPanel {
    GameManager gameManager;
    public StagePanel(GameManager gameManager){
        setDoubleBuffered(true);
        setBackground(Color.CYAN);
        this.gameManager = gameManager;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        gameManager.getPlayer().draw(g2);

        g2.setColor(Color.RED);

        for(int i = 1; i <= getWidth() / tileSize; i++) {
            g2.drawLine(i * tileSize, 0, i * tileSize, getHeight());
        }

        for(int i = 1; i <= getHeight() / tileSize; i++) {
            g2.drawLine(0, i * tileSize, getWidth(), i * tileSize);
        }

        g2.dispose();
    }
}
