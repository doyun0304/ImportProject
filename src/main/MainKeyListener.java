package main;

import util.Vec2D;
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
        player = gameManager.getPlayer();
        int c = e.getKeyCode();

        // DEBUG CODE
        if(c==KeyEvent.VK_Z){
            player.getInventory().setSelectedIdx(player.getInventory().getSelectedIdx()-1);
        }
        if(c==KeyEvent.VK_X){
            player.addItem(new world.entity.item.Key("key", "lock"));
        }
        if(c==KeyEvent.VK_C){
            player.getInventory().setSelectedIdx(player.getInventory().getSelectedIdx()+1);
        }
        if(c==KeyEvent.VK_P){
            //gameManager.setRoom(1-gameManager.getCurrentRoomId(), new Vec2D(1, 1));
        }

        if(c==KeyEvent.VK_F) {
            moveClear('w');
            moveClear('a');
            moveClear('s');
            moveClear('d');

            player.interact();
        }

        if(c==KeyEvent.VK_ESCAPE) {
            gameManager.getGamePanel().switchMode();
        }

        if(gameManager.getGamePanel().isPuzzle()) return;

        if(c==KeyEvent.VK_W) {
            moveClear('a');
            moveClear('s');
            moveClear('d');

            player.setDirection(Direction.UP);
            player.move();
            player.updateMoveCondition(false);
            upCnt++; upCnt %= 4;
        }
        if(c==KeyEvent.VK_A) {
            moveClear('w');
            moveClear('s');
            moveClear('d');

            player.setDirection(Direction.LEFT);
            player.move();
            player.updateMoveCondition(false);
            leftCnt++; leftCnt %= 4;
        }
        if(c==KeyEvent.VK_S) {
            moveClear('w');
            moveClear('a');
            moveClear('d');

            player.setDirection(Direction.DOWN);
            player.move();
            player.updateMoveCondition(false);
            downCnt++; downCnt %= 4;
        }
        if(c==KeyEvent.VK_D) {
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
        if(gameManager.getGamePanel().isPuzzle()) {
            gameManager.getGamePanel().getAnswerPanel().setFocus();
        }

        int c = e.getKeyCode();
        if(c==KeyEvent.VK_W||c==KeyEvent.VK_A||c==KeyEvent.VK_S||c==KeyEvent.VK_D) {
            moveClear('w');
            moveClear('a');
            moveClear('s');
            moveClear('d');
            player.updateMoveCondition(true);
        }
    }

    public void setUpCnt(int upCnt) {
        this.upCnt = upCnt;
    }

    public void setDownCnt(int downCnt) {
        this.downCnt = downCnt;
    }

    public void setLeftCnt(int leftCnt) {
        this.leftCnt = leftCnt;
    }

    public void setRightCnt(int rightCnt) {
        this.rightCnt = rightCnt;
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
