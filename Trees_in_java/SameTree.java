import java.util.*;

// The main class containing the Node structure and the main method.
public class SameTree
{
    // Inner static class representing a node in the binary tree.
    // Each node holds an integer value and references to its left and right children.
    public static class Node
    {
        int val;
        Node left;
        Node right;

        // Constructor to initialize a node with a given value.
        public Node(int val)
        {
            this.val = val;
            this.left = null; // Explicitly setting to null for clarity (default for references)
            this.right = null;
        }
    }


 public static boolean same(Node root1, Node root2)
{
if(root1==null&& root2==null) return true;// but what if one is false and one is true then it will not e able to take the null value to compare so ---->>
if(root1==null||root2==null) return false;
if(root1.val!=root2.val) return false;// here first we are checking the roots-->
return same(root1.left,root2.left)&& same(root1.right,root2.right);

}

    // The main method where the two trees are constructed and initialized.
    public static void main(String[] args)
    {
        // --- Construction of Tree 1 ---
        System.out.println("--- Constructing Tree 1 ---");
        
        // 1. Create the root node for the first tree
        Node root1 = new Node(10); // Root: 10
        System.out.println("Root 1 created with value: " + root1.val);

        // 2. Add children to the root
        root1.left = new Node(5);   // Left child: 5
        root1.right = new Node(15); // Right child: 15

        // 3. Add grandchildren (a sub-tree structure)
        root1.left.left = new Node(2);  // 10 -> 5 -> 2 (left)
        root1.left.right = new Node(7); // 10 -> 5 -> 7 (right)
        
        // Tree 1 Structure:
        //       10
        //      /  \
        //     5    15
        //    / \
        //   2   7


        // --- Construction of Tree 2 ---
        System.out.println("\n--- Constructing Tree 2 ---");

        // 1. Create the root node for the second tree
        Node root2 = new Node(25); // Root: 25
        System.out.println("Root 2 created with value: " + root2.val);

        // 2. Add children to the root
        root2.left = new Node(18);  // Left child: 18
        root2.right = new Node(30); // Right child: 30
        
        // 3. Add a grandchild on the right side
        root2.right.right = new Node(35); // 25 -> 30 -> 35 (right)
        
        // Tree 2 Structure:
        //       25
        //      /  \
        //     18   30
        //           \
        //            35

        System.out.println("\n--- Initialization Complete ---");
        System.out.println("Tree 1 Root: " + root1.val);
        System.out.println("Tree 2 Root: " + root2.val);
        System.out.println("You now have two independent binary trees ready for processing.");
        System.out.println(same(root1,root2));
    }
}