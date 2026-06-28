// geometrical_shapes/Circle.java
package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Circle implements Drawable {
    private Point center;
    private int radius;
    private static final Random rng = new Random();

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public static Circle random(int width, int height) {
        return new Circle(Point.random(width, height), 10 + rng.nextInt(390));
    }

    public int centerX() { return center.x; }
    public int centerY() { return center.y; }
    public int getRadius() { return radius; }

    @Override
    public Color getColor() {
        return new Color(30 + rng.nextInt(225), 30 + rng.nextInt(225), 30 + rng.nextInt(225));
    }

    @Override
    public void draw(Displayable displayable) {
        Color color = getColor();
        int x = radius, y = 0, err = 0;
        int cx = center.x, cy = center.y;

        while (x >= y) {
            displayable.display(cx + x, cy + y, color);
            displayable.display(cx + y, cy + x, color);
            displayable.display(cx - y, cy + x, color);
            displayable.display(cx - x, cy + y, color);
            displayable.display(cx - x, cy - y, color);
            displayable.display(cx - y, cy - x, color);
            displayable.display(cx + y, cy - x, color);
            displayable.display(cx + x, cy - y, color);
            y++;
            if (err <= 0) {
                err += 2 * y + 1;
            } else {
                x--;
                err += 2 * (y - x) + 1;
            }
        }
    }
}
