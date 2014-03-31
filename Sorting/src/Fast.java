import java.util.Arrays;

/**
 * Created by RamaKrishna on 3/30/14.
 */
public class Fast {
    public static void main(String []args)
    {
        In inputFile = new In(args[0]);

        int N = inputFile.readInt();

        Point [] pa = new Point[N];
        int x, y;

        for(int i=0; i<N; i++)
        {
            x = inputFile.readInt();
            y = inputFile.readInt();

            pa[i] = new Point(x, y);
        }

//        StdOut.println("\n Point Array as is from the file = \n\n" + Arrays.toString(pa));

        // Sort the array for each point for finding corresponding slopes
        for(int i=0; i<N; i++)
        {
            Arrays.sort(pa, pa[i].SLOPE_ORDER);

//            StdOut.println("\n\n Point Array after the sort = \n\n" + Arrays.toString(pa));

            int sequenceCount = 1;
            Point lowPoint = pa[i];

            for(int j=i+1; j<N; j++)
            {
                double slope1 = pa[i].slopeTo(pa[j]);

                while (j<N-1)
                {
                    double slope2 = pa[i].slopeTo(pa[j++]);
                    if (slope1 != slope2)
                        break;

                    if (pa[j].compareTo(lowPoint)<0)
                        lowPoint = pa[j];
                    sequenceCount++;
                }

                // Print the collinear series if pa[i] is the lowest point to avoid the printing of permutations
                if (sequenceCount >= 3 && lowPoint.compareTo(pa[i])==0)
                {
//                   StdOut.printf("\nFound new collinear series...");

                   StdOut.printf("\n\n%s", pa[i]);
                   while (sequenceCount > 0)
                   {
                       StdOut.printf("-> %s", pa[j-sequenceCount]);
                       sequenceCount--;
                   }
                }
            }
        }
    }
}
