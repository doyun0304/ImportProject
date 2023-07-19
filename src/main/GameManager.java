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
    private int currentStageId;
    private int currentRoomId;
    private Stage currentStage;
    private Room currentRoom;

    public GameManager(){
        stages = new ArrayList<>();
        currentStageId = 0;
        currentRoomId = 0;
        StageBuilder sb = new StageBuilder(currentStageId, "");
        RoomBuilder rb1 = new RoomBuilder(currentStageId, new Vec2D(1, 1));
        rb1.getBackgroundManager().setTiles(readRoomData(currentStageId, currentRoomId));
        rb1.addObstacle(new PuzzleObstacle(new Vec2D(3, 3), 0));
        rb1.addObstacle(new Door(new Vec2D(25, 1), 1, currentRoomId, new Vec2D(24, 1)));
        rb1.addPuzzle(new KeyTypePuzzle("test", 0, rb1.getObstacle(0), "6", "half half"));
        rb1.addPuzzle(new KeyTypePuzzle("doorPuzzle", 0, rb1.getObstacle(1), "6", "half"));
        sb.addRoom(rb1.build());
        RoomBuilder rb2 = new RoomBuilder(currentStageId, new Vec2D(1, 1));
        rb2.getBackgroundManager().setTiles(readRoomData(currentStageId, 1));
        rb2.addObstacle(new Door(new Vec2D(-1, 1), 1, 1, new Vec2D(0, 1)));
        rb2.addPuzzle(new KeyTypePuzzle("doorPuzzle2", 0, rb2.getObstacle(0), "", ""));
        sb.addRoom(rb2.build());
        ((Door)rb1.getObstacle(1)).setNextDoor((Door)rb2.getObstacle(0));
        ((Door)rb2.getObstacle(0)).setNextDoor((Door)rb1.getObstacle(1));
        stages.add(sb.build());
        updateRoomInfo();
        player = new Player(this);
        gamePanel = new GamePanel(this);
        player.addItem(new Key("key01", "lock01"));
    }

    public void initiate(JFrame frame) {
        frame.add(gamePanel);
        gamePanel.stageStart();
    }

    public void setRoom(int roomId, Vec2D initialPos){
        currentRoomId = roomId;
        updateRoomInfo();
        player.setPosition(initialPos);
    }

    public void updateRoomInfo(){
        currentStage = stages.get(currentStageId);
        currentRoom = currentStage.getRoom(currentRoomId);
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

    public int getCurrentRoomId() {
        return currentRoomId;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
