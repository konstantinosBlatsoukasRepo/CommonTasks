package kon.blats;

/**
 * Created by k.blatsoukas on 10/4/2017.
 */
public class Ordered implements Comparable<Ordered> {
    int order;
    String name;

    public Ordered(int order, String name) {
        this.order = order;
        this.name = name;
    }

    @Override
    public int compareTo(Ordered other) {
        return this.order - other.order;
    }
}
