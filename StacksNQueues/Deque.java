import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by RamaKrishna on 3/17/14.
 */
public class Deque<Item> implements Iterable<Item> {

    // Data structure used must be internal to the class
    // Only interface should be exposed to separate interface from implementation

    // No need to add constructor as it is a private class
    // access modifiers does not exist
    private int N;
    private class Node<Item> {
        Item value;
        Node<Item> next;
    }

    private Node<Item> top;
    private int count;

    public Deque()
    {
    }

    public boolean isEmpty()
    {
        return (N==0);
    }

    public int size()
    {
        return 0;
    }

    public void addFirst(Item item)
    {

    }

    public void addLast(Item item)
    {

    }

    public Item removeFirst(Item item)
    {
        return null;
    }

    public Item removeLast(Item item)
    {
        return null;
    }

    public Iterator<Item> iterator()
    {
        return null;
    }
    public static void main(String []args)
    {

    }
}
