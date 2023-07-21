package render.panel;

import main.ImportProject;
import main.MainKeyListener;
import main.GameManager;
import render.Sound;
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
    private Sound sound;
    private boolean isPuzzle = false;
    private int gameMode;
    public static final int MAIN = 0;
    public static final int GAME = 1;
    public static final int PUZZLE = 2;

    public GamePanel(GameManager gameManager){
        this.gameManager = gameManager;
        keyListener = new MainKeyListener(gameManager);
        sound = new Sound();
        stagePanel = new StagePanel(gameManager, sound);
        toolPanel = new ToolPanel(gameManager);
        puzzlePanel = new PuzzlePanel(gameManager);
        answerPanel = new AnswerPanel(gameManager);
        mainPanel = new MainPanel(gameManager, sound);
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
        stopMusic();
        playMusic(0);
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
        if(gameMode==MAIN){
            stopMusic();
            playMusic(0);
        }
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
        if(gameMode==MAIN){
            stopMusic();
            playMusic(0);
        }
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

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }

    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }

    public PuzzlePanel getPuzzlePanel() {
        return puzzlePanel;
    }

    public AnswerPanel getAnswerPanel() {
        return answerPanel;
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

    public Sound getSound() {
        return sound;
    }
}
