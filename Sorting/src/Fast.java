import java.util.Arrays;

/**
 * Created by RamaKrishna on 3/30/14.
 */
public class Fast {
    public static void main(String []args)
    {
        In inputFile = new In(args[0]);

        int N = inputFile.readInt();

        Point [] origPA = new Point[N];
        Point [] pa = new Point[N];
        int x, y;

        for(int i=0; i<N; i++)
        {
            x = inputFile.readInt();
            y = inputFile.readInt();

            pa[i] = new Point(x, y);
            origPA[i] = new Point(x, y);
        }

//        StdOut.println("\n Point Array as is from the file = \n\n" + Arrays.toString(pa));

        //            StdOut.println("\n\n Original array = \n\n" + Arrays.toString(origPA));

        // Sort the array for each point for finding corresponding slopes
        for(int i=0; i<N; i++)
        {
            Arrays.sort(pa, origPA[i].SLOPE_ORDER);

//            StdOut.println("\n\n Point Array after the sort = \n\n" + Arrays.toString(pa));

            int sequenceCount = 1;
            Point lowPoint = pa[0];

            double slope1, slope2;

//            StdOut.printf("\nP0 = %s, P1 = %s", pa[0],pa[1]);

            int j;

            for(j=1; j < N-1; j++)
            {
//                StdOut.printf("\npa[%d]=%s", j, pa[j]);

                slope1 = pa[0].slopeTo(pa[j]);
                slope2 = pa[0].slopeTo(pa[j+1]);

//                StdOut.printf("\nSlope1 = %f", slope1);
//                StdOut.printf("\nSlope2 = %f", slope2);

//                StdOut.printf("\nSequence Count = %d", sequenceCount);

                if (slope1 != slope2)
                {
                    if (sequenceCount >= 3)
                        break;
                    else
                    {
                        sequenceCount = 1;
                        continue;
                    }
                }

                if (pa[j].compareTo(lowPoint)<0)
                {
                        lowPoint = pa[j];
//                        StdOut.printf("\nLow Point = %s", lowPoint);
                }

                sequenceCount++;

//                StdOut.printf("\nsequenceCount = %d", sequenceCount);
//                StdOut.printf("\nLow Point = %s", lowPoint);

            }

//            StdOut.printf("\nsequnceCount = %d, LowPoint = %s, pa[i] = %s", sequenceCount, lowPoint, pa[i]);

            // Print the collinear series if pa[i] is the lowest point to avoid the printing of permutations
            if (sequenceCount >= 3 && lowPoint.compareTo(pa[0])==0)
            {
                   StdOut.printf("\nFound new collinear series...");

                   StdOut.printf("\n\n%s", pa[0]);
                   do
                   {
                       if (j-sequenceCount>0)
                        StdOut.printf("-> %s", pa[j-sequenceCount]);
                   }
                   while (--sequenceCount > 0);
                }
        }

    }
}
