public class UnionFind
{
	public static void main(String args[])
	{
		UnionFind qu = new UnionFind(10);

		qu.quickFindUnion(0,2);
		qu.quickFindUnion(2,3);
		qu.quickFindUnion(3,6);
		qu.quickFindUnion(5,4);
		qu.quickFindUnion(5,7);
//		qu.quickFindUnion(6,7);

		System.out.println("0 and 4 are connected => " + qu.quickFindConnected(0,4));
	}

	public UnionFind(int N)
	{
		id = new int[N];

		for(int i=0; i < N; i++)
			id[i] = i;
	}

	public boolean quickFindConnected(int v1, int v2)
	{
		return (id[v1] == id[v2]);
	}

	public void quickFindUnion(int v1, int v2)
	{
		int v1Id = id[v1];
		int v2Id = id[v2];

		for(int i=0; i < id.length; i++)
		{
			if (id[i] == v1Id)
				id[i] = v2Id;
		}
		
	}

	private int[] id;
	private int currVertexCount;
}
