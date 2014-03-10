public class DrawFunctionValues
{
	public static void main(String []args)
	{
		int N = 100;

		StdDraw.setXscale(0,N);
		StdDraw.setYscale(0, N*N);

		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.BLUE);

		for(int i=1; i <= N; i++)
		{
			StdDraw.point(i, i);
			StdDraw.point(i, i*i);
			StdDraw.point(i, i*Math.log(i));
		}
	}


}
