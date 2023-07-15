package render;

import world.entity.character.Player;
import world.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private ArrayList<Stage> stages;
    private Player player;
    private PlayPanel stagePanel;
    private ToolPanel toolPanel;

    public GameManager(){
        stages = new ArrayList<>();
        player = new Player();
        stagePanel = new PlayPanel();
        toolPanel = new ToolPanel();
    }

    public void initiate(JFrame frame)  {
        stagePanel.add(new ImageLabel(Images.gshsImage));
        stagePanel.setBackground(Color.WHITE);
        stagePanel.setBorder(Borders.LOWEREDBEVEL);
        stagePanel.setVisible(true);

        toolPanel.setBackground(Color.BLACK);
        toolPanel.add(new JButton("BUTTON"));
        toolPanel.setBorder(Borders.BLACKLINE);
        toolPanel.setVisible(true);

        frame.add(stagePanel, BorderLayout.CENTER);
        frame.add(toolPanel, BorderLayout.SOUTH);
    }
}
