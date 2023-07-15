import javax.swing.*;
import java.awt.*;

public class ImportProject {
    public static JFrame screen;
    public static final int cellSize = 40;
    public static void main(String[] args) {
        showScreen(1080, 840);
    }

    public static void showScreen(int screenWidth, int screenHeight) {
        screen = new JFrame();
        screen.setTitle("world.stage.Room Escape");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setPreferredSize(new Dimension(screenWidth, screenHeight));
        screen.getContentPane().setBackground(new Color(0,0,0));
        screen.setVisible(true);
    }
}