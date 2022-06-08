import java.io.IOException;

public class TestUtils {

    public static Image givenImage(String resourceFileName) throws IOException {
        return Image.fromStream(TestUtils.class.getClassLoader().getResourceAsStream(resourceFileName));
    }
}
