/**
 * Created by RAGA on 4/2/2014.
 */
public class UnorderedMaxPQ <Key extends Comparable<Key>>
{
    private Key [] A;
    private int N; // current number of items

    public UnorderedMaxPQ(int capacity)
    {
        A = (Key []) new Comparable[capacity];
    }

    public void insert(Key key) throws Exception
    {
        if (N >= A.length)
            throw new Exception("Java Overflow error");

        A[N++] = key;
    }

    public Key deleteMax() throws Exception
    {
        if (N==0)
            throw new Exception("Empty PQ found");

        int max = 0;

        for(int i=1; i < N; i++)
        {
            if (A[max].compareTo(A[i]) < 0) {
                max = i;
            }
        }

        Key temp = A[max];
        A[max] = A[N-1];
        A[N-1] = temp;

        return A[--N]; // Does lazy deletion with loitering
    }

    public int size() { return N; }
    public boolean isEmpty() { return N==0; }

    public static void main(String []args)
    {
        UnorderedMaxPQ<String> maxPQ = new UnorderedMaxPQ<String>(15);

        try {
            maxPQ.insert("Zhone");
            maxPQ.insert("Google");
            maxPQ.insert("LinkedIn");
            maxPQ.insert("Adobe");
            maxPQ.insert("Facebook");

            while ( ! maxPQ.isEmpty() )
                StdOut.printf("\n\nNext Max = " + maxPQ.deleteMax());

        }
        catch(Exception ex)
        {
            StdOut.printf("Exception thrown " + ex);
        }

    }


}
