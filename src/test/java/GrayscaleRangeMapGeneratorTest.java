import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GrayscaleRangeMapGeneratorTest {

    @Test
    void shouldGenerateGrayscaleRangeMapForBlackAndWhiteDieSet() {
        Map<Integer, IntRange> grayscaleRangeMap = GrayscaleRangeMapGenerator.generate(DieSet.BLACK_AND_WHITE);

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

    @Test
    void shouldGenerateGrayscaleRangeMapForWhiteDieSet() {
        Map<Integer, IntRange> grayscaleRangeMap = GrayscaleRangeMapGenerator.generate(DieSet.WHITE);

        Map<Integer, IntRange> expectedMap = new HashMap<>();

        expectedMap.put(6, IntRange.range((255 * 0) / 7, (255 * 1) / 7));
        expectedMap.put(5, IntRange.range((255 * 1) / 7, (255 * 2) / 7));
        expectedMap.put(4, IntRange.range((255 * 2) / 7, (255 * 3) / 7));
        expectedMap.put(3, IntRange.range((255 * 3) / 7, (255 * 4) / 7));
        expectedMap.put(2, IntRange.range((255 * 4) / 7, (255 * 5) / 7));
        expectedMap.put(1, IntRange.range((255 * 5) / 7, (255 * 6) / 7));
        expectedMap.put(0, IntRange.range((255 * 6) / 7, (255 * 7) / 7));

        assertThat(grayscaleRangeMap).isEqualTo(expectedMap);
    }

    @Test
    void shouldGenerateGrayscaleRangeMapForBlackDieSet() {
        Map<Integer, IntRange> grayscaleRangeMap = GrayscaleRangeMapGenerator.generate(DieSet.BLACK);

        Map<Integer, IntRange> expectedMap = new HashMap<>();

        expectedMap.put(0, IntRange.range((255 * 0) / 7, (255 * 1) / 7));
        expectedMap.put(1, IntRange.range((255 * 1) / 7, (255 * 2) / 7));
        expectedMap.put(2, IntRange.range((255 * 2) / 7, (255 * 3) / 7));
        expectedMap.put(3, IntRange.range((255 * 3) / 7, (255 * 4) / 7));
        expectedMap.put(4, IntRange.range((255 * 4) / 7, (255 * 5) / 7));
        expectedMap.put(5, IntRange.range((255 * 5) / 7, (255 * 6) / 7));
        expectedMap.put(6, IntRange.range((255 * 6) / 7, (255 * 7) / 7));

        assertThat(grayscaleRangeMap).isEqualTo(expectedMap);
    }
}