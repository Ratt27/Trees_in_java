import java.util.*;

public class LowestCommonAncestor
{
    // Node class definition
    public static class Node
    {
        int val;
        Node left;
        Node right;

        public Node(int val)
        {
            this.val = val;
        }
    }

    // This function checks whether the node 'node' is present in the subtree rooted at 'root'.
    public static boolean contains(Node root, Node node)
    {
        if(root == null) return false;
        if(root == node) return true;
        // FIX: Changed 'returns' to 'return'
        return contains(root.left, node) || contains(root.right, node);
    }

    // Function to find the Lowest Common Ancestor (LCA) of two nodes p and q.
    public static Node lca(Node root, Node p, Node q)
    {
        if(p == root || q == root) return root;
        if(p == q) return p;

        // Check if p is in the left subtree and q is in the right subtree
        boolean leftP = contains(root.left, p);
        boolean rightQ = contains(root.right, q);
        
                if ((leftP && rightQ) || (!leftP && !rightQ)) {
                       return root;
        }
        
        // Scenario 2: Both p and q are in the left subtree (p is in left, q is NOT in right)
        if(leftP && !rightQ) {
            return lca(root.left, p, q);
        }
        
        // Scenario 3: Both p and q are in the right subtree (p is NOT in left, q IS in right)
        if(!leftP && rightQ) {
            return lca(root.right, p, q);
        }
        
        // Fallback (should be covered by the first if-statement but necessary for completeness)
        return root; 
    }

    public static void main(String args[])
    {
        // --- 1. Tree Construction ---
        Node root = new Node(-1);
        Node a = new Node(-2);
        Node b = new Node(-3);

        root.left = a;
        root.right = b;

        Node c = new Node(-4);
        Node d = new Node(-5);

        a.left = c;
        a.right = d;
        
        Node e = new Node(-8);
        b.right = e;

        // Tree structure:
        //       -1 (root)
        //      /  \
        //     -2 (a) -3 (b)
        //    / \      \
        // -4 (c) -5 (d) -8 (e)
        
        System.out.println("Binary Tree Constructed.");
        
        // --- 2. Test Case 1: Nodes in the same subtree (LCA = 'a') ---
        Node p1 = c; // Value: -4
        Node q1 = d; // Value: -5
        
        Node lca1 = lca(root, p1, q1);
        
        System.out.println("\n--- Test Case 1 ---");
        System.out.println("P: " + p1.val + ", Q: " + q1.val);
        System.out.println("LCA Value: " + lca1.val + " (Expected: -2)");
        
        // --- 3. Test Case 2: Nodes in different subtrees (LCA = 'root') ---
        Node p2 = d; // Value: -5
        Node q2 = e; // Value: -8
        
        Node lca2 = lca(root, p2, q2);
        
        System.out.println("\n--- Test Case 2 ---");
        System.out.println("P: " + p2.val + ", Q: " + q2.val);
        System.out.println("LCA Value: " + lca2.val + " (Expected: -1)");
    }
}