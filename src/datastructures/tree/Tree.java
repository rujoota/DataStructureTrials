/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.tree;

/**
 *
 * @author rujuraj
 */
public class Tree {
    Node root;
    public void insert()
    {
        
    }
    public void displayTree(Node node)
    {
        if(node!=null)
        {
            System.out.println(node.data+":left:"+node.left+",right:"+node.right);
            displayTree(node.left);
            displayTree(node.right);
        }
    }
}
