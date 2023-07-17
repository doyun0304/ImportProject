package world.entity.item;

import java.awt.image.BufferedImage;

public class Item {
    int stageId;
    String name;
    BufferedImage imgOnMap;
    BufferedImage imgOnToolbar;

    public Item(String name) {
        this.name = name;
    }

}
