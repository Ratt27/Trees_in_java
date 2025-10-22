import java.util.*;
public class PathSum1
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

// here target sum is given we have to find a path from root to leaf which will give the sum

public  static Boolean hasPathSum(Node root, int targetSum)
{
if(root==null) return false;
if(root!=null && root.left==null &&root.right==null)
{
if(root.val==targetSum) return true;
}
return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
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
System.out.println(hasPathSum(root,-7));

}
}