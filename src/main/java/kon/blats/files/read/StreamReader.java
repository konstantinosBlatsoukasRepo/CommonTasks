package kon.blats.files.read;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Created by k.blatsoukas on 9/5/2017.
 */
public class StreamReader {
    public static long streamRead(String fileName) {
        long startTime = System.nanoTime();
        Path file = Paths.get(fileName);
        try {
            Stream<String> lines = Files.lines( file, StandardCharsets.UTF_8 );
            for(String line : (Iterable<String>) lines::iterator ) {
                //System.out.println(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        return elapsedTimeInMillis;
    }

}
