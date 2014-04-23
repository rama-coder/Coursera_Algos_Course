/**
 * Created by RAGA on 4/22/2014.
 */
public class Edge implements Comparable<Edge>
{
    private final int v, w;
    private double weight;

    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either()
    {
        return v;
    }

    public int other(int x)
    {
        if (v==x) return w;
        if (w==x) return v;

        throw new IllegalArgumentException("Invalid edge vertex.");
    }

    public int compareTo(Edge that)
    {
        if (this.weight < that.weight) return -1;
        if (this.weight > that.weight) return 1;

        return 0;
    }

    public String toString()
    {
        return v + "-" + w + "=" + weight;
    }
}
