package world.entity.item;

import render.Images;

public class Key extends Item {
    String lockName;
    public Key(String name) {
        super(name);
    }
    public Key(String name, String lockName){
        super(name);
        this.lockName = lockName;
        img = Images.gshsImage;
    }

    @Override
    public void acquire() {

    }

    @Override
    public void use() {

    }

    @Override
    public void discard() {

    }
}
