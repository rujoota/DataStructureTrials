/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import datastructures.tree.BinaryTree;

/**
 *
 * @author rujuraj
 */
public class SerializeBinaryTree {
    
   
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        bt.insert(10);
        bt.insert(11);
        bt.insert(5);
        bt.insert(4);
        bt.insert(18);
        
        bt.insertAt(14, 4, Boolean.TRUE);
        bt.display(bt.root);
    }
 
}
