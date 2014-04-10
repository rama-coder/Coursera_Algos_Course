/**
 * Created by RAGA on 4/9/2014.
 */
public class PlainBST
{
    private Node root;

    private class Node
    {
        public int key;
        public Node left, right, parent;
        public int count;

        public Node(int key)
        {
            this.key = key;
        }
    }

    public int search(int key) throws Exception
    {
        if (root != null)
        {
            Node temp = root;
            while (temp != null)
            {
                if (temp.key == key)
                    return key;
                if (key < temp.key)
                    temp = temp.left;
                else
                    temp = temp.right;
            }
        }
        throw new Exception("Key not found");
    }

    public void insert(int key)
    {
        StdOut.printf("\nInserting %d\n", key);

        root = insert(root, key);
    }

    public Node insert(Node root, int key)
    {
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        root.count = 1;

        if (root.left != null)
            root.count += root.left.count;

//        if (root.right != null)
//            root.count += root.right.count;

        return root;
    }

    public void inOrder()
    {
        inOrder(root);
    }

    private void inOrder(Node node)
    {
        if (node != null)
        {
            inOrder(node.left);
            StdOut.printf("Visited Node %d and its rank = %d\n\n", node.key, node.count);
            inOrder(node.right);
        }
    }
    public static void main(String []args)  throws Exception
    {
        PlainBST pbst = new PlainBST();

        pbst.insert(10);
        pbst.insert(114);
        pbst.insert(121);

        StdOut.printf("%d search returned ", pbst.search(121));
        pbst.insert(1);
        pbst.insert(4);

        pbst.insert(132);
        pbst.insert(111);
        pbst.insert(13);
        pbst.insert(12);
        pbst.insert(23);

        StdOut.printf("Printing pbst in inorder traversal\n\n");
        pbst.inOrder();
    }
}
