//Search In Bst
import java.util.*;
public class SearchInBst
{
public  static class Node
{
int val;// initially  the value =0
Node  left;// initially they are null
Node right;

 public Node(int val)
{
this.val=val;
}
}

public Node searchBst(Node root, int val)
{
if(root==null)return null;
if(root.val==val) return root;
if(root.val>val) return searchBst(root.left,val);
if(root.val<val) return searchBst(root.right,val);
return root;
}


public static void main(String args[])
{
    // --- 1. Build a VALID Binary Search Tree (BST) ---
    // The structure is:
    //             10
    //            /  \
    //           5    15
    //          / \   / \
    //         3   7 12  18

    Node root = new Node(10);
    
    // Left Subtree (all < 10)
    Node n5 = new Node(5);
    Node n3 = new Node(3);
    Node n7 = new Node(7);
    
    // Right Subtree (all > 10)
    Node n15 = new Node(15);
    Node n12 = new Node(12);
    Node n18 = new Node(18);

    // Build connections
    root.left = n5;
    root.right = n15;
    
    n5.left = n3;
    n5.right = n7;
    
    n15.left = n12;
    n15.right = n18;

    // --- 2. Instantiate the class and Test the searchBst method ---
    SearchInBst solution = new SearchInBst();
    
    // Test Case 1: Search for an existing value (7)
    int searchValue1 = 7;
    Node result1 = solution.searchBst(root, searchValue1);
    
    System.out.println("Searching for: " + searchValue1);
    if (result1 != null) {
        System.out.println("Result: Node with value " + result1.val + " found.");
    } else {
        System.out.println("Result: Value not found.");
    }
}
}