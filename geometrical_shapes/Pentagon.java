// geometrical_shapes/Pentagon.java
package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Pentagon implements Drawable {
    private Point p1, p2, p3, p4, p5;
    private static final Random rng = new Random();

    public Pentagon(Point p1, Point p2, Point p3, Point p4, Point p5) {
        this.p1 = p1; this.p2 = p2; this.p3 = p3;
        this.p4 = p4; this.p5 = p5;
    }

    @Override
    public Color getColor() {
        return new Color(30 + rng.nextInt(225), 30 + rng.nextInt(225), 30 + rng.nextInt(225));
    }

    @Override
    public void draw(Displayable displayable) {
        Color color = getColor();
        Line.drawLine(displayable, p1, p2, color);
        Line.drawLine(displayable, p2, p3, color);
        Line.drawLine(displayable, p3, p4, color);
        Line.drawLine(displayable, p4, p5, color);
        Line.drawLine(displayable, p5, p1, color);
    }
}
