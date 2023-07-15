package main;

import render.GameManager;
import world.entity.character.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainKeyListener implements KeyListener {
    boolean upPressed, downPressed, rightPressed, leftPressed;
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
            upPressed = true;
            gameManager.getPlayer().setDirection(Direction.TOP);
            gameManager.getPlayer().move();
        }
        if(c=='a') {
            leftPressed = true;
            gameManager.getPlayer().setDirection(Direction.LEFT);
            gameManager.getPlayer().move();
        }
        if(c=='s') {
            downPressed = true;
            gameManager.getPlayer().setDirection(Direction.BOTTOM);
            gameManager.getPlayer().move();
        }
        if(c=='d') {
            rightPressed = true;
            gameManager.getPlayer().setDirection(Direction.RIGHT);
            gameManager.getPlayer().move();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char c = e.getKeyChar();
        if(c=='w') upPressed = false;
        if(c=='a') leftPressed = false;
        if(c=='s') downPressed = false;
        if(c=='d') rightPressed = false;
    }
}
