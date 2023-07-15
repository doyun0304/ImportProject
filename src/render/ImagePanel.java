package render;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImagePanel extends JPanel {
    String imagePath;
    File file;
    BufferedImage img;
    JLabel label;

    public ImagePanel(BufferedImage img) {
        this.img = img;
        label = new JLabel(new ImageIcon(img));
        add(label);
    }
}
