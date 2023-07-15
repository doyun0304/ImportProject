package render;

import world.entity.character.Player;
import world.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private ArrayList<Stage> stages;
    private Player player;
    private JPanel stagePanel;

    public GameManager(){
        stages = new ArrayList<>();
        player = new Player();
        stagePanel = new JPanel();
    }

    public void initiate(JFrame frame)  {
        stagePanel.add(new JTextField());
        stagePanel.setSize(200, 200);
        stagePanel.setLayout(new BorderLayout());
        stagePanel.setBackground(Color.WHITE);

        frame.add(stagePanel, BorderLayout.CENTER);
        frame.add(new ImagePanel(Images.gshsImage), BorderLayout.NORTH);

        stagePanel.setVisible(true);
    }
}
