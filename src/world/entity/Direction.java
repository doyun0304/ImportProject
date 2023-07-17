package world.entity;

public enum Direction{
    UP, RIGHT, DOWN, LEFT;

    public static Direction get(int i){
        return switch (i){
            case 0 -> UP;
            case 1 -> RIGHT;
            case 2 -> DOWN;
            case 3 -> LEFT;
            default -> UP;
        };
    }

    public int toIndex(){
        return switch (this) {
            case UP -> 0;
            case RIGHT -> 1;
            case DOWN -> 2;
            case LEFT -> 3;
        };
    }
}