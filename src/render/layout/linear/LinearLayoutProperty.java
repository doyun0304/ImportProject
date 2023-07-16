package render.layout.linear;

interface LinearLayoutProperty {
    Orientation getOrientation();
    Alignment getAlignment();
    int getGap();
    int getWeightSum();
}