import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    public static void main(String[] args) {
        int totalItemsToPrint = Integer.parseInt(args[0]);
//        String input = "A B C D E F G H I";
        String input = StdIn.readString();
        Deque<String> deque = fillDeque(input);
        printDequeItems(deque, totalItemsToPrint);
    }

    private static void printDequeItems(Deque<String> deque, int numberOfItems) {
        for(int i = 0; i < numberOfItems; i++) {
            System.out.println(deque.removeFirst());
        }
    }

    private static Deque fillDeque(String input) {
        Deque<String> deque = new Deque<>();
        for(String splittedItem:input.split(" ")) {
            deque.addFirst(splittedItem);
        }
        return deque;
    }

}