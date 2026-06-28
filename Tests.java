// Tests.java (at project root)
import geometrical_shapes.*;
import java.awt.Color;
import java.io.File;

public class Tests {
    static int passed = 0;
    static int failed = 0;

    static void assertTrue(String name, boolean condition) {
        if (condition) {
            System.out.println("PASS: " + name);
            passed++;
        } else {
            System.out.println("FAIL: " + name);
            failed++;
        }
    }

    static void testImage() {
        Image img = new Image(100, 200);
        assertTrue("Image getWidth", img.getWidth() == 100);
        assertTrue("Image getHeight", img.getHeight() == 200);

        // display in-bounds should not throw
        img.display(0, 0, Color.RED);
        img.display(99, 199, Color.BLUE);
        assertTrue("Image display in-bounds", true);

        // display out-of-bounds should not throw
        img.display(-1, -1, Color.RED);
        img.display(100, 200, Color.RED);
        assertTrue("Image display out-of-bounds safe", true);

        // save produces a file
        img.save("test_output.png");
        File f = new File("test_output.png");
        assertTrue("Image save creates file", f.exists());
        f.delete();
    }

    static void testPoint() {
        Point p = new Point(42, 100);
        assertTrue("Point x stored", p.x == 42);
        assertTrue("Point y stored", p.y == 100);

        for (int i = 0; i < 100; i++) {
            Point r = Point.random(500, 600);
            assertTrue("Point random x in bounds", r.x >= 0 && r.x < 500);
            assertTrue("Point random y in bounds", r.y >= 0 && r.y < 600);
        }

        Color c = p.getColor();
        assertTrue("Point getColor not null", c != null);
        assertTrue("Point getColor r in range", c.getRed() >= 30 && c.getRed() <= 254);
        assertTrue("Point getColor g in range", c.getGreen() >= 30 && c.getGreen() <= 254);
        assertTrue("Point getColor b in range", c.getBlue() >= 30 && c.getBlue() <= 254);

        Image img = new Image(200, 200);
        p.draw(img);
        assertTrue("Point draw does not throw", true);
    }

    static void testLine() {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(30, 40);
        Line line = new Line(p1, p2);
        assertTrue("Line constructor does not throw", true);

        for (int i = 0; i < 50; i++) {
            Line r = Line.random(800, 600);
            assertTrue("Line random does not throw", r != null);
        }

        Color c = line.getColor();
        assertTrue("Line getColor not null", c != null);

        Image img = new Image(200, 200);
        line.draw(img);
        assertTrue("Line draw does not throw", true);
    }

    static void testTriangle() {
        Triangle t = new Triangle(new Point(0, 0), new Point(100, 0), new Point(50, 100));
        assertTrue("Triangle constructor does not throw", true);

        Color c = t.getColor();
        assertTrue("Triangle getColor not null", c != null);

        Image img = new Image(200, 200);
        t.draw(img);
        assertTrue("Triangle draw does not throw", true);
    }

    static void testRectangle() {
        Rectangle r = new Rectangle(new Point(50, 50), new Point(300, 200));
        assertTrue("Rectangle constructor does not throw", true);

        Color c = r.getColor();
        assertTrue("Rectangle getColor not null", c != null);

        Image img = new Image(400, 400);
        r.draw(img);
        assertTrue("Rectangle draw does not throw", true);
    }

    static void testCircle() {
        Circle c = new Circle(new Point(500, 500), 75);
        assertTrue("Circle constructor does not throw", true);

        for (int i = 0; i < 50; i++) {
            Circle r = Circle.random(1000, 1000);
            assertTrue("Circle random center x in bounds", r.centerX() >= 0 && r.centerX() < 1000);
            assertTrue("Circle random center y in bounds", r.centerY() >= 0 && r.centerY() < 1000);
            assertTrue("Circle random radius positive", r.getRadius() > 0);
        }

        Color color = c.getColor();
        assertTrue("Circle getColor not null", color != null);

        Image img = new Image(1000, 1000);
        c.draw(img);
        assertTrue("Circle draw does not throw", true);
    }

    static void testPentagon() {
        Pentagon p = new Pentagon(
            new Point(700, 100), new Point(800, 150),
            new Point(750, 250), new Point(650, 250), new Point(600, 150)
        );
        assertTrue("Pentagon constructor does not throw", true);

        Color c = p.getColor();
        assertTrue("Pentagon getColor not null", c != null);

        Image img = new Image(1000, 1000);
        p.draw(img);
        assertTrue("Pentagon draw does not throw", true);
    }

    static void testCube() {
        Cube cube = new Cube(
            new Point(100, 400), new Point(200, 400),
            new Point(200, 500), new Point(100, 500),
            new Point(150, 350), new Point(250, 350),
            new Point(250, 450), new Point(150, 450)
        );
        assertTrue("Cube constructor does not throw", true);

        Color c = cube.getColor();
        assertTrue("Cube getColor not null", c != null);

        Image img = new Image(1000, 1000);
        cube.draw(img);
        assertTrue("Cube draw does not throw", true);
    }

    public static void main(String[] args) {
        testImage();
        testPoint();
        testLine();
        testTriangle();
        testRectangle();
        testCircle();
        testPentagon();
        testCube();
        System.out.println("\n" + passed + " passed, " + failed + " failed");
        if (failed > 0) System.exit(1);
    }
}
