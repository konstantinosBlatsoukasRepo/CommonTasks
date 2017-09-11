package kon.blats.files.generate;

import org.junit.Test;
import java.io.IOException;
/**
 * Created by k.blatsoukas on 9/5/2017.
 */
public class GeneratorTest {

    @Test
    public void generatorTest() throws IOException {
        FileGeneratorInASpecificSize.generateFile("testFile.txt", 5_242_889);
    }
}
