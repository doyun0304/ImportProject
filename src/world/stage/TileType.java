package world.stage;

public enum TileType {
    WALL, GSHS;

    public int toIndex(){
        return switch(this){
            case WALL -> 0;
            case GSHS -> 1;
        };
    }

    public static TileType get(int i){
        return switch (i){
            case 0 -> WALL;
            case 1 -> GSHS;
            default -> WALL;
        };
    }
}
