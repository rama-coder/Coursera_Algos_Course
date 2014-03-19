import java.util.NoSuchElementException;

/**
 * Created by RamaKrishna on 3/17/14.
 */
public class ArrayStackOfStrings<Item> {

    // Data structure used must be internal to the class
    // Only interface should be exposed to separate interface from implementation

    Item [] stackArray;

    private int N;

    public ArrayStackOfStrings(int N)
    {
        stackArray = (Item[]) new Object[N];
    }

    public void push(Item value)
    {
        stackArray[N++] = value;
    }

    public Item pop()
    {
        Item oldItem = stackArray[--N];
        stackArray[N] = null;
        return oldItem;
    }

    public boolean isEmpty()
    {
        return (N == 0);
    }

    public int size()
    {
        return N;
    }

    public static void main(String []args)
    {
        ArrayStackOfStrings<String> stringStack = new ArrayStackOfStrings<String>(10);

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
