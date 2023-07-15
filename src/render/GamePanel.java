package render;

import main.ImportProject;
import main.MainKeyListener;

import javax.swing.*;
import java.awt.*;

import static render.RenderUtil.tileSize;

// Panel for stage screen - play screen.
public class GamePanel extends JPanel implements Runnable{
    Thread gameThread;
    StagePanel stagePanel;
    ToolPanel toolPanel;
    MainKeyListener keyListener;
    GameManager gameManager;

    public GamePanel(GameManager gameManager){
        this.gameManager = gameManager;
        setDoubleBuffered(true);
        stagePanel = new StagePanel();
        toolPanel = new ToolPanel();
        stagePanel.setVisible(true);
        toolPanel.setVisible(true);
        setLayout(new GridLayout(0,1));
        add(stagePanel);
        add(toolPanel);
        setFocusable(true);
        requestFocus();
        keyListener = new MainKeyListener(gameManager);
        addKeyListener(keyListener);
    }

    public void stageStart(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.drawRect(gameManager.getPlayer().getPosition().x*tileSize, gameManager.getPlayer().getPosition().y*tileSize, tileSize, tileSize);
        g2.dispose();
    }

    @Override
    public void run() {
        while(gameThread!=null){
            repaint();
        }
    }
}
