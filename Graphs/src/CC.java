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



}
