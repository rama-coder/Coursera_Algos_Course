public class QuickUnion
{
	public static void main(String args[])
	{
		QuickUnion qu = new QuickUnion();

		qu.union1(0,2);
		qu.union1(2,3);
		qu.union1(3,6);
		qu.union1(5,4);
		qu.union1(5,7);
//		qu.union1(6,7);

		System.out.println("0 and 4 are connected => " + qu.areConnected(0,4));
	}

	public QuickUnion()
	{
		for(int i=0; i < 10; i++)
			a[i] = -1;
	}

	public boolean areConnected(int v1, int v2)
	{
		return (a[v1] != -1 && a[v1] == a[v2]);
	}

	public void union1(int v1, int v2)
	{
		int v1Id = a[v1];
		int v2Id = a[v2];

		if ( v1Id == -1 && v2Id == -1) 
			a[v1] = a[v2] = v2;
		else if (v1Id == -1)
			a[v1] = v2Id;
		else if (v2Id == -1)
			a[v2] = v1Id;
		else // Both v1Id and v2Id are not -1
		{
			for(int i=0; i < 10; i++)
			{
				if (a[i] == v1Id)
					a[i] = v2Id;
			}
		}
		
	}

	private int[] a = new int [10];
	private int currVertexCount;
}
