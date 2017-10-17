package kon.blats;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by k.blatsoukas on 10/5/2017.
 */
public class UF {
    private int[] graph;

    public UF(int N) {
        graph = new int[N];
        IntStream.rangeClosed(0, N-1).forEach(i -> graph[i] = i);
        ArrayList<String> s = new ArrayList<>();
    }

    public boolean isConnected(int onePoint, int otherPoint) {
        return graph[onePoint] == graph[otherPoint];
    }

    public void connect(int onePoint, int otherPoint) {
        if(!isConnected(onePoint, otherPoint)) {
            IntStream.rangeClosed(0, graph.length - 1)
                    .filter(i -> graph[onePoint] != graph[otherPoint])
                    .forEach(i -> graph[i] = graph[otherPoint]);
        }
    }
}
