package render;

import world.entity.character.Player;
import world.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private ArrayList<Stage> stages;
    private Player player;
    private GamePanel gamePanel;

    public GameManager(){
        stages = new ArrayList<>();
        gamePanel = new GamePanel(this);
        player = new Player(gamePanel);
    }

    public void initiate(JFrame frame)  {
        gamePanel.add(new ImageLabel(Images.gshsImage), BorderLayout.PAGE_START);
        gamePanel.setBackground(Color.BLUE);
        gamePanel.setBorder(Borders.LOWEREDBEVEL);
        gamePanel.setVisible(true);
        frame.add(gamePanel);
        gamePanel.stageStart();
    }

    public Player getPlayer() {
        return player;
    }
}
