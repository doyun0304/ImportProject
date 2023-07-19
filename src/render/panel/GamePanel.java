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
    private MainPanel mainPanel;
    private StagePanel stagePanel;
    private ToolPanel toolPanel;
    private PuzzlePanel puzzlePanel;
    private AnswerPanel answerPanel;
    private MainKeyListener keyListener;
    private GameManager gameManager;
    private boolean isPuzzle = false;
    private int gameMode;
    public static final int MAIN = 0;
    public static final int GAME = 1;
    public static final int PUZZLE = 2;

    public GamePanel(GameManager gameManager){
        this.gameManager = gameManager;
        keyListener = new MainKeyListener(gameManager);
        stagePanel = new StagePanel(gameManager);
        toolPanel = new ToolPanel(gameManager);
        puzzlePanel = new PuzzlePanel(gameManager);
        answerPanel = new AnswerPanel(gameManager);
        mainPanel = new MainPanel(gameManager);
        setPreferredSize(new Dimension(ImportProject.screenWidth, ImportProject.screenHeight));
        addKeyListener(keyListener);

        setMainPanel();
    }

    public void stageStart(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public void setMainPanel(){
        gameMode = MAIN;
        setLayout(new BorderLayout());
        mainPanel.setVisible(true);
        stagePanel.setVisible(false);
        toolPanel.setVisible(false);
        puzzlePanel.setVisible(false);
        answerPanel.setVisible(false);
        removeAll();
        add(mainPanel);
        mainPanel.initiate();
        setFocusable(true);
        requestFocus();
    }

    public void setPuzzlePanel() {
        gameMode = PUZZLE;
        setLayout(new LinearLayout(Orientation.VERTICAL, 0));
        mainPanel.setVisible(false);
        stagePanel.setVisible(false);
        toolPanel.setVisible(false);
        puzzlePanel.setVisible(true);
        answerPanel.setVisible(true);
        answerPanel.textField.setText("");
        removeAll();
        add(puzzlePanel, new LinearConstraints().setWeight(15).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(answerPanel, new LinearConstraints().setWeight(2).setLinearSpace(LinearSpace.MATCH_PARENT));
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
    }

    public void setStagePanel() {
        gameMode = GAME;
        mainPanel.setVisible(false);
        stagePanel.setVisible(true);
        toolPanel.setVisible(true);
        puzzlePanel.setVisible(false);
        answerPanel.setVisible(false);
        removeAll();
        setLayout(new LinearLayout(Orientation.VERTICAL, 0));
        add(stagePanel, new LinearConstraints().setWeight(15).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(toolPanel, new LinearConstraints().setWeight(2).setLinearSpace(LinearSpace.MATCH_PARENT));
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
    }

    public PuzzlePanel getPuzzlePanel() {
        return puzzlePanel;
    }

    public AnswerPanel getAnswerPanel() {
        return answerPanel;
    }

    @Override
    public void run() {
        int frameRate = 60;
        double drawInterval = 1000000000f/ frameRate;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread!=null){
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

    public int getGameMode() {
        return gameMode;
    }

    public MainKeyListener getKeyListener() {
        return keyListener;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
