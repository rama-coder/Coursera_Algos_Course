import java.util.Vector;

public class TestRandom
{
    
    public static void main(String []args)
    {
        Vector<Double> randomsList;
        
        if (args.length != 1)
            throw new IllegalArgumentException("You must specify number of times to generate random numbers");
        
        int N = Integer.parseInt(args[0]);
        StdOut.printf("N=%d\n",N);
        StdRandom.setSeed(N);
        randomsList = new Vector<Double>();
        
//        for(int i=0; i<N;i++)
        {
//            int random = (int) (StdRandom.random()*N);
//            StdOut.printf("\nRandom value during %d time is %d", i, random);
//            StdOut.printf("\nRandom value during %d time is %f", i, StdRandom.random());
        }
        
        for(int i=0; i<N;i++)
        {
            double random = StdRandom.uniform(N);
            
            if (randomsList.contains(random))
                StdOut.printf("\n%f is duplicate", random);
            else
                randomsList.add(random);
            
            StdOut.printf("\nRandom test uniform value during %d time is %f", i, random);
            
//            StdOut.printf("\nRandom value during %d time is %f", i, StdRandom.random());
        }
    }
}