import java.util.HashMap;
import java.util.Map;

public class GrayscaleRangeMapGenerator {
    public static Map<Integer, IntRange> generate() {
        Map<Integer, IntRange> map = new HashMap<>();
        for (int die = 0; die < 14; die++) {
            map.put(die, IntRange.range((255 * die) / 14, (255 * (die + 1)) / 14));
        }
        return map;
    }
}
