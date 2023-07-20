package world.stage.tile;

public enum TileType {
    WALL, WOOD_FLOOR, SAND;

    public int toIndex(){
        return switch(this){
            case WALL -> 0;
            case WOOD_FLOOR -> 1;
            case SAND -> 2;
        };
    }

    public static TileType get(int i){
        return switch (i){
            case 0 -> WALL;
            case 1 -> WOOD_FLOOR;
            case 2 -> SAND;
            default -> WALL;
        };
    }
}
