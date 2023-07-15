package world.stage;

import java.util.ArrayList;

public class Room {

    ArrayList<Thing> obstacles = new ArrayList<Thing>();
    ArrayList<Thing> interactables = new ArrayList<Thing>();

    int obstacleCount = 0;
    int interactableCount = 0;

    public void addObstacle(Thing obstacle) {
        obstacles.add(obstacle);
        obstacleCount++;
    }

    public void addInteractable(Thing interactable) {
        interactables.add(interactable);
        interactableCount++;
    }

    public void show() {
        for(int i=0; i<obstacleCount; i++) obstacles.get(i).show();
        for(int i=0; i<interactableCount; i++) interactables.get(i).show();
    }
}
