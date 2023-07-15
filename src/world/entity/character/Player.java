package world.entity.character;

import util.Vec2D;

public class Player {
    private Vec2D position;
    Direction direction;
    private int velocity = 1;

    public Player(){
        position = new Vec2D();
        direction = Direction.TOP;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move(){
        if(canMove(direction)) {
            switch (direction) {
                case TOP:
                    position.add(new Vec2D(0, -velocity));
                    break;
                case LEFT:
                    position.add(new Vec2D(-velocity, 0));
                    break;
                case BOTTOM:
                    position.add(new Vec2D(0, velocity));
                    break;
                case RIGHT:
                    position.add(new Vec2D(velocity, 0));
                    break;
            }
        }
    }

    private boolean canMove(Direction direction){
        return true;
    }

    public Vec2D getPosition() {
        return position;
    }
}
