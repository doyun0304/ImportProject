package render;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static render.RenderUtil.tileSize;

public class ImageLabel extends JLabel {
    BufferedImage img;

    public ImageLabel(BufferedImage img) {
        this.img = img;
        setIcon(new ImageIcon(img));
        setPreferredSize(new Dimension(tileSize, tileSize));
    }
}
