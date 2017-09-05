package kon.blats.files.generate;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by k.blatsoukas on 9/5/2017.
 */
public class FileGeneratorInASpecificSize {
    public static void generateFile(String fileName, int sizeInBytes) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        try {
            raf.setLength(sizeInBytes);
        } finally {
            raf.close();
        }
    }

}
