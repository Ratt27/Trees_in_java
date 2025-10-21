import java.util.*;
public class sizeMaxSumHeight
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
// THIS IS NORMAL WAY  OF CALCULATING SIZE:---
 //public static void preorder(Node root)
//{
//if(root==null) return;
//size++;
//preorder(root.left);
//preorder(root.right);
//}

public  static int Sum(Node root)
{
if(root==null) return 0;
return root.val+ Sum(root.left)+Sum(root.right);
}


//HOMEWORK2:--

public  static int product(Node root)
{
if(root==null) return 1;
return root.val* product(root.left)* product(root.right);
}


//THS IS THE FORMULATIVE WAY OF CALCULATING SIZE:---

public  static int size(Node root)
{if(root==null) return 0;
return 1+ size(root.left)+size(root.right);
}

public static int max(Node root)
{
if(root==null) return Integer.MIN_VALUE;

int a= root.val;
int b=max(root.left);
int c=max(root.right);
return Math.max(a,Math.max(b,c));  // THIS IS THE WAY OF COMPARING 3 NOS
}
public static int height(Node root)
{
if(root==null) return 0;
if(root.left==null&&root.right==null) return 0;//LEAF NODE--> otherwise it considers its height to be 1
return 1+ Math.max(height(root.left),height(root.right));
}
//HOOMEWORK1:-
public static int min(Node root)
{
if(root==null) return Integer.MAX_VALUE;

int a= root.val;
int b=min(root.left);
int c=min(root.right);
return Math.min(a,Math.min(b,c));  // THIS IS THE WAY OF COMPARING 3 NOS
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
System.out.println(size(root));
System.out.println(Sum(root));
System.out.println(max(root));
System.out.println(height(root));
System.out.println(min(root));
System.out.println(product(root));


}

}

