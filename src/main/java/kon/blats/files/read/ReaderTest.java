package kon.blats.files.read;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by k.blatsoukas on 9/5/2017.
 */
public class ReaderTest {
    @Test
    public void readerTest() throws IOException {
        List<Long> readingTimes = new ArrayList<>();
        //light memory usage, heavy IO
        long bufferTotalTime = BufferReader.bufferReader("testFile.txt");
        long scannerTotalTime = ScannerReader.scannerRead("testFile.txt"); // line-by-line
        long streamTotalTime = StreamReader.streamRead("testFile.txt"); //lines Stream<String>
        long javaSevenTotalTime = JavaSevenReader.scannerRead("testFile.txt"); //Files.readAllLines
        readingTimes.add(scannerTotalTime);
        readingTimes.add(streamTotalTime);
        readingTimes.add(javaSevenTotalTime);
        readingTimes.add(bufferTotalTime);
        IntStream.range(0, readingTimes.size())
                .boxed().min(Comparator.comparing(readingTimes::get))
                .ifPresent(minIndex -> System.out.println("Index " + minIndex + ", value " + readingTimes.get(minIndex)));
    }
}
