/**
 * Created by RAGA on 4/16/2014.
 */
public class Paths {
    private Graph g;
    private DFS dfsTraversal;
    private int s;

    public Paths(Graph g, int s)
    {
        dfsTraversal = new DFS(g, s);
        this.g = g;
        this.s = s;
    }

    public boolean hasPathTo(int v)
    {
        return dfsTraversal.isConnected(v);
    }

    public String pathTo(int v)
    {
        return dfsTraversal.getPath(v);

    }
}
