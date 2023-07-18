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
    public static BufferedImage[] puzzleImage = new BufferedImage[50];
    public static BufferedImage[] tileImage = new BufferedImage[11];
    public static BufferedImage testObstacleImage;

    static{
        try {
            gshsImage = getResizedImage("gshslogo.png", tileSize, tileSize);
            testObstacleImage = getResizedImage("test_obstacle.png", tileSize, tileSize);

            String[] direction = {"UP", "RIGHT", "DOWN", "LEFT"};
            for(int i=0; i<4; i++) {
                playerImage[i][0] = getResizedImage("player_"+direction[i]+"_0.png", tileSize, tileSize);
                playerImage[i][1] = getResizedImage("player_"+direction[i]+"_1.png", tileSize, tileSize);
                playerImage[i][2] = getResizedImage("player_"+direction[i]+"_0.png", tileSize, tileSize);
                playerImage[i][3] = getResizedImage("player_"+direction[i]+"_2.png", tileSize, tileSize);
            }
          
            for(int i=0; i<TileType.values().length; i++) {
                tileImage[i] = getResizedImage("tile_"+TileType.get(i)+".png", tileSize, tileSize);
            }

            for(int i = 0; i < 1; i++) {
                puzzleImage[i] = getResizedImage("puzzle_"+i+".png", tileSize * 25, tileSize * 15);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage getResizedImage(String fileName, int width, int height) throws IOException{
        Image image = ImageIO.read(new File(assetPath + fileName));
        Image resizedImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage output =  new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = output.createGraphics();
        graphics2D.drawImage(resizedImg, 0, 0, width, height, null);
        graphics2D.dispose();
        return output;
    }
}
