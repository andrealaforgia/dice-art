import java.util.List;
import java.util.Map;

public class DiceArtGenerator {

    private static final int DIE_BOX_SIZE = 4;

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
        image.setPixelRgb(x + 0, y + 0, 0);
        image.setPixelRgb(x + 1, y + 0, 0);
        image.setPixelRgb(x + 2, y + 0, 0);
        image.setPixelRgb(x + 0, y + 1, 0);
        image.setPixelRgb(x + 1, y + 1, 0);
        image.setPixelRgb(x + 2, y + 1, 0);
        image.setPixelRgb(x + 0, y + 2, 0);
        image.setPixelRgb(x + 1, y + 2, 0);
        image.setPixelRgb(x + 2, y + 2, 0);
        if (die == 1) {
            image.setPixelRgb(x + 1, y + 1, dotColor);
        } else if (die == 2) {
            image.setPixelRgb(x + 0, y + 0, dotColor);
            image.setPixelRgb(x + 2, y + 2, dotColor);
        } else if (die == 3) {
            image.setPixelRgb(x + 2, y + 0, dotColor);
            image.setPixelRgb(x + 1, y + 1, dotColor);
            image.setPixelRgb(x + 0, y + 2, dotColor);
        } else if (die == 4) {
            image.setPixelRgb(x + 0, y + 0, dotColor);
            image.setPixelRgb(x + 2, y + 0, dotColor);
            image.setPixelRgb(x + 0, y + 2, dotColor);
            image.setPixelRgb(x + 2, y + 2, dotColor);
        } else if (die == 5) {
            image.setPixelRgb(x + 0, y + 0, dotColor);
            image.setPixelRgb(x + 2, y + 0, dotColor);
            image.setPixelRgb(x + 1, y + 1, dotColor);
            image.setPixelRgb(x + 0, y + 2, dotColor);
            image.setPixelRgb(x + 2, y + 2, dotColor);
        } else if (die == 6) {
            image.setPixelRgb(x + 0, y + 0, dotColor);
            image.setPixelRgb(x + 0, y + 1, dotColor);
            image.setPixelRgb(x + 0, y + 2, dotColor);
            image.setPixelRgb(x + 2, y + 0, dotColor);
            image.setPixelRgb(x + 2, y + 1, dotColor);
            image.setPixelRgb(x + 2, y + 2, dotColor);
        }
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
