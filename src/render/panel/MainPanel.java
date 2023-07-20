package render.panel;

import main.GameManager;
import main.ImportProject;
import render.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel {
    private GameManager gameManager;
    private BufferedImage[] playerImg = Images.mainPlayerImage;
    private int imgCondition;
    private int menuNumber;
    private final static String[] menu = {"SELECT STAGE", "QUIT"};
    private long nextTime;
    private static final long walkInterval = 400000000; //0.4 s

    public MainPanel(GameManager gameManager){
        this.gameManager = gameManager;
        setPreferredSize(new Dimension(ImportProject.screenWidth, ImportProject.screenHeight));
        initiate();
    }

    public void initiate(){
        imgCondition = 0;
        menuNumber = 0;
        nextTime = System.nanoTime() + walkInterval;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0, getWidth(),getHeight());
        g2.setFont(new Font("Arial", Font.BOLD, 90));
        String title = "ROOM ESCAPE";
        int x = getWidth()/2-g2.getFontMetrics().stringWidth(title)/2;
        int y = (int)(getHeight()*0.20);
        g2.setColor(Color.GRAY);
        g2.drawString(title, x+3, y+3);
        g2.setColor(Color.WHITE);
        g2.drawString(title, x, y);
        g2.drawImage(playerImg[imgCondition], getWidth()/2-playerImg[0].getWidth()/2, (int)(getHeight()*0.25), playerImg[0].getWidth(), playerImg[0].getHeight(), null);
        if(System.nanoTime()>nextTime){
            nextTime += walkInterval;
            updateImg();
        }
        g2.setFont(new Font("Arial", Font.PLAIN, 48));
        for(int i=0; i<menu.length; i++) {
            x = getWidth() / 2 - g2.getFontMetrics().stringWidth(menu[i]) / 2;
            y = (int) (getHeight()*0.7) + i*50;
            if(i==menuNumber) {
                g2.setFont(new Font("Arial", Font.BOLD, 48));
                g2.drawString("> ", x-40, y);
                g2.setFont(new Font("Arial", Font.PLAIN, 48));
            }
            g2.drawString(menu[i], x, y);
        }
    }

    public void menuSelect(){
        switch (menuNumber){
            case 0 ->{ // STAGE SELECT
                gameManager.getGamePanel().setStagePanel();
            }
            case 1 ->{ // QUIT
                System.exit(0);
            }
        }
    }

    public void setMenuNumber(int newMenuNumber){
        int i = newMenuNumber % menu.length;
        menuNumber = i<0?i+menu.length:i;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    private void updateImg(){
        imgCondition = (imgCondition+1)%(playerImg.length);
    }
}
