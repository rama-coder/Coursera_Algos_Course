/**
 * Created by RAGA on 4/22/2014.
 */

public class EdgeWeightedGraph
{
    private int V, E;

    private Bag<Edge>[] ba;

    public EdgeWeightedGraph(int V)
    {
        this.V = V;
        ba  = (Bag <Edge>[]) (new Bag[V]);

        for(int i=0; i < V; i++)
            ba[i] = new Bag<Edge>();
    }

    public int V() { return V;}
    public int E() { return E;}

    public void addEdge(Edge e)
    {
        int v = e.either();
        int w = e.other(v);

        ba[v].add(e);
        ba[w].add(e);

        E++;
    }

    public Iterable<Edge> adj(int v)
    {
        return ba[v];
    }

    public Iterable<Edge> edges()
    {
        Bag<Edge> edges = new Bag<Edge>();
        for(int i=0; i < V; i++)
        {
            for (Edge be:adj(i))
            {
                if (i < be.other(i))
                    edges.add(be);
            }
        }

        return edges;
    }

    public static void main(String []args)
    {
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(Integer.parseInt(args[0]));

        ewg.addEdge(new Edge(0, 1, 10));
        ewg.addEdge(new Edge(1, 2, 11));
        ewg.addEdge(new Edge(2, 3, 12));
        ewg.addEdge(new Edge(3, 4, 13));
        ewg.addEdge(new Edge(4, 5, 14));

        ewg.addEdge(new Edge(5, 6, 21));
        ewg.addEdge(new Edge(6, 7, 22));
        ewg.addEdge(new Edge(7, 8, 23));
        ewg.addEdge(new Edge(8, 9, 24));
        ewg.addEdge(new Edge(9, 0, 25));

        int count = 0;
        for(Edge e:ewg.edges())
        {
            StdOut.println(count + " => " + e);
            count++;
        }
    }
}
