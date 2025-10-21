import java.util.*;
public class InvertBinary
{
 //static int size=0;
public  static class Node
{
int val;// initially  the value =0
Node  left;
Node right;// initially they are nullright;

 public Node(int val)
{
this.val=val;
}
}


public static  Node invert(Node root)
{
if(root==null) return root;
Node temp= root.left;
root.left=root.right;
root.right=temp;
root.left=invert(root.left);
root.right=invert(root.right);
return root;
}


public static void printPreOrder(Node root) {
    if (root == null) {
        return;
    }
    // 1. Visit the Node (Print its value)
    System.out.print(root.val + " ");
    
    // 2. Traverse Left Subtree
    printPreOrder(root.left);
    
    // 3. Traverse Right Subtree
    printPreOrder(root.right);
}

public static void main(String args[])
{
Node root= new Node(-1);
Node a= new Node(-2);// firstly we are creating the nodes of children.. then we will connect
Node b= new Node(-3);

root.left=a;//here we are  building the connection => arrow
root.right=b;

Node c= new Node(-4);
Node d= new Node(-5);

a.left=c;
a.right=d;
Node e= new Node(-8);
b.right=e;
printPreOrder(root);
System.out.println();
Node invertRoot = invert(root);
printPreOrder(invertRoot);
System.out.println();
}
}