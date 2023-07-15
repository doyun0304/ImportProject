package world.stage;

import util.Vec2D;
public class Obstacle {
    Vec2D position;
    Vec2D size;
    boolean collision = true;

    Obstacle(Vec2D position, Vec2D size){
        this.position = position;
        this.size = size;
    }

    public void show() {
    }

    public boolean canBeCollidedWith(){
        return collision;
    }
}
