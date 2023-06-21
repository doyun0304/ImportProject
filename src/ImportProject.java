import javax.swing.*;
import java.awt.*;

public class ImportProject {
    public static void main(String[] args) {
        showScreen(1080, 840);
    }

    public static void showScreen(int screenWidth, int screenHeight) {
        JFrame screen = new JFrame();
        screen.setTitle("Room Escape");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setSize(screenWidth, screenHeight);
        screen.setLayout(null);
        screen.getContentPane().setBackground(new Color(0, 0, 0));
        screen.setVisible(true);
    }
}