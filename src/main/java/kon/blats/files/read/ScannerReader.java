package kon.blats.files.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by k.blatsoukas on 9/5/2017.
 */
public class ScannerReader {
    public static long scannerRead(String fileName) {
        long startTime = System.nanoTime();
        try (Scanner sc = new Scanner(new File(fileName), "UTF-8")) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // parse line
                //System.out.println(line);
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                sc.ioException().printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        return elapsedTimeInMillis;
    }
}
