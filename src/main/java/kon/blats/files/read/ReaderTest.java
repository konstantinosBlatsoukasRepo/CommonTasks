package kon.blats.files.read;

import org.junit.Test;

/**
 * Created by k.blatsoukas on 9/5/2017.
 */
public class ReaderTest {
    @Test
    public void readerTest() {
        long scannerTotalTime = ScannerReader.scannerRead("testFile.txt");
        System.out.println("Scanner total time: " + scannerTotalTime + "ms");
    }
}
