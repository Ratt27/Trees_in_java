import java.util.*;
public class Bfs
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

//USING QUEUE-->

public static void bfs(Node root)//Iterative way--->>
{
Queue<Node> q= new LinkedList<>();
if(root!=null)
q.add(root);
while(q.size()>0)
{
Node temp=q.peek();
if(temp.left!=null)
q.add(temp.left);
if(temp.right!=null)
q.add(temp.right);
System.out.println(temp.val+" ");
q.remove();

}

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
bfs(root);
}
}

