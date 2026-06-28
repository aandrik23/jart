// geometrical_shapes/Rectangle.java
package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Rectangle implements Drawable {
    private Point p1;
    private Point p2;
    private static final Random rng = new Random();

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public Color getColor() {
        return new Color(30 + rng.nextInt(225), 30 + rng.nextInt(225), 30 + rng.nextInt(225));
    }

    @Override
    public void draw(Displayable displayable) {
        Color color = getColor();
        Point topRight  = new Point(p2.x, p1.y);
        Point bottomLeft = new Point(p1.x, p2.y);
        Line.drawLine(displayable, p1,         topRight,   color);
        Line.drawLine(displayable, topRight,    p2,         color);
        Line.drawLine(displayable, p2,          bottomLeft, color);
        Line.drawLine(displayable, bottomLeft,  p1,         color);
    }
}
