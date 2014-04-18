/**
 * Created by RAGA on 4/18/2014.
 */
public class DirectedDFS {
    private boolean [] marked;

    public DirectedDFS(Digraph g, int s)
    {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    public void dfs(Digraph g, int v)
    {
        marked[v] = true;

        StdOut.printf("\n Visited vertex " + v);
        for(int w:g.adj(v))
        {
            if ( ! marked[w]) dfs(g, w);
        }
    }

    public boolean visited(int v)
    {
        return marked[v];
    }
}
