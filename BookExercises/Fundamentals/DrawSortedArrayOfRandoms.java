import java.util.Arrays;

public class DrawSortedArrayOfRandoms
{
	public static void main(String []args)
	{
		int N = 10;
		double [] a = new double[N];

		for (int i = 0; i < N; i++)
			a[i] = StdRandom.random();
		Arrays.sort(a);
		StdDraw.setPenColor(StdDraw.BLUE);

		for(int i=0; i < N; i++)
		{
			double x = 1.0*i/N;
			double y = a[i]/2.0;
			double rw = 0.5/N;
			double rh = y;
			StdOut.printf("\nX=%f,Y=%f,RW=%f,RH=%f", x, y, rw, rh);
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}


}
