import java.util.*;
public class SymmetricTree
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

// using the concepts of SAME and INVERT tree concepts-->


public static boolean same(Node root1, Node root2)
{
if(root1==null&& root2==null) return true;// but what if one is false and one is true then it will not e able to take the null value to compare so ---->>
if(root1==null||root2==null) return false;
if(root1.val!=root2.val) return false;// here first we are checking the roots-->
return same(root1.left,root2.left)&& same(root1.right,root2.right);

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


public static boolean isSymmetric(Node root)
{
if(root==null) return true;
root.left=invert(root.left);
return same(root.left,root.right);
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
System.out.println(isSymmetric(root));
}
}
