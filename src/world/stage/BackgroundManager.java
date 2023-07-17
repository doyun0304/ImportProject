package world.stage;

import util.Vec2D;

import java.awt.*;

public class BackgroundManager {
    private Room room;
    private BackgroundTile[][] tiles;

    public BackgroundManager(){
        tiles = new BackgroundTile[Room.size.y][Room.size.x];
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
                try {
                    tiles[i][j] = BackgroundTile.fromInt(pTiles[i][j]);
                } catch (ArrayIndexOutOfBoundsException e){
                    tiles[i][j] = BackgroundTile.fromInt(0);
                }
            }
        }
    }

    public BackgroundTile getTile(int x, int y){
        return tiles[y][x];
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
