package render;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Borders {
    public static final Border BLACKLINE = BorderFactory.createLineBorder(Color.BLACK);
    public static final Border RAISEDETCHED = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    public static final Border LOWEREDETCHED = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    public static final Border RAISEDBEVEL = BorderFactory.createRaisedBevelBorder();
    public static final Border LOWEREDBEVEL = BorderFactory.createLoweredBevelBorder();
    public static final Border EMPTY = BorderFactory.createEmptyBorder();
}
