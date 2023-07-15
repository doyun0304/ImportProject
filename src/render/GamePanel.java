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
    GameManager game;

    public GamePanel(){
        setDoubleBuffered(true);
        stagePanel = new StagePanel();
        toolPanel = new ToolPanel();
        stagePanel.setVisible(true);
        toolPanel.setVisible(true);
        setLayout(new GridLayout(0,1));
        add(stagePanel);
        add(toolPanel);
        setFocusable(true);
        game = ImportProject.getGame();
        keyListener = new MainKeyListener(game);
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
        g2.drawRect(100, 100, tileSize, tileSize);
        g2.dispose();
    }

    @Override
    public void run() {
        while(gameThread!=null){
            repaint();
        }
    }
}
