import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class DiceArtGeneratorTest {

    @Test
    void shouldGenerateDiceArtForImage() throws IOException {
        // given
        Image sourceImage = TestUtils.givenImage("mickey.jpeg");

        // when
        Image diceArtImage = new DiceArtGenerator().generate(sourceImage, DieSet.BLACK_AND_WHITE);

        // then
        assertThatDiceArtImagesWereGeneratedAsExpected(sourceImage, diceArtImage);
    }

    private void assertThatDiceArtImagesWereGeneratedAsExpected(Image sourceImage, Image diceArtImage) {
        thenDiceArtImageIsBlackAndWhite(diceArtImage);
    }

    private void thenDiceArtImageIsBlackAndWhite(Image diceArtImage) {
        diceArtImage.forEachPixel(pixel -> assertThat(pixel.isWhite() || pixel.isBlack()).isTrue());
    }
}