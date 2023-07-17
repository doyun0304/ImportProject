package render;

import world.entity.Direction;
import world.stage.TileType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static render.RenderUtil.tileSize;

public class Images {
    public static final String assetPath = "src/assets/";
    public static BufferedImage gshsImage;
    public static BufferedImage[][] playerImage = new BufferedImage[4][4];
    public static BufferedImage[] tileImage = new BufferedImage[11];

    static{
        try {
            gshsImage = getResizedImage("gshslogo.png");
            for(int i=0; i<4; i++) {
                playerImage[i][0] = getResizedImage("player_"+Direction.get(i)+"_0.png");
                playerImage[i][1] = getResizedImage("player_"+Direction.get(i)+"_1.png");
                playerImage[i][2] = getResizedImage("player_"+Direction.get(i)+"_0.png");
                playerImage[i][3] = getResizedImage("player_"+Direction.get(i)+"_2.png");
            }
            for(int i=0; i<TileType.values().length; i++) {
                tileImage[i] = getResizedImage("tile_"+TileType.get(i)+".png");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage getResizedImage(String fileName) throws IOException{
        Image image = ImageIO.read(new File(assetPath + fileName));
        Image resizedImg = image.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
        BufferedImage output =  new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = output.createGraphics();
        graphics2D.drawImage(resizedImg, 0, 0, tileSize, tileSize, null);
        graphics2D.dispose();
        return output;
    }
}
