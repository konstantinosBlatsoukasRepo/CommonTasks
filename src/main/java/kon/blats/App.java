package kon.blats;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
/**
 * Hello world!
 *
 */
public class App {

    public static Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args ) throws IOException {
        logger.info("hello from main, info stuff");
        logger.error("hello from main, error stuff");
    }
}
