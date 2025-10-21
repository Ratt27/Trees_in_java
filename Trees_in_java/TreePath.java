import java.util.*;
public class TreePath
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

public static void helper(Node root,List<String>arr,String s)
{
if(root==null) return;
if(root.left==null && root.right==null)
{
s+=root.val;
arr.add(s);
return;
}

helper(root.left,arr,s+root.val+"->");
helper(root.right,arr,s+root.val+"->");
}



 public static List<String> path(Node root)
{
List<String> arr= new ArrayList<>();
helper(root,arr,"");
return arr;
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
List<String> resultPaths = path(root);
 System.out.println(resultPaths); 
        
}
}
