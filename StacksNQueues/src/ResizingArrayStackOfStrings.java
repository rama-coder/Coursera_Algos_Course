import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by RamaKrishna on 3/17/14.
 */
public class ResizingArrayStackOfStrings<Item> implements Iterable<Item>{

    private int N;
    private Item [] items;

    // This constructor should not take capacity as arg as the whole idea is to automatically resize the array based on how full the array is

    public ResizingArrayStackOfStrings()
    {
        items = (Item[]) new Object[1];
    }

    public void push(Item value)
    {
        if (N == items.length )
        {
            resize(2*N);
        }

        items[N++] = value;
    }

    private void resize(int capacity)
    {
        Item [] copy = (Item[]) new Object[capacity];

        for(int i=0; i < N; i++)
            copy[i] = items[i];

        items = copy;
    }

    public Item pop()
    {
        Item topValue = items[--N];

        if (N > 0 && N == items.length/4)
            resize(N*2);

        items[N] = null;
        return topValue;
    }

    public boolean isEmpty()
    {
        return (N == 0);
    }

    public Iterator<Item> iterator()
    {
        return null;
    }

    public static void main(String []args)
    {
        ResizingArrayStackOfStrings<String> stringStack = new ResizingArrayStackOfStrings<String>();

        while ( ! StdIn.isEmpty())
        {
            String s = StdIn.readString();

            if (s.equals("-"))
                StdOut.println(stringStack.pop());
            else
                stringStack.push(s);
        }

        for (String item:stringStack)
            StdOut.printf(" %s ", item);

    }
}
