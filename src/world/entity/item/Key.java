package world.entity.item;

public class Key extends Item {
    String lockName;
    public Key(String name) {
        super(name);
    }
    public Key(String name, String lockName){
        super(name);
        this.lockName = lockName;
    }
}
