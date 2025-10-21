import java.util.*;
//  This is leetcode 543-->

public class Diameter
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


public static int height(Node root)
{
if(root==null) return 0;
if(root.left==null&&root.right==null) return 0;//LEAF NODE--> otherwise it considers its height to be 1
return 1+ Math.max(height(root.left),height(root.right));
}


public static int diameter(Node root)
{
//BASE CASE-->
if(root==null||(root.left==null && root.right==null)) return 0;

int leftAns=diameter(root.left);
int rightAns=diameter(root.right);
int mid= height(root.left)+height(root.right);
if(root.left!=null)mid++;
if(root.right!=null) mid++;
int max= Math.max(leftAns,Math.max(rightAns,mid));
return max;

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
System.out.println(diameter(root));
}
}

