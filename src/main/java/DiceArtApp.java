import java.io.IOException;

public class DiceArtApp {

    public static void main(String[] args) throws IOException {
        generateDiceArtImage("mickey.jpeg");
    }

    private static void generateDiceArtImage(String filename) throws IOException {
        Image sourceImage = Image.fromStream(
                DiceArtApp.class.getClassLoader().getResourceAsStream(filename)
        );

        Image diceArtImage = new DiceArtGenerator().generate(sourceImage);

        diceArtImage.saveToFile("dice-art-"+filename);
    }
}
