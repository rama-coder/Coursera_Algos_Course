// Implement Monte Corlo Simulation to find p* of Percolation

public class Percolation
{
	boolean [][] site;

	// Initialize all sites as blocked 
	
	public Percolation(int N)
	{
		site = new boolean[N+1][N+1];

		for(int i=1; i<=N; i++)
			for (int j=1; j<=N; j++)
				site[i][j] = false;
	}

	public void open(int i, int j)
	{
	}

	public boolean isOpen(int i, int j)
	{
	}

	public boolean isFull(int i, int j)
	{
	}

	public boolean percolates()
	{
	}

	public static void main(String []args)
	{
		StdOut.println("Enter the number of rows/cols");
		int N = StdIn.getInt();
	}




}
