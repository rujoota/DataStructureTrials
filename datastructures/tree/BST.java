/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this rootlate file, choose Tools | Templates
 * and open the rootlate in the editor.
 */
package datastructures.tree;

/**
 *
 * @author rujuraj
 */
public class BST extends BinaryTree{
    public void insert(int newData)
    {   
        if(root==null)
        {
            root=new Node();
            root.data=newData;
        }
        else
        {
            Node temp=root;
            while(temp.left!=null && temp.right!=null)
            {
                if(newData<=temp.data)
                {
                    temp=temp.left;
                }
                else
                {
                    temp=temp.right;
                }
            }
            if(newData<=temp.data)
            {
                temp.left=new Node();
                temp.left.data=newData;
            }
            else
            {
                temp.right=new Node();
                temp.right.data=newData;
            }
        }
    }
    
    
    public void search(int val)
    {
        Node temp=root;
        while(temp!=null)
        {
            if(val==temp.data)
            {
                System.out.println("found!");
                return;
            }
            else if(val<temp.data)
                temp=temp.left;
            else
                temp=temp.right;
        }
        System.out.println("Not found...");
    }
    
    public void delete(Node node,int keyToDelete)
    {
        if(node==null)
            return;
        else
        {
            if(keyToDelete<node.data)
                delete(node.left, keyToDelete);
            else if(keyToDelete>node.data)
                delete(node.right, keyToDelete);
            else
            {
                if(node.left==null && node.right==null) // leaf
                {
                    node=null;
                }
                else if(node.left==null)
                {
                    node=node.right;
                }
                else if(node.right==null)
                {
                    node=node.left;
                }
                else
                {
                    Node temp=findMinNode(node.right);
                    node.data=temp.data;
                    delete(node.right, temp.data);
                }
            }
                
        }
    }
    
    public Node deleteTreeNode(Node node, int data) {
        Node cur = node;
        if(cur == null){
            return cur;
        }
        if(cur.data > data){            
            cur.left = deleteTreeNode(cur.left, data);
        }else if(cur.data < data){
            cur.right = deleteTreeNode(cur.right, data);
        }else{          
            if(cur.left == null && cur.right == null){
                cur = null;
            }else if(cur.right == null){
                cur = cur.left;
            }else if(cur.left == null){
                cur = cur.right;
            }else{
                Node temp  = findMinNode(cur.right);
                cur.data = temp.data;
                cur.right = deleteTreeNode(cur.right, temp.data);
            }
        }
        return cur;
}
    public Node findMinNode(Node node)
    {
        while(node.left!=null)
        {
            node=node.left;
        }
        return node;
    }
}
