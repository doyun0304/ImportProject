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
    int frameRate = 60;

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
        setBackground(Color.CYAN);
        setBorder(Borders.LOWEREDBEVEL);
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
        g2.setColor(Color.GREEN);
        gameManager.getPlayer().draw(g2);
        g2.dispose();
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
