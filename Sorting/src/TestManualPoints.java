import java.awt.*;

/**
 * Created by RamaKrishna on 3/30/14.
 */
public class TestManualPoints {
    public static void main(String []args)
    {
        while (true)
        {
            StdOut.printf("\nEnter first point\n");

            int x0 = StdIn.readInt();
            int y0 = StdIn.readInt();

            Point p = new Point(x0, y0);

            StdOut.printf("\nEnter second point\n");

            int x1 = StdIn.readInt();
            int y1 = StdIn.readInt();

            Point q = new Point(x1, y1);

            StdOut.printf("\nEnter third point\n");

            int x2 = StdIn.readInt();
            int y2 = StdIn.readInt();

            Point r = new Point(x2, y2);

            double pqSlope = p.slopeTo(q);
            double prSlope = p.slopeTo(r);

            StdOut.printf("\npqSlope = " + pqSlope);
            StdOut.printf("\nprSlope = " + prSlope);

            StdOut.printf("\n\np, q and r are collinear => " + (pqSlope == prSlope));

        }

    }


}
