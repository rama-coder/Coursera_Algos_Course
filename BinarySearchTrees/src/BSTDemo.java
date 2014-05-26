/**
 * Created by RamaKrishna on 5/25/14.
 */
public class BSTDemo
{
    public static void main(String []args)
    {
        try
        {
            PlainBST2 bst = new PlainBST2();

            bst.put(100,100);
            bst.put(200,200);
            bst.put(300,300);

            bst.put(40,40);
            bst.put(150,150);
            bst.put(160,160);

            bst.printInOrder();

            int k = -1;

            do {
                StdOut.println("\nEnter the value for finding floor...\n");
                k = StdIn.readInt();
                StdOut.printf("floor(%d) = %d", k, bst.floor(k));
            }
            while (k != -1);
        }
        catch(Exception ex)
        {
            System.out.println("Key not found");
        }
    }
}