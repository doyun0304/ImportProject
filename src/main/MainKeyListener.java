package main;

import render.GameManager;
import world.entity.character.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainKeyListener implements KeyListener {
    GameManager gameManager;

    public MainKeyListener(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("The key Typed was: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        if(c=='w') {
            gameManager.getPlayer().setDirection(Direction.TOP);
            gameManager.getPlayer().move();
        }
        if(c=='a') {
            gameManager.getPlayer().setDirection(Direction.LEFT);
            gameManager.getPlayer().move();
        }
        if(c=='s') {
            gameManager.getPlayer().setDirection(Direction.BOTTOM);
            gameManager.getPlayer().move();
        }
        if(c=='d') {
            gameManager.getPlayer().setDirection(Direction.RIGHT);
            gameManager.getPlayer().move();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
