package render;

import main.MainKeyListener;

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
        setLayout(new GridLayout(0,1));
        add(stagePanel);
        add(toolPanel);
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
