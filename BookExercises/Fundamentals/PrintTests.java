import java.util.Arrays;

public class PrintTests
{
	public static void main(String []args)
	{
		System.out.println('b'+0);
		System.out.println('b' + 'c');
		System.out.println((char)('a' + 4));

		int []a = new int[10];

		for(int i=0; i < 10; i++)
			a[i] = 9 - i;

		for(int i=0; i<10; i++)
			a[i] = a[a[i]];

		for(int i = 0; i < 10; i++)
			System.out.println(a[i]);
	}


}
