import java.util.Map;

public class DiceArtGenerator {

    private static final int DIE_SIZE = 10;

    private Map<Integer, IntRange> dieToGrayscaleRangeMap;

    public Image generate(Image sourceImage, DieSet dieSet) {
        dieToGrayscaleRangeMap = GrayscaleRangeMapGenerator.generate(dieSet);

        Image diceArtImage = new Image(
                sourceImage.getWidth() * DIE_SIZE,
                sourceImage.getHeight() * DIE_SIZE
        );

        sourceImage.forEachPixel(
                pixel -> drawDie(
                        pixel.getX() * DIE_SIZE,
                        pixel.getY() * DIE_SIZE,
                        getDie(pixel),
                        diceArtImage,
                        dieSet
                )
        );
        return diceArtImage;
    }

    private void drawDie(int x, int y, int die, Image image, DieSet dieSet) {
        int dieColor = Color.black();
        int dieDotColor = Color.white();
        if ((dieSet == DieSet.BLACK_AND_WHITE && die > 6) || dieSet == DieSet.WHITE) {
            dieColor = Color.white();
            dieDotColor = Color.black();
        }
        for (int yy = 0; yy < DIE_SIZE; yy++) {
            for (int xx = 0; xx < DIE_SIZE; xx++) {
                image.setPixelRgb(x + xx, y + yy, dieColor);
            }
        }
        for (int yy = 0; yy < DIE_SIZE; yy++) {
            for (int xx = 0; xx < DIE_SIZE; xx++) {
                image.setPixelRgb(x + xx, y + yy, dieColor);
            }
        }
        if (die == 1 || die == 12) {
            drawDot(x + 4, y + 4, dieDotColor, image);
        } else if (die == 2 || die == 11) {
            drawDot(x + 1, y + 1, dieDotColor, image);
            drawDot(x + 7, y + 7, dieDotColor, image);
        } else if (die == 3 || die == 10) {
            drawDot(x + 1, y + 1, dieDotColor, image);
            drawDot(x + 4, y + 4, dieDotColor, image);
            drawDot(x + 7, y + 7, dieDotColor, image);
        } else if (die == 4 || die == 9) {
            drawDot(x + 1, y + 1, dieDotColor, image);
            drawDot(x + 1, y + 7, dieDotColor, image);
            drawDot(x + 7, y + 1, dieDotColor, image);
            drawDot(x + 7, y + 7, dieDotColor, image);
        } else if (die == 5 || die == 8) {
            drawDot(x + 1, y + 1, dieDotColor, image);
            drawDot(x + 1, y + 7, dieDotColor, image);
            drawDot(x + 7, y + 1, dieDotColor, image);
            drawDot(x + 7, y + 7, dieDotColor, image);
            drawDot(x + 4, y + 4, dieDotColor, image);
        } else if (die == 6 || die == 7) {
            drawDot(x + 1, y + 1, dieDotColor, image);
            drawDot(x + 1, y + 4, dieDotColor, image);
            drawDot(x + 1, y + 7, dieDotColor, image);
            drawDot(x + 7, y + 1, dieDotColor, image);
            drawDot(x + 7, y + 4, dieDotColor, image);
            drawDot(x + 7, y + 7, dieDotColor, image);
        }
    }

    private void drawDot(int x, int y, int dotColor, Image image) {
        image.setPixelRgb(x, y, dotColor);
        image.setPixelRgb(x + 1, y, dotColor);
        image.setPixelRgb(x + 1, y + 1, dotColor);
        image.setPixelRgb(x, y + 1, dotColor);
    }

    private int getDie(Pixel pixel) {
        return dieToGrayscaleRangeMap.entrySet().stream()
                .filter(entry -> entry.getValue().in(pixel.getColor().toGrayScale().getR()))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
}
