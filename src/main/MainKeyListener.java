package main;

import render.GameManager;
import world.entity.character.Direction;
import world.entity.character.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainKeyListener implements KeyListener {
    GameManager gameManager;
    Player player;

    private int moveCnt = 0;
    private char preC = ' ';

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
        if(preC != c) {
            if(preC=='w') {
                while(moveCnt != 0) {
                    //TODO: key delay

                    player.setDirection(Direction.UP);
                    player.move();
                    player.updateMoveCondition(false);
                    moveCnt++; moveCnt %= 4;
                }
            }
            if(preC=='a') {
                while(moveCnt != 0) {
                    //TODO: key delay

                    player.setDirection(Direction.LEFT);
                    player.move();
                    player.updateMoveCondition(false);
                    moveCnt++; moveCnt %= 4;
                }
            }
            if(preC=='s') {
                while(moveCnt != 0) {
                    //TODO: key delay

                    player.setDirection(Direction.DOWN);
                    player.move();
                    player.updateMoveCondition(false);
                    moveCnt++; moveCnt %= 4;
                }
            }
            if(preC=='d') {
                while(moveCnt != 0) {
                    //TODO: key delay

                    player.setDirection(Direction.RIGHT);
                    player.move();
                    player.updateMoveCondition(false);
                    moveCnt++; moveCnt %= 4;
                }
            }

            preC = c;
        }

        if(c=='w') {
            player.setDirection(Direction.UP);
            player.move();
            player.updateMoveCondition(false);
            moveCnt++; moveCnt %= 4;
        }
        if(c=='a') {
            player.setDirection(Direction.LEFT);
            player.move();
            player.updateMoveCondition(false);
            moveCnt++; moveCnt %= 4;
        }
        if(c=='s') {
            player.setDirection(Direction.DOWN);
            player.move();
            player.updateMoveCondition(false);
            moveCnt++; moveCnt %= 4;
        }
        if(c=='d') {
            player.setDirection(Direction.RIGHT);
            player.move();
            player.updateMoveCondition(false);
            moveCnt++; moveCnt %= 4;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char c = e.getKeyChar();
        if(c=='w') {
            while(moveCnt != 0) {
                //TODO: key delay

                player.setDirection(Direction.UP);
                player.move();
                player.updateMoveCondition(false);
                moveCnt++; moveCnt %= 4;
            }
            player.updateMoveCondition(true);
        }

        if(c=='a') {
            while(moveCnt != 0) {
                //TODO: key delay

                player.setDirection(Direction.LEFT);
                player.move();
                player.updateMoveCondition(false);
                moveCnt++; moveCnt %= 4;
            }
            player.updateMoveCondition(true);
        }

        if(c=='s') {
            while(moveCnt != 0) {
                //TODO: key delay

                player.setDirection(Direction.DOWN);
                player.move();
                player.updateMoveCondition(false);
                moveCnt++; moveCnt %= 4;
            }
            player.updateMoveCondition(true);
        }

        if(c=='d') {
            while(moveCnt != 0) {
                //TODO: key delay

                player.setDirection(Direction.RIGHT);
                player.move();
                player.updateMoveCondition(false);
                moveCnt++; moveCnt %= 4;
            }
            player.updateMoveCondition(true);
        }
    }
}
