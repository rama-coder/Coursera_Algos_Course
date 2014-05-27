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
                StdOut.println("\nEnter the value for finding floor, ciel, select and rank...\n");
                k = StdIn.readInt();
                StdOut.printf("\nfloor(%d) = %d", k, bst.floor(k));
                StdOut.printf("\nciel(%d) = %d", k, bst.ciel(k));
                StdOut.printf("\nselect(%d) = %d", k%6, bst.select(k%6));
                StdOut.printf("\nrank(%d) = %d", k, bst.rank(k));
            }
            while (k != -1);
        }
        catch(Exception ex)
        {
            System.out.println("Key not found");
        }
    }
}
