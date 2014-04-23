import java.util.LinkedList;

/**
 * Created by RAGA on 4/13/2014.
 */
public class Graph
{
            private final int V;
            private int E;
            private int numOfSelfLoops;
            private Bag<Integer> [] adjList;

            public Graph(int n)
            {
                V = n;

                adjList = (Bag<Integer>[]) new Bag[V];

                for(int i = 0; i < n; i++)
                {
                    adjList[i] = new Bag<Integer>();
                }
            }

            /* Sample file format
             * 10 (Number of vertices)
             * 4  (Number of edges)
             * 0 5 (Edges follows)
             * 1 7
             * 8 2
             * 1 5
             */
            public Graph(In inputStream)
            {
                this(inputStream.readInt());
                E = inputStream.readInt();
		System.out.println("Creating Graph object");
                for(int i=0; i < E; i++)
                {
                    int x = inputStream.readInt();
                    int y = inputStream.readInt();

                    adjList[x].add(y);
                    adjList[y].add(x);
                }
            }

            public Iterable<Integer> adj(int v)
            {
                return adjList[v];
            }

            public int V()
            {
                return V;
            }

            public int E()
            {
                return E;
            }

            public String toString()
            {
                StringBuilder graphString = new StringBuilder("");

                for (int i=0; i < V; i++)
                {
                    graphString.append("\n Adj List for " + i);
                    for (int w:adj(i))
                        graphString.append(" => " + w);
                }
                return graphString.toString();
            }

            public void addEdge(int v, int w)
            {
                adjList[v].add(w);
                adjList[w].add(v);
                if (v == w)
                    numOfSelfLoops++;
                E++;
            }

            public int getNumOfSelfLoops()
            {
                return numOfSelfLoops;
            }

            public void print()
            {
                    StdOut.printf(toString());
            }

            public int degree(int v) throws Exception
            {
                if (adjList[v] == null)
                    throw new Exception("Given vertex missing");

                return adjList[v].size();
            }

            public int maxDegree()
            {
                int max = 0;
                for(int i=0; i < adjList.length; i++)
                {
                    int vertexListSize = adjList[i].size();
                    max = vertexListSize > max ? vertexListSize : max;
                }

                return max;
            }

            public int avgDegree()
            {
                return 2 * E / V;
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

                Graph g = new Graph(inputSteam);

                System.out.printf("\nPrinting the graph...\n");

//                g.print();

//                DFS dfsTraversal = new DFS(g, 0);
//
//                int x = -1;
//                while (x != 0) {
//                    System.out.println("\nEnter the edge for checking connectivity");
//                    x = StdIn.readInt();
//                    boolean connected = dfsTraversal.isConnected(x);
//                    StdOut.printf("0 and %d are connected => %b", x, connected);
//
//                    if (connected)
//                        dfsTraversal.printPath(x);
//                }

//                Paths paths = new Paths(g, 0);
//
//                int x = -1;
//                while (x != 0) {
//                    System.out.println("\nEnter the edge for checking connectivity");
//                    x = StdIn.readInt();
//                    boolean connected = paths.hasPathTo(x);
//                    StdOut.printf("0 and %d are connected => %b", x, connected);
//
//                    if (connected)
//                        StdOut.println(" => " + paths.pathTo(x));
//                }

//                BFS bfs = new BFS(g, 0);
//
//                int x = -1;
//                while (x != 0) {
//                    System.out.println("\nEnter the edge for checking connectivity");
//                    x = StdIn.readInt();
//                    boolean connected = bfs.isConnected(x);
//                    StdOut.printf("0 and %d are connected => %b", x, connected);
//
//                    if (connected)
//                        StdOut.println(" => " + bfs.getPath(x));
//                }

                CC cc = new CC(g, 0);

                g.print();
                StdOut.println("\n\nCC count = " + cc.count());

                while(true) {
                    In in2 = new In();
                    StdOut.printf("\n\nEnter 2 vertices separated by space...\n");
                    int v = in2.readInt();
                    int w = in2.readInt();

                    StdOut.printf("\n\n%d and %d are connected = %b", v, w, cc.connected(v, w));
                }

            }
}
