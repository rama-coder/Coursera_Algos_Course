import java.util.Comparator;

/**
 * Created by RamaKrishna on 3/30/14.
 */
public class Point
{
    private int x, y;

    private class PointComparator implements Comparator<Point>
    {
        public int compare(Point q, Point r)
        {
            double qSlope = slopeTo(q);
            double rSlope = slopeTo(r);

            if (qSlope < rSlope)
                return -1;
            else if (qSlope == rSlope)
                return 0;
            else
                return 1;
        }

    }

    public final Comparator<Point> SLOPE_ORDER = new PointComparator();
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void draw()
    {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that)
    {
        StdDraw.line(x, y, that.x, that.y);
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }

    public int compareTo(Point that)
    {
        if (y == that.y && x == that.x)
            return 0;

        else if (y < that.y || ( y == that.y && x < that.x))
            return -1;

        return 1;
    }

    public double slopeTo(Point that)
    {
        if (y == that.y && x == that.x)
            return Double.NEGATIVE_INFINITY;

        if (x == that.x)
            return Double.POSITIVE_INFINITY;

        double slope = (that.y - y)*1.0 / (that.x - x);

        return slope;
    }
}
