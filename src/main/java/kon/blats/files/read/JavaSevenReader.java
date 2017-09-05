package kon.blats.files.read;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by k.blatsoukas on 9/5/2017.
 */
public class JavaSevenReader {
    public static long scannerRead(String fileName) {
        long startTime = System.nanoTime();
        try {
            Path file = Paths.get(fileName);
            List<String> readAllLines = Files.readAllLines(file, StandardCharsets.UTF_8);
            for (String string : readAllLines) {
                System.out.println(string);
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        return elapsedTimeInMillis;
    }

}
