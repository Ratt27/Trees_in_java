import java.util.*;
public class ConstructBinary
{
 //static int size=0;
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

public static Node helper(int[]preorder, int prelo, int prehi, int[] inorder,int inlo, int  inhi)
{
//First element of the preorder is always the root
if(prelo>prehi) return null;
Node root= new Node(preorder[prelo]);
int i=inlo;
while(inorder[i]!=preorder[prelo])
i++;
int leftsize=i-inlo;
root.left=helper(preorder,prelo+1,prelo+leftsize,inorder,inlo,i-1);
root.right=helper(preorder,prelo+leftsize+1,prehi,inorder,i+1,inhi);
return root;

}


public static Node buildTree(int[] preorder, int[] inorder)
{
int n=preorder.length;
return helper(preorder,0,n-1,inorder,0,n-1);
}


public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

public static void main(String args[])
    {
        // Tree Structure:
        //      3
        //     / \
        //    9  20
        //      /  \
        //     15   7

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        System.out.println("Starting tree construction...");
        System.out.println("Preorder Input: " + Arrays.toString(preorder));
        System.out.println("Inorder Input:  " + Arrays.toString(inorder));

        // Build the tree
        Node root = buildTree(preorder, inorder);

        // Verify the result by printing the inorder traversal
        System.out.print("\nConstructed Tree Inorder Traversal (Expected: 9 3 15 20 7): ");
        printInorder(root);
        System.out.println();
    }
}