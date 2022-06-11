import java.util.HashMap;
import java.util.Map;

public class GrayscaleRangeMapGenerator {
    public static Map<Integer, IntRange> generate(DieSet dieSet) {
        int dieCount = 7;
        if (dieSet == DieSet.BLACK_AND_WHITE) {
            dieCount *= 2;
        }
        Map<Integer, IntRange> map = new HashMap<>();
        if (dieSet == DieSet.BLACK_AND_WHITE || dieSet == DieSet.BLACK) {
            for (int die = 0; die < dieCount; die++) {
                map.put(die, IntRange.range((255 * die) / dieCount, (255 * (die + 1)) / dieCount));
            }
        } else {
            for (int die = 0; die < dieCount; die++) {
                map.put(die, IntRange.range((255 * (dieCount - die - 1)) / dieCount, (255 * (dieCount - die)) / dieCount));
            }
        }
        return map;
    }
}
