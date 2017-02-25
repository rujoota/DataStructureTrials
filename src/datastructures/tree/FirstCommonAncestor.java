/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.tree;

import com.sun.xml.internal.ws.message.RootElementSniffer;


public class FirstCommonAncestor {
    static boolean isChildOf(Node node,Node root)
    {
        if(root==null || root.left==null || root.right==null)
            return false;
        if(root.left.data==node.data || root.right.data==node.data)
            return true;
      
        boolean isLeft=isChildOf(node, root.left);
        boolean isRight=isChildOf(node, root.right);
        return isLeft || isRight;
        
    }
    static Node getFirstCommonAncestorBST(Node node1,Node node2, Node root)
    {
        if(root==null || node1==null || node2==null)
        {
            System.out.println("not found...");
            return null;
        }
        if(isChildOf(node2,node1))
            return node1;
        else if(isChildOf(node1, node2))
            return node2;
        if((node1.data<root.data && node2.data>root.data) || (node1.data>root.data && node2.data<root.data))
            return root;
        else
        {
            if(node1.data<root.data && node2.data<root.data)
                return getFirstCommonAncestorBST(node1, node2, root.left);
            else// if(node1.data>root.data && node2.data>root.data)
                return getFirstCommonAncestorBST(node1, node2, root.right);
        }
    }
    // optimal
    static Node firstCommonAncestorBST(Node node1,Node node2, Node root)
    {
        if(root==null || node1==null || node2==null)
        {
            System.out.println("not found...");
            return null;
        }
        if(node1.data>root.data && node2.data>root.data)
            return firstCommonAncestorBST(node1, node2, root.right);
        else if(node1.data<root.data && node2.data<root.data)
            return firstCommonAncestorBST(node1, node2, root.left);
        return root;
    }
    
    public static void main(String[] args) {
        BST bst=new BST();
        bst.root=new Node(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(15);
        bst.insert(21);
        bst.insert(40);
        Node node1=bst.root.left.right;
        Node node2=bst.root.left;
        Node node=getFirstCommonAncestorBST(node1,node2,bst.root);
        Node nodeOptimal=getFirstCommonAncestorBST(node1,node2,bst.root);
        System.out.println("node1="+node1.data);
        System.out.println("node2="+node2.data);
        System.out.println(node.data);
        System.out.println(nodeOptimal.data);
    }
}
