import java.util.Objects;

public class IntRange {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntRange intRange = (IntRange) o;
        return min == intRange.min && max == intRange.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]", min, max);
    }

    private final int min;
    private final int max;

    private IntRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static IntRange range(int min, int max) {
        return new IntRange(min, max);
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public boolean in(int value) {
        return value >= min && value <= max;
    }
}
