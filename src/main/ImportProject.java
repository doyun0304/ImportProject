package main;

import render.GameManager;

import javax.swing.*;
import java.awt.*;

public class ImportProject {
    private static JFrame screen;
    public static final int screenWidth = 1080;
    public static final int screenHeight = 800;
    public static GameManager gameManager;

    public static void main(String[] args) {
        gameManager = new GameManager();
        showScreen(screenWidth, screenHeight);
    }

    public static void showScreen(int screenWidth, int screenHeight) {
        screen = new JFrame();
        screen.setTitle("Room Escape");
        System.out.println(gameManager);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setSize(screenWidth, screenHeight);
        screen.setPreferredSize(new Dimension(screenWidth, screenHeight));
        screen.getContentPane().setBackground(new Color(0,0,0));
        gameManager.initiate(screen);

        screen.setVisible(true);
    }
}