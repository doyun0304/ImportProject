import global.Vec2D;

public class Player {
    Vec2D position;
    Direction direction;

    Player(){
        position = new Vec2D();
        direction = Direction.TOP;
    }
}
