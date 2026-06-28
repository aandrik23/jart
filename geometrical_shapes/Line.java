// geometrical_shapes/Line.java
package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Line implements Drawable {
    private Point p1;
    private Point p2;
    private static final Random rng = new Random();

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public static Line random(int width, int height) {
        return new Line(Point.random(width, height), Point.random(width, height));
    }

    static void drawLine(Displayable displayable, Point a, Point b, Color color) {
        int x0 = a.x, y0 = a.y;
        int x1 = b.x, y1 = b.y;
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            displayable.display(x0, y0, color);
            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) { err -= dy; x0 += sx; }
            if (e2 < dx)  { err += dx; y0 += sy; }
        }
    }

    @Override
    public Color getColor() {
        return new Color(30 + rng.nextInt(225), 30 + rng.nextInt(225), 30 + rng.nextInt(225));
    }

    @Override
    public void draw(Displayable displayable) {
        drawLine(displayable, p1, p2, getColor());
    }
}
