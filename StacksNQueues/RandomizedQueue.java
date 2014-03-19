import java.util.Iterator;

/**
 * Created by RamaKrishna on 3/17/14.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

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

    public RandomizedQueue()
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

    public void enqueue(Item item)
    {

    }

    public Item dequeue()
    {
        return null;
    }

    public Item sample()
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
