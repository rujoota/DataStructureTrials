/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import javafx.scene.AccessibleAttribute;

/**
 *
 * @author rujuraj
 */
public class BinaryTree {
    int ident=1;
     public Node root;
     // insert node at left or right of 'node'
     public void insertAt(int newVal,int existingValue,Boolean isLeft)
     {
         Node foundNode=search(existingValue, root);
         if(isLeft)
         {
             if(foundNode==null)
             {
                 System.out.println("wrong existing value, can't insert");
                 return;
             }
             if(foundNode.left==null)
             {
                 foundNode.left=new Node();
                 foundNode.left.data=newVal;
             }
             else
                 System.out.println("can't insert, value already present");
         }
         else
         {
             if(foundNode.right==null)
             {
                 foundNode.right=new Node();
                 foundNode.right.data=newVal;
             }
             else
                 System.out.println("can't insert, value already present");
         }
     }
     // custom pre-order traversal for search
     public Node search(int val, Node node)
     {
         Node foundNode=null;
         if(node==null)
             foundNode= null;
         else if(node.data==val)
             foundNode= node;
         else
         {
             foundNode=search(val, node.left);
             if(foundNode==null)
                foundNode=search(val, node.right);
         }
         return foundNode;
     }
     public void insert(int newVal)
     {
         if(root==null)
         {
             root=new Node();
             root.data=newVal;
         }
         else
         {
             Queue<Node> queue=new LinkedList<Node>();
             queue.offer(root);
             while(true)
             {
                 Node elem=queue.remove();
                 if(elem.left==null)
                 {
                     elem.left=new Node();
                     elem.left.data=newVal;
                     break;
                 }
                 else
                     queue.offer(elem.left);
                 if(elem.right==null)
                 {
                     elem.right=new Node();
                     elem.right.data=newVal;
                     break;
                 }
                 else
                    queue.offer(elem.right);
             }
         }
     }
    public void display(Node node)
    {
        if(node!=null)
        {
            System.out.println(node.data);
            if(node.left!=null)
            {
                for(int i=0;i<ident;i++)
                    System.out.print(" ");
                System.out.print("l:");
                ident++;
                display(node.left);
                ident--;
            }
            if(node.right!=null)
            {
                for(int i=0;i<ident;i++)
                    System.out.print(" ");
                System.out.print("r:");
                ident++;
                display(node.right);
                ident--;
            }
        }
    }
    public void inOrder(Node node)
    {
        if(node==null)
            return;
        else
        {
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }
    public void preOrder(Node node)
    {
        if(node==null)
            return;
        else
        {
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void postOrder(Node node)
    {
        if(node==null)
            return;
        else
        {
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }
    public void visit(Node node)
    {
        System.out.println("visiting:"+node.data);
    }
}
