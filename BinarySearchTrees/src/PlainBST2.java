/**
 * Created by RamaKrishna on 5/25/14.
 */
public class PlainBST2
{
    private Node root;

    private class Node
    {
        private Node left, right;
        private int key, value, count;

        public Node(int key, int value, int count)
        {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    private int size(Node x)
    {
        return (x==null)?0:( 1 + size(x.left) + size(x.right));
    }

    public int get(int key) throws Exception
    {
        return get(root, key);
    }

    private int get(Node x, int key) throws Exception
    {
        if (x == null)
            throw new Exception("Key not found");

        if (key == x.key)
            return x.value;

        if (key < x.key)
            return get(x.left, key);

        return get(x.right, key);
    }

    public void put(int key, int value)
    {
        if (root == null)
        {
            root = new Node(key, value, 1);
            return;
        }

        put(root, key, value);
    }

    private Node put(Node x, int key, int value)
    {
        if (x == null)
        {
            return new Node(key, value, 1);
        }

        if (key == x.key)
            x.value = value;

        if (key < x.key)
            x.left = put(x.left, key, value);
        else
            x.right = put(x.right, key, value);

        x.count = 1 + size(x.left) + size(x.right);

        return x;
    }

    public void printInOrder()
    {
        if (root == null)
        {
            System.out.println("Its an empty tree. Holiday for printing...");
            return;
        }

        printInOrder(root);
    }

    private void printInOrder(Node x)
    {
        if ( x == null )
            return;

        printInOrder(x.left);
        System.out.println(x.value);
        printInOrder(x.right);
    }

    public int floor(int key) throws Exception
    {
        if (root == null)
            throw new Exception("Empty tree found hence floor is not applicable");

        Node x = floor(root, key);
        if ( x == null)
            return -1;
        return x.value;
    }

    private Node floor(Node x, int key) throws Exception
    {
        if (x == null)
            return null;

        if (key == x.key)
            return x;

        if (key < x.key)
        {
            return floor(x.left, key);
        }

        Node t = floor(x.right, key);

        if (t == null) return x;
        return t;
    }

    public int ciel(int key) throws Exception
    {
        if (root == null)
            throw new Exception("Empty tree");

        Node x = ciel(root, key);

        if ( x == null)
            return -1;
        return x.value;
    }

    private Node ciel(Node x, int key)
    {
        if (x == null)
            return null;

        if (key == x.key)
            return x;

        if (key > x.key)
            return ciel(x.right, key);

        Node t = ciel(x.left, key);
        return (t==null)?x:t;
    }

    public int rank(int key)
    {
        return rank(root, key);
    }

    private int rank(Node x, int key)
    {
        if (x == null)
            return 0;

        if (key == x.key)
            return size(x.left);

        if (key < x.key)
            return rank(x.left, key);

        return size (x.left) + 1 + rank(x.right, key);
    }

    public int select(int k) { return select(root, k).key; }

    private Node select(Node x, int k)
    {
        if (x == null)
            return null;

        int t = size(x.left);

        if (k < t)
            return select(x.left, k);

        if (k > t)
            return select(x.right, k-t-1);

        return x;

    }


}
