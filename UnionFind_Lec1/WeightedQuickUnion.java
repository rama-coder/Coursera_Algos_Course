/**
 * Created with IntelliJ IDEA.
 * User: RAGA
 * Date: 3/4/14
 * Time: 6:00 AM
 * To change this template use File | Settings | File Templates.
 */
// TC => O(log N) for both union and find as the trees can not get taller
// SC => O(2N) = O(N) as it uses 2 arrays of size N

public class WeightedQuickUnion {
    int [] id, size;
    int count;
    
    public WeightedQuickUnion(int N)
    {
        id = new int[N];
        size = new int[N];
        count = N;
        
        for(int i=0; i<N; i++)
        {
            id[i] = i;
            size[i] = 1;
        }
        
    }

    // Return the number of connected components
    
    public int count()
    {
        return count;
    }
    
    private int root(int v)
    {
        while (v != id[v])
            v = id[v];

        return v;
    }

    public boolean connect(int v1, int v2)
    {
        return (root(v1) == root(v2));
    }

    // Update parent nodes and size of root of the node

    public void union(int v1, int v2)
    {
        int v1Root = root(v1);
        int v2Root = root(v2);

        if (v1Root == v2Root)
        {
            StdOut.printf("%d and %d are under same tree hence skipping union", v1, v2);
            return;
        }

        count--;
        
        if (size[v1Root] > size[v2Root])
        {
            id[v2Root] = v1Root;
            size[v1Root] += size[v2Root];
        }
        else
        {
            id[v1Root] = v2Root;
            size[v2Root] += size[v1Root];
        }

    }

    public static void main(String []args)
    {
        WeightedQuickUnion qupcTree = new WeightedQuickUnion(10);

        qupcTree.union(4,3);
        qupcTree.union(3,8);

        System.out.printf("\n6 and 5 are connected => %b", qupcTree.connect(6,5));
        System.out.printf("\n9 and 4 are connected => %b", qupcTree.connect(9,4));
        System.out.printf("\n4 and 3 are connected => %b", qupcTree.connect(4,3));
        System.out.printf("\n4 and 8 are connected => %b", qupcTree.connect(4,8));

        qupcTree.union(6,5);
        qupcTree.union(9,4);

        System.out.printf("\n6 and 5 are connected => %b", qupcTree.connect(6,5));
        System.out.printf("\n9 and 3 are connected => %b", qupcTree.connect(9,3));

        qupcTree.union(2,1);
        qupcTree.union(5,0);

        System.out.printf("\n2 and 1 are connected => %b", qupcTree.connect(2,1));
        System.out.printf("\n5 and 0 are connected => %b", qupcTree.connect(5,0));

        qupcTree.union(7,2);
        qupcTree.union(6,1);

        System.out.printf("\n7 and 3 are connected => %b", qupcTree.connect(7,3));
        qupcTree.union(7,3);

        System.out.printf("\n6 and 5 are connected => %b", qupcTree.connect(6,5));
        System.out.printf("\n7 and 3 are connected => %b", qupcTree.connect(7,3));
        System.out.printf("\n7 and 4 are connected => %b", qupcTree.connect(7,4));

    }
}
