package kon.blats.files.read;

import org.junit.Test;

/**
 * Created by k.blatsoukas on 9/5/2017.
 */
public class ReaderTest {
    @Test
    public void readerTest() {
        //light memory usage, heavy IO
        long scannerTotalTime = ScannerReader.scannerRead("testFile.txt");
        System.out.println("Scanner total time: " + scannerTotalTime + "ms");
        long streamTotalTime = StreamReader.streamRead("testFile.txt");
        System.out.println("Stream total time: " + streamTotalTime + "ms");
    }
}
