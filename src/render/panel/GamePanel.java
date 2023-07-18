package render.panel;

import main.ImportProject;
import main.MainKeyListener;
import main.GameManager;
import render.layout.linear.LinearConstraints;
import render.layout.linear.LinearLayout;
import render.layout.linear.LinearSpace;
import render.layout.linear.Orientation;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    private Thread gameThread;
    private StagePanel stagePanel;
    private ToolPanel toolPanel;
    private PuzzlePanel puzzlePanel;
    private AnswerPanel answerPanel;
    private MainKeyListener keyListener;
    private GameManager gameManager;
    private final int frameRate = 60;

    private boolean isPuzzle = false;

    public GamePanel(GameManager gameManager){
        this.gameManager = gameManager;
        keyListener = new MainKeyListener(gameManager);
        stagePanel = new StagePanel(gameManager);
        toolPanel = new ToolPanel(gameManager);
        puzzlePanel = new PuzzlePanel(gameManager);
        answerPanel = new AnswerPanel(gameManager);

        addKeyListener(keyListener);
        setStagePanel();
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

    public void switchMode() {
        isPuzzle = !isPuzzle;

        if(isPuzzle) setPuzzlePanel();
        else setStagePanel();
    }

    public boolean isPuzzle() {
        return isPuzzle;
    }

    public void setPuzzlePanel() {
        setLayout(new LinearLayout(Orientation.VERTICAL, 0));
        stagePanel.setVisible(false);
        toolPanel.setVisible(false);
        puzzlePanel.setVisible(true);
        answerPanel.setVisible(true);
        setPreferredSize(new Dimension(ImportProject.screenWidth, ImportProject.screenHeight));
        add(puzzlePanel, new LinearConstraints().setWeight(15).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(answerPanel, new LinearConstraints().setWeight(2).setLinearSpace(LinearSpace.MATCH_PARENT));
        remove(stagePanel);
        remove(toolPanel);
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        setVisible(true);
    }

    public void setStagePanel() {
        stagePanel.setVisible(true);
        toolPanel.setVisible(true);
        puzzlePanel.setVisible(false);
        answerPanel.setVisible(false);
        setLayout(new LinearLayout(Orientation.VERTICAL, 0));
        setPreferredSize(new Dimension(ImportProject.screenWidth, ImportProject.screenHeight));
        add(stagePanel, new LinearConstraints().setWeight(15).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(toolPanel, new LinearConstraints().setWeight(2).setLinearSpace(LinearSpace.MATCH_PARENT));
        remove(puzzlePanel);
        remove(answerPanel);
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        setVisible(true);
    }

    public PuzzlePanel getPuzzlePanel() {
        return puzzlePanel;
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

    public StagePanel getStagePanel() {
        return stagePanel;
    }

    public ToolPanel getToolPanel() {
        return toolPanel;
    }
}
