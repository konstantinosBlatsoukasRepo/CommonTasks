package kon.blats.princeton.stack;

/**
 * Created by k.blatsoukas on 10/12/2017.
 */
public class StackOfStringsArrayFixed implements StackOfStrings {
    private int N = 0;
    private String[] arrayStrings;

    public StackOfStringsArrayFixed(int N) {
        arrayStrings = new String[N];
    }

    @Override
    public void push(String item) {
        arrayStrings[++N] = item;
    }

    @Override
    public String pop() {
        return arrayStrings[N--] ;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return arrayStrings.length;
    }

    public static void main(String[] args) {
        StackOfStringsArrayFixed stackOfStringsArrayFixed = new StackOfStringsArrayFixed(10);
        stackOfStringsArrayFixed.push("Kostas");
        System.out.println(stackOfStringsArrayFixed.pop());
    }
}
