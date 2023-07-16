package render.panel;

import main.MainKeyListener;
import main.GameManager;
import render.layout.linear.LinearConstraints;
import render.layout.linear.LinearLayout;
import render.layout.linear.LinearSpace;
import render.layout.linear.Orientation;

import javax.swing.*;
import java.awt.*;

// Panel for stage screen - play screen.
public class GamePanel extends JPanel implements Runnable{
    Thread gameThread;
    StagePanel stagePanel;
    ToolPanel toolPanel;
    MainKeyListener keyListener;
    GameManager gameManager;
    int frameRate = 60;

    public GamePanel(GameManager gameManager){
        this.gameManager = gameManager;
        keyListener = new MainKeyListener(gameManager);
        stagePanel = new StagePanel(gameManager);
        toolPanel = new ToolPanel(gameManager);

        stagePanel.setVisible(true);
        toolPanel.setVisible(true);
        setLayout(new LinearLayout(Orientation.VERTICAL, 0));
        add(stagePanel, new LinearConstraints().setWeight(9).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(toolPanel, new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        addKeyListener(keyListener);
        setVisible(true);
    }

    public void stageStart(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    void update(){

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }

    @Override
    public void run() {
        double drawInterval = 1000000000f/frameRate;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread!=null){
            update();
            repaint();

            try {
                double remainingTime = (nextDrawTime - System.nanoTime())/1000000;
                if(remainingTime<0) remainingTime = 0;
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
