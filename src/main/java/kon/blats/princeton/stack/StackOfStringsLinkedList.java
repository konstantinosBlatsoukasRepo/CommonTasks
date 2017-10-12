package kon.blats.princeton.stack;

/**
 * Created by k.blatsoukas on 10/12/2017.
 */
public class StackOfStringsLinkedList implements StackOfStrings {

    private Node first = null;
    private static int sizeCounter = 0;
    private class Node {
        String item;
        Node next;
    }

    @Override
    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        sizeCounter++;
    }

    @Override
    public String pop() {
        String poppedItem = first.item;
        first = first.next;
        sizeCounter--;
        return poppedItem;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return sizeCounter;
    }

    public static void main(String[] args) {
        StackOfStringsLinkedList stackOfStringsLinkedList = new StackOfStringsLinkedList();
        stackOfStringsLinkedList.push("kostas");
        stackOfStringsLinkedList.push("mitsos");
        System.out.println(stackOfStringsLinkedList.size());
        System.out.println(stackOfStringsLinkedList.pop());
    }
}
