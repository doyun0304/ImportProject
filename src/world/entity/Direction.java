package world.entity;

public enum Direction{
    UP, RIGHT, DOWN, LEFT;

    public int toIndex(){
        return switch (this) {
            case UP -> 0;
            case RIGHT -> 1;
            case DOWN -> 2;
            case LEFT -> 3;
        };
    }
}