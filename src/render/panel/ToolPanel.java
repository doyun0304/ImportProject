package render.panel;

import main.ImportProject;
import render.Borders;
import main.GameManager;
import render.label.ItemLabel;
import render.layout.linear.LinearConstraints;
import render.layout.linear.LinearLayout;
import render.layout.linear.LinearSpace;
import render.layout.linear.Orientation;
import world.entity.character.Inventory;

import javax.swing.*;
import java.awt.*;

import static render.RenderUtil.tileSize;

// panel for toolbar - on playing / exists with PlayPanel

public class ToolPanel extends JPanel {
    private GameManager gameManager;
    private Inventory inventory;
    private ItemPanel itemPanel;

    public ToolPanel(GameManager gameManager){
        this.gameManager = gameManager;
        itemPanel = new ItemPanel();
        setLayout(new LinearLayout(Orientation.VERTICAL, 0));
        add(new JTextField(), new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(itemPanel, new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
        itemPanel.setLayout(new LinearLayout(Orientation.HORIZONTAL, 0));
        itemPanel.setBorder(Borders.BLACKLINE);
        itemPanel.setBackground(Color.GRAY);
        itemPanel.setPreferredSize(new Dimension(ImportProject.screenWidth, tileSize));
        for(int i=0; i<Inventory.maxItemCnt; i++) itemPanel.add(new ItemLabel(i, this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    class ItemPanel extends JPanel{

    }
}
