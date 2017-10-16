package kon.blats.javaEight.optionalExample.parralelLoop;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by k.blatsoukas on 10/2/2017.
 */
public class ParallelLoopExample {

    @Test
    public void parallelLoop() {
        int summation = IntStream.rangeClosed(0, 10).parallel().sum();
        System.out.println(summation);

    }
}
