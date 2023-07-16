package world.stage;

import render.panel.StagePanel;
import util.Vec2D;

import java.awt.*;

public class BackgroundManager {
    private Room room;
    private BackgroundTile[][] tiles;

    public BackgroundManager(Vec2D size){
        tiles = new BackgroundTile[size.y][size.x];
    }

    public void draw(Graphics2D g2){
        for(int i=0; i<tiles.length; i++){
            for(int j=0; j<tiles[i].length; j++){
                if(tiles[i][j]==null) continue;
                tiles[i][j].draw(g2, j, i);
            }
        }
    }

    public void setTiles(int[][] pTiles){
        for(int i=0; i<tiles.length; i++){
            for(int j=0; j<tiles[i].length; j++){
                tiles[i][j] = BackgroundTile.fromInt(pTiles[i][j]);
            }
        }
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
