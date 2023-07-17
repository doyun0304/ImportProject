package main;

import render.panel.PuzzlePanel;
import world.entity.Direction;
import world.entity.character.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainKeyListener implements KeyListener {
    GameManager gameManager;
    Player player;

    private int upCnt = 0, downCnt = 0, leftCnt = 0, rightCnt = 0;

    public MainKeyListener(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        //TODO: key delay
        player = gameManager.getPlayer();
        char c = e.getKeyChar();

        if(c=='p') {
            gameManager.getGamePanel().getPuzzlePanel().checkPuzzle(player.getPosition());
        }

        if(gameManager.getGamePanel().isPuzzle()) return;

        if(c=='w') {
            moveClear('a');
            moveClear('s');
            moveClear('d');

            player.setDirection(Direction.UP);
            player.move();
            player.updateMoveCondition(false);
            upCnt++; upCnt %= 4;
        }
        if(c=='a') {
            moveClear('w');
            moveClear('s');
            moveClear('d');

            player.setDirection(Direction.LEFT);
            player.move();
            player.updateMoveCondition(false);
            leftCnt++; leftCnt %= 4;
        }
        if(c=='s') {
            moveClear('w');
            moveClear('a');
            moveClear('d');

            player.setDirection(Direction.DOWN);
            player.move();
            player.updateMoveCondition(false);
            downCnt++; downCnt %= 4;
        }
        if(c=='d') {
            moveClear('w');
            moveClear('a');
            moveClear('s');

            player.setDirection(Direction.RIGHT);
            player.move();
            player.updateMoveCondition(false);
            rightCnt++; rightCnt %= 4;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char c = e.getKeyChar();

        if(c=='w'||c=='a'||c=='s'||c=='d') {
            moveClear('w');
            moveClear('a');
            moveClear('s');
            moveClear('d');
            player.updateMoveCondition(true);
        }
    }

    private void moveClear(char ch) {
        if(ch=='w') {
            while(upCnt != 0) {

                player.setDirection(Direction.UP);
                player.move();
                player.updateMoveCondition(false);
                upCnt++; upCnt %= 4;
            }
        }

        if(ch=='a') {
            while(leftCnt != 0) {
                player.setDirection(Direction.LEFT);
                player.move();
                player.updateMoveCondition(false);
                leftCnt++; leftCnt %= 4;
            }
        }

        if(ch=='s') {
            while(downCnt != 0) {
                player.setDirection(Direction.DOWN);
                player.move();
                player.updateMoveCondition(false);
                downCnt++; downCnt %= 4;
            }
        }

        if(ch=='d') {
            while(rightCnt != 0) {
                player.setDirection(Direction.RIGHT);
                player.move();
                player.updateMoveCondition(false);
                rightCnt++; rightCnt %= 4;
            }
        }
    }
}
