package main;

import render.panel.GamePanel;
import util.Vec2D;
import world.entity.character.Player;
import world.entity.item.Key;
import world.stage.*;

import javax.swing.*;
import java.util.ArrayList;

import static util.Util.readRoomData;

public class GameManager {
    private ArrayList<Stage> stages;
    private Player player;
    private GamePanel gamePanel;

    public GameManager(){
        stages = new ArrayList<>();
        StageBuilder sb = new StageBuilder(0, "");
        RoomBuilder rb = new RoomBuilder(0, "", new Vec2D(13, 8));
        rb.getBackgroundManager().setTiles(readRoomData(0,0));
        rb.addObstacle(new puzzleObstacle(new Vec2D(13, 3), 0));
        rb.addPuzzle(new KeyTypePuzzle("", "test", 0, rb.getObstacle(0)));

        sb.addRoom(rb.build());
        stages.add(sb.build());
        gamePanel = new GamePanel(this);
        player = new Player(gamePanel);
        gamePanel.getToolPanel().setInventory(player.getInventory());
        player.addItem(new Key("key01", "lock01"));
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

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
