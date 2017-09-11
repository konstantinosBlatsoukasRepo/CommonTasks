package kon.blats;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        Runnable task = () -> IntStream.range(0,120).forEach(System.out::println);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(task, 0, 2, TimeUnit.MINUTES);
    }
}
