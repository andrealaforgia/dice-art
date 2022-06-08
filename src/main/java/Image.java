import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

public class Image {
    private final BufferedImage image;

    public Image(int width, int height) {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    private Image(BufferedImage image) {
        this.image = image;
    }

    public static Image fromStream(InputStream inputStream) throws IOException {
        return new Image(ImageIO.read(inputStream));
    }

    public void saveToFile(String filename) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            ImageIO.write(this.image, FilenameUtils.getExtension(filename), fileOutputStream);
        }
    }

    public void forEachPixel(Consumer<Pixel> pixelConsumer) {
        for (int y = 0; y < this.image.getHeight(); y++) {
            for (int x = 0; x < this.image.getWidth(); x++) {
                pixelConsumer.accept(new Pixel(x, y, new Color(this.image.getRGB(x, y))));
            }
        }
    }

    public int getWidth() {
        return this.image.getWidth();
    }

    public int getHeight() {
        return this.image.getHeight();
    }

    public void setPixelRgb(int x, int y, int rgb) {
        this.image.setRGB(x, y, rgb);
    }
}
