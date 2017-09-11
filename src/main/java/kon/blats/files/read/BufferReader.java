package kon.blats.files.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by k.blatsoukas on 9/5/2017.
 */
public class BufferReader {
    public static long bufferReader(String filename) throws IOException {
        long startTime = System.nanoTime();
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String value;
        while ((value = bufferedReader.readLine()) != null) {
        }
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        return elapsedTimeInMillis;
    }
}
