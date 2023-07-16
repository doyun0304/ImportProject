package world.stage;

import render.panel.StagePanel;
import util.Vec2D;

import java.awt.*;

public class BackgroundManager {
    private Room room;
    private BackgroundTile[][] tiles;

    public BackgroundManager(Vec2D size){
        tiles = new BackgroundTile[size.x][size.y];
    }

    public BackgroundManager(Room room){
        this.room = room;
        tiles = new BackgroundTile[room.getSize().x][room.getSize().y];
    }

    public void draw(Graphics2D g2){
        for(int i=0; i<tiles.length; i++){
            for(int j=0; j<tiles[i].length; j++){
                if(tiles[i][j]==null) continue;
                tiles[i][j].draw(g2, i, j);
            }
        }
    }

    public boolean setTile(int x, int y, BackgroundTile tile){
        if(x<0||x>=room.getSize().x||y<0||y>=room.getSize().y) return false;
        tiles[x][y] = tile;
        return true;
    }

    public void setTiles(BackgroundTile[][] tiles) {
        this.tiles = tiles;
    }

    public void setTiles(int[][] pTiles){
        for(int i=0; i<tiles.length; i++){
            for(int j=0; j<tiles[i].length; j++){
                tiles[i][j] = BackgroundTile.fromInt(pTiles[i][j]);
            }
        }
    }
}
