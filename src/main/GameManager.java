package main;

import render.panel.GamePanel;
import world.entity.character.Player;
import world.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;

public class GameManager {
    private ArrayList<Stage> stages;
    private Player player;
    private GamePanel gamePanel;

    public GameManager(){
        stages = new ArrayList<>();
        gamePanel = new GamePanel(this);
        player = new Player(gamePanel);
    }

    public void initiate(JFrame frame) {
        frame.add(gamePanel);
        gamePanel.stageStart();
    }

    public Player getPlayer() {
        return player;
    }
}
