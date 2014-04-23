/**
 * Created by RAGA on 4/23/2014.
 */
public class CC
{
    private int V, E;
    private int [] cc;
    private int ccCount;
    private boolean []marked;
    private int []edgeTo;

    public CC(Graph g, int s)
    {
        this.V = g.V();

        marked = new boolean[V];
        edgeTo = new int[V];
        cc = new int[V];

        for(int i=0; i < V; i++)
        {
            marked[i] = false;
            edgeTo[i] = i;
        }

        for(int i=0; i < V; i++) {
            if ( ! marked[i]) {
                dfs(g, i);
                ccCount++;
            }
        }
    }

    public int count()
    {
        return ccCount;
    }

    public boolean connected(int v, int w)
    {
        return (cc[v] == cc[w]);
    }

    public void dfs(Graph g, int s)
    {
        marked[s] = true;
        cc[s] = ccCount;
        for(int v:g.adj(s)) {
            if (!marked[v]) {
                dfs(g, v);
                edgeTo[v] = s;
            }
        }
    }

    public void printPath(int v, int w)
    {
        if ( ! connected(v, w))
            return;

        boolean pathFound = false;

        int count = 0;
        for(int x=v; x != w && count < V; x = edgeTo[x],count++)
        {
            StdOut.printf("\nVisited %d", x);
        }

        if (count >= V) {
            StdOut.printf("Previous path is invalid hence rewalking");
            count = 0;

            for(int x=w; x != v && count < V; x = edgeTo[x],count++)
            {
                StdOut.printf("\nVisited %d", x);
            }

            StdOut.printf("\nLast node Visited %d", v);
        }
        else
            StdOut.printf("\nLast node Visited %d", w);

    }


}
