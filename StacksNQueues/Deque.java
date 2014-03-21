import java.lang.UnsupportedOperationException;
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

    class Node<Item>
    {
        Item data;
        Node<Item> prev, next;

        Node(Item item)
        {
            this.data = item;
        }
    }

    Node<Item> first, last;

    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }

    class DequeIterator implements Iterator<Item>
    {
        Node<Item> current = first;

        public boolean hasNext()
        {
            return (current != null );
        }

        public Item next()
        {
            if (current == null)
                throw new NoSuchElementException("No next element found");

            Node<Item> oldCurrent = current;
            current = current.next;
            return oldCurrent.data;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Remove operation not supported as it can cause insidenious bugs");
        }
    }

    private int N;

    public Deque()
    {
    }

    public boolean isEmpty()
    {
        return (N==0);
    }

    public int size()
    {
        return N;
    }

    public void addFirst(Item item)
    {
        if (item == null)
            throw new NullPointerException("Could not add null items to Deque");

        N++;

        Node<Item> newNode = new Node<Item>(item);

        if (first == null)
        {
            first = last = newNode;
            return;
        }

        newNode.next = first;
        first.prev = newNode;
        first = newNode;

    }

    public void addLast(Item item)
    {
        if (item == null)
            throw new NullPointerException("Could not add null items to Deque");

        N++;

        Node<Item> newNode = new Node<Item>(item);

        // Same as checking for first == null as both first and last nodes point to same node in the beginning for 0 and 1 length lists
        if (last == null)
        {
            first = last = newNode;
            return;
        }

        newNode.prev = last;
        last.next = newNode;
        last = newNode;

    }

    public Item removeFirst()
    {
        if (first == null)
            throw new NoSuchElementException("Queue is empty hence remove cannot be performed");

        N--;

        Item removedData = first.data;
        Node<Item> newNode = first.next;

        if (newNode != null)
            newNode.prev = null;

        first.next = null;
        first = newNode;
        return removedData;
    }

    public Item removeLast()
    {
        if (last == null)
            throw new NoSuchElementException("Queue is empty hence remove cannot be performed");

        N--;

        Item removedData = last.data;
        Node<Item> newLast = last.prev;

        if (newLast != null)
            newLast.next = null;

        last.prev = null;
        last = newLast;
        return removedData;
    }


    public static void main(String []args)
    {
        Deque<String> dequeOfStrings = new Deque<String>();

        StdOut.println("Adding the elements into Deque...");

        StdOut.println("Size of the Deque = "+ dequeOfStrings.size());

        dequeOfStrings.addLast("Rama");
        StdOut.println("Size of the Deque = "+ dequeOfStrings.size());
        dequeOfStrings.addLast("Gayathri");
        StdOut.println("Size of the Deque = "+ dequeOfStrings.size());
        dequeOfStrings.addLast("Sree");
        StdOut.println("Size of the Deque = "+ dequeOfStrings.size());
        dequeOfStrings.addLast("Mom");
        StdOut.println("Size of the Deque = "+ dequeOfStrings.size());

        for(String s:dequeOfStrings)
            StdOut.printf("\nEncountered %s", s);

        StdOut.println("Removing the elements from Deque...");

        dequeOfStrings.removeFirst();
        StdOut.println("Size of the Deque = "+ dequeOfStrings.size());
        dequeOfStrings.removeFirst();
        StdOut.println("Size of the Deque = "+ dequeOfStrings.size());
        dequeOfStrings.removeFirst();
        StdOut.println("Size of the Deque = "+ dequeOfStrings.size());
        dequeOfStrings.removeFirst();
        StdOut.println("Size of the Deque = "+ dequeOfStrings.size());

        for(String s:dequeOfStrings)
            StdOut.printf("\nEncountered %s", s);
    }
}
