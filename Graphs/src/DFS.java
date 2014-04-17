/**
 * Created by RAGA on 4/16/2014.
 */
public class DFS {
    private boolean [] marked;
    private int [] edgeTo;

    public DFS(Graph g, int s)
    {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];

        dfs(g, s);
    }

    public void dfs(Graph g, int s)
    {
        if (marked[s])
            return;

        marked[s] = true;

        for(int t:g.adj(s))
        {
            if ( ! marked[t]) {
                edgeTo[t] = s;
                dfs(g, t);
            }

        }
    }

    public boolean isConnected(int v)
    {
        return marked[v];
    }

    public void printPath(int v)
    {
        if ( ! marked[v]) {
            StdOut.printf("\n0 and %d are not connected.\n", v);
            return;
        }

        Stack<Integer> stack = new Stack<Integer>();

        for(int x=v; x != 0; x = edgeTo[x])
            stack.push(x);
        stack.push(0);

        StdOut.println("Printing the path that is used for reaching " + v);
        while( ! stack.isEmpty())
            System.out.println(" => " + stack.pop());
    }

    public String getPath(int v)
    {
        if ( ! marked[v]) {
            StdOut.printf("\n0 and %d are not connected.\n", v);
            return null;
        }

        Stack<Integer> stack = new Stack<Integer>();

        for(int x=v; x != 0; x = edgeTo[x])
            stack.push(x);
        stack.push(0);

        StringBuilder sb = new StringBuilder("");

        while( ! stack.isEmpty())
            sb.append(" => " + stack.pop());

        return sb.toString();
    }
}
