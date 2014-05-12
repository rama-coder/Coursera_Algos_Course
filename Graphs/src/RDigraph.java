/**
 * Created by RAGA on 4/18/2014.
 */
public class RDigraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public RDigraph(int V)
    {
        this.V = V;

        adj = (Bag<Integer>[]) new Bag[V];

        for (int i=0; i<V; i++)
            adj[i] = new Bag<Integer>();
    }

    public RDigraph(In in)
    {
        this(in.readInt());
        E = in.readInt();

        for(int i = 0; i < E; i++)
        {
            int x = in.readInt();
            int y = in.readInt();

            adj[x].add(y);
        }
    }

    public void addEdge(int x, int y)
    {
        adj[x].add(y);
    }

    public Iterable<Integer> adj(int x)
    {
        return adj[x];
    }

    public int degree(int x)
    {
        return adj[x].size();
    }

    public int maxDegree()
    {
        int maxDegree = adj[0].size();

        for (int i=1; i < V; i++)
        {
            maxDegree = (maxDegree < adj[i].size()?adj[i].size():maxDegree);
        }

        return maxDegree;
    }

    public int V() { return V; }
    public int E() { return E; }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < V; i++)
        {
            sb.append("\nAdj List for " + i);
            for (int w:adj(i))
            {
                sb.append(" => " + w);
            }
        }

        return sb.toString();
    }

    public void print()
    {
        StdOut.printf(toString());
    }

    public static void main(String []args) throws Exception
    {
        System.out.println("Inside main...");
        if (args.length != 1)
        {
            System.out.println("\nWHOOPS...USAGE ERROR....");
            throw new Exception("\nWRONG NUMBER OF ARGS => You must pass the graph data file.\n\n");
        }

        In inputSteam = new In(args[0]);

        RDigraph g = new RDigraph(inputSteam);

        System.out.printf("\nPrinting the graph...\n");

        g.print();

        System.out.printf("\nRunning directed DFS ....");

        DirectedDFS dg = new DirectedDFS(g, 0);

    }
}
