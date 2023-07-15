package world.entity.character;

import util.Vec2D;

public class Player {
    Vec2D position;
    Direction direction;
    int velocity = 1;

    public Player(){
        position = new Vec2D();
        direction = Direction.TOP;
    }
}
