public class Pixel {
    private final int x;
    private final int y;
    private final Color color;

    public Pixel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean isWhite() {
        return this.color.isWhite();
    }

    public boolean isBlack() {
        return this.color.isBlack();
    }
}
