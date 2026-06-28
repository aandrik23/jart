import geometrical_shapes.*;

public class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);

        Rectangle rectangle = new Rectangle(new Point(50, 50), new Point(300, 200));
        rectangle.draw(image);

        Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
        triangle.draw(image);

        for (int i = 0; i < 50; i++) {
            Circle circle = Circle.random(image.getWidth(), image.getHeight());
            circle.draw(image);
        }

        Pentagon pentagon = new Pentagon(
            new Point(700, 100), new Point(800, 150), new Point(750, 250),
            new Point(650, 250), new Point(600, 150)
        );
        pentagon.draw(image);

        Cube cube = new Cube(
            new Point(100, 400), new Point(200, 400),
            new Point(200, 500), new Point(100, 500),
            new Point(150, 350), new Point(250, 350),
            new Point(250, 450), new Point(150, 450)
        );
        cube.draw(image);

        image.save("image.png");
    }
}
