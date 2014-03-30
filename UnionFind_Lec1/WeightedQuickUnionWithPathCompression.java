/**
 * Created with IntelliJ IDEA.
 * User: RAGA
 * Date: 3/4/14
 * Time: 6:00 AM
 * To change this template use File | Settings | File Templates.
 */

// TC => O(log N) for both union and find as the trees can not get taller
// SC => O(2N) = O(N) as it uses 2 arrays of size N
// Any sequence of M union/find operations will take O(N+ M log*N)

public class WeightedQuickUnionWithPathCompression {
    int [] id, size;
    int count;

    public WeightedQuickUnionWithPathCompression(int N)
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

    private int root(int v)
    {
        while (v != id[v])
            v = id[v];

        return v;
    }

    private int root1(int v)
    {
        while (v != id[v])
        {
            id[v] = id[id[v]];
            v = id[v];
        }
        return v;
    }

    private int root2(int v)
    {
        int vRoot = root(v);

        while (v != id[v])
        {
            int oldParent = id[v];
            id[v] = vRoot;
            v = oldParent;
        }

        return v;
    }

    public boolean connect(int v1, int v2)
    {
        return (root2(v1) == root2(v2));
    }

    public int count()
    {
	    return N;
    }

    public void union(int v1, int v2)
    {
        int v1Root = root2(v1);
        int v2Root = root2(v2);

        if (v1Root == v2Root)
            return;

	count--;

        // V1 is in large tree hence add v2 under v1 tree
        if (size[v1Root] > size[v2Root])
        {
            id[v2Root] = v1Root;
            size[v1Root] += size[v2Root];
        }
        else // v2 is in large tree hence add v1 under v2 tree
        {
            id[v1Root] = v2Root;
            size[v2Root] += size[v1Root];
        }
    }

    public static void main(String []args)
    {
        WeightedQuickUnionWithPathCompression qupcTree = new WeightedQuickUnionWithPathCompression(10);

        qupcTree.union(4,3);
        qupcTree.union(3,8);

        System.out.printf("\n6 and 5 are connected => %b", qupcTree.connect(6,5));
        System.out.printf("\n9 and 4 are connected => %b", qupcTree.connect(9, 4));
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

        System.out.printf("\n7 and 3 are connected => %b", qupcTree.connect(7, 3));
        qupcTree.union(7,3);

        System.out.printf("\n6 and 5 are connected => %b", qupcTree.connect(6,5));
        System.out.printf("\n7 and 3 are connected => %b", qupcTree.connect(7,3));
        System.out.printf("\n7 and 4 are connected => %b", qupcTree.connect(7,4));

    }
}
