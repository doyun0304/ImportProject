package main;

import render.GameManager;
import world.entity.character.Direction;
import world.entity.character.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainKeyListener implements KeyListener {
    GameManager gameManager;
    Player player;

    public MainKeyListener(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("The key Typed was: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player = gameManager.getPlayer();
        char c = e.getKeyChar();
        if(c=='w') {
            player.setDirection(Direction.UP);
            player.move();
            player.updateMoveCondition(false);
        }
        if(c=='a') {
            player.setDirection(Direction.LEFT);
            player.move();
            player.updateMoveCondition(false);
        }
        if(c=='s') {
            player.setDirection(Direction.DOWN);
            player.move();
            player.updateMoveCondition(false);
        }
        if(c=='d') {
            player.setDirection(Direction.RIGHT);
            player.move();
            player.updateMoveCondition(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char c = e.getKeyChar();
        if(c=='w'||c=='a'||c=='s'||c=='d') {
            player.updateMoveCondition(true);
        }
    }
}
