import java.util.NoSuchElementException;

/**
 * Created by RamaKrishna on 3/17/14.
 */
public class StackOfLinkedList<Item> {

    // Data structure used must be internal to the class
    // Only interface should be exposed to separate interface from implementation

    // No need to add constructor as it is a private class
    // access modifiers does not exist
    private class Node<Item> {
        Item value;
        Node<Item> next;
    }

    private Node<Item> top;
    private int count;

    public StackOfLinkedList()
    {
    }

    public void push(Item value)
    {
        // There is no need to add check for top == null if we store top in oldTop in the beginning
        // Less code and achieves the goal...
        Node<Item> oldTop = top;
        Node<Item> top = new Node<Item>();
        top.value = value;
        top.next = oldTop;
        count++;
    }

    public Item pop()
    {
        if (top == null)
            throw new NoSuchElementException("Stack is empty");

        Item topItem = top.value;
        top = top.next;

        count--;

        return topItem;
    }

    public boolean isEmpty()
    {
        return (top == null);
    }

    public int size()
    {
        return count;
    }

    public static void main(String []args)
    {
        StackOfLinkedList<String> stringStack = new StackOfLinkedList<String>();

        while ( ! StdIn.isEmpty())
        {
            String s = StdIn.readString();

            if (s.equals("-"))
                StdOut.println(stringStack.pop());
            else
                stringStack.push(s);
        }

        while( ! stringStack.isEmpty())
            StdOut.printf(" %s ", stringStack.pop());

    }
}
