import render.GameManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ImportProject {
    public static JFrame screen;
    public static GameManager game = new GameManager();
    public static void main(String[] args) {
        try {
            showScreen(1080, 600);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void showScreen(int screenWidth, int screenHeight) throws IOException {
        screen = new JFrame();
        screen.setTitle("Room Escape");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setSize(screenWidth, screenHeight);
        screen.setPreferredSize(new Dimension(screenWidth, screenHeight));
        screen.getContentPane().setBackground(new Color(0,0,0));
        screen.setLayout(new BorderLayout());
        MainKeyListener keyListener = new MainKeyListener();
        screen.addKeyListener(keyListener);
        game.initiate(screen);

        screen.setVisible(true);
    }
}