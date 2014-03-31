import java.awt.*;
import java.util.Arrays;

/**
 * Created by RamaKrishna on 3/30/14.
 */
public class Brute {
    public static void main(String []args)
    {
        In inputFile = new In(args[0]);
        int N = inputFile.readInt();

        Point [] pa = new Point[N];
        int x, y;

        // Read the input file and make point array
        for(int i=0; i<N; i++)
        {
            x = inputFile.readInt();
            y = inputFile.readInt();

            pa[i] = new Point(x, y);
        }

        StdOut.printf("\nGiven points are " + Arrays.toString(pa));

        Point p, q, r, s;

        StdOut.println("\n\nPrinting the collinear points...\n");

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.setPenColor(Color.GREEN);

        Stopwatch sw = new Stopwatch();
        double startTime = sw.elapsedTime();
        Point lowPoint, highPoint;

        for (int i1=0; i1<N; i1++)
        {
            p = pa[i1];
            p.draw();

            for (int i2=i1+1; i2<N; i2++)
            {
                q = pa[i2];
                q.draw();

                for (int i3=i2+1; i3<N; i3++)
                {
                    r = pa[i3];
                    r.draw();

                    for (int i4=i3+1; i4<N; i4++)
                    {
                        s = pa[i4];
                        s.draw();

                        double pqSlope = p.slopeTo(q);
                        double prSlope = p.slopeTo(r);
                        double psSlope = p.slopeTo(s);

                        if (pqSlope == prSlope && prSlope == psSlope)
                        {
                            // Find the lower point in the line
                            if (p.compareTo(q) < 0)
                                lowPoint = p;
                            else
                                lowPoint = q;

                            if (r.compareTo(lowPoint) < 0)
                                lowPoint = r;

                            if (s.compareTo(lowPoint) < 0)
                                lowPoint = s;

                            // Find the highest point in the line

                            if (p.compareTo(q) > 0)
                                highPoint = p;
                            else
                                highPoint = q;

                            if (r.compareTo(highPoint) > 0)
                                highPoint = r;

                            if (s.compareTo(highPoint) > 0)
                                highPoint = s;

                            StdOut.printf("\n%s -> %s -> %s -> %s ", p, q, r, s);

                            highPoint.drawTo(lowPoint);
                        }
                    }
                }

            }
        }
        double stopTime = sw.elapsedTime();

        StdOut.printf("\n\nIt took %f nano seconds ", stopTime);
    }
}
