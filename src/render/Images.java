package render;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static render.RenderUtil.tileSize;

public class Images {
    public static final String assetPath = "src/assets/";
    public static BufferedImage gshsImage;

    static{
        try {
            gshsImage = getResizedImage("gshslogo.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage getResizedImage(String fileName) throws IOException{
        Image image = ImageIO.read(new File(assetPath + fileName));
        Image resizedImg = image.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
        return new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_RGB);
    }
}
