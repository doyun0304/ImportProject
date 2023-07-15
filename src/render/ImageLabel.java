package render;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ImageLabel extends JLabel {
    BufferedImage img;

    public ImageLabel(BufferedImage img) {
        this.img = img;
        setIcon(new ImageIcon(img));
    }
}
