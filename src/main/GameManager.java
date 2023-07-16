package main;

import render.panel.GamePanel;
import util.Vec2D;
import world.entity.character.Player;
import world.stage.RoomBuilder;
import world.stage.Stage;
import world.stage.StageBuilder;

import javax.swing.*;
import java.util.ArrayList;

public class GameManager {
    private ArrayList<Stage> stages;
    private Player player;
    private GamePanel gamePanel;

    public GameManager(){
        stages = new ArrayList<>();
        StageBuilder sb = new StageBuilder(0, "");
        RoomBuilder rb = new RoomBuilder(0, "", new Vec2D(3, 5));
        rb.getBackgroundManager().setTiles(new int[][]{
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        });
        sb.addRoom(rb.build());
        stages.add(sb.build());
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

    public Stage getStage(int id){
        return stages.get(id);
    }
}
