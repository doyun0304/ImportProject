package main;

import util.Vec2D;
import world.entity.item.FieldItem;
import world.entity.item.Key;

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
        FieldItem item = new FieldItem("Key", new Vec2D(0,0), new Key("Key01", "Lock01"));
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