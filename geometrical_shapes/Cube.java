// geometrical_shapes/Cube.java
package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Cube implements Drawable {
    private Point p1, p2, p3, p4, p5, p6, p7, p8;
    private static final Random rng = new Random();

    public Cube(Point p1, Point p2, Point p3, Point p4,
                Point p5, Point p6, Point p7, Point p8) {
        this.p1 = p1; this.p2 = p2; this.p3 = p3; this.p4 = p4;
        this.p5 = p5; this.p6 = p6; this.p7 = p7; this.p8 = p8;
    }

    @Override
    public Color getColor() {
        return new Color(30 + rng.nextInt(225), 30 + rng.nextInt(225), 30 + rng.nextInt(225));
    }

    @Override
    public void draw(Displayable displayable) {
        Color color = getColor();
        // front face
        Line.drawLine(displayable, p1, p2, color);
        Line.drawLine(displayable, p2, p3, color);
        Line.drawLine(displayable, p3, p4, color);
        Line.drawLine(displayable, p4, p1, color);
        // back face
        Line.drawLine(displayable, p5, p6, color);
        Line.drawLine(displayable, p6, p7, color);
        Line.drawLine(displayable, p7, p8, color);
        Line.drawLine(displayable, p8, p5, color);
        // depth edges
        Line.drawLine(displayable, p1, p5, color);
        Line.drawLine(displayable, p2, p6, color);
        Line.drawLine(displayable, p3, p7, color);
        Line.drawLine(displayable, p4, p8, color);
    }
}
