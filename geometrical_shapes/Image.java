// geometrical_shapes/Image.java
package geometrical_shapes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Image implements Displayable {
    private BufferedImage bufferedImage;

    public Image(int width, int height) {
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public int getWidth() {
        return bufferedImage.getWidth();
    }

    public int getHeight() {
        return bufferedImage.getHeight();
    }

    @Override
    public void display(int x, int y, Color color) {
        if (x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {
            bufferedImage.setRGB(x, y, color.getRGB());
        }
    }

    @Override
    public void save(String filename) {
        try {
            ImageIO.write(bufferedImage, "png", new File(filename));
        } catch (Exception e) {
            throw new RuntimeException("Failed to save image: " + e.getMessage());
        }
    }
}
