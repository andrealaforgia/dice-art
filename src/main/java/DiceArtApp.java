import java.io.IOException;

public class DiceArtApp {

    public static void main(String[] args) throws IOException {
        generateDiceArtImage("g.jpeg", DieSet.BLACK_AND_WHITE);
        generateDiceArtImage("g.jpeg", DieSet.BLACK);
        generateDiceArtImage("g.jpeg", DieSet.WHITE);

        generateDiceArtImage("IMG_2513.JPG", DieSet.BLACK_AND_WHITE);
        generateDiceArtImage("IMG_2513.JPG", DieSet.BLACK);
        generateDiceArtImage("IMG_2513.JPG", DieSet.WHITE);

        generateDiceArtImage("originale.jpeg", DieSet.BLACK_AND_WHITE);
        generateDiceArtImage("originale.jpeg", DieSet.BLACK);
        generateDiceArtImage("originale.jpeg", DieSet.WHITE);
    }

    private static void generateDiceArtImage(String filename, DieSet dieSet) throws IOException {
        System.out.printf("Processing %s (die set: %s)%n", filename, dieSet.toString());
        Image sourceImage = Image.fromStream(
                DiceArtApp.class.getClassLoader().getResourceAsStream(filename)
        );

        Image diceArtImage = new DiceArtGenerator().generate(sourceImage, dieSet);

        diceArtImage.saveToFile("dice-art-" + dieSet + filename);
    }
}
