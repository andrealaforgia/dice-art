import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GrayscaleRangeMapGeneratorTest {

    @Test
    void shouldGenerateGrayscaleRangeMap() {
        Map<Integer, IntRange> grayscaleRangeMap = GrayscaleRangeMapGenerator.generate();

        Map<Integer, IntRange> expectedMap = new HashMap<>();

        expectedMap.put(0, IntRange.range((255 * 0) / 14, (255 * 1) / 14));
        expectedMap.put(1, IntRange.range((255 * 1) / 14, (255 * 2) / 14));
        expectedMap.put(2, IntRange.range((255 * 2) / 14, (255 * 3) / 14));
        expectedMap.put(3, IntRange.range((255 * 3) / 14, (255 * 4) / 14));
        expectedMap.put(4, IntRange.range((255 * 4) / 14, (255 * 5) / 14));
        expectedMap.put(5, IntRange.range((255 * 5) / 14, (255 * 6) / 14));
        expectedMap.put(6, IntRange.range((255 * 6) / 14, (255 * 7) / 14));
        expectedMap.put(7, IntRange.range((255 * 7) / 14, (255 * 8) / 14));
        expectedMap.put(8, IntRange.range((255 * 8) / 14, (255 * 9) / 14));
        expectedMap.put(9, IntRange.range((255 * 9) / 14, (255 * 10) / 14));
        expectedMap.put(10, IntRange.range((255 * 10) / 14, (255 * 11) / 14));
        expectedMap.put(11, IntRange.range((255 * 11) / 14, (255 * 12) / 14));
        expectedMap.put(12, IntRange.range((255 * 12) / 14, (255 * 13) / 14));
        expectedMap.put(13, IntRange.range((255 * 13) / 14, (255 * 14) / 14));

        assertThat(grayscaleRangeMap).isEqualTo(expectedMap);
    }
}