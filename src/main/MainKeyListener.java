package main;

import render.GameManager;

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
        if(c=='w') upPressed = true;
        else if(c=='a') leftPressed = true;
        else if(c=='s') downPressed = true;
        else if(c=='d') rightPressed = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char c = e.getKeyChar();
        if(c=='w') upPressed = false;
        else if(c=='a') leftPressed = false;
        else if(c=='s') downPressed = false;
        else if(c=='d') rightPressed = false;
    }
}
