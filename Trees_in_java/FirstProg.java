import java.util.*;

public class FirstProg { 
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

//WE WILL DISPLAY THE TREE USING RECURSION:-
//by default it will print in PREORDER Traversal

 public static void display(Node root)
{
if(root==null) return;
System.out.print(root.val+" -> ");
if(root.left!=null)
System.out.print(root.left.val+ " ,");
if(root.right!=null)
System.out.print(root.right.val);
System.out.println();
display(root.left);
display(root.right);


}
    public static void main(String[] args) {
        System.out.println("Hello World");
Node root= new Node(1);
Node a= new Node(2);// firstly we are creating the nodes of children.. then we will connect
Node b= new Node(3);

root.left=a;//here we are  building the connection => arrow
root.right=b;

Node c= new Node(4);
Node d= new Node(5);

a.left=c;
a.right=d;
Node e= new Node(6);
b.right=e;
display(root);




    }
}