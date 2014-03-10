public class CheckCodeNature
{
    public static void main(String []args)
    {
        System.out.println(changedString(args[0]));
    }
    
    public static String changedString(String s)
    {
        int length = s.length();
        
        if (length <= 1) return s;
        
        String s1 = s.substring(0,length/2);
        String s2 = s.substring(length/2, length);
        
        return changedString(s2) + changedString(s1);
    }
}