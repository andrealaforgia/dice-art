public class Color {

    private final int r;
    private final int g;
    private final int b;
    private final int rgb;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rgb = (r << 16) + (g << 8) + b;
    }

    public Color(int rgb) {
        this.rgb = removeAlpha(rgb);
        this.r = (this.rgb >> 16) & 0xFF;
        this.g = (this.rgb >> 8) & 0xFF;
        this.b = this.rgb & 0xFF;
    }

    public boolean isInGrayscaleRange(Integer min, Integer max) {
        return this.r >= min && this.r <= max;
    }

    private int removeAlpha(int rgb) {
        return rgb & 0x00FFFFFF;
    }

    public int getRgb() {
        return this.rgb;
    }

    public boolean isWhite() {
        return this.rgb == 0xFFFFFF;
    }

    public boolean isBlack() {
        return this.rgb == 0;
    }

    public Color toGrayScale() {
        int grayscaleShade = (int) (this.r * 0.3 + this.r * 0.59 + this.r * 0.11);
        return new Color(grayscaleShade, grayscaleShade, grayscaleShade);
    }
}
