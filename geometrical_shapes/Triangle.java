// geometrical_shapes/Triangle.java
package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Triangle implements Drawable {
    private Point p1;
    private Point p2;
    private Point p3;
    private static final Random rng = new Random();

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
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
        Line.drawLine(displayable, p3, p1, color);
    }
}
