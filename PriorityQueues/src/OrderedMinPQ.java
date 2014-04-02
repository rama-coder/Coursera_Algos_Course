/**
 * Created by RAGA on 4/2/2014.
 */
public class OrderedMinPQ<Key extends Comparable<Key>>
{
   Key [] pq;
   int N = 1;

   public OrderedMinPQ(int capacity)
   {
       pq = (Key[]) new Comparable[capacity + 1];
   }

   public void swim(int k) // heap up as the node at k is smaller than his parent
   {
       while ( k > 1 && pq[k].compareTo(pq[k/2])<0)
       {
           Key temp = pq[k/2];
           pq[k/2] = pq[k];
           pq[k] = temp;
           k >>= 1;
       }
   }

   public void sink(int k)
   {
       while ( 2*k <= N) {

           int j = 2 * k;

           if (j <= N && pq[j].compareTo(pq[k]) < 0)
               j++;

           Key temp = pq[j];
           pq[j] = pq[k];
           pq[k] = temp;
            k = j;
       }
   }

    public Key deleteMin()
    {
        Key min = pq[1];

        pq[1] = pq[--N];
        pq[N+1] = null; // take care of loitering
        sink(1);

        return min;
    }

    public void insert(Key key)
    {
        pq[N++] = key;
        swim(N-1);
    }
}
