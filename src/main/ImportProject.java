package main;

import javax.swing.*;
import java.awt.*;

public class ImportProject {
    private static JFrame screen;
    public static final int screenWidth = 1000;
    public static final int screenHeight = 680;
    public static GameManager gameManager;

    public static void main(String[] args) {
        gameManager = new GameManager();
        showScreen(screenWidth, screenHeight);
    }

    public static void showScreen(int screenWidth, int screenHeight) {
        screen = new JFrame();
        screen.setTitle("Room Escape");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.getContentPane().setPreferredSize(new Dimension(screenWidth, screenHeight));
        screen.getContentPane().setBackground(Color.BLACK);
        gameManager.initiate(screen);
        screen.setVisible(true);
        screen.pack();
    }
}