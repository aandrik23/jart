// geometrical_shapes/Point.java
package geometrical_shapes;

import java.awt.Color;
import java.util.Random;

public class Point implements Drawable {
    public int x;
    public int y;
    private static final Random rng = new Random();

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point random(int width, int height) {
        return new Point(rng.nextInt(width), rng.nextInt(height));
    }

    @Override
    public Color getColor() {
        return new Color(30 + rng.nextInt(225), 30 + rng.nextInt(225), 30 + rng.nextInt(225));
    }

    @Override
    public void draw(Displayable displayable) {
        displayable.display(x, y, getColor());
    }
}
