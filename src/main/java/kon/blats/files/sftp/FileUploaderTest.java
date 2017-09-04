package kon.blats.files.sftp;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by k.blatsoukas on 9/4/2017.
 */
public class FileUploaderTest {
    @Test
    public void fileUploaderTest() throws IOException {
        FileUploader fileUploader = new FileUploader();
        fileUploader.uploadFile("application.properties");
    }
}
