import java.util.*;
public class preInPost
{

 public  static void pip(int n)
{
if(n==0) return;
System.out.println("Pre"+n);
pip(n-1);
System.out.println("In"+n);
pip(n-1);
System.out.println("Post"+n);
}

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


public static void preorder(Node root)
{
if(root==null) return;
System.out.println(root.val);
preorder(root.left);
preorder(root.right);
}


public static void inorder(Node root)
{
if(root==null) return;
inorder(root.left);
System.out.println(root.val);
inorder(root.right);
}


public static void postorder(Node root)
{
if(root==null) return;
postorder(root.left);
postorder(root.right);
System.out.println(root.val);
}

//PRINT NTH LEVEL NODES::----
public static void nthlevel(Node root, int n)
{
if(root==null) return;
if(n==1)
{
System.out.print(root.val+" ");
return;
} 
nthlevel(root.left,n-1);
nthlevel(root.right,n-1);

}

public static int height(Node root)
{
if(root==null) return 0;
if(root.left==null&&root.right==null) return 0;//LEAF NODE--> otherwise it considers its height to be 1
return 1+ Math.max(height(root.left),height(root.right));
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
//preorder(root);
//inorder(root);
//postorder(root);
//nthlevel(root,2);--> this is just for printing the nth level with the help of this, we can do BFS-->

//this is high time complexity
//If we do BFS like this the time complexity is O(nlogn)
int level =height(root)+1;

for(int i=1;i<=level;i++)
{
nthlevel(root,i);
System.out.println();
}
}
}
