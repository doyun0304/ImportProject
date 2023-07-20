package world.stage.tile;

public enum TileType {
    WALL, WOOD_FLOOR, SAND, WATER, FOREST;

    public int toIndex(){
        return switch(this){
            case WALL -> 0;
            case WOOD_FLOOR -> 1;
            case SAND -> 2;
            case WATER -> 3;
            case FOREST -> 4;
        };
    }

    public static TileType get(int i){
        return switch (i){
            case 0 -> WALL;
            case 1 -> WOOD_FLOOR;
            case 2 -> SAND;
            case 3 -> WATER;
            case 4 -> FOREST;
            default -> WALL;
        };
    }

    public boolean canBeCollided(){
        TileType t = this;
        return t==WALL || t==WATER || t==FOREST;
    }
}
