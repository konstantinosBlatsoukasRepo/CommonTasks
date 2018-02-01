package kon.blats.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by k.blatsoukas on 1/30/2018.
 */
public class LogTest {

  public static final Logger logger = LogManager.getLogger();

  public static void main(String[] args) {
    logger.error("Hello from error level");
    TestLog.usingLogTestLogger();
  }
}
