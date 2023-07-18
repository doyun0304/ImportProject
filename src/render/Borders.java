package render;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Borders {
    public static final Border BLACKLINE = BorderFactory.createLineBorder(Color.BLACK);
    public static final Border SELECTEDITEM = BorderFactory.createMatteBorder(4, 4, 4, 4, Color.WHITE);
    public static final Border NONSELECTEDITEM = BorderFactory.createLoweredBevelBorder();
}
