package render.label;

import render.Borders;
import render.panel.ToolPanel;
import world.entity.item.Item;

import javax.swing.*;
import java.awt.*;

import static render.RenderUtil.tileSize;

public class ItemLabel extends JLabel {
    private int idx;
    private ToolPanel toolPanel;
    private Item item;

    public ItemLabel(int idx, ToolPanel toolPanel){
        this.idx = idx;
        this.toolPanel = toolPanel;
        setBorder(Borders.NONSELECTEDITEM);
        setSize(tileSize, tileSize);
        setPreferredSize(new Dimension(tileSize, tileSize));
        update();
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(item!=null){
            g2.drawImage(item.getImg(), 0, 0, tileSize, tileSize, null);
        }
        else{
            g2.setColor(Color.GRAY);
            g2.drawRect(0, 0, tileSize, tileSize);
        }
    }

    public void update(){
        if(toolPanel.getInventory()!=null) {
            setBorder(toolPanel.getInventory().getSelectedIdx()==idx?Borders.SELECTEDITEM:Borders.NONSELECTEDITEM);
            item = toolPanel.getInventory().getItem(idx);
        }
    }
}
