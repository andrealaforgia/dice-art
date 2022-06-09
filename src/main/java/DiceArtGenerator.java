import java.util.List;
import java.util.Map;

public class DiceArtGenerator {

    private static final int DIE_BOX_SIZE = 10;
    private static final int DIE_SIZE = 10;

    private static Map<Integer, List<Integer>> DIE_TO_GRAYSCALE_RANGE_MAP = Map.of(
            0, List.of(255 * 0 / 7, 255 * 1 / 7),
            1, List.of(255 * 1 / 7, 255 * 2 / 7),
            2, List.of(255 * 2 / 7, 255 * 3 / 7),
            3, List.of(255 * 3 / 7, 255 * 4 / 7),
            4, List.of(255 * 4 / 7, 255 * 5 / 7),
            5, List.of(255 * 5 / 7, 255 * 6 / 7),
            6, List.of(255 * 6 / 7, 255 * 7 / 7)
    );

    public Image generate(Image sourceImage) {
        Image diceArtImage = new Image(
                sourceImage.getWidth() * DIE_BOX_SIZE,
                sourceImage.getHeight() * DIE_BOX_SIZE
        );

        sourceImage.forEachPixel(
                pixel -> drawDie(
                        pixel.getX() * DIE_BOX_SIZE,
                        pixel.getY() * DIE_BOX_SIZE,
                        getDie(pixel),
                        diceArtImage
                )
        );
        return diceArtImage;
    }

    private void drawDie(int x, int y, int die, Image image) {
        int dotColor = new Color(255, 255, 255).getRgb();
        for (int yy = 0; y < DIE_SIZE; y++) {
            for (int xx = 0; x < DIE_SIZE; x++) {
                image.setPixelRgb(x + xx, y + yy, 0);
            }
        }
        if (die == 1) {
            drawDot(x+4, y+4, dotColor, image);
        } else if (die == 2) {
            drawDot(x+1, y+1, dotColor, image);
            drawDot(x+7, y+7, dotColor, image);
        } else if (die == 3) {
            drawDot(x+1, y+1, dotColor, image);
            drawDot(x+4, y+4, dotColor, image);
            drawDot(x+7, y+7, dotColor, image);
        } else if (die == 4) {
            drawDot(x+1, y+1, dotColor, image);
            drawDot(x+1, y+7, dotColor, image);
            drawDot(x+7, y+1, dotColor, image);
            drawDot(x+7, y+7, dotColor, image);
        } else if (die == 5) {
            drawDot(x+1, y+1, dotColor, image);
            drawDot(x+1, y+7, dotColor, image);
            drawDot(x+7, y+1, dotColor, image);
            drawDot(x+7, y+7, dotColor, image);
            drawDot(x+4, y+4, dotColor, image);
        } else if (die == 6) {
            drawDot(x+1, y+1, dotColor, image);
            drawDot(x+1, y+4, dotColor, image);
            drawDot(x+1, y+7, dotColor, image);
            drawDot(x+7, y+1, dotColor, image);
            drawDot(x+7, y+4, dotColor, image);
            drawDot(x+7, y+7, dotColor, image);
        }
    }

    private void drawDot(int x, int y, int dotColor, Image image) {
        image.setPixelRgb(x, y, dotColor);
        image.setPixelRgb(x+1, y, dotColor);
        image.setPixelRgb(x+1, y+1, dotColor);
        image.setPixelRgb(x, y+1, dotColor);
    }

    private int getDie(Pixel pixel) {
        return DIE_TO_GRAYSCALE_RANGE_MAP.entrySet().stream()
                .filter(entry -> {
                    List<Integer> grayscaleRange = entry.getValue();
                    return pixel.getColor().toGrayScale().isInGrayscaleRange(grayscaleRange.get(0), grayscaleRange.get(1));
                })
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
}
