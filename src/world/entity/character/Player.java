package world.entity.character;

import util.Vec2D;

public class Player {
    Vec2D position;
    Direction direction;

    public Player(){
        position = new Vec2D();
        direction = Direction.TOP;
    }
}
