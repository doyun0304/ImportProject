package world.stage;

public enum TileType {
    WALL, WOOD_FLOOR;

    public int toIndex(){
        return switch(this){
            case WALL -> 0;
            case WOOD_FLOOR -> 1;
        };
    }

    public static TileType get(int i){
        return switch (i){
            case 0 -> WALL;
            case 1 -> WOOD_FLOOR;
            default -> WALL;
        };
    }
}
