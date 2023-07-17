package util;

import world.stage.Room;

import java.io.*;

public class Util {
    public static int[][] readRoomData(int stageId, int roomId){
        int[][] output = new int[Room.size.y][Room.size.x];
        int x = 0;
        try {
            File file = new File("src/assets/stage_" + stageId + "_room_" + roomId + ".txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while((line = br.readLine()) != null) {
                String[] tiles = line.split(" ");
                for(int i=0; i<Room.size.x; i++) {
                    output[x][i] = Integer.parseInt(tiles[i]);
                }
                x++;
            }
            fis.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return output;
    }
}
