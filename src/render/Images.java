package render;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {
    public static final String assetPath = "src/assets/";
    public static BufferedImage gshsImage;

    static{
        try {
            gshsImage = ImageIO.read(new File(assetPath+"gshslogo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
