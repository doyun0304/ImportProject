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
import world.entity.item.Item;

import javax.swing.*;
import java.awt.*;

import static render.RenderUtil.tileSize;

public class ToolPanel extends JPanel {
    private GameManager gameManager;
    private Inventory inventory;
    private JLabel itemName;
    private JPanel itemPanel;

    public ToolPanel(GameManager gameManager){
        this.gameManager = gameManager;
        itemName = new JLabel();
        itemPanel = new JPanel();
        setLayout(new LinearLayout(Orientation.VERTICAL, 0));
        add(itemName, new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
        add(itemPanel, new LinearConstraints().setWeight(1).setLinearSpace(LinearSpace.MATCH_PARENT));
        itemName.setFont(new Font("Arial", Font.PLAIN, 24));
        itemPanel.setLayout(new LinearLayout(Orientation.HORIZONTAL, 0));
        itemPanel.setBorder(Borders.BLACKLINE);
        itemPanel.setBackground(Color.GRAY);
        itemPanel.setPreferredSize(new Dimension(ImportProject.screenWidth, tileSize));
        inventory = gameManager.getPlayer().getInventory();
        for(int i=0; i<Inventory.maxItemCnt; i++) itemPanel.add(new ItemLabel(i, this));
        updateItems();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void updateItems(){
        for(Component c: itemPanel.getComponents()){
            if(c instanceof ItemLabel l){
                l.update();
            }
        }
        if(inventory!=null) {
            Item item = inventory.getSelectedItem();
            itemName.setText(" " + (item==null?"":item.getName()));
        }
    }
}
