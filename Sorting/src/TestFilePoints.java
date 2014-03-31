import java.util.Arrays;

/**
 * Created by RamaKrishna on 3/30/14.
 */
public class TestFilePoints {
    public static void main(String []args)
    {
        In inputFile = new In(args[0]);
        int N = inputFile.readInt();

        Point[] pa = new Point[N];
        int x, y;

        for (int i=0; i < N; i++)
        {
            x = inputFile.readInt();
            y = inputFile.readInt();

            pa[i] = new Point(x, y);

            System.out.println("Point " + pa[i]);
        }

        System.out.println("\n\nPoints before sorting are " + Arrays.toString(pa));
        StdOut.println("First point = " + pa[0]);
        Arrays.sort(pa, pa[0].SLOPE_ORDER);
        System.out.println("\n\nPoints after sorting are " + Arrays.toString(pa));

    }


}
