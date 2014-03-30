// Implement Monte Corlo Simulation to find p* of Percolation

public class Percolation
{
 boolean [][] site;
 int [][]topVirtualNode, bottomVirtualNode;
 
 // Initialize all sites as blocked 
 
 public Percolation(int N)
 {
  site = new boolean[N+1][N+1];
  topVirtualNote = new boolean [1][N+1];
  bottomVirtualNote = new boolean [1][N+1];

  for(int i=1; i<=N; i++)
   for (int j=1; j<=N; j++)
    site[i][j] = false;

  for(int i=1; i<=N; i++)
  {
   	topVirtualNode[0][i] = true;
	site[0][i] = true; // Open up top row to connect to top virtual node
  }

  for(int i=1; i<=N; i++)
  {
   	bottomVirtualNode[0][i] = true;
	site[N][i] = true; // Open up bottom row to connecto to bottom virtual node
  }
  
 }

 public void open(int i, int j)
 {
     
 }

 public boolean isOpen(int i, int j)
 {
  return site[i][j];
 }

 public boolean isFull(int i, int j)
 {
     // TODO: Replace it with code to find if site is full
     return site[i][j];
 }

 public boolean percolates()
 {
     // TODO: Replace it with code to find if system percolates
     return false;
 }

 public static void main(String []args)
 {
  StdOut.println("Enter the number of rows/cols");
  int N = StdIn.readInt();
 }

}
